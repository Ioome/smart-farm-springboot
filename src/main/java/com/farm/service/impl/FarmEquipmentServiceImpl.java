package com.farm.service.impl;

import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.po.FarmEquipment;
import com.farm.mapper.FarmEquipmentMapper;
import com.farm.service.FarmEquipmentService;
import com.farm.utils.EquipmentUtils;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.hutool.core.util.ObjectUtil.isEmpty;
import static cn.hutool.core.util.ObjectUtil.isNotNull;

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
        for (String param : parse) {
            logger.info("解析后的参数:{}", param);
        }
        String equipmentNumber = ctx.channel().id().toString();
        FarmEquipment farmEquipment = farmEquipmentMapper.selectOne(new QueryWrapper<FarmEquipment>().lambda().eq(FarmEquipment::getChannelId, equipmentNumber));
        if (isNotNull(farmEquipment)) {
            logger.info("设备已经存在");
            farmEquipment.setData(parse.get(5));
        }

        //循环判断
        if (parse.size() < 5) {
            logger.info("解析失败");
            throw new RuntimeException("解析失败");
        }

        //绑定设备
//        Map<String, FarmEquipment> farmEquipmentMap = new HashMap<>();
//        FarmEquipment data = new FarmEquipment();
//        data.setData(parse.get(4));
//        data.setChannelId(equipmentNumber);
//        farmEquipmentMap.put(equipmentNumber, data);
//        farmEquipmentMapper.insert(farmEquipment);
    }

}
