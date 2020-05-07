/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.217.136
 Source Server Type    : MySQL
 Source Server Version : 50647
 Source Host           : 192.168.217.136:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50647
 File Encoding         : 65001

 Date: 07/05/2020 13:18:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` bigint(1) NULL DEFAULT NULL COMMENT '状态0.不可用1.可用',
  `create_by` int(11) NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '21232F297A57A5A743894A0E4A801FC3', NULL, 1, 0);
INSERT INTO `admin` VALUES (2, 'common', '9EFAB2399C7C560B34DE477B9AA0A465', NULL, 1, 1);
INSERT INTO `admin` VALUES (3, 'testtest', '670B14728AD9902AECBA32E22FA4F6BD', '2020-05-07 11:05:55', 1, NULL);

-- ----------------------------
-- Table structure for community
-- ----------------------------
DROP TABLE IF EXISTS `community`;
CREATE TABLE `community`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '小区名',
  `location` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '位置',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '小区表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of community
-- ----------------------------
INSERT INTO `community` VALUES (1, '11', '1', '2020-05-05 19:12:05');
INSERT INTO `community` VALUES (2, '22', '2', '2020-05-05 19:12:28');
INSERT INTO `community` VALUES (3, '华亭名苑', '中心路1450号', '2020-05-05 19:20:28');
INSERT INTO `community` VALUES (4, '', '12345678', '2020-05-05 19:43:42');
INSERT INTO `community` VALUES (5, '33', '33', '2020-05-05 19:44:50');
INSERT INTO `community` VALUES (6, '44', '44', '2020-05-07 11:28:35');

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容',
  `exam_date` datetime(0) NULL DEFAULT NULL COMMENT '测试时间',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '测试表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES (1, '2020-05-06', '1.你好吗?\n2.棒棒的?', '2020-05-06 00:00:00', '2020-05-06 11:35:44');
INSERT INTO `exam` VALUES (2, '1', '?', '2020-05-07 00:00:00', '2020-05-06 11:37:43');
INSERT INTO `exam` VALUES (3, '6', '6', '2020-05-07 00:00:00', '2020-05-07 10:33:05');
INSERT INTO `exam` VALUES (4, '4', '4', '2020-05-07 00:00:00', '2020-05-07 11:29:59');

-- ----------------------------
-- Table structure for exam_score
-- ----------------------------
DROP TABLE IF EXISTS `exam_score`;
CREATE TABLE `exam_score`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '昵称',
  `score` int(3) NULL DEFAULT NULL COMMENT '成绩',
  `exam_id` int(11) NULL DEFAULT NULL COMMENT '测试id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '测试标题',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '垃圾测验成绩表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of exam_score
-- ----------------------------
INSERT INTO `exam_score` VALUES (1, 1, NULL, 90, 1, NULL, NULL);

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '登录账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '登录密码',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '昵称',
  `gender` tinyint(1) NULL DEFAULT NULL COMMENT '性别0.保密1.男2.女',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机号',
  `type` int(1) NULL DEFAULT NULL COMMENT '类别',
  `province` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '省',
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '市',
  `area` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '区',
  `street` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '街道',
  `community_id` int(11) NULL DEFAULT NULL COMMENT '小区id',
  `community` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '小区',
  `unit_id` int(11) NULL DEFAULT NULL COMMENT '单元id',
  `unit` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '单元',
  `floor` int(2) NULL DEFAULT NULL COMMENT '楼层',
  `room` int(10) NULL DEFAULT NULL COMMENT '房间',
  `integral` decimal(10, 0) NULL DEFAULT NULL COMMENT '积分',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (1, '13027619526', '21232F297A57A5A743894A0E4A801FC3', NULL, NULL, NULL, '13027619526', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for trash
-- ----------------------------
DROP TABLE IF EXISTS `trash`;
CREATE TABLE `trash`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `community_id` int(11) NULL DEFAULT NULL COMMENT '小区id',
  `community` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '小区',
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '编号',
  `trash_type_id` int(11) NULL DEFAULT NULL COMMENT '垃圾分类Id',
  `trash_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '垃圾分类名称',
  `capacity` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '容量',
  `status` bigint(1) NULL DEFAULT NULL COMMENT '状态0.空1.未满2.已满',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '位置',
  `create_by` int(11) NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '垃圾桶表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of trash
-- ----------------------------
INSERT INTO `trash` VALUES (1, NULL, NULL, '111', 1, NULL, '111', 1, '2020-05-06 11:47:23', '1', NULL);

-- ----------------------------
-- Table structure for trash_knowledge
-- ----------------------------
DROP TABLE IF EXISTS `trash_knowledge`;
CREATE TABLE `trash_knowledge`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `trash_type_id` int(11) NULL DEFAULT NULL COMMENT '垃圾分类Id',
  `trash_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '垃圾分类名称',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '垃圾小知识表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of trash_knowledge
-- ----------------------------
INSERT INTO `trash_knowledge` VALUES (1, 1, NULL, '1', '1', '2020-05-06 11:46:42', NULL);
INSERT INTO `trash_knowledge` VALUES (2, 1, NULL, '2', '222', '2020-05-07 11:41:43', NULL);

-- ----------------------------
-- Table structure for trash_type
-- ----------------------------
DROP TABLE IF EXISTS `trash_type`;
CREATE TABLE `trash_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '类别名称',
  `status` bigint(1) NULL DEFAULT NULL COMMENT '状态0.不可用，1.可用',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '分类表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of trash_type
-- ----------------------------
INSERT INTO `trash_type` VALUES (1, '干垃圾', 1, '2020-05-05 21:00:18', NULL);
INSERT INTO `trash_type` VALUES (2, '湿垃圾', 1, '2020-05-05 21:00:50', NULL);
INSERT INTO `trash_type` VALUES (3, '不可回收垃圾', 1, '2020-05-05 21:01:24', NULL);

-- ----------------------------
-- Table structure for unit
-- ----------------------------
DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `community_id` int(11) NULL DEFAULT NULL COMMENT '小区id',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '几单元',
  `floor` int(11) NULL DEFAULT NULL COMMENT '多少层',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '位置',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '单元表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of unit
-- ----------------------------
INSERT INTO `unit` VALUES (1, 1, '1', 1, '2020-05-05 17:21:10', '1');
INSERT INTO `unit` VALUES (2, NULL, NULL, NULL, '2020-05-05 18:25:23', NULL);
INSERT INTO `unit` VALUES (3, NULL, NULL, NULL, '2020-05-05 18:25:29', NULL);
INSERT INTO `unit` VALUES (4, NULL, NULL, NULL, '2020-05-05 18:25:31', NULL);
INSERT INTO `unit` VALUES (5, NULL, NULL, NULL, '2020-05-05 18:25:31', NULL);
INSERT INTO `unit` VALUES (6, NULL, NULL, NULL, '2020-05-05 18:25:31', NULL);
INSERT INTO `unit` VALUES (7, NULL, NULL, NULL, '2020-05-05 18:25:32', NULL);
INSERT INTO `unit` VALUES (8, NULL, NULL, NULL, '2020-05-05 18:25:32', NULL);
INSERT INTO `unit` VALUES (9, NULL, NULL, NULL, '2020-05-05 18:25:37', NULL);
INSERT INTO `unit` VALUES (10, NULL, NULL, NULL, '2020-05-05 18:25:40', NULL);
INSERT INTO `unit` VALUES (11, NULL, NULL, NULL, '2020-05-05 18:26:59', NULL);
INSERT INTO `unit` VALUES (12, NULL, NULL, NULL, '2020-05-05 18:27:12', NULL);
INSERT INTO `unit` VALUES (13, NULL, '2', 2, '2020-05-05 18:29:34', '2');
INSERT INTO `unit` VALUES (14, NULL, '2', 2, '2020-05-05 18:29:44', '2');
INSERT INTO `unit` VALUES (15, NULL, '2', 2, '2020-05-05 18:29:45', '2');
INSERT INTO `unit` VALUES (16, NULL, '2', 2, '2020-05-05 18:29:45', '2');
INSERT INTO `unit` VALUES (17, NULL, '2', 2, '2020-05-05 18:29:45', '2');
INSERT INTO `unit` VALUES (18, NULL, '2', 2, '2020-05-05 18:29:53', '2');
INSERT INTO `unit` VALUES (19, NULL, '2', 2, '2020-05-05 18:29:54', '2');
INSERT INTO `unit` VALUES (20, NULL, '2', 2, '2020-05-05 18:29:54', '2');
INSERT INTO `unit` VALUES (21, NULL, '3', 3, '2020-05-05 18:30:47', '3');
INSERT INTO `unit` VALUES (22, 2, '22', 22, '2020-05-05 19:12:42', '22');
INSERT INTO `unit` VALUES (23, 6, '44', 44, '2020-05-07 11:28:55', '44');

SET FOREIGN_KEY_CHECKS = 1;
