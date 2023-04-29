package com.farm.utils;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.commons.codec.binary.Hex;

import java.util.List;

/**
 * @name: HexDecoder
 * @author: sutton
 * @date: 2023-04-29 14:27
 * @description: HexDecoder
 */
public class HexDecoder  extends ByteToMessageDecoder {
    @Override
    protected void decode (ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> list) throws Exception {
        if (in.isReadable()) {
            byte[] data = new byte[in.readableBytes()];
            in.readBytes(data);
            String hexString = Hex.encodeHexString(data); // 将字节数组转换为16进制字符串
            // TODO: 解析和处理16进制数据
            list.add(hexString); // 将解码后的数据添加到输出列表中
        }
    }
}
