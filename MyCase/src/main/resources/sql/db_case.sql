/*
SQLyog Ultimate v9.10 
MySQL - 5.7.15-log : Database - db_case
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_case` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_case`;

/*Table structure for table `case` */

DROP TABLE IF EXISTS `case`;

CREATE TABLE `case` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '案件id',
  `title` varchar(255) DEFAULT NULL COMMENT '案件标题',
  `name` varchar(255) DEFAULT NULL COMMENT '案件名称',
  `customer_name` varchar(255) DEFAULT NULL COMMENT '原告,客户公司名字',
  `debtor_name` varchar(255) DEFAULT NULL COMMENT '债务人，债务方,被告公司名称',
  `customer_linkman_name` varchar(255) DEFAULT NULL COMMENT '客户联系人电话',
  `customer_linkman_tel` varchar(11) DEFAULT NULL COMMENT '客户联系人电话',
  `debtor_user_name` varchar(255) DEFAULT NULL COMMENT '债务人名称',
  `debtor_linkman_name` varchar(255) DEFAULT NULL COMMENT '债务方联系人名字',
  `debtor_linkman_tel` varchar(255) DEFAULT NULL COMMENT '债务方联系人电话',
  `address` varchar(255) DEFAULT NULL COMMENT '案件地址',
  `brokerage` decimal(20,2) DEFAULT NULL COMMENT '应获得的佣金',
  `brokerage_rate` decimal(4,2) DEFAULT NULL COMMENT '应获得的佣金比例',
  `brokerage_desc` varchar(255) DEFAULT NULL COMMENT '佣金备注',
  `brokerage_paid` decimal(20,2) DEFAULT NULL COMMENT '客户已支付的佣金',
  `invoice` decimal(20,2) DEFAULT NULL COMMENT '发票的已开票金额',
  `contract_begin_date` datetime DEFAULT NULL COMMENT '合同开始时间',
  `contract_end_date` datetime DEFAULT NULL COMMENT '合同结束时间',
  `contract_money` decimal(20,2) DEFAULT NULL COMMENT '合同金额',
  `contract_paid_money` decimal(20,2) DEFAULT NULL COMMENT '合同已付金额',
  `salesman` varchar(255) DEFAULT NULL COMMENT '案件销售人员',
  `status` tinyint(3) unsigned DEFAULT NULL COMMENT '默认为0,1未分配,2未处理,运作中(3-11, 3非法暂停,4转诉讼,5诉讼中,6执行阶段{停滞中},\r\n7执行阶段{履行中},8准备关闭,9关闭原因{客户关闭},10关闭原因{案件关闭}),11回款中,12已结案',
  `type` tinyint(255) unsigned DEFAULT '0' COMMENT '案件性质/类型，1为优质案件，2普通案件，3尝试案件',
  `handle_user` bigint(20) unsigned DEFAULT NULL COMMENT '当前经办人',
  `handle_manager` bigint(20) DEFAULT NULL COMMENT '经办主管',
  `create_date` datetime DEFAULT NULL COMMENT '案件的创建时间',
  `updated_date` datetime DEFAULT NULL COMMENT '信息更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `case` */

/*Table structure for table `case_opera_log` */

DROP TABLE IF EXISTS `case_opera_log`;

CREATE TABLE `case_opera_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id记录',
  `case_id` int(11) unsigned DEFAULT NULL COMMENT '案件id',
  `log_desc` varchar(300) DEFAULT NULL COMMENT '当前案件 处理情况描述',
  `create_date` datetime DEFAULT NULL COMMENT '当前操作的记录时间',
  `user_id` bigint(11) unsigned DEFAULT NULL COMMENT '执行律师的用户id',
  `next_status` tinyint(3) unsigned DEFAULT NULL,
  `pre_status` tinyint(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `case_opera_log` */

/*Table structure for table `case_status` */

DROP TABLE IF EXISTS `case_status`;

CREATE TABLE `case_status` (
  `id` tinyint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `case_status` */

insert  into `case_status`(`id`,`name`) values (1,NULL);

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `create_date` datetime DEFAULT NULL COMMENT '部门创建时间',
  `creater` varchar(50) DEFAULT NULL COMMENT '创建者的名字',
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `count` int(11) unsigned DEFAULT NULL COMMENT '部门人数',
  `pre_dept` int(11) unsigned DEFAULT '0' COMMENT '该部门的父部门',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `dept` */

insert  into `dept`(`id`,`create_date`,`creater`,`name`,`count`,`pre_dept`) values (16,'2018-12-24 20:14:58','李四','采购部',NULL,0);

/*Table structure for table `job` */

DROP TABLE IF EXISTS `job`;

CREATE TABLE `job` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '岗位id',
  `name` varchar(255) DEFAULT NULL COMMENT '岗位名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `type` int(11) unsigned DEFAULT NULL COMMENT '岗位类别',
  `count` int(11) unsigned DEFAULT NULL COMMENT '该岗位目前的人数',
  `deptId` int(20) DEFAULT NULL COMMENT '所属部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `job` */

insert  into `job`(`id`,`name`,`create_date`,`type`,`count`,`deptId`) values (1,'总管',NULL,0,NULL,NULL),(2,'采购',NULL,0,NULL,NULL);

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menuName` varchar(200) DEFAULT NULL COMMENT '菜单名',
  `description` varchar(200) DEFAULT NULL COMMENT '菜单描述',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单链接',
  `parentId` bigint(20) DEFAULT NULL COMMENT '父级菜单id',
  `creater` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`id`,`menuName`,`description`,`url`,`parentId`,`creater`,`create_time`,`icon`) values (5,'部门管理','对部门进行管理','',0,NULL,NULL,NULL),(7,'创建部门','对部门进行创建','/dept/add?one=1',5,NULL,NULL,NULL),(8,'部门列表',NULL,'/dept/index?one=1',5,NULL,NULL,NULL),(9,'公告管理',NULL,NULL,0,NULL,NULL,NULL),(10,'发布公告',NULL,'/notice/add',9,NULL,NULL,NULL),(11,'公告列表',NULL,'/notice/index',9,NULL,NULL,NULL),(12,'角色管理',NULL,NULL,0,NULL,NULL,NULL),(13,'创建角色',NULL,'/role/add?one=1',12,NULL,NULL,NULL),(14,'角色列表',NULL,'/role/index?one=1',12,NULL,NULL,NULL),(18,'菜单管理',NULL,NULL,0,NULL,NULL,NULL),(19,'创建菜单',NULL,'/menu/add?one=1',18,NULL,NULL,NULL),(20,'菜单列表',NULL,'/menu/index?one=1',18,NULL,NULL,NULL),(26,'权限管理','对权限进行管理的一级菜单','',0,1,'2018-12-26 14:20:43',NULL),(27,'创建权限','','/url/add?one=1',26,1,'2018-12-26 14:45:40',NULL),(29,'权限列表','','/url/index?one=1',26,1,'2018-12-26 15:49:05',NULL),(30,'用户管理','对用户进行管理','',0,1,'2018-12-26 22:08:47',NULL),(31,'创建用户','新增用户','/users/add?one=1',30,1,'2018-12-26 22:10:07',NULL),(32,'用户列表','','/users/index?one=1',30,1,'2018-12-26 22:10:40',NULL),(34,'案件管理','','',0,1,'2018-12-27 12:47:30',NULL);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名',
  `description` varchar(200) DEFAULT NULL COMMENT '角色描述',
  `creater` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`role_id`,`role_name`,`description`,`creater`,`create_time`) values (36,'系统管理员','对系统进行管理以及设置，可以进行权限管理角色管理',1,'2018-12-14 14:31:11'),(37,'大声道','333方法',1,'2018-12-14 14:56:57'),(40,'办公','大叔大婶大声道',1,'2018-12-15 15:08:25'),(43,'法法','法法',1,'2018-12-16 22:25:38'),(46,'律师','对案件进行管理',1,'2018-12-24 14:50:06'),(52,'管理员','普通管理员',1,'2018-12-25 13:44:58');

/*Table structure for table `role_menu` */

DROP TABLE IF EXISTS `role_menu`;

CREATE TABLE `role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户角色ID',
  `roleid` bigint(20) NOT NULL COMMENT '角色id',
  `menuid` bigint(20) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `role_menu` */

insert  into `role_menu`(`id`,`roleid`,`menuid`) values (13,36,8),(14,36,13),(15,36,14),(17,36,19),(18,36,20),(19,36,27),(20,36,29),(21,36,7),(22,36,31),(23,36,32),(24,52,19),(25,52,20),(26,52,27),(27,52,29),(28,46,13),(29,46,14),(34,52,7),(35,52,8);

/*Table structure for table `role_url` */

DROP TABLE IF EXISTS `role_url`;

CREATE TABLE `role_url` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户链接ID',
  `roleid` bigint(20) NOT NULL COMMENT '角色id',
  `urlid` bigint(20) NOT NULL COMMENT '链接id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

/*Data for the table `role_url` */

insert  into `role_url`(`id`,`roleid`,`urlid`) values (9,36,5),(10,36,1),(11,36,2),(12,36,3),(13,36,4),(15,36,6),(16,36,7),(17,36,9),(18,36,10),(19,36,11),(20,36,13),(21,36,14),(22,36,15),(23,36,16),(24,36,8),(25,52,6),(26,52,7),(27,52,8),(28,52,9),(29,52,10),(30,52,11),(31,46,1),(32,46,2),(33,46,3),(38,52,13),(39,52,5);

/*Table structure for table `url` */

DROP TABLE IF EXISTS `url`;

CREATE TABLE `url` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户角色ID',
  `urlName` varchar(200) DEFAULT NULL COMMENT '权限链接名',
  `url` varchar(200) DEFAULT NULL COMMENT '权限链接',
  `mid` bigint(20) DEFAULT NULL COMMENT '所属菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `url` */

insert  into `url`(`id`,`urlName`,`url`,`mid`) values (1,'新增','/role/add',13),(2,'修改','/role/add',14),(3,'删除','/role/remove',14),(4,'查询','/role/index',14),(5,'查询','/dept/index',8),(6,'新增与修改','/menu/add',19),(7,'查询','/menu/index',20),(8,'删除','/menu/remove',20),(9,'权限新增与修改','/url/add',27),(10,'权限查询','/url/index',29),(11,'权限删除','/url/remove',29),(13,'新增与修改部门','/dept/add',7),(14,'创建与新增用户','/users/add',31),(15,'查询用户','/users/index',32),(16,'删除用户','/users/remove',32);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `tel` varchar(16) DEFAULT NULL COMMENT '电话',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名字',
  `password` varchar(65) DEFAULT NULL COMMENT '密码',
  `job_id` bigint(20) unsigned DEFAULT NULL COMMENT 'g工作职位编号',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `create_date` datetime DEFAULT NULL COMMENT '用户创建时间',
  `creater` varchar(255) DEFAULT NULL,
  `dept_id` bigint(20) DEFAULT NULL,
  `is_active` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`user_id`,`tel`,`username`,`password`,`job_id`,`email`,`create_date`,`creater`,`dept_id`,`is_active`) values (1,'17828168689','李四','ls',1,NULL,NULL,NULL,3,0),(2,'1111','王五','ws',1,NULL,NULL,NULL,3,0);

/*Table structure for table `users_role` */

DROP TABLE IF EXISTS `users_role`;

CREATE TABLE `users_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户角色ID',
  `uid` bigint(20) NOT NULL COMMENT '用户id',
  `rid` bigint(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `users_role` */

insert  into `users_role`(`id`,`uid`,`rid`) values (1,1,36),(2,2,52);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
