# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.13)
# Database: VR_BANk
# Generation Time: 2019-08-07 23:21:57 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table ACCOUNT
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ACCOUNT`;

CREATE TABLE `ACCOUNT` (
  `branch` varchar(4) NOT NULL DEFAULT '',
  `basic` int(5) unsigned NOT NULL,
  `suffix` varchar(3) NOT NULL DEFAULT '',
  `balance` int(11) NOT NULL,
  KEY `branch` (`branch`),
  KEY `suffix` (`suffix`),
  KEY `basic` (`basic`),
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`branch`) REFERENCES `branch` (`branch_id`),
  CONSTRAINT `account_ibfk_2` FOREIGN KEY (`suffix`) REFERENCES `ACCOUNT_TYPES` (`id`),
  CONSTRAINT `account_ibfk_3` FOREIGN KEY (`basic`) REFERENCES `CUSTOMERS` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table ACCOUNT_TYPES
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ACCOUNT_TYPES`;

CREATE TABLE `ACCOUNT_TYPES` (
  `id` varchar(3) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table branch
# ------------------------------------------------------------

DROP TABLE IF EXISTS `branch`;

CREATE TABLE `branch` (
  `branch_id` varchar(4) NOT NULL DEFAULT '',
  PRIMARY KEY (`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table CUSTOMERS
# ------------------------------------------------------------

DROP TABLE IF EXISTS `CUSTOMERS`;

CREATE TABLE `CUSTOMERS` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `national number` int(9) NOT NULL,
  `nationality` varchar(2) NOT NULL DEFAULT '',
  `Tel_1` varchar(10) DEFAULT NULL,
  `Tel_2` varchar(10) DEFAULT NULL,
  `gender` char(1) NOT NULL DEFAULT '',
  `last_update_date` date NOT NULL,
  `creation_date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table TRANSACTIONS
# ------------------------------------------------------------

DROP TABLE IF EXISTS `TRANSACTIONS`;

CREATE TABLE `TRANSACTIONS` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account_number` varchar(13) NOT NULL DEFAULT '',
  `debit_value` int(6) DEFAULT NULL,
  `credit_value` int(6) DEFAULT NULL,
  `reference` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table USERS
# ------------------------------------------------------------

DROP TABLE IF EXISTS `USERS`;

CREATE TABLE `USERS` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(10) NOT NULL DEFAULT '',
  `password` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
