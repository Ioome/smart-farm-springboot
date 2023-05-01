package com.farm.service.impl;

import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.constant.Constant;
import com.farm.entity.po.FarmEquipment;
import com.farm.mapper.FarmEquipmentMapper;
import com.farm.service.FarmEquipmentService;
import com.farm.utils.EquipmentUtils;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 从设备获取响应的信息
     *
     * @param ctx 通道
     * @param msg 消息
     */
    @Override
    public void saveEquipment (ChannelHandlerContext ctx, Object msg) {
        logger.info("saveEquipment............");
        logger.info("收到的消息为: {}", ctx);
        logger.info("收到客户端的消息:{}", msg.toString());

        String msgStr = msg.toString();
        List<String> parse = EquipmentUtils.splitString(msgStr, "-");
        if (isEmpty(parse)) {
            logger.info("解析失败");
            return;
        }
        //将数据除以10 parse 4 除以10
        BigDecimal finalData = new BigDecimal(parse.get(4)).divide(new BigDecimal(10));
        logger.info("解析后的数据:{}", finalData);
        for (String param : parse) {
            logger.info("解析后的参数:{}", param);
        }
        String equipmentNumber = ctx.channel().id().toString();
        FarmEquipment farmEquipment = farmEquipmentMapper.selectOne(new QueryWrapper<FarmEquipment>().lambda().eq(FarmEquipment::getChannelId, equipmentNumber));
        if (isNotNull(farmEquipment)) {
            logger.info("设备已经存在");
            farmEquipment.setSendTime(new Date());
            farmEquipment.setData(String.valueOf(finalData));
            //更新
            farmEquipmentMapper.update(farmEquipment, new QueryWrapper<FarmEquipment>().lambda().eq(FarmEquipment::getChannelId, equipmentNumber));
        }

        //循环判断
        if (parse.size() < 5) {
            logger.info("解析失败");
            throw new RuntimeException("解析失败");
        }

        //绑定设备
        if (isNull(farmEquipment)) {
            FarmEquipment data = new FarmEquipment();
            data.setData(String.valueOf(finalData));
            data.setClientIp(((InetSocketAddress) ctx.channel().remoteAddress()).getAddress().getHostAddress());
            data.setChannelId(equipmentNumber);
            data.setEquipmentNumber(parse.get(0));
            data.setEquipmentType(parse.get(1));
            data.setEquipmentName(parse.get(2));

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
        return farmEquipmentMapper.selectList(new QueryWrapper<FarmEquipment>().lambda().eq(FarmEquipment::getEquipmentStatus, Constant.FarmEquipmentTypeConstant.START_THE));
    }


}
