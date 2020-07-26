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

 Date: 26/07/2020 23:35:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `role` int(1) NULL DEFAULT NULL COMMENT '角色 0老师 1学生 3admin',
  `is_delete` int(1) NULL DEFAULT NULL COMMENT '0 未删除 1已删除',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES (11, '张三', 2, NULL, 'f29ab4c470105679f596a9138d6901b7');
INSERT INTO `person` VALUES (12, '李四', 2, NULL, 'f29ab4c470105679f596a9138d6901b7');
INSERT INTO `person` VALUES (13, '王五', 2, NULL, 'f29ab4c470105679f596a9138d6901b7');
INSERT INTO `person` VALUES (14, '王老师', 1, NULL, 'f29ab4c470105679f596a9138d6901b7');
INSERT INTO `person` VALUES (15, '李老师', 1, NULL, 'f29ab4c470105679f596a9138d6901b7');

SET FOREIGN_KEY_CHECKS = 1;
