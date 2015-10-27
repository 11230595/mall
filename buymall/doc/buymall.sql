/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : buymall

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2015-10-27 17:42:22
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
  `CREATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for frame_url
-- ----------------------------
DROP TABLE IF EXISTS `frame_url`;
CREATE TABLE `frame_url` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `T_URL` varchar(255) DEFAULT NULL COMMENT '链接',
  `T_NAME` varchar(255) DEFAULT NULL COMMENT '显示的名字，如“全场包邮”',
  `T_SORT` int(2) DEFAULT NULL COMMENT '排序，暂时不用',
  `T_TYPE` int(2) DEFAULT NULL COMMENT '类型，0-9.9包邮，1-品牌特卖',
  `T_DESC` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8;

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
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `photo_id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键',
  `album_id` varchar(255) DEFAULT NULL COMMENT '相册id',
  `photo_name` varchar(50) NOT NULL DEFAULT '未命名' COMMENT '照片名称',
  `photo_desc` varchar(500) DEFAULT NULL COMMENT '照片描述',
  `photo_path` varchar(255) DEFAULT NULL COMMENT '照片路径',
  `photo_small_path` varchar(1200) DEFAULT NULL COMMENT '小图路径(现在用于商品地址)',
  `user_id` varchar(255) DEFAULT NULL COMMENT '上传人id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `del_flag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
  `view_count` int(11) DEFAULT NULL COMMENT '浏览次数',
  `turn_count` int(11) NOT NULL DEFAULT '0' COMMENT '被转次数',
  `act_desc` varchar(255) DEFAULT NULL COMMENT '打折说明',
  `turn_time` date DEFAULT NULL COMMENT '照片被转发时间',
  `photo_raw_id` varchar(255) DEFAULT NULL COMMENT '照片原id,如果照片是转过来的，则该字段有值',
  `price` double(11,2) DEFAULT '9.90' COMMENT '价格',
  `type` int(1) DEFAULT '0' COMMENT '类型0--其他  1--服装，2--鞋包，3--数码，4--食品，5--家居，6--健身按摩,7--美容护理，9--饰品',
  PRIMARY KEY (`photo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `ID` varchar(40) CHARACTER SET utf8 NOT NULL COMMENT '主键',
  `TITLE` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '标题',
  `PRODUCT_DESC` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '描述',
  `ITEM_URL` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '产品地址',
  `IMG_URL` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '图片地址',
  `BUY_COUNT` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '销量',
  `COLLECT_COUNT` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '收藏数量',
  `SURPLUS_COUNT` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '剩余数量',
  `SCORE` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '得分',
  `ACT_DESC` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '特色描述',
  `PLATFORM` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '平台名称',
  `TYPE` int(2) NOT NULL DEFAULT '0' COMMENT '类型，1-女装，2-男装，3-内衣，4-鞋品，5-儿童，6-母婴，7-居家，8-食品，9-数码，10-箱包，11-美妆',
  `STATUS` int(1) NOT NULL DEFAULT '0' COMMENT '标示，0-正常，1-过期',
  `BZ1` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '预留字段1',
  `BZ2` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '预留字段2',
  `BZ3` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '预留字段3',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `EXPIRE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '到期时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` char(36) NOT NULL DEFAULT '',
  `user_code` varchar(255) DEFAULT '',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `user_desc` varchar(500) DEFAULT NULL COMMENT '用户说明',
  `email` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `del_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记，0-未删除，1-删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` varchar(255) DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_code` (`user_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
