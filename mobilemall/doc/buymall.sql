/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : buymall

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2015-10-27 22:12:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `ID` varchar(40) NOT NULL,
  `TITLE` varchar(128) NOT NULL COMMENT '名称',
  `ITEM_URL` varchar(255) NOT NULL COMMENT '链接地址',
  `IMG_URL` varchar(255) NOT NULL COMMENT '图片地址',
  `BANNER_DESC` varchar(255) DEFAULT NULL COMMENT '描述',
  `TYPE` int(2) DEFAULT '0' COMMENT '类型',
  `PAGE` varchar(128) DEFAULT NULL COMMENT '所属页面',
  `POSITION` int(6) DEFAULT NULL COMMENT '位置',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log` (
  `ID` varchar(40) NOT NULL,
  `APP_NAME` varchar(100) DEFAULT NULL COMMENT '应用名称',
  `LOGIN_TYPE` int(1) DEFAULT NULL COMMENT '登录类型0-正常，1-QQ，2-微博',
  `LOGIN_NAME` varchar(255) DEFAULT NULL COMMENT '登录名',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `ERROR_INFO` varchar(255) DEFAULT NULL COMMENT '异常信息',
  `IP_ADDR` varchar(100) DEFAULT NULL COMMENT 'IP地址',
  `ADDR` varchar(255) DEFAULT NULL COMMENT '访问者所在地址',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `ID` varchar(40) NOT NULL COMMENT '主键',
  `TITLE` varchar(255) DEFAULT NULL COMMENT '标题',
  `PRODUCT_DESC` varchar(255) DEFAULT NULL COMMENT '描述',
  `ITEM_URL` varchar(255) DEFAULT NULL COMMENT '产品地址',
  `IMG_URL` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `PRICE` varchar(30) NOT NULL DEFAULT '0.00' COMMENT '价格',
  `BUY_COUNT` varchar(50) DEFAULT NULL COMMENT '销量',
  `COLLECT_COUNT` varchar(50) DEFAULT NULL COMMENT '收藏数量',
  `SURPLUS_COUNT` varchar(50) DEFAULT NULL COMMENT '剩余数量',
  `SCORE` varchar(50) DEFAULT NULL COMMENT '得分',
  `ACT_DESC` varchar(50) DEFAULT NULL COMMENT '特色描述',
  `PLATFORM` varchar(100) DEFAULT NULL COMMENT '平台名称',
  `TYPE` int(2) NOT NULL DEFAULT '0' COMMENT '类型，1-女装，2-男装，3-内衣，4-鞋品，5-儿童，6-母婴，7-居家，8-食品，9-数码，10-箱包，11-美妆',
  `STATUS` int(1) NOT NULL DEFAULT '0' COMMENT '标示，0-正常，1-过期',
  `BZ1` varchar(255) DEFAULT NULL COMMENT '预留字段1',
  `BZ2` varchar(255) DEFAULT NULL COMMENT '预留字段2',
  `BZ3` varchar(255) DEFAULT NULL COMMENT '预留字段3',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `EXPIRE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '到期时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
