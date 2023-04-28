package com.farm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.po.FarmEquipment;
import com.farm.mapper.FarmEquipmentMapper;
import com.farm.service.FarmEquipmentService;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * @name: FarmEquipmentServiceImpl
 * @author: sutton
 * @date: 2023-04-28 16:52
 * @description: 硬件设备管理
 */
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
        // TODO 先获取到设备的信息， 如果设备不存在于数据库，那么将设备通道 id 管理，并且将设备信息保存到数据库，如果存在则直接更改
        // TODO 设备的状态，然后将设备的信息保存到数据库
        logger.info("收到的消息为: {}", ctx);
        logger.info("收到客户端的消息:{}", msg.toString());
    }
}
