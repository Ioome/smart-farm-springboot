CREATE TABLE `farm_real_time_weather`
(
    `id`              bigint   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `now_obsTime `    datetime          DEFAULT NULL COMMENT ' 数据观测时间',
    `now_temperature` varchar(20)       DEFAULT NULL COMMENT '当前温度',
    `now_feelsLike`   varchar(20)       DEFAULT NULL COMMENT '体感温度',
    `now_icon`        varchar(20)       DEFAULT NULL COMMENT '天气图标',
    `now_text`        varchar(20)       DEFAULT NULL COMMENT '天气文字',
    `now_wind360`     varchar(20)       DEFAULT NULL COMMENT '风向360角度',
    `now_windDir`     varchar(20)       DEFAULT NULL COMMENT '风向',
    `now_windScale`   varchar(20)       DEFAULT NULL COMMENT '风力等级',
    `now_windSpeed`   varchar(20)       DEFAULT NULL COMMENT '风速，公里/小时',
    `now_humidity`    varchar(20)       DEFAULT NULL COMMENT '相对湿度',
    `now_precip`      varchar(20)       DEFAULT NULL COMMENT '降水量',
    `now_pressure`    varchar(20)       DEFAULT NULL COMMENT '大气压强',
    `now_vis`         varchar(20)       DEFAULT NULL COMMENT '能见度，默认单位：公里',
    `now_cloud`       varchar(20)       DEFAULT NULL COMMENT '云量',
    `now_dew`         varchar(20)       DEFAULT NULL COMMENT '露点温度',
    `created_time`    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`     datetime          DEFAULT NULL COMMENT '更新时间',
    `update_by`       INT               DEFAULT NULL COMMENT '更新人',
    `create_by`       INT               DEFAULT NULL COMMENT '创建人',
    `delete_time`     datetime          DEFAULT NULL COMMENT '删除（null.正常)',
    `parent_id`       BIGINT            DEFAULT NULL COMMENT '主环境id',
    `block_id`        BIGINT            DEFAULT NULL COMMENT '区块',
    `equipment`       BIGINT            DEFAULT NULL COMMENT '设备',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = utf8 COMMENT ='实时天气数据表';
