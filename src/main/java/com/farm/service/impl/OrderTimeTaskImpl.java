package com.farm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author sutton
 * @name: OrderTimeOutCancelTask
 * @description: OrderTimeOutCancelTask
 * @date: 2023-04-28 08:11
 * @version: 1.0
 * @since: JDK 1.8
 * @see: com.farm.service.impl
 */
@Component
public class OrderTimeTaskImpl {
    private final  Logger logger = LoggerFactory.getLogger(OrderTimeTaskImpl.class);

    /**
     * cron表达式：Seconds Minutes Hours Day-ofMonth Month Day-ofWeek [Year]
     * 每 1 分钟触发一次: 0 0/1 * * * ?
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    private void cancelTimeOutOrder () {
        logger.info("测试定时任务 {}", new Date());
    }
}
