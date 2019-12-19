drop database if exists shiro;
CREATE DATABASE shiro DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

use shiro;

drop table if exists user;
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    username VARCHAR(50) DEFAULT NULL COMMENT '用户名',
    password VARCHAR(50) DEFAULT NULL COMMENT '密码',
    creat_time TIMESTAMP,
    update_time TIMESTAMP
);

INSERT INTO user VALUES ('1', 'lujiahao', '123', now(),now());


drop table if exists permission;
CREATE TABLE permission (
   id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
   url VARCHAR(256) NULL COMMENT '权限地址',
   name VARCHAR(64) NULL COMMENT '权限名称'
);

INSERT INTO permission VALUES ('1', '/user/list', 'user:list');
INSERT INTO permission VALUES ('2', '/user/add', 'user:add');
INSERT INTO permission VALUES ('3', '/user/delete', 'user:delete');


drop table if exists role;
CREATE TABLE role (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(32) NULL COMMENT '角色名称',
    memo VARCHAR(32) NULL COMMENT '角色描述'
);

INSERT INTO role VALUES ('1', 'admin', '超级管理员');
INSERT INTO role VALUES ('2', 'test', '测试账户');


drop table if exists role_permission;
CREATE TABLE role_permission (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    rid bigint NULL COMMENT '角色id',
    pid bigint NULL COMMENT '权限id'
);

INSERT INTO role_permission VALUES ('1','1', '2');
INSERT INTO role_permission VALUES ('2','1', '3');
INSERT INTO role_permission VALUES ('3','2', '1');
INSERT INTO role_permission VALUES ('4','1', '1');


drop table if exists user_role;
CREATE TABLE user_role (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    uid bigint NULL COMMENT '用户id',
    rid bigint NULL COMMENT '角色id'
);

INSERT INTO user_role VALUES ('1','1', '1');
INSERT INTO user_role VALUES ('2','2', '2');