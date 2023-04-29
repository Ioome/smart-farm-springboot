package com.farm.data.nio.server;

import com.farm.service.FarmEquipmentService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sutton
 * @name: MyServerHandler
 * @date: 2023-04-24 09:48
 */
@Service("myServerHandler")
public class MyServerHandler extends ChannelInboundHandlerAdapter {


    private final Logger logger = LoggerFactory.getLogger(MyServerHandler.class);


    @Autowired
    private FarmEquipmentService farmEquipmentService;

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

        logger.info("收到的消息为: {}", ctx);
        logger.info("收到客户端的消息:{}", msg.toString());
        //获取客户端ip
        InetSocketAddress ipSocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = ipSocket.getAddress().getHostAddress();
        logger.info("客户端ip: {}", clientIp);

        //获取客户端端口
        int clientPort = ipSocket.getPort();
        logger.info("客户端端口: {}", clientPort);

        //获取客户端信息
        logger.info("服务端收到: {}", msg);

        //获取通道 id
        logger.info("通道 id: {}", ctx.channel().id());


        farmEquipmentService.saveEquipment(ctx, msg);
        String str = "服务端收到: " + new Date() + " " + msg + "\r\n" + "请与后台人员核对数据";
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
        logger.info("异常信息1：{}\r\n", cause.getMessage());
    }

}
