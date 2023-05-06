package com.farm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.constant.Constant;
import com.farm.entity.dto.Now;
import com.farm.entity.dto.RealTimeWeatherDto;
import com.farm.entity.po.FarmEquipment;
import com.farm.exception.MyException;
import com.farm.mapper.FarmBlockMapper;
import com.farm.mapper.FarmEquipmentMapper;
import com.farm.service.FarmEquipmentService;
import com.farm.utils.EquipmentUtils;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.List;

import static cn.hutool.core.util.ObjectUtil.isEmpty;
import static cn.hutool.core.util.ObjectUtil.isNotNull;
import static java.util.Objects.isNull;

/**
 * @name: FarmEquipmentServiceImpl
 * @author: sutton
 * @date: 2023-04-28 16:52
 * @description: 硬件设备管理
 */
@Service
public class FarmEquipmentServiceImpl extends ServiceImpl<FarmEquipmentMapper, FarmEquipment> implements FarmEquipmentService {


    private final Logger logger = LoggerFactory.getLogger(FarmEquipmentServiceImpl.class);

    @Resource
    private FarmEquipmentMapper farmEquipmentMapper;

    @Resource
    private FarmBlockMapper blockMapper;


    @Value("${real.weather.key}")
    private String value;


    @Resource
    private RestTemplate restTemplate;


    /**
     * 从设备获取响应的信息
     *
     * @param ctx 通道
     * @param msg 消息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveEquipment (ChannelHandlerContext ctx, Object msg) {
        logger.info("saveEquipment............");
        logger.info("收到的消息为: {}", ctx);
        logger.info("收到客户端的消息:{}", msg.toString());

        String msgStr = msg.toString();
        List<String> parse = EquipmentUtils.splitString(msgStr, "-");
        if (isEmpty(parse)) {
            logger.info("解析失败");
            throw new MyException("解析失败");
        }
        for (String param : parse) {
            logger.info("解析后的参数:{}", param);
        }
        String equipmentNumber = ctx.channel().id().toString();
        FarmEquipment farmEquipment = farmEquipmentMapper.selectOne(new QueryWrapper<FarmEquipment>().lambda().eq(FarmEquipment::getEquipmentType, parse.get(2)));
        if (isNotNull(farmEquipment)) {
            logger.info("设备已经存在");
            farmEquipment.setSendTime(new Date());
            farmEquipment.setData(parse.get(4));
            farmEquipment.setUpdateTime(new Date());
            //更新
            farmEquipmentMapper.update(farmEquipment, new QueryWrapper<FarmEquipment>().lambda().eq(FarmEquipment::getChannelId, equipmentNumber));
        }

        //循环判断
        if (parse.size() < 5) {
            logger.info("解析失败");
        }

        //绑定设备
        if (isNull(farmEquipment)) {
            FarmEquipment data = new FarmEquipment();
            data.setData(parse.get(4));
            data.setClientIp(((InetSocketAddress) ctx.channel().remoteAddress()).getAddress().getHostAddress());
            data.setChannelId(equipmentNumber);
            data.setEquipmentName(parse.get(0));
            data.setEquipmentNumber(parse.get(1));
            data.setEquipmentType(parse.get(2));
            data.setEquipmentStatus(parse.get(3));
            data.setClientPort(String.valueOf(((InetSocketAddress) ctx.channel().remoteAddress()).getPort()));
            farmEquipmentMapper.insert(data);
        }
    }

    /**
     * 获取通过netty注册到服务器的设备
     *
     * @return 返回已经启动设备
     */
    @Override
    public List<FarmEquipment> getEqupmentLists () {
        List<FarmEquipment> farmEquipments = farmEquipmentMapper.selectList(new QueryWrapper<FarmEquipment>().lambda().eq(FarmEquipment::getEquipmentStatus, Constant.FarmEquipmentTypeConstant.START_THE));
        if (isEmpty(farmEquipments)) {
            throw new MyException("没有设备");
        }
        return farmEquipments;
    }

    /**
     * 返回温度
     *
     * @return 返回温度
     */
    @Override
    public String getTemperature () {
        FarmEquipment farmEquipment = farmEquipmentMapper.selectOne(new QueryWrapper<FarmEquipment>().lambda().eq(FarmEquipment::getEquipmentType, Constant.FarmTypeConstant.TEMP));
        if (isNull(farmEquipment)) {
            throw new MyException("设备不存在");
        }
        return farmEquipment.getData();
    }

    /**
     * 获取日照
     *
     * @return 获取日照
     */
    @Override
    public String getSunShine () {
        FarmEquipment farmEquipment = farmEquipmentMapper.selectOne(new QueryWrapper<FarmEquipment>().lambda().eq(FarmEquipment::getEquipmentType, Constant.FarmTypeConstant.SUNSHINE));
        if (isNull(farmEquipment)) {
            throw new MyException("设备不存在");
        }
        return farmEquipment.getData();
    }

    /**
     * 获取降雨量
     *
     * @return 返回降雨量数据
     */
    @Override
    public String getRainfall () {
        FarmEquipment farmEquipment = farmEquipmentMapper.selectOne(new QueryWrapper<FarmEquipment>().lambda().eq(FarmEquipment::getEquipmentType, Constant.FarmTypeConstant.RAILFALL));
        if (isNull(farmEquipment)) {
            throw new MyException("设备不存在");
        }
        return farmEquipment.getData();
    }

    /**
     * 获取空气温度
     *
     * @return 获取空气温度
     */
    @Override
    public String getAirTemp () {
        FarmEquipment farmEquipment = farmEquipmentMapper.selectOne(new QueryWrapper<FarmEquipment>().lambda().eq(FarmEquipment::getEquipmentType, Constant.FarmTypeConstant.AIR_TEMP));
        if (isNull(farmEquipment)) {
            throw new MyException("设备不存在");
        }
        return farmEquipment.getData();
    }


    /**
     * 获取空气湿度
     *
     * @return 返回湿度
     */
    @Override
    public String getAirHund () {
        FarmEquipment farmEquipment = farmEquipmentMapper.selectOne(new QueryWrapper<FarmEquipment>().lambda().eq(FarmEquipment::getEquipmentType, Constant.FarmTypeConstant.AIR_HUN));
        if (isNull(farmEquipment)) {
            throw new MyException("设备不存在");
        }
        return farmEquipment.getData();
    }

    /**
     * 获取土壤湿度
     *
     * @return 获取土壤湿度
     */
    @Override
    public String getLandHund () {
        FarmEquipment farmEquipment = farmEquipmentMapper.selectOne(new QueryWrapper<FarmEquipment>().lambda().eq(FarmEquipment::getEquipmentType, Constant.FarmTypeConstant.LAND_TEMP));
        if (isNull(farmEquipment)) {
            throw new MyException("设备不存在");
        }
        return farmEquipment.getData();
    }

    /**
     * 获取土壤温度
     *
     * @return 返回温度
     */
    @Override
    public String getLandTemp () {
        FarmEquipment farmEquipment = farmEquipmentMapper.selectOne(new QueryWrapper<FarmEquipment>().lambda().eq(FarmEquipment::getEquipmentType, Constant.FarmTypeConstant.LAND_HUN));
        if (isNull(farmEquipment)) {
            throw new MyException("设备不存在");
        }
        return farmEquipment.getData();
    }

    @Override
    public Object getBlock () {

        return null;
    }

    /**
     * 设置第三方数据
     */
    @Override
    public void setApiData () {
        RealTimeWeatherDto forObject = restTemplate.getForObject("https://devapi.qweather.com/v7/weather/now?location=101010100&key={key}", RealTimeWeatherDto.class, value);
        if (isNull(forObject.getNow())) {
            throw new MyException("获取天气失败");
        }
        Now now = forObject.getNow();

        List<FarmEquipment> farmEquipments = farmEquipmentMapper.selectList(null);
        if (isEmpty(farmEquipments)) {
            throw new MyException("设备不存在");
        }
        for (FarmEquipment farmEquipment : farmEquipments) {
            farmEquipment.setSendTime(new Date());
            if (farmEquipment.getEquipmentType().equals(Constant.FarmTypeConstant.TEMP.toString())) {
                farmEquipment.setData(now.getTemp());
            }
            if (farmEquipment.getEquipmentType().equals(Constant.FarmTypeConstant.AIR_HUN.toString())) {
                farmEquipment.setData(now.getHumidity());
            }
            if (farmEquipment.getEquipmentType().equals(Constant.FarmTypeConstant.RAILFALL.toString())) {
                farmEquipment.setData(now.getPrecip());
            }
            farmEquipmentMapper.updateById(farmEquipment);
        }
        logger.info("设置天气成功");

    }


}