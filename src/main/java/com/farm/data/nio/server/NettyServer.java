package com.farm.data.nio.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;


/**
 * @author sutton
 * @name: NettyServer
 * @description: NettyServer
 * @date: 2023-04-24 09:48
 * @version: 1.0.0
 * @since: JDK 1.8
 */
@Component("nettyServer")
public class NettyServer {

    private final  Logger logger = LoggerFactory.getLogger(NettyServer.class);

    private final EventLoopGroup parentGroup = new NioEventLoopGroup();
    private final EventLoopGroup childGroup = new NioEventLoopGroup();
    private Channel channel;


    public ChannelFuture bing (InetSocketAddress address) {
        ChannelFuture channelFuture = null;
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(parentGroup, childGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childHandler(new MyChannelInitializer());
            channelFuture = b.bind(address).syncUninterruptibly();
            channel = channelFuture.channel();
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            if (null != channelFuture && channelFuture.isSuccess()) {
                logger.info("netty server start done. ");
            } else {
                logger.error("netty server start error. ");
            }
        }
        return channelFuture;
    }

    public void destroy () {
        if (null == channel) {
            return;
        }
        logger.info("netty server close");
        channel.close();
        parentGroup.shutdownGracefully();
        childGroup.shutdownGracefully();
    }

    public Channel getChannel () {
        logger.info("netty server getChannel");
        return channel;
    }

}
