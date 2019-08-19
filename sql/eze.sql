/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : eze

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 14/08/2019 23:05:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department` (
  `id` varchar(32) NOT NULL COMMENT '部门表',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父ID 上级部门',
  `sort_order` smallint(4) unsigned DEFAULT '50',
  `status` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '正常0 冻结1',
  `deptName` varchar(32) DEFAULT NULL COMMENT '公司名称(部门名称)',
  `level` smallint(3) unsigned DEFAULT '50' COMMENT '层级',
  `full_name` varchar(32) DEFAULT NULL COMMENT '公司或部门全称',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(32) NOT NULL COMMENT '菜单表',
  `record_id` varchar(32) DEFAULT NULL COMMENT '记录 ID',
  `name` varchar(32) DEFAULT NULL COMMENT '菜单权限名称',
  `component` varchar(32) DEFAULT NULL COMMENT '前端组件地址',
  `path` varchar(32) DEFAULT NULL COMMENT '页面路径 前端组件URL',
  `title` varchar(32) DEFAULT NULL COMMENT '菜单标题',
  `icon` varchar(32) DEFAULT NULL COMMENT '菜单图标',
  `sort_order` smallint(4) unsigned DEFAULT '50' COMMENT '排序值',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父ID 上级菜单ID',
  `level` smallint(3) unsigned DEFAULT '0' COMMENT '层级',
  `status` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '正常0 冻结1',
  `url` varchar(32) DEFAULT NULL COMMENT '菜单为网页连接 是URL',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES ('172235609287430144', NULL, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 'aaaa', 50, NULL, 0, 0, 'aaaa', '2019-08-09 12:55:10', '2019-08-09 12:55:10');
INSERT INTO `sys_menu` VALUES ('172235718804901888', NULL, 'bbbb', 'bbbb', 'bbbb', 'bbbb', 'bbbb', 50, NULL, 0, 0, 'bbbb', '2019-08-09 12:55:36', '2019-08-09 12:55:36');
INSERT INTO `sys_menu` VALUES ('172235758004867072', NULL, 'cccc', 'cccc', 'cccc', 'cccc', 'cccc', 50, NULL, 0, 0, 'cccc', '2019-08-09 12:55:46', '2019-08-09 12:55:46');
INSERT INTO `sys_menu` VALUES ('172235809674498048', NULL, 'dddd', 'dddd', 'dddd', 'dddd', 'dddd', 50, NULL, 0, 0, 'dddd', '2019-08-09 12:55:58', '2019-08-09 12:55:58');
INSERT INTO `sys_menu` VALUES ('172236003749138432', NULL, 'qqqq', 'qqqq', 'qqqq', 'qqqq', 'qqqq', 50, '172235609287430144', 0, 0, 'qqqq', '2019-08-09 12:56:44', '2019-08-09 12:56:44');
INSERT INTO `sys_menu` VALUES ('172236079997390848', NULL, 'wwww', 'wwww', 'wwww', 'wwww', 'wwww', 50, '172235609287430144', 0, 0, 'wwww', '2019-08-09 12:57:02', '2019-08-09 12:57:02');
INSERT INTO `sys_menu` VALUES ('172236178412539904', NULL, 'eeee', 'eeee', 'eeee', 'eeee', 'eeee', 50, '172236079997390848', 0, 0, 'eeee', '2019-08-09 12:57:26', '2019-08-09 12:57:26');
INSERT INTO `sys_menu` VALUES ('172238595988393984', NULL, 'rrrr', 'rrrr', 'rrrr', 'rrrr', 'rrrr', 50, '172236178412539904', 0, 0, 'rrrr', '2019-08-09 13:07:02', '2019-08-09 13:07:02');
INSERT INTO `sys_menu` VALUES ('172238700959240192', NULL, 'ttttt', 'ttttt', 'ttttt', 'ttttt', 'ttttt', 50, '172236178412539904', 0, 0, 'ttttt', '2019-08-09 13:07:27', '2019-08-09 13:07:27');
INSERT INTO `sys_menu` VALUES ('172238802050355200', NULL, 'yyyy', 'yyyy', 'yyyy', 'yyyy', 'yyyy', 50, '172236079997390848', 0, 0, 'yyyy', '2019-08-09 13:07:51', '2019-08-09 13:07:51');
INSERT INTO `sys_menu` VALUES ('172238936037396480', NULL, 'uuuu', 'uuuu', 'uuuu', 'uuuu', 'uuuu', 50, '172238802050355200', 0, 0, 'uuuu', '2019-08-09 13:08:23', '2019-08-09 13:08:23');
INSERT INTO `sys_menu` VALUES ('172239145630961664', NULL, 'iiii', 'iiii', 'iiii', 'iiii', 'iiii', 50, '172235809674498048', 0, 0, 'iiii', '2019-08-09 13:09:13', '2019-08-09 13:09:13');
INSERT INTO `sys_menu` VALUES ('172239223930228736', NULL, 'oooo', 'oooo', 'oooo', 'oooo', 'oooo', 50, '172239145630961664', 0, 0, 'oooo', '2019-08-09 13:09:32', '2019-08-09 13:09:32');
INSERT INTO `sys_menu` VALUES ('172239319086403584', NULL, 'ppppp', 'ppppp', 'ppppp', 'ppppp', 'ppppp', 50, '172235809674498048', 0, 0, 'ppppp', '2019-08-09 13:09:55', '2019-08-09 13:09:55');
COMMIT;

-- ----------------------------
-- Table structure for sys_menu_action
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_action`;
CREATE TABLE `sys_menu_action` (
  `id` varchar(32) NOT NULL COMMENT '动作表',
  `menu_id` varchar(32) DEFAULT NULL COMMENT '菜单ID',
  `code` smallint(4) unsigned NOT NULL COMMENT '动作编号',
  `menu_action_name` varchar(32) DEFAULT NULL COMMENT '动作名称',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_menu_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_resource`;
CREATE TABLE `sys_menu_resource` (
  `id` varchar(32) NOT NULL COMMENT '请求资源表',
  `menu_id` varchar(32) DEFAULT NULL COMMENT '菜单ID',
  `code` smallint(4) unsigned NOT NULL COMMENT '资源编号',
  `menu_resource_name` varchar(20) DEFAULT NULL COMMENT '资源名称',
  `method` varchar(8) DEFAULT NULL COMMENT '资源请求方式',
  `path` varchar(20) DEFAULT NULL COMMENT '资源请求路径',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(32) NOT NULL COMMENT '角色表',
  `record_id` varchar(32) DEFAULT NULL COMMENT '记录 ID',
  `role_name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `sort_order` smallint(4) unsigned DEFAULT '50',
  `memo` varchar(32) DEFAULT NULL COMMENT '备注',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` varchar(32) NOT NULL COMMENT '角色与菜单关联表',
  `menu_id` varchar(32) DEFAULT NULL COMMENT '菜单表ID',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色表ID',
  `action` varchar(128) DEFAULT NULL COMMENT '动作编号（多个以英文逗号分隔）',
  `resource` varchar(128) DEFAULT NULL COMMENT '资源编号（多个以英文逗号分隔）',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(32) NOT NULL COMMENT '用户表',
  `record_id` varchar(32) DEFAULT NULL COMMENT '记录 ID',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `real_name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '正常0 冻结1',
  `avatar` varchar(128) DEFAULT NULL COMMENT '头像',
  `department_id` varchar(32) DEFAULT NULL COMMENT '所属于公司 所属公司ID',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(32) NOT NULL COMMENT '用户角色关联表',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色ID',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
