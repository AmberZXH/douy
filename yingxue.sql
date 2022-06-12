/*
 Navicat Premium Data Transfer

 Source Server         : xindexin
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 8.136.187.29:3306
 Source Schema         : yingxue

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 12/06/2022 14:37:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(40) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `avatar` varchar(255) DEFAULT NULL COMMENT '用户头像地址',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted_at` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` (`id`, `username`, `password`, `avatar`, `created_at`, `updated_at`, `deleted_at`) VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'https://zxhblog.oss-cn-hangzhou.aliyuncs.com/img/image-20210802094633340.png', '2021-12-07 16:41:24', '2021-12-07 16:41:27', NULL);
COMMIT;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL COMMENT '名称',
  `parent_id` int DEFAULT NULL COMMENT '父级分类id',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category_category_1` (`parent_id`),
  CONSTRAINT `fk_category_category_1` FOREIGN KEY (`parent_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3 COMMENT='分类';

-- ----------------------------
-- Records of category
-- ----------------------------
BEGIN;
INSERT INTO `category` (`id`, `name`, `parent_id`, `created_at`, `updated_at`, `deleted_at`) VALUES (1, '微服务架构', NULL, '2021-12-09 20:24:46', '2021-12-25 08:39:28', NULL);
INSERT INTO `category` (`id`, `name`, `parent_id`, `created_at`, `updated_at`, `deleted_at`) VALUES (2, 'springAlibaba', 1, '2021-12-09 20:25:20', '2021-12-09 20:25:22', NULL);
INSERT INTO `category` (`id`, `name`, `parent_id`, `created_at`, `updated_at`, `deleted_at`) VALUES (3, 'zhangxuhui', 4, '2021-12-10 22:25:44', '2022-06-11 03:16:04', NULL);
INSERT INTO `category` (`id`, `name`, `parent_id`, `created_at`, `updated_at`, `deleted_at`) VALUES (4, '编程百科', NULL, '2021-12-25 16:40:01', '2021-12-25 16:40:03', NULL);
INSERT INTO `category` (`id`, `name`, `parent_id`, `created_at`, `updated_at`, `deleted_at`) VALUES (14, 'testOne', 4, '2021-12-25 09:08:54', '2021-12-25 09:53:28', '2021-12-25 09:53:28');
INSERT INTO `category` (`id`, `name`, `parent_id`, `created_at`, `updated_at`, `deleted_at`) VALUES (17, '内涵段子2', NULL, '2021-12-25 09:13:27', '2021-12-25 10:35:04', NULL);
INSERT INTO `category` (`id`, `name`, `parent_id`, `created_at`, `updated_at`, `deleted_at`) VALUES (18, '生活趣事', 17, '2021-12-25 09:14:02', '2021-12-25 09:24:13', '2021-12-25 09:24:13');
INSERT INTO `category` (`id`, `name`, `parent_id`, `created_at`, `updated_at`, `deleted_at`) VALUES (19, '古城往事', 17, '2021-12-25 09:52:53', '2021-12-25 09:52:53', NULL);
INSERT INTO `category` (`id`, `name`, `parent_id`, `created_at`, `updated_at`, `deleted_at`) VALUES (20, '科研', NULL, '2021-12-25 10:34:55', '2021-12-25 10:35:15', '2021-12-25 10:35:15');
INSERT INTO `category` (`id`, `name`, `parent_id`, `created_at`, `updated_at`, `deleted_at`) VALUES (21, 'Mybatis', 2, '2022-06-11 03:16:47', '2022-06-11 03:16:47', NULL);
INSERT INTO `category` (`id`, `name`, `parent_id`, `created_at`, `updated_at`, `deleted_at`) VALUES (22, 'mybatisdsss', 1, '2022-06-11 03:17:45', '2022-06-11 03:18:11', NULL);
INSERT INTO `category` (`id`, `name`, `parent_id`, `created_at`, `updated_at`, `deleted_at`) VALUES (23, '无敌', 17, '2022-06-11 07:24:16', '2022-06-11 07:24:23', '2022-06-11 07:24:23');
COMMIT;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL COMMENT '用户id',
  `video_id` int NOT NULL COMMENT '视频id',
  `content` text NOT NULL COMMENT '内容',
  `parent_id` int DEFAULT NULL COMMENT '父评论id',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comment_user_1` (`uid`),
  KEY `fk_comment_video_1` (`video_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`video_id`) REFERENCES `video` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3 COMMENT='评论';

-- ----------------------------
-- Records of comment
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for favorite
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL COMMENT '用户id',
  `video_id` int NOT NULL COMMENT '视频id',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_favorite_user_1` (`uid`),
  KEY `fk_favorite_video_1` (`video_id`),
  CONSTRAINT `fk_favorite_user_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_favorite_video_1` FOREIGN KEY (`video_id`) REFERENCES `video` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='收藏';

-- ----------------------------
-- Records of favorite
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for following
-- ----------------------------
DROP TABLE IF EXISTS `following`;
CREATE TABLE `following` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL COMMENT '用户id',
  `following_id` int NOT NULL COMMENT '被关注用户id',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_following_user_1` (`uid`),
  KEY `fk_following_user_2` (`following_id`),
  CONSTRAINT `fk_following_user_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_following_user_2` FOREIGN KEY (`following_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='关注';

-- ----------------------------
-- Records of following
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for played
-- ----------------------------
DROP TABLE IF EXISTS `played`;
CREATE TABLE `played` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL COMMENT '用户id',
  `video_id` int NOT NULL COMMENT '视频id',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_played_user_1` (`uid`),
  KEY `fk_played_video_1` (`video_id`),
  CONSTRAINT `fk_played_user_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_played_video_1` FOREIGN KEY (`video_id`) REFERENCES `video` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='播放历史';

-- ----------------------------
-- Records of played
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL COMMENT '用户名',
  `avatar` varchar(256) NOT NULL COMMENT '头像链接',
  `intro` varchar(256) NOT NULL COMMENT '简介',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `phone_linked` tinyint(1) NOT NULL COMMENT '是否绑定手机号',
  `openid` varchar(28) DEFAULT NULL COMMENT '微信openid',
  `wechat_linked` tinyint(1) NOT NULL COMMENT '是否绑定微信',
  `following_count` int NOT NULL COMMENT '关注数',
  `followers_count` int NOT NULL COMMENT '粉丝数',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COMMENT='用户';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `name`, `avatar`, `intro`, `phone`, `phone_linked`, `openid`, `wechat_linked`, `following_count`, `followers_count`, `created_at`, `updated_at`, `deleted_at`) VALUES (1, '张旭辉', 'https://zxhblog.oss-cn-hangzhou.aliyuncs.com/img/image-20210802094633340.png', '我自己本人', '17351442576', 1, 'wechat', 1, 0, 0, '2021-12-25 20:39:07', '2021-12-25 20:39:09', NULL);
INSERT INTO `user` (`id`, `name`, `avatar`, `intro`, `phone`, `phone_linked`, `openid`, `wechat_linked`, `following_count`, `followers_count`, `created_at`, `updated_at`, `deleted_at`) VALUES (2, 'wxw', 'https://zxhblog.oss-cn-hangzhou.aliyuncs.com/img/image-20210802094633340.png', '不是本文', '123123123', 1, 'wechat', 1, 0, 0, '2021-12-25 21:27:46', '2021-12-25 21:27:48', NULL);
INSERT INTO `user` (`id`, `name`, `avatar`, `intro`, `phone`, `phone_linked`, `openid`, `wechat_linked`, `following_count`, `followers_count`, `created_at`, `updated_at`, `deleted_at`) VALUES (3, 'wew', 'https://zxhblog.oss-cn-hangzhou.aliyuncs.com/img/image-20210802094633340.png', 'afa', '123123123', 1, '1', 0, 0, 0, '2021-12-25 22:46:44', '2021-12-25 22:46:46', NULL);
INSERT INTO `user` (`id`, `name`, `avatar`, `intro`, `phone`, `phone_linked`, `openid`, `wechat_linked`, `following_count`, `followers_count`, `created_at`, `updated_at`, `deleted_at`) VALUES (4, 'wws', 'https://zxhblog.oss-cn-hangzhou.aliyuncs.com/img/image-20210802094633340.png', 'sddsf', '1231241', 1, '1', 1, 1, 1, '2021-12-25 22:47:03', '2021-12-25 22:47:05', NULL);
INSERT INTO `user` (`id`, `name`, `avatar`, `intro`, `phone`, `phone_linked`, `openid`, `wechat_linked`, `following_count`, `followers_count`, `created_at`, `updated_at`, `deleted_at`) VALUES (5, 'wer', 'https://zxhblog.oss-cn-hangzhou.aliyuncs.com/img/image-20210802094633340.png', 'sdfs', '12', 1, '1', 1, 1, 1, '2021-12-25 22:47:29', '2021-12-25 22:47:31', NULL);
INSERT INTO `user` (`id`, `name`, `avatar`, `intro`, `phone`, `phone_linked`, `openid`, `wechat_linked`, `following_count`, `followers_count`, `created_at`, `updated_at`, `deleted_at`) VALUES (6, 'asdf', 'https://zxhblog.oss-cn-hangzhou.aliyuncs.com/img/image-20210802094633340.png', '8', '8', 8, '8', 8, 8, 8, '2021-12-25 22:48:19', '2021-12-25 22:48:20', NULL);
INSERT INTO `user` (`id`, `name`, `avatar`, `intro`, `phone`, `phone_linked`, `openid`, `wechat_linked`, `following_count`, `followers_count`, `created_at`, `updated_at`, `deleted_at`) VALUES (7, 'asf', 'https://zxhblog.oss-cn-hangzhou.aliyuncs.com/img/image-20210802094633340.png', '8', '8', 8, '8', 8, 8, 8, '2021-12-25 22:48:37', '2021-12-25 22:48:39', NULL);
INSERT INTO `user` (`id`, `name`, `avatar`, `intro`, `phone`, `phone_linked`, `openid`, `wechat_linked`, `following_count`, `followers_count`, `created_at`, `updated_at`, `deleted_at`) VALUES (8, 'efwe', 'https://zxhblog.oss-cn-hangzhou.aliyuncs.com/img/image-20210802094633340.png', '8', '8', 8, '8', 8, 8, 8, '2021-12-25 22:48:49', '2021-12-25 22:48:50', NULL);
INSERT INTO `user` (`id`, `name`, `avatar`, `intro`, `phone`, `phone_linked`, `openid`, `wechat_linked`, `following_count`, `followers_count`, `created_at`, `updated_at`, `deleted_at`) VALUES (9, 'wef', 'https://zxhblog.oss-cn-hangzhou.aliyuncs.com/img/image-20210802094633340.png', '8', '8', 8, '8', 8, 8, 8, '2021-12-02 22:49:02', '2021-12-25 22:49:06', NULL);
INSERT INTO `user` (`id`, `name`, `avatar`, `intro`, `phone`, `phone_linked`, `openid`, `wechat_linked`, `following_count`, `followers_count`, `created_at`, `updated_at`, `deleted_at`) VALUES (10, 'awefa', 'https://zxhblog.oss-cn-hangzhou.aliyuncs.com/img/image-20210802094633340.png', '8', '8', 8, '8', 8, 8, 8, '2021-12-25 22:47:55', '2021-12-25 22:47:59', NULL);
INSERT INTO `user` (`id`, `name`, `avatar`, `intro`, `phone`, `phone_linked`, `openid`, `wechat_linked`, `following_count`, `followers_count`, `created_at`, `updated_at`, `deleted_at`) VALUES (11, 'fwf', 'https://zxhblog.oss-cn-hangzhou.aliyuncs.com/img/image-20210802094633340.png', '8', '8', 8, '8', 8, 8, 8, '2021-12-25 22:49:22', '2021-12-25 22:49:23', NULL);
COMMIT;

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(64) NOT NULL COMMENT '标题',
  `intro` varchar(256) NOT NULL COMMENT '简介',
  `uid` int NOT NULL COMMENT 'up主id',
  `cover` varchar(256) NOT NULL COMMENT '视频封面链接',
  `link` varchar(256) NOT NULL COMMENT '视频播放链接',
  `category_id` int NOT NULL COMMENT '分类id',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_video_user_1` (`uid`),
  KEY `fk_video_tag_1` (`category_id`),
  CONSTRAINT `fk_video_tag_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_video_user_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 COMMENT='视频';

-- ----------------------------
-- Records of video
-- ----------------------------
BEGIN;
INSERT INTO `video` (`id`, `title`, `intro`, `uid`, `cover`, `link`, `category_id`, `created_at`, `updated_at`, `deleted_at`) VALUES (1, '张忘川的内心世界', '没有意思哈哈哈', 1, 'https://zxhblog.oss-cn-hangzhou.aliyuncs.com/img/image-20210802094633340.png', 'https://zxhblog.oss-cn-hangzhou.aliyuncs.com/img/image-20210802094633340.png', 1, '2021-12-26 03:10:05', '2021-12-26 03:10:08', NULL);
INSERT INTO `video` (`id`, `title`, `intro`, `uid`, `cover`, `link`, `category_id`, `created_at`, `updated_at`, `deleted_at`) VALUES (2, 'zxh', 'wudi', 2, 'https://zxhblog.oss-cn-hangzhou.aliyuncs.com/img/image-20210802094633340.png', 'https://zxhblog.oss-cn-hangzhou.aliyuncs.com/img/image-20210802094633340.png', 2, '2021-12-26 15:45:59', '2021-12-26 15:46:02', NULL);
INSERT INTO `video` (`id`, `title`, `intro`, `uid`, `cover`, `link`, `category_id`, `created_at`, `updated_at`, `deleted_at`) VALUES (3, 'zxh', 'wdsfa', 3, 'https://zxhblog.oss-cn-hangzhou.aliyuncs.com/img/image-20210802094633340.png', 'https://zxhblog.oss-cn-hangzhou.aliyuncs.com/img/image-20210802094633340.png', 4, '2021-12-26 15:47:41', '2021-12-26 15:47:43', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
