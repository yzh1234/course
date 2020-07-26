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

 Date: 26/07/2020 23:35:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `tid` int(1) NULL DEFAULT NULL COMMENT '所属老师id',
  `is_delete` int(1) NULL DEFAULT NULL COMMENT '0 未删除 1已删除',
  `course_describe` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (7, '数学课', 14, NULL, 'ssss', NULL);
INSERT INTO `course` VALUES (8, '语文课', 14, NULL, 'ssss', NULL);
INSERT INTO `course` VALUES (9, '体育课', 15, NULL, 'ssss', NULL);

SET FOREIGN_KEY_CHECKS = 1;
