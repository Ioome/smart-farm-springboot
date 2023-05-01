

package com.farm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.farm.entity.po.FarmEquipment;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @name: FarmEquipmentService
 * @author: sutton
 * @date: 2023-04-28 16:51
 * @description: FarmEquipmentService
 */
@Service
public interface FarmEquipmentService extends IService<FarmEquipment> {

    /**
     * 从设备获取响应的信息
     *
     * @param ctx 通道
     * @param msg 消息
     */
    void saveEquipment (ChannelHandlerContext ctx, Object msg);


    /**
     * 获取通过netty注册到服务器的设备
     *
     * @return 返回设备
     */
    List<FarmEquipment> getEqupmentLists ();
}
