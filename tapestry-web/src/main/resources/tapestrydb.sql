/*
SQLyog Ultimate v9.50 
MySQL - 5.0.51b-community-nt : Database - tapestrydb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tapestrydb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tapestrydb`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(11) NOT NULL auto_increment,
  `firstname` varchar(100) default NULL,
  `lastname` varchar(100) default NULL,
  `email` varchar(100) default NULL,
  `passwd` varchar(100) default NULL,
  `registereddate` datetime default NULL,
  `companyname` varchar(255) default NULL,
  `country` varchar(50) default NULL,
  `city` varchar(50) default NULL,
  `street` varchar(50) default NULL,
  `address` text,
  `phone` varchar(100) default NULL,
  `skypeId` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`firstname`,`lastname`,`email`,`passwd`,`registereddate`,`companyname`,`country`,`city`,`street`,`address`,`phone`,`skypeId`) values (1,'Admin','Adminsky','admin@gmail.com','e10adc3949ba59abbe56e057f20f883e','2016-03-19 14:41:31','CarWash',NULL,NULL,NULL,'15 Sayat-Nova Ave, Yerevan, Armenia',NULL,NULL),(2,'Aram','Manukyan','armen@gmail.com','e10adc3949ba59abbe56e057f20f883e','2016-03-19 14:41:31','Lot of',NULL,NULL,NULL,NULL,NULL,NULL),(3,'Armen','Arzumanyan','armen.arzumanyan@gmail.com','0b4e7a0e5fe84ad35fb5f95b9ceeac79','2016-04-14 14:22:20','LuxSoft',NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
