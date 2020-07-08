# 水平分库(多个库相同表名)
# 第一个数据库
drop database if exists order_0;
create database order_0;
use order_0;
drop table if exists t_order;
CREATE TABLE `t_order`(
    `id`       bigint(20) NOT NULL,
    `order_no` varchar(255)  DEFAULT NULL,
    `user_id`  bigint(20) NOT NULL,
    `driver_id`  bigint(20) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

# 第二个数据库
drop database if exists order_1;
create database order_1;
use order_1;
drop table if exists t_order;
CREATE TABLE `t_order`(
    `id`       bigint(20) NOT NULL,
    `order_no` varchar(255)  DEFAULT NULL,
    `user_id`  bigint(20) NOT NULL,
    `driver_id`  bigint(20) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

######################################################################
# 水平分表(同一个库不同表名)
drop database if exists order_db;
create database order_db;
use order_db;
# 第一张表
drop table if exists t_order_0;
CREATE TABLE `t_order_0`(
    `id`       bigint(20) NOT NULL,
    `order_no` varchar(255)  DEFAULT NULL,
    `user_id`  bigint(20) NOT NULL,
    `driver_id`  bigint(20) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

# 第二张表
drop table if exists t_order_1;
CREATE TABLE `t_order_1`(
    `id`       bigint(20) NOT NULL,
    `order_no` varchar(255)  DEFAULT NULL,
    `user_id`  bigint(20) NOT NULL,
    `driver_id`  bigint(20) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

######################################################################
# 水平分库分表
# 第一个数据库
drop database if exists order_0;
create database order_0;
use order_0;
# 第一张表
drop table if exists t_order_0;
CREATE TABLE `t_order_0`(
    `id`       bigint(20) NOT NULL,
    `order_no` varchar(255)  DEFAULT NULL,
    `user_id`  bigint(20) NOT NULL,
    `driver_id`  bigint(20) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
# 第二张表
drop table if exists t_order_1;
CREATE TABLE `t_order_1`(
    `id`       bigint(20) NOT NULL,
    `order_no` varchar(255)  DEFAULT NULL,
    `user_id`  bigint(20) NOT NULL,
    `driver_id`  bigint(20) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

# 第二个数据库
drop database if exists order_1;
create database order_1;
use order_1;
# 第一张表
drop table if exists t_order_0;
CREATE TABLE `t_order_0`(
    `id`       bigint(20) NOT NULL,
    `order_no` varchar(255)  DEFAULT NULL,
    `user_id`  bigint(20) NOT NULL,
    `driver_id`  bigint(20) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
# 第二张表
drop table if exists t_order_1;
CREATE TABLE `t_order_1`(
    `id`       bigint(20) NOT NULL,
    `order_no` varchar(255)  DEFAULT NULL,
    `user_id`  bigint(20) NOT NULL,
    `driver_id`  bigint(20) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;