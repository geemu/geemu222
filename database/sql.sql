/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.28 : Database - geemu
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`geemu` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `geemu`;

/*Table structure for table `pass_tool_account` */

DROP TABLE IF EXISTS `pass_tool_account`;

CREATE TABLE `pass_tool_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '账号管理 账号表',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `account` varchar(20) NOT NULL DEFAULT '' COMMENT '账号',
  `password` varchar(20) NOT NULL DEFAULT '0' COMMENT '密码',
  `assortment_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '账号分类id',
  `sort` tinyint(4) NOT NULL DEFAULT '0' COMMENT '排序',
  `remark` varchar(20) NOT NULL DEFAULT '' COMMENT '备注',
  `is_valid` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否有效 0无效 1有效',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除 0未删除 1删除',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `pass_tool_account` */

insert  into `pass_tool_account`(`id`,`user_id`,`account`,`password`,`assortment_id`,`sort`,`remark`,`is_valid`,`is_delete`,`create_id`,`update_id`,`create_time`,`update_time`) values (1,1,'用户1的分类1','0',0,0,'','','\0',0,0,'1970-01-01 00:00:00','1970-01-01 00:00:00');

/*Table structure for table `pass_tool_assortment` */

DROP TABLE IF EXISTS `pass_tool_assortment`;

CREATE TABLE `pass_tool_assortment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '账号管理 用户表',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `assortment_name` varchar(20) NOT NULL DEFAULT '' COMMENT '分类名称',
  `sort` tinyint(20) NOT NULL DEFAULT '0' COMMENT '排序',
  `is_valid` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否有效 0无效 1有效',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除 0未删除 1删除',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `pass_tool_assortment` */

insert  into `pass_tool_assortment`(`id`,`user_id`,`assortment_name`,`sort`,`is_valid`,`is_delete`,`create_id`,`update_id`,`create_time`,`update_time`) values (1,1,'用户1的分类1',0,'','\0',0,0,'1970-01-01 00:00:00','1970-01-01 00:00:00');

/*Table structure for table `pass_tool_user_info` */

DROP TABLE IF EXISTS `pass_tool_user_info`;

CREATE TABLE `pass_tool_user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '账号管理 用户表',
  `account` varchar(20) NOT NULL DEFAULT '' COMMENT '账号',
  `password` varchar(20) NOT NULL DEFAULT '' COMMENT '密码',
  `nick_name` varchar(20) NOT NULL DEFAULT '' COMMENT '昵称',
  `phone` char(11) NOT NULL DEFAULT '' COMMENT '手机号',
  `email` varchar(20) NOT NULL DEFAULT '' COMMENT '邮箱',
  `is_valid` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否有效 0无效 1有效',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除 0未删除 1删除',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `pass_tool_user_info` */

insert  into `pass_tool_user_info`(`id`,`account`,`password`,`nick_name`,`phone`,`email`,`is_valid`,`is_delete`,`create_id`,`update_id`,`create_time`,`update_time`) values (1,'geemu','geemu','geemu','18852950875','cfmmail@sina.com','','\0',1,1,'2017-10-14 00:00:00','2017-10-14 00:00:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
