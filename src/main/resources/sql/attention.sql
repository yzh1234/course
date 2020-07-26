/*
 Navicat Premium Data Transfer

 Source Server         : 172.27.140.204
 Source Server Type    : MySQL
 Source Server Version : 100322
 Source Host           : 172.27.140.204:3306
 Source Schema         : course

 Target Server Type    : MySQL
 Target Server Version : 100322
 File Encoding         : 65001

 Date: 26/07/2020 23:35:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attention
-- ----------------------------
DROP TABLE IF EXISTS `attention`;
CREATE TABLE `attention`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NULL DEFAULT NULL COMMENT '学生id',
  `cid` int(11) NULL DEFAULT NULL COMMENT '课程id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attention
-- ----------------------------
INSERT INTO `attention` VALUES (4, 11, 7);
INSERT INTO `attention` VALUES (5, 11, 8);

SET FOREIGN_KEY_CHECKS = 1;
