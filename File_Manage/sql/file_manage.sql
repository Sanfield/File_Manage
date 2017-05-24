/*
SQLyog Ultimate v9.10 
MySQL - 5.1.73-community : Database - file_manage
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`file_manage` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `file_manage`;

/*Table structure for table `klfile` */

DROP TABLE IF EXISTS `klfile`;

CREATE TABLE `klfile` (
  `klfile_ID` int(11) NOT NULL AUTO_INCREMENT,
  `klfile_fileName` varchar(30) NOT NULL COMMENT '文件名',
  `klfile_author` varchar(30) NOT NULL COMMENT '上传者',
  `klfile_uploadingTime` varchar(30) NOT NULL DEFAULT '2017-01-01' COMMENT '上传时间',
  `klfile_visitTime` int(20) NOT NULL COMMENT '浏览次数',
  `klfile_downloads` int(20) NOT NULL COMMENT '下载次数',
  `klfile_fileType` varchar(10) NOT NULL COMMENT '文件类型',
  `klfile_fileSize` double DEFAULT NULL COMMENT '文件大小',
  `klfile_documentClassification` varchar(20) NOT NULL COMMENT '所在类型',
  PRIMARY KEY (`klfile_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `klfile` */

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `manager_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `manager_number` varchar(20) NOT NULL COMMENT '账号',
  `manager_password` varchar(30) NOT NULL COMMENT '登陆密码',
  `manager_lastTime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `manager_loginTime` int(11) DEFAULT '0' COMMENT '登陆次数',
  PRIMARY KEY (`manager_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `manager` */

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `student_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `student_number` varchar(20) NOT NULL COMMENT '学号',
  `student_password` varchar(30) NOT NULL COMMENT '登陆密码',
  `student_name` varchar(20) NOT NULL COMMENT '姓名',
  `student_phone` varchar(11) NOT NULL COMMENT '电话',
  `student_email` varchar(30) NOT NULL COMMENT '邮箱',
  `student_QQ` varchar(20) DEFAULT NULL COMMENT 'qq',
  `student_weChat` varchar(20) DEFAULT NULL COMMENT '微信',
  `student_brithday` varchar(20) DEFAULT '1990-01-01' COMMENT '生日',
  `student_class` varchar(10) DEFAULT NULL COMMENT '班级',
  `student_academy` varchar(20) DEFAULT NULL COMMENT '学院',
  `student_strongPoint` varchar(50) NOT NULL COMMENT '知识特长',
  `student_loginTime` int(10) DEFAULT NULL COMMENT '登陆次数',
  `student_lastTime` varchar(20) DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`student_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

/*Table structure for table `studentfile` */

DROP TABLE IF EXISTS `studentfile`;

CREATE TABLE `studentfile` (
  `studentFile_ID` int(11) NOT NULL AUTO_INCREMENT,
  `studentFile_fileName` varchar(50) NOT NULL COMMENT '浏览过的文件名',
  `studentFile_browseTime` varchar(20) NOT NULL DEFAULT '2017-01-01' COMMENT '浏览时间',
  `studentFile_download` int(11) NOT NULL DEFAULT '0' COMMENT '是否下载过(0没下载过)',
  `studentFile_studentName` varchar(20) NOT NULL COMMENT '学生姓名',
  `studentFile_uploading` int(11) NOT NULL DEFAULT '0' COMMENT '是否是本人上传(1为本人上传)',
  `studentFile_evaluate` varchar(100) DEFAULT NULL COMMENT '评价',
  PRIMARY KEY (`studentFile_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `studentfile` */

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `teacher_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '老师ID',
  `teacher_number` varchar(20) NOT NULL COMMENT '考试登陆账号',
  `teacher_password` varchar(30) NOT NULL COMMENT '登陆密码',
  `teacher_name` varchar(10) NOT NULL COMMENT '老师密码',
  `teacher_title` varchar(10) DEFAULT NULL COMMENT '老师职称',
  `teacher_duty` varchar(10) DEFAULT NULL COMMENT '职务',
  `teacher_department` varchar(20) DEFAULT NULL COMMENT '部门',
  `teacher_office` varchar(20) DEFAULT NULL COMMENT '办公室',
  `teacher_phone` varchar(11) NOT NULL COMMENT '电话',
  `teacher_telephone` varchar(11) DEFAULT NULL COMMENT '固定电话',
  `teacher_email` varchar(20) NOT NULL COMMENT '老师邮箱',
  `teacher_academy` varchar(20) DEFAULT NULL COMMENT '老师院系',
  `teacher_honor` varchar(100) DEFAULT NULL COMMENT '老师获奖情况',
  `teacher_loginTime` int(11) DEFAULT NULL COMMENT '登陆次数',
  `teacher_lastTime` varchar(10) DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`teacher_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

/*Table structure for table `teacherfile` */

DROP TABLE IF EXISTS `teacherfile`;

CREATE TABLE `teacherfile` (
  `teacherFile_ID` int(11) NOT NULL AUTO_INCREMENT,
  `teacherFile_fileName` varchar(30) NOT NULL COMMENT '老师浏览文件名',
  `teacherFile_browseTime` varchar(30) DEFAULT '2017-01-01' COMMENT '浏览时间',
  `teacherFile_download` int(11) NOT NULL DEFAULT '0' COMMENT '是否被下载过(0为没被下载过)',
  `teacherFile_teacherName` varchar(20) NOT NULL COMMENT '教师姓名',
  `teacherFile_uploading` int(11) DEFAULT '0' COMMENT '是否为本人上传(1为本人上传)',
  `teacherFile_evaluate` varchar(100) DEFAULT NULL COMMENT '对文件的评价',
  PRIMARY KEY (`teacherFile_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacherfile` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
