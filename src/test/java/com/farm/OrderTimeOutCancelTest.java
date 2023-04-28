package com.farm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @name: OrderTimeOutCancelTask
 * @author: sutton
 * @date: 2023-04-28 08:11
 * @description: OrderTimeOutCancelTask
 */
@Component
public class OrderTimeOutCancelTest {

    private static Logger LOGGER = LoggerFactory.getLogger(OrderTimeOutCancelTest.class);

    @Scheduled(cron = "* * * * * ? *")
    public static void main (String[] args) {
        LOGGER.info("取消订单，并根据sku编号释放锁定库存");
    }
}
