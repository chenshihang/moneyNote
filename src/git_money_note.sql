/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.22-0ubuntu0.16.04.1 : Database - git_money_note
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`git_money_note` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `git_money_note`;

/*Table structure for table `moneydetail` */

DROP TABLE IF EXISTS `moneydetail`;

CREATE TABLE `moneydetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `income` double(7,2) DEFAULT '0.00',
  `student_name` varchar(20) NOT NULL,
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `outcome` double(7,2) DEFAULT '0.00',
  `detail` double(7,2) NOT NULL,
  `create_time` datetime NOT NULL,
  `rest_money` double(7,2) NOT NULL COMMENT '结余',
  `notes` varchar(50) DEFAULT NULL COMMENT '备注',
  `student_id` int(11) NOT NULL,
  `record_by` varchar(20) NOT NULL COMMENT '记录人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `moneydetail` */

insert  into `moneydetail`(`id`,`income`,`student_name`,`description`,`outcome`,`detail`,`create_time`,`rest_money`,`notes`,`student_id`,`record_by`) values (1,20.00,'刘科辰','会费收取',0.00,1.00,'2017-10-11 00:00:00',20.00,'',20158750,'王学波'),(14,20.00,'吴金秋\r\n','会费收取',0.00,20.00,'2018-06-22 00:00:00',40.00,'',20158531,'陈世航'),(15,20.00,'林鑫\r\n','会费收取',0.00,20.00,'2018-06-22 00:00:00',60.00,'',20154860,'陈世航'),(16,20.00,'劳一柯\r\n','会费收取',0.00,20.00,'2018-06-22 00:00:00',80.00,'',201603648,'陈世航'),(17,20.00,'黄成','会费收取',0.00,20.00,'2018-06-22 00:00:00',100.00,'',20140234,'陈世航'),(18,20.00,'李爽\r\n','会费收取',0.00,20.00,'2018-06-22 00:00:00',120.00,'',20158474,'陈世航'),(19,20.00,'王学波','会费收取',0.00,20.00,'2018-06-22 00:00:00',140.00,'',201603869,'陈世航'),(20,20.00,'王名军\r\n','会费收取',0.00,20.00,'2018-06-22 00:00:00',160.00,'',20158557,'陈世航'),(21,0.00,'吴金秋\r\n','打印宣传单',7.00,-7.00,'2018-06-22 00:00:00',153.00,'无收据',20158531,'陈世航'),(22,20.00,'陈世航\r\n','会费收取',0.00,20.00,'2018-06-22 00:00:00',173.00,'',201604044,'陈世航'),(23,20.00,'李海涛\r\n','会费收取',0.00,20.00,'2018-06-22 00:00:00',193.00,'',20158589,'陈世航'),(24,20.00,'严兵','会费收取',0.00,20.00,'2018-06-22 00:00:00',213.00,'',20158711,'陈世航'),(25,0.00,'黄成','协会会旗制作',50.00,-50.00,'2018-06-22 00:00:00',163.00,'有收据（实付50）',20140234,'陈世航'),(26,0.00,'吴金秋\r\n','打印资料 ',12.50,-12.50,'2018-06-22 00:00:00',150.50,'无收据 ',20158531,'陈世航'),(27,1.00,'刘小葆\r\n','测试',2.00,-1.00,'2018-07-25 00:00:00',149.50,'测试备注',20158480,'陈世航');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(20) NOT NULL,
  `student_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`student_name`,`student_id`,`create_time`) values (1,'黄成',123456,'2017-06-01 00:00:00'),(2,'刘小葆\r\n',123456,'2017-06-01 00:00:00'),(4,'李海涛\r\n',123456,'2017-06-01 00:00:00'),(5,'严兵',123456,'2017-06-01 00:00:00'),(6,'王学波',123456,'2017-06-01 00:00:00'),(7,'唐香\r\n',123456,'2017-06-01 00:00:00'),(8,'陈世航\r\n',123456,'2017-06-01 00:00:00'),(9,'吴金秋\r\n',123456,'2017-06-01 00:00:00'),(10,'黄中圣\r\n',123456,'2017-06-01 00:00:00'),(11,'龚成平\r\n',123456,'2017-06-01 00:00:00'),(12,'张斌\r\n',123456,'2017-06-01 00:00:00'),(13,'薛志鹏\r\n',123456,'2017-06-01 00:00:00'),(14,'杨怀博\r\n',123456,'2017-06-01 00:00:00'),(15,'劳一柯\r\n',123456,'2017-06-01 00:00:00'),(16,'林鑫\r\n',123456,'2017-06-01 00:00:00'),(17,'刘科辰\r\n',123456,'2017-06-01 00:00:00'),(18,'王名军\r\n',123456,'2017-06-01 00:00:00'),(19,'许娜\r\n',123456,'2017-06-01 00:00:00'),(20,'李爽\r\n',123456,'2017-06-01 00:00:00'),(21,'苟正宇\r\n',123456,'2017-10-01 00:00:00'),(22,'罗鑫\r\n',123456,'2017-10-01 00:00:00'),(23,'陈菲扬\r\n',123456,'2017-10-01 00:00:00'),(25,'陈浩\r\n',123456,'2017-10-01 00:00:00'),(26,'刘述伟\r\n',123456,'2017-10-01 00:00:00'),(27,'王作文\r\n',123456,'2017-10-01 00:00:00'),(28,'代雄生\r\n',123456,'2017-10-01 00:00:00'),(29,'吴沿江\r\n',123456,'2017-10-01 00:00:00'),(30,'方胜\r\n',123456,'2017-10-01 00:00:00'),(31,'甘悠然\r\n',123456,'2017-10-01 00:00:00'),(32,'李珍珍\r\n',123456,'2017-10-01 00:00:00'),(33,'王正飞\r\n',123456,'2017-10-01 00:00:00'),(34,'林超\r\n',123456,'2017-10-01 00:00:00'),(35,'杨汶逸\r\n',123456,'2017-10-01 00:00:00'),(36,'王鸿杰\r\n',123456,'2017-10-01 00:00:00'),(37,'魏国华\r\n',123456,'2017-10-01 00:00:00'),(39,'谢李\r\n',123456,'2017-10-01 00:00:00'),(40,'刘禹辰\r\n',123456,'2017-10-01 00:00:00'),(41,'杜铁生\r\n',123456,'2017-10-01 00:00:00'),(42,'赵栩晨\r\n',123456,'2017-10-01 00:00:00'),(44,'廖思琪\r\n',123456,'2017-10-01 00:00:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;