/*
SQLyog Ultimate v11.24 (32 bit)
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

/*Table structure for table `blog_user_info` */

DROP TABLE IF EXISTS `blog_user_info`;

CREATE TABLE `blog_user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '普通会员id',
  `nick_name` char(16) NOT NULL DEFAULT '' COMMENT '昵称 唯一',
  `email` varchar(20) NOT NULL DEFAULT '' COMMENT '邮箱',
  `phone_number` char(11) NOT NULL DEFAULT '' COMMENT '手机号',
  `password` char(20) NOT NULL DEFAULT '' COMMENT '密码',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除 0未删除 1删除',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `blog_user_info` */

insert  into `blog_user_info`(`id`,`nick_name`,`email`,`phone_number`,`password`,`is_delete`,`create_time`,`update_time`) values (1,'geemu','cfmmail@sina.com','18852950875','geemu','\0','2017-09-13 08:45:00','1970-01-01 00:00:00');

/*Table structure for table `passtool_user_info` */

DROP TABLE IF EXISTS `passtool_user_info`;

CREATE TABLE `passtool_user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '普通会员id',
  `nick_name` char(16) NOT NULL DEFAULT '' COMMENT '昵称 唯一',
  `email` varchar(20) NOT NULL DEFAULT '' COMMENT '邮箱',
  `phone_number` char(11) NOT NULL DEFAULT '' COMMENT '手机号',
  `password` char(20) NOT NULL DEFAULT '' COMMENT '密码',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除 0未删除 1删除',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `passtool_user_info` */

insert  into `passtool_user_info`(`id`,`nick_name`,`email`,`phone_number`,`password`,`is_delete`,`create_time`,`update_time`) values (1,'geemu','cfmmail@sina.com','18852950875','geemu','\0','2017-09-13 08:45:00','1970-01-01 00:00:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
