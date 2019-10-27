/*
Navicat MySQL Data Transfer

Source Server         : mysqltest
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : db_book

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2019-10-27 18:30:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_reader
-- ----------------------------
DROP TABLE IF EXISTS `tb_reader`;
CREATE TABLE `tb_reader` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `barcode` varchar(30) DEFAULT NULL,
  `vocation` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `paperType` varchar(10) DEFAULT NULL,
  `paperNO` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `operator` varchar(30) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `typeid` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_reader
-- ----------------------------
INSERT INTO `tb_reader` VALUES ('1', 'wgh', '男', '2008010100001', '的', '1980-07-17', '身份证', '2201041980********', '13634*******', 'wgh717@****.com', '2007-11-22', 'tsoft', '的', '1', null, null);
INSERT INTO `tb_reader` VALUES ('2', '的', '女', '123123123', '的', '1983-02-22', '身份证', '220', '', '', '2007-12-29', 'tsoft', '', '2', null, null);

-- ----------------------------
-- Table structure for tb_readertype
-- ----------------------------
DROP TABLE IF EXISTS `tb_readertype`;
CREATE TABLE `tb_readertype` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `number` int(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

