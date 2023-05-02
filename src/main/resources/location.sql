CREATE TABLE `farm_location`
(
    `id`                 bigint   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `location_id`        BIGINT            DEFAULT NULL COMMENT '地点id',
    `location_name`      varchar(255)      DEFAULT NULL COMMENT '地点名称',
    `location_lat`       varchar(255)      DEFAULT NULL COMMENT '地点纬度',
    `location_lon`       varchar(255)      DEFAULT NULL COMMENT '地点经度',
    `location_adm2`      varchar(255)      DEFAULT NULL COMMENT '地点所属区县',
    `location_adm1`      varchar(255)      DEFAULT NULL COMMENT '地点所属市',
    `location_country`   varchar(255)      DEFAULT NULL COMMENT '地点所属国家',
    `location_tz`        varchar(255)      DEFAULT NULL COMMENT '地点时区',
    `location_utc`       varchar(255)      DEFAULT NULL COMMENT '地点utc',
    `location_utcOffset` varchar(255)      DEFAULT NULL COMMENT '地点utcOffset',
    `location_isDst`     varchar(255)      DEFAULT NULL COMMENT '地点isDst',
    `location_type`      varchar(255)      DEFAULT NULL COMMENT '地点类型',
    `location_rank`      varchar(255)      DEFAULT NULL COMMENT '地点rank',
    `location_fxLink`    varchar(255)      DEFAULT NULL COMMENT '地点fxLink',
    `created_time`       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`        datetime          DEFAULT NULL COMMENT '更新时间',
    `update_by`          INT               DEFAULT NULL COMMENT '更新人',
    `create_by`          INT               DEFAULT NULL COMMENT '创建人',
    `delete_time`        datetime          DEFAULT NULL COMMENT '删除（null.正常)',
    `parent_id`          BIGINT            DEFAULT NULL COMMENT '主环境id',
    `block_id`           BIGINT            DEFAULT NULL COMMENT '区块',
    `equipment`          BIGINT            DEFAULT NULL COMMENT '设备',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = utf8 COMMENT ='城市表';
