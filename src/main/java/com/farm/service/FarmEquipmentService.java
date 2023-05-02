

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


    /**
     * 返回温度
     *
     * @return
     */
    String getTemperature ();


    /**
     * 获取日照
     *
     * @return
     */
    String getSunShine ();

    /**
     * 获取降雨量
     *
     * @return 返回降雨量数据
     */
    String getRainfall ();

    /**
     * 获取空气温度
     *
     * @return 获取空气温度
     */
    String getAirTemp ();


    /**
     * 获取空气湿度
     *
     * @return 获取空气湿度
     */
    String getAirHund ();

    /**
     * 获取土壤湿度
     *
     * @return 获取土壤湿度
     */

    String getLandHund ();


    /**
     * 获取土壤温度
     *
     * @return
     */
    String getLandTemp ();


    /**
     * 获取区块信息
     *
     * @return
     */
    Object getBlock ();
}
