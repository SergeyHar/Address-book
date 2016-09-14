/*
SQLyog Community v11.52 (64 bit)
MySQL - 5.7.15-log : Database - address_book
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`address_book` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `address_book`;

/*Table structure for table `friends` */

DROP TABLE IF EXISTS `friends`;

CREATE TABLE `friends` (
  `user_id` int(3) NOT NULL,
  `friend_id` int(3) NOT NULL,
  KEY `user` (`user_id`),
  KEY `friend` (`friend_id`),
  CONSTRAINT `friend` FOREIGN KEY (`friend_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `friends` */

insert  into `friends`(`user_id`,`friend_id`) values (2,5),(2,5);

/*Table structure for table `tel_number` */

DROP TABLE IF EXISTS `tel_number`;

CREATE TABLE `tel_number` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `user_id` int(3) NOT NULL,
  `type` enum('mobile','home','work') DEFAULT 'mobile',
  `number` int(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tel_numbers` (`user_id`),
  CONSTRAINT `tel_numbers` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `tel_number` */

insert  into `tel_number`(`id`,`user_id`,`type`,`number`) values (3,2,'mobile',864864),(4,3,'work',13541);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`name`,`password`,`age`,`gender`) values (2,'hayk','dsf',NULL,NULL),(3,'karen','dsf',NULL,NULL),(5,'aram','sajdas',NULL,NULL),(6,'manvel','sdf',NULL,NULL),(7,'manvel','dasdas',NULL,NULL),(12,'manvel12','dasdas',NULL,NULL),(13,'145','dasdas',NULL,'545'),(14,'manvel','cc6e64edaef7731c65d29607cb493439',NULL,NULL),(15,'manvel','cc6e64edaef7731c65d29607cb493439',NULL,NULL),(16,'manvel','cc6e64edaef7731c65d29607cb493439',NULL,NULL),(19,'manvel','cc6e64edaef7731c65d29607cb493439',NULL,NULL),(20,'manvel','912ec803b2ce49e4a541068d495ab570',NULL,NULL),(21,'manvel15','912ec803b2ce49e4a541068d495ab570',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
