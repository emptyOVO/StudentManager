/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 8.0.31 : Database - studentlibrary
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`studentlibrary` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `studentlibrary`;

/*Table structure for table `classes` */

DROP TABLE IF EXISTS `classes`;

CREATE TABLE `classes` (
  `classid` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `classname` varchar(2) DEFAULT NULL,
  `studentid` int NOT NULL,
  `studentname` varchar(50) DEFAULT NULL,
  `studentsex` varchar(2) DEFAULT NULL,
  `studentintertime` date DEFAULT NULL,
  PRIMARY KEY (`studentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `classes` */

insert  into `classes`(`classid`,`classname`,`studentid`,`studentname`,`studentsex`,`studentintertime`) values ('01','一班',20190101,'张三四','男','2019-09-01'),('01','一班',20190102,'李四四','男','2019-09-01'),('01','一班',20190103,'王五四','女','2019-09-01'),('02','二班',20190201,'张三四','男','2019-09-01'),('02','二班',20190202,'李四四','男','2019-09-01'),('02','二班',20190203,'王五四','女','2019-09-01'),('01','一班',20200101,'张三三','男','2020-09-01'),('01','一班',20200102,'李四三','男','2020-09-01'),('01','一班',20200103,'王五三','女','2020-09-01'),('02','二班',20200201,'张三三','男','2020-09-01'),('02','二班',20200202,'李四三','男','2020-09-01'),('02','二班',20200203,'王五三','女','2020-09-01'),('01','一班',20210101,'张三二','男','2021-09-01'),('01','一班',20210102,'李四二','男','2021-09-01'),('01','一班',20210103,'王五二','女','2021-09-01'),('02','二班',20210201,'张三二','男','2021-09-01'),('02','二班',20210202,'李四二','男','2021-09-01'),('02','二班',20210203,'王五二','女','2021-09-01'),('01','一班',20220101,'张三一','男','2022-09-01'),('01','一班',20220102,'李四一','男','2022-09-01'),('01','一班',20220103,'王五一','女','2022-09-01'),('02','二班',20220201,'张三一','男','2022-09-01'),('02','二班',20220202,'李四一','男','2022-09-01'),('02','二班',20220203,'王五一','女','2022-09-01');

/*Table structure for table `students` */

DROP TABLE IF EXISTS `students`;

CREATE TABLE `students` (
  `id` varchar(8) NOT NULL,
  `name` varchar(50) NOT NULL,
  `sex` varchar(5) NOT NULL,
  `grade` varchar(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `students` */

insert  into `students`(`id`,`name`,`sex`,`grade`) values ('20190101','张三四','男','大四'),('20190102','李四四','男','大四'),('20190103','王五四','女','大四'),('20190201','张三四','男','大四'),('20190202','李四四','男','大四'),('20190203','王五四','女','大四'),('20200101','张三三','男','大三'),('20200102','李四三','男','大三'),('20200103','王五三','女','大三'),('20200201','张三三','男','大三'),('20200202','李四三','男','大三'),('20200203','王五三','女','大三'),('20210101','张三二','男','大二'),('20210102','李四二','男','大二'),('20210103','王五二','女','大二'),('20210201','张三二','男','大二'),('20210202','李四二','男','大二'),('20210203','王五二','女','大二'),('20220101','张三一','男','大一'),('20220102','李四一','男','大一'),('20220103','王五一','女','大一'),('20220201','张三一','男','大一'),('20220202','李四一','男','大一'),('20220203','王五一','女','大一');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
