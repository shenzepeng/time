/*
Navicat MySQL Data Transfer

Source Server         : http://47.102.113.146
Source Server Version : 50557
Source Host           : 47.102.113.146:3306
Source Database       : time

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2019-04-27 23:31:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `plan`
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blanck_space_three` varchar(255) DEFAULT NULL,
  `blanck_space_two` varchar(255) DEFAULT NULL,
  `blanck_space_one` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------

-- ----------------------------
-- Table structure for `remind`
-- ----------------------------
DROP TABLE IF EXISTS `remind`;
CREATE TABLE `remind` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blanck_space_three` varchar(255) DEFAULT NULL,
  `blanck_space_two` varchar(255) DEFAULT NULL,
  `blanck_space_one` varchar(255) DEFAULT NULL,
  `remind_way` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remind
-- ----------------------------

-- ----------------------------
-- Table structure for `trip`
-- ----------------------------
DROP TABLE IF EXISTS `trip`;
CREATE TABLE `trip` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blanck_space_three` varchar(255) DEFAULT NULL,
  `blanck_space_two` varchar(255) DEFAULT NULL,
  `blanck_space_one` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trip
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blanck_space_three` varchar(255) DEFAULT NULL,
  `blanck_space_two` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `blanck_space_one` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `qq_number` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('8', 'asd', 'adfs', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('9', null, null, null, null, 'asd', 'as', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('10', null, null, null, null, null, 'asdf', 'asf', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('11', null, null, null, null, null, null, null, 'asfd', null, null, null, null, null);
INSERT INTO `user` VALUES ('12', null, null, null, null, null, null, null, null, 'asd', null, null, null, null);
INSERT INTO `user` VALUES ('13', null, null, null, null, null, null, null, 'asd', null, null, null, null, null);
INSERT INTO `user` VALUES ('14', null, null, null, null, null, 'da', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('15', null, null, null, null, null, 'sdasd', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('16', null, null, null, null, 'ds', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('17', null, null, null, null, 'asdd', null, null, null, null, null, null, null, null);
