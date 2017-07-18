/*
SQLyog Enterprise v12.09 (32 bit)
MySQL - 5.5.27 : Database - cafemanagement
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cafemanagement` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `cafemanagement`;

/*Table structure for table `orders` */
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) DEFAULT NULL,
  `password` VARCHAR(255) DEFAULT NULL,
  `role` ENUM('MANAGER','WAITER') DEFAULT 'WAITER',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

INSERT INTO `users` VALUES (1,'manager','1','MANAGER'),(2,'name','1','WAITER'),(3,'Ruben','1','WAITER'),(4,'WaiterName','1','WAITER'),(5,'John','1','WAITER');

CREATE TABLE `tables` (
  `table_id` INT(11) NOT NULL AUTO_INCREMENT,
  `table_name` VARCHAR(25) NOT NULL,
  `table_status` TINYINT(1) DEFAULT 1,
  `user_id` INT(11) DEFAULT NULL,
  PRIMARY KEY (`table_id`),
  KEY `fk_tables_1_idx` (`user_id`),
  CONSTRAINT `fk_tables_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

INSERT INTO `tables` VALUES (1,'table1',0,3),(2,'table2',0,2),(3,'table3',0,4),(4,'table4',0,5);

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `status` ENUM('OPEN','CLOSED','CANCELLED') DEFAULT 'OPEN',
  `table_id` INT(11) DEFAULT NULL,
  KEY `fk_order_1_idx` (`table_id`),
  CONSTRAINT `fk_order_1` FOREIGN KEY (`table_id`) REFERENCES `tables` (`table_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

INSERT INTO `orders` VALUES (1,'CANCELLED',1),(2,'OPEN',1),(3,'OPEN',2);

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `product_id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `product_name` VARCHAR(50) NOT NULL,
  `price` DOUBLE NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

INSERT INTO `product` VALUES (1,'coffee',50),(2,'tea',100),(3,'juice',150),(4,'Biskvit',200),(5,'CocaCila',250);


DROP TABLE IF EXISTS `product_in_order`;
CREATE TABLE `product_in_order` (
  `product_id` INT(11) NOT NULL,
  `order_id` INT(11) NOT NULL,
  `amount` INT(11) NOT NULL,
  `status` ENUM('ACTIVE','CANCELLED') DEFAULT 'ACTIVE',
  PRIMARY KEY (`product_id`,`order_id`)
) ENGINE=INNODB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

INSERT INTO `product_in_order` VALUES (1,1,1,'ACTIVE'),(1,2,1,'ACTIVE'),(1,3,1,'ACTIVE'),(1,4,1,'ACTIVE'),(2,2,1,'ACTIVE'),
(2,3,1,'ACTIVE'),(2,4,2,'ACTIVE'),(3,3,1,'ACTIVE'),(4,1,2,'ACTIVE'),(4,3,1,'ACTIVE'),(4,5,2,'ACTIVE'),(5,1,2,'ACTIVE');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
