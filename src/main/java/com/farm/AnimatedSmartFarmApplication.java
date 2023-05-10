package com.farm;

import cn.hutool.core.text.CharSequenceUtil;
import com.farm.data.nio.server.NettyServer;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;


/**
 * @author: sutton
 * @date: 2023/4/2
 * @description: SpringbootSchemaApplication
 * @since 1.
 */
@SpringBootApplication
@Slf4j
@EnableAsync
@EnableSwagger2
@EnableFeignClients
@EnableScheduling
@MapperScan(basePackages = "com.farm.mapper")
public class AnimatedSmartFarmApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Value("${netty.host}")
    private String host;
    @Value("${netty.port}")
    private int port;
    @Resource
    private NettyServer nettyServer;

    public static void main (String[] args) throws UnknownHostException {
        ConfigurableApplicationContext run = SpringApplication.run(AnimatedSmartFarmApplication.class, args);
        log.info("-----------------------------------");
        Environment env = run.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        path = CharSequenceUtil.isNotEmpty(path) ? path : "";
        log.info("\n----------------------------------------------------------\n\t"
                + "Application descr-Boot is running! Access URLs:\n\t" + "Local: \t\thttp://localhost:" + port + path
                + "\n\t" + "External: \thttps://" + ip + ":" + port + path + "\n\t" + "----------------------------------------------------------");
        log.info("启动成功 V0.0.1{}", System.currentTimeMillis());
    }

    @Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(AnimatedSmartFarmApplication.class);
    }

    @Override
    public void run (String... args) {
        InetSocketAddress address = new InetSocketAddress(host, port);
        nettyServer.bing(address);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> nettyServer.destroy()));
    }
}
