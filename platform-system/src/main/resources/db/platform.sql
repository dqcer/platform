/*
Navicat MySQL Data Transfer

Source Server         : localhost_33061
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : platform

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2019-07-29 21:58:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cost_time` bigint(20) NOT NULL COMMENT '耗时',
  `ip` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'IP',
  `request_param` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求参数',
  `request_type` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求类型',
  `request_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求路径',
  `method` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '请求方法',
  `response_status` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '返回状态码',
  `uid` int(11) NOT NULL COMMENT '操作人主键',
  `username` varchar(11) COLLATE utf8mb4_bin NOT NULL COMMENT '操作人用户名称',
  `name` varchar(11) COLLATE utf8mb4_bin NOT NULL COMMENT '操作人账户',
  `log_content` text COLLATE utf8mb4_bin NOT NULL COMMENT '操作详细日志',
  `log_type` int(11) NOT NULL COMMENT '日志类型（1登录日志，2操作日志）',
  `operate_type` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '操作类型',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL,
  `available` bit(1) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `permission` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `resource_type` enum('menu','button') COLLATE utf8mb4_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL,
  `available` bit(1) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `role` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  KEY `FKomxrs8a388bknvhjokh440waq` (`permission_id`),
  KEY `FK9q28ewrhntqeipl1t04kh1be7` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `role_id` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  KEY `FKgkmyslkrfeyn9ukmolvek8b8f` (`uid`),
  KEY `FKhh52n8vd4ny9ff4x9fb8v65qx` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `uid` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `salt` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `state` tinyint(4) NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
