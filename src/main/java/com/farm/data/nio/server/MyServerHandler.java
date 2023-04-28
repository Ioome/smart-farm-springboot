package com.farm.data.nio.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sutton
 * @name: MyServerHandler
 * @date: 2023-04-24 09:48
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(MyServerHandler.class);

    /**
     * 当客户端主动链接服务端的链接后，这个通道就是活跃的了。也就是客户端与服务端建立了通信通道并且可以传输数据
     */
    @Override
    public void channelActive (ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();
        logger.info("链接报告开始");
        logger.info("链接报告信息：有一客户端链接到本服务端");
        logger.info("链接报告IP:{}", channel.localAddress().getHostString());
        logger.info("链接报告Port:{}", channel.localAddress().getPort());
        logger.info("链接报告完毕");
        String str = "通知客户端链接建立成功" + " " + new Date() + " " + channel.localAddress().getHostString() + "\r\n";
        ctx.writeAndFlush(str);
    }

    /**
     * 当客户端主动断开服务端的链接后，这个通道就是不活跃的。也就是说客户端与服务端的关闭了通信通道并且不可以传输数据
     */
    @Override
    public void channelInactive (ChannelHandlerContext ctx) throws Exception {
        logger.info("客户端断开链接{}", ctx.channel().localAddress());
    }

    @Override
    public void channelRead (ChannelHandlerContext ctx, Object msg) throws Exception {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        logger.info("date {}", format);
        logger.info("收到客户端的消息:{}", msg.toString());
        logger.info("收到的消息为: {}",ctx);
        Channel channel = ctx.channel();
        //获取硬件信息
        logger.info("硬件信息:{}", channel.id());
        logger.info("硬件信息:{}", channel.remoteAddress());
        logger.info("硬件信息:{}", channel.localAddress());
        logger.info("硬件信息:{}", channel.metadata());
        logger.info("硬件信息:{}", channel.pipeline());
        logger.info("硬件信息:{}", channel.config());
        logger.info("硬件信息:{}", channel.eventLoop());
        logger.info("硬件信息:{}", channel.parent());
        logger.info("硬件信息:{}", channel.unsafe());
        logger.info("硬件信息:{}", channel.isActive());
        logger.info("硬件信息:{}", channel.isWritable());
        logger.info("硬件信息:{}", channel.isRegistered());
        logger.info("硬件信息:{}", channel.isWritable());
        logger.info("硬件信息:{}", channel.isWritable());
        String str = "服务端收到: " + new Date() + " " + msg + "\r\n";
        ByteBuf buf = Unpooled.buffer(str.getBytes().length);
        buf.writeBytes(str.getBytes("GBK"));
        ctx.writeAndFlush(buf);
    }

    /**
     * 抓住异常，当发生异常的时候，可以做一些相应的处理，比如打印日志、关闭链接
     */
    @Override
    public void exceptionCaught (ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        logger.info("异常信息：{}\r\n", cause.getMessage());
    }

}
