CREATE TABLE `farm_planting`
(
    `id`                         bigint   NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
    `code`                       varchar(100)      DEFAULT NULL COMMENT '编号',
    `land_name`                  varchar(200)      DEFAULT NULL COMMENT '土地名称',
    `scale`                      varchar(200)      DEFAULT NULL COMMENT '规模',
    `area`                       int               DEFAULT NULL COMMENT '面积',
    `planting_plant_number`      BIGINT            DEFAULT 0 COMMENT '种植数量',
    `status`                     bigint            DEFAULT NULL COMMENT '状态 1 启动计划  2 正在进行 3 废弃',
    `suitable_crop`              varchar(200)      DEFAULT NULL COMMENT '适合作物',
    `plant_name`                 varchar(200)      DEFAULT NULL COMMENT '植物名称',
    `classification`             varchar(200)      DEFAULT NULL COMMENT '分类',
    `growth_cycle`               varchar(200)      DEFAULT NULL COMMENT '生长周期',
    `temperature_recommendation` varchar(200)      DEFAULT NULL COMMENT '温度建议',
    `humidity_recommendation`    varchar(200)      DEFAULT NULL COMMENT '湿度建议',
    `plant_image`                varchar(200)      DEFAULT NULL COMMENT '植物图片',
    `planting_date`              date              DEFAULT NULL COMMENT '种植日期',
    `harvest_date`               date              DEFAULT NULL COMMENT '收割日期',
    `current_status`             varchar(200)      DEFAULT NULL COMMENT '当前状态',
    `remarks`                    varchar(200)      DEFAULT NULL COMMENT '备注',
    `username`                   varchar(200)      DEFAULT NULL COMMENT '用户名',
    `phone_number`               varchar(200)      DEFAULT NULL COMMENT '手机号码',
    `user_id`                    bigint   NOT NULL COMMENT '用户 id',
    `created_time`               datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`                datetime          DEFAULT NULL COMMENT '更新时间',
    `update_by`                  INT               DEFAULT NULL COMMENT '更新人',
    `create_by`                  INT               DEFAULT NULL COMMENT '创建人',
    `delete_time`                datetime          DEFAULT NULL COMMENT '删除（null.正常)',
    `plant_id`                   INT               DEFAULT NULL COMMENT '植物id',
    `block_id`                   INT               DEFAULT NULL COMMENT '区块id ',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = utf8 COMMENT ='种植计划表';


CREATE TABLE `farm_environment`
(
    `id`               bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `air_temperature`  varchar(200) NOT NULL COMMENT '环境温度',
    `air_humidity `    varchar(200) NOT NULL COMMENT '空气湿度',
    `bright_sunshine`  varchar(200)          DEFAULT NULL COMMENT '湿度状态',
    `soil_temperature` varchar(200)          DEFAULT NULL COMMENT '土壤温度',
    `soil_humidity `   varchar(200)          DEFAULT NULL COMMENT '土壤湿度',
    `other`            varchar(200)          DEFAULT NULL COMMENT '其它',
    `user_name`        varchar(200)          DEFAULT NULL COMMENT '用户名',
    `phone_number`     varchar(200)          DEFAULT NULL COMMENT '手机',
    `user_id`          bigint       NOT NULL COMMENT '用户id',
    `created_time`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`      datetime              DEFAULT NULL COMMENT '更新时间',
    `update_by`        INT                   DEFAULT NULL COMMENT '更新人',
    `create_by`        INT                   DEFAULT NULL COMMENT '创建人',
    `delete_time`      datetime              DEFAULT NULL COMMENT '删除（null.正常)',
    `parent_id`        BIGINT                DEFAULT NULL COMMENT '主环境id',
    `block_id`         BIGINT                DEFAULT NULL COMMENT '区块',
    `equipment`        BIGINT                DEFAULT NULL COMMENT '设备',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1608432827022
  DEFAULT CHARSET = utf8 COMMENT ='环境';

CREATE TABLE `farm_equipment`
(
    `id`               bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `equipment_name`   varchar(200) NOT NULL COMMENT '设备名称',
    `equipment_number` varchar(200) NOT NULL COMMENT '设备编号',
    `equipment_type`   varchar(200) NOT NULL COMMENT '设备类型',
    `equipment_status` varchar(200) NOT NULL COMMENT '设备状态',
    `status`           bigint                default 1 NOT NULL COMMENT ' 1 启动 2 关机',
    `start_time`       datetime              DEFAULT NULL COMMENT '开机时间',
    `end_time`         datetime              DEFAULT NULL COMMENT '关机时间',
    `created_time`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`      datetime              DEFAULT NULL COMMENT '更新时间',
    `update_by`        INT                   DEFAULT NULL COMMENT '更新人',
    `create_by`        INT                   DEFAULT NULL COMMENT '创建人',
    `delete_time`      datetime              DEFAULT NULL COMMENT '删除（null.正常)'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='设备';


CREATE TABLE `farm_block`
(
    `id`            bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `code`          varchar(200) NOT NULL COMMENT '编号',
    `land_name`     varchar(200) NOT NULL COMMENT '土地名称',
    `land_code`     varchar(200) NOT NULL COMMENT '土地编码',
    `land_time`     datetime     NOT NULL COMMENT '土地期限',
    `land_position` varchar(200) NOT NULL COMMENT '土地地理位置',
    `status`        bigint                default 1 NOT NULL COMMENT '状态 1 启动 2 回收 3 废弃',
    `image`         varchar(200)          DEFAULT NULL COMMENT '图片',
    `scale`         varchar(200)          DEFAULT NULL COMMENT '规模',
    `area`          int                   DEFAULT NULL COMMENT '面积',
    `suitable_crop` varchar(200)          DEFAULT NULL COMMENT '适合作物',
    `details`       longtext COMMENT '详情',
    `click_time`    datetime              DEFAULT NULL COMMENT '最后点击时间',
    `click_count`   int                   DEFAULT '0' COMMENT '点击数',
    `created_time`  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   datetime              DEFAULT NULL COMMENT '更新时间',
    `update_by`     INT                   DEFAULT NULL COMMENT '更新人',
    `create_by`     INT                   DEFAULT NULL COMMENT '创建人',
    `delete_time`   datetime              DEFAULT NULL COMMENT '删除（null.正常)',
    PRIMARY KEY (`id`),
    UNIQUE KEY `code` (`code`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = utf8 COMMENT ='block';



CREATE TABLE `farm_plant`
(
    `id`                   bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `plant_name`           varchar(200) NOT NULL COMMENT '植物名称',
    `plant_classification` varchar(200)          DEFAULT NULL COMMENT '分类',
    `picture`              varchar(200)          DEFAULT NULL COMMENT '图片',
    `growth_cycle`         varchar(200)          DEFAULT NULL COMMENT '生长周期',
    `nutritional_value`    varchar(200)          DEFAULT NULL COMMENT '营养价值',
    `fert_varieties`       varchar(200)          DEFAULT NULL COMMENT '施肥品种',
    `sun_cycle`            varchar(200)          DEFAULT NULL COMMENT '光照周期',
    `land_condition`       varchar(200)          DEFAULT NULL COMMENT '土壤建议',
    `temp_condition`       varchar(200)          DEFAULT NULL COMMENT '温度建议',
    `humidity_condition`   varchar(200)          DEFAULT NULL COMMENT '湿度建议',
    `remark`               varchar(200)          DEFAULT NULL COMMENT '备注',
    `created_time`         datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`          datetime              DEFAULT NULL COMMENT '更新时间',
    `update_by`            INT                   DEFAULT NULL COMMENT '更新人',
    `create_by`            INT                   DEFAULT NULL COMMENT '创建人',
    `delete_time`          datetime              DEFAULT NULL COMMENT '删除（null.正常)',
    `warehouse_id`         INT                   DEFAULT NULL COMMENT '仓库id',
    PRIMARY KEY (`id`),
    UNIQUE KEY `plant_name` (`plant_name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8 COMMENT ='植物';



CREATE TABLE `farm_change_water`
(
    `id`                 bigint   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `bianhao`            varchar(200)      DEFAULT NULL COMMENT '编号',
    `land_name`          varchar(200)      DEFAULT NULL COMMENT '土地名称',
    `change_create_time` date              DEFAULT NULL COMMENT '换水日期',
    `statue`             varchar(200)      DEFAULT NULL COMMENT '当前状态  0 未换水 1 已换水',
    `next_change`        date              DEFAULT NULL COMMENT '下次换水',
    `other`              varchar(200)      DEFAULT NULL COMMENT '其它',
    `user_name`          varchar(200)      DEFAULT NULL COMMENT '用户名',
    `phone_number`       varchar(200)      DEFAULT NULL COMMENT '手机号码',
    `created_time`       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`        datetime          DEFAULT NULL COMMENT '更新时间',
    `update_by`          INT               DEFAULT NULL COMMENT '更新人',
    `create_by`          INT               DEFAULT NULL COMMENT '创建人',
    `delete_time`        datetime          DEFAULT NULL COMMENT '删除（null.正常)',
    `userid`             bigint   NOT NULL COMMENT '用户id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1608432839693
  DEFAULT CHARSET = utf8 COMMENT ='换水';

CREATE TABLE `farm_plant_inventory_receipts`
(
    `id`             int(11) unsigned NOT NULL COMMENT '主键唯一标识入库单的 ID',
    `receipt_number` varchar(20)           DEFAULT NULL COMMENT '入库单编号',
    `receipt_date`   timestamp        NULL DEFAULT NULL COMMENT '入库时间',
    `total_cost`     decimal(10, 2)        DEFAULT NULL COMMENT '所有植物成本',
    `remarks`        varchar(20)           DEFAULT NULL COMMENT '入库单备注',
    `create_by`      int(11)               DEFAULT NULL COMMENT '创建人id',
    `create_time`    timestamp        NULL DEFAULT NULL COMMENT '创建时间',
    `update_by`      int(11)               DEFAULT NULL COMMENT '更新人',
    `update_time`    timestamp        NULL DEFAULT NULL COMMENT '更新时间',
    `is_deleted`     tinyint(1)            DEFAULT '0' COMMENT '逻辑删除'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='入库单 wzb';


CREATE TABLE `farm_plant_warehouse`
(
    `id`                 int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `warehouse_name`     varchar(30)      DEFAULT NULL COMMENT '仓库名称',
    `warehouse_code`     varchar(30)      DEFAULT NULL COMMENT '仓库编码',
    `warehouse_address`  varchar(300)     DEFAULT NULL COMMENT '仓库地址',
    `description`        varchar(300)     DEFAULT NULL COMMENT '描述',
    `admin_id`           int(20)          DEFAULT NULL COMMENT '管理员id',
    `create_time`        datetime         DEFAULT NULL COMMENT '创建时间',
    `update_time`        datetime         DEFAULT NULL COMMENT '更新时间',
    `status`             tinyint(1)       DEFAULT NULL COMMENT '0 关闭仓库 1 开启仓库',
    `create_by`          int(20)          DEFAULT NULL COMMENT '创建人',
    `update_by`          int(20)          DEFAULT NULL COMMENT '更新人',
    `warehouse_nickname` varchar(255)     DEFAULT NULL COMMENT '仓库助记名',
    `phone`              varchar(255)     DEFAULT NULL COMMENT '仓库电话',
    `remark`             varchar(255)     DEFAULT NULL COMMENT '备注',
    `parent_id`          int(11)          DEFAULT NULL COMMENT '父id',
    `remove_flag`        tinyint(1)       DEFAULT NULL COMMENT '逻辑删除（0 未删除、1 删除）',
    `sort`               int(20) unsigned DEFAULT '0' COMMENT '排序',
    PRIMARY KEY (`id`),
    KEY `idx_id` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 196
  DEFAULT CHARSET = utf8mb4 COMMENT ='仓库表 wzb';

-- ----------------------------
-- Table structure for ums_admin
-- ----------------------------
DROP TABLE IF EXISTS `farm_admin`;
CREATE TABLE `farm_admin`
(
    `id`           bigint(20)                                              NOT NULL AUTO_INCREMENT,
    `username`     varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '用户名',
    `nick_name`    varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '昵称',
    `password`     varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '密码',
    `status`       int(1)                                                  NULL     DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
    `phone`        VARCHAR(32)                                                      DEFAULT NULL COMMENT '手机号',
    `sex`          CHAR(1)                                                          DEFAULT NULL COMMENT '用户性别（0男，1女，2未知）',
    `user_type`    CHAR(1)                                                 NOT NULL DEFAULT '1' COMMENT '用户类型（0管理员，1普通用户）',
    `icon`         varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '头像',
    `email`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '邮箱',
    `note`         varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '备注信息',
    `login_time`   datetime                                                NULL     DEFAULT NULL COMMENT '最后登录时间',
    `created_time` datetime                                                NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  datetime                                                         DEFAULT NULL COMMENT '更新时间',
    `update_by`    INT                                                              DEFAULT NULL COMMENT '更新人',
    `create_by`    INT                                                              DEFAULT NULL COMMENT '创建人',
    `delete_time`  datetime                                                         DEFAULT NULL COMMENT '删除（null.正常)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户表'
  ROW_FORMAT = Dynamic;


-- Table structure for ums_role
DROP TABLE IF EXISTS `farm_role`;
CREATE TABLE `farm_role`
(
    `id`           bigint(20)                                              NOT NULL AUTO_INCREMENT,
    `name`         varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '名称: 角色权限字符串',
    `description`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '描述:角色权限字符串 ',
    `admin_count`  int(11)                                                 NULL     DEFAULT NULL COMMENT '后台用户数量',
    `status`       int(1)                                                  NULL     DEFAULT 1 COMMENT '启用状态：0->禁用；1->启用',
    `sort`         int(11)                                                 NULL     DEFAULT 0,
    `created_time` datetime                                                NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  datetime                                                         DEFAULT NULL COMMENT '更新时间',
    `update_by`    INT                                                              DEFAULT NULL COMMENT '更新人',
    `create_by`    INT                                                              DEFAULT NULL COMMENT '创建人',
    `delete_time`  datetime                                                         DEFAULT NULL COMMENT '删除（null.正常)',
    `remark`       varchar(500)                                                     DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户角色表'
  ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for ums_permission
-- ----------------------------
DROP TABLE IF EXISTS `farm_permission`;
CREATE TABLE `farm_permission`
(
    `id`            BIGINT(20)                                              NOT NULL AUTO_INCREMENT,
    `pid`           BIGINT(20)                                              NULL     DEFAULT NULL COMMENT '父级权限id',
    `name`          VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '菜单名称',
    `value`         VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '权限标识',
    `icon`          VARCHAR(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '图标',
    `type`          INT(1)                                                           DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
    `url`           VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '前端资源路径',
    `component_url` varchar(255)                                                     DEFAULT NULL COMMENT '组件路径',
    `status`        INT(1)                                                  NULL     DEFAULT 1 COMMENT '启用状态；0->禁用；1->启用',
    `visible`       CHAR(1)                                                          DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
    `sort`          INT(11)                                                 NULL     DEFAULT NULL COMMENT '排序',
    `created_time`  datetime                                                NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   datetime                                                         DEFAULT NULL COMMENT '更新时间',
    `update_by`     INT                                                              DEFAULT NULL COMMENT '更新人',
    `create_by`     INT                                                              DEFAULT NULL COMMENT '创建人',
    `delete_time`   datetime                                                         DEFAULT NULL COMMENT '删除（null.正常)',
    `remark`        VARCHAR(500)                                                     DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB
  AUTO_INCREMENT = 19
  CHARACTER
      SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户权限表'
  ROW_FORMAT = Dynamic;



-- Table structure for ums_admin_role_relation，用户具有多个角色，角色也可以分配给多个用户，所以是多对多的关系
-- ----------------------------
DROP TABLE IF EXISTS `farm_admin_role_relation`;
CREATE TABLE `farm_admin_role_relation`
(
    `id`       bigint(20) NOT NULL AUTO_INCREMENT,
    `admin_id` bigint(20) NULL DEFAULT NULL,
    `role_id`  bigint(20) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 32
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户和角色关系表'
  ROW_FORMAT = Dynamic;



-- ----------------------------
-- Table structure for ums_role_permission_relation 从角色到权限来看，它是有一对多的权限， 但是站在权限的角度来看， 它是一个多对多
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_permission_relation`;
CREATE TABLE `farm_role_permission_relation`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `role_id`       bigint(20) NULL DEFAULT NULL,
    `permission_id` bigint(20) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 18
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户角色和权限关系表'
  ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `ums_admin_permission_relation`;
CREATE TABLE `farm_admin_permission_relation`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `admin_id`      bigint(20) NULL DEFAULT NULL,
    `permission_id` bigint(20) NULL DEFAULT NULL,
    `type`          int(1)     NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户和权限关系表(除角色中定义的权限以外的加减权限)'
  ROW_FORMAT = Dynamic;





