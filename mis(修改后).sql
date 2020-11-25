/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : mis

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-11-25 16:27:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `cardid` int NOT NULL AUTO_INCREMENT,
  `cardtype` varchar(50) NOT NULL,
  `discount` float NOT NULL DEFAULT '1',
  PRIMARY KEY (`cardid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------

-- ----------------------------
-- Table structure for casehistory
-- ----------------------------
DROP TABLE IF EXISTS `casehistory`;
CREATE TABLE `casehistory` (
  `caseid` int NOT NULL AUTO_INCREMENT,
  `doctorid` int NOT NULL,
  `patientid` int NOT NULL,
  `sickinfo` varchar(200) NOT NULL,
  `recorddate` datetime NOT NULL,
  PRIMARY KEY (`caseid`),
  KEY `doctorpk3` (`doctorid`),
  KEY `patientid` (`patientid`),
  CONSTRAINT `doctorpk3` FOREIGN KEY (`doctorid`) REFERENCES `doctor` (`doctorid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patientid` FOREIGN KEY (`patientid`) REFERENCES `patient` (`patientid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of casehistory
-- ----------------------------
INSERT INTO `casehistory` VALUES ('2', '2', '5', 'k', '2020-11-24 21:34:31');
INSERT INTO `casehistory` VALUES ('1007', '2', '5', '难受', '2020-11-24 21:19:45');

-- ----------------------------
-- Table structure for cost
-- ----------------------------
DROP TABLE IF EXISTS `cost`;
CREATE TABLE `cost` (
  `serialid` int NOT NULL AUTO_INCREMENT,
  `outpatientid` int NOT NULL,
  `patientid` int NOT NULL,
  `drugcost` int NOT NULL,
  `registrationcost` int NOT NULL,
  `total` int NOT NULL,
  `state` varchar(2) NOT NULL,
  PRIMARY KEY (`serialid`),
  KEY `outpatientpk3` (`outpatientid`),
  KEY `patientpk3` (`patientid`),
  CONSTRAINT `outpatientpk3` FOREIGN KEY (`outpatientid`) REFERENCES `outpatient` (`outpatientid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patientpk3` FOREIGN KEY (`patientid`) REFERENCES `patient` (`patientid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cost
-- ----------------------------

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `departmentid` int NOT NULL AUTO_INCREMENT,
  `dptname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`departmentid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '外科', '治外的');
INSERT INTO `department` VALUES ('2', '内科', '治内的');
INSERT INTO `department` VALUES ('3', '五官科', '治五官的');
INSERT INTO `department` VALUES ('4', '儿科', '治疗儿童的');
INSERT INTO `department` VALUES ('5', '传染病科', '治疗传染病的');
INSERT INTO `department` VALUES ('6', '妇产科', '治疗孕妇问题的');
INSERT INTO `department` VALUES ('7', '皮肤科', '治疗皮肤病的');
INSERT INTO `department` VALUES ('8', '肛肠科', '治疗肛肠病的');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `doctorid` int NOT NULL AUTO_INCREMENT,
  `docname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` char(10) NOT NULL,
  `departmentid` int NOT NULL,
  `phone` varchar(50) NOT NULL,
  `registrationfee` int NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `title` varchar(50) NOT NULL,
  PRIMARY KEY (`doctorid`),
  KEY `department1` (`departmentid`),
  CONSTRAINT `department1` FOREIGN KEY (`departmentid`) REFERENCES `department` (`departmentid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('2', 'XU', '男', '1', '125', '5', 'sb', '外科医生');

-- ----------------------------
-- Table structure for drug
-- ----------------------------
DROP TABLE IF EXISTS `drug`;
CREATE TABLE `drug` (
  `drugid` int NOT NULL AUTO_INCREMENT,
  `drugname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pinyin` varchar(20) NOT NULL,
  `unit` char(10) NOT NULL,
  `specification` char(10) NOT NULL,
  `price` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`drugid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drug
-- ----------------------------
INSERT INTO `drug` VALUES ('1', '清开灵', 'qkl', '盒', '1*8', '8', '200');
INSERT INTO `drug` VALUES ('2', '板蓝根', 'blg', '袋', '1*20', '5', '100');
INSERT INTO `drug` VALUES ('3', '感冒灵', 'gml', '盒', '1*12', '8', '100');
INSERT INTO `drug` VALUES ('4', '小柴胡', 'xch', '盒', '1*15', '13', '100');

-- ----------------------------
-- Table structure for onduty
-- ----------------------------
DROP TABLE IF EXISTS `onduty`;
CREATE TABLE `onduty` (
  `dutyid` int NOT NULL AUTO_INCREMENT,
  `doctorid` int NOT NULL,
  `week` varchar(50) NOT NULL,
  `starttime` varchar(50) NOT NULL,
  `endtime` varchar(50) NOT NULL,
  `limit` int NOT NULL,
  `balance` int NOT NULL,
  `state` varchar(10) NOT NULL,
  PRIMARY KEY (`dutyid`),
  KEY `doctorpk` (`doctorid`),
  CONSTRAINT `doctorpk` FOREIGN KEY (`doctorid`) REFERENCES `doctor` (`doctorid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of onduty
-- ----------------------------

-- ----------------------------
-- Table structure for outpatient
-- ----------------------------
DROP TABLE IF EXISTS `outpatient`;
CREATE TABLE `outpatient` (
  `outpatientid` int NOT NULL AUTO_INCREMENT,
  `patientid` int NOT NULL,
  `departmentid` int NOT NULL,
  `doctorid` int NOT NULL,
  `time` datetime NOT NULL,
  `Iscancel` varchar(2) NOT NULL,
  PRIMARY KEY (`outpatientid`),
  KEY `patientpk` (`patientid`),
  KEY `departmentpk` (`departmentid`),
  KEY `doctorpk1` (`doctorid`),
  CONSTRAINT `departmentpk` FOREIGN KEY (`departmentid`) REFERENCES `department` (`departmentid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `doctorpk1` FOREIGN KEY (`doctorid`) REFERENCES `doctor` (`doctorid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patientpk` FOREIGN KEY (`patientid`) REFERENCES `patient` (`patientid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outpatient
-- ----------------------------
INSERT INTO `outpatient` VALUES ('1', '5', '1', '2', '2020-11-24 20:36:15', '0');

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `patientid` int NOT NULL AUTO_INCREMENT,
  `patientname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` char(10) NOT NULL,
  `age` char(10) NOT NULL,
  `sidno` varchar(50) NOT NULL,
  `sidtype` char(10) NOT NULL,
  `address` varchar(80) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `companynameaddress` varchar(80) DEFAULT NULL,
  `companyphone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `firstman` varchar(50) NOT NULL,
  `firstquery` char(10) NOT NULL COMMENT '与病人关系',
  `firstphone` varchar(50) NOT NULL,
  `firstaddress` varchar(80) DEFAULT NULL,
  `Recorddate` varchar(30) NOT NULL,
  `hispass` varchar(200) DEFAULT NULL,
  `hisoperate` varchar(200) DEFAULT NULL,
  `cardtype` char(10) DEFAULT NULL,
  `balance` double NOT NULL,
  `creditlimit` double NOT NULL,
  PRIMARY KEY (`patientid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES ('5', 'YZY', '男', '22', '441823', '身份证', '清远', '135', '中山', '无', '125@qq.com', 'YWZ', '父子', '无', '广州', '2020-11-24', '无', '无', '金卡', '1', '1');

-- ----------------------------
-- Table structure for prescription
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription` (
  `descriptionid` int NOT NULL AUTO_INCREMENT,
  `outpatientid` int NOT NULL,
  PRIMARY KEY (`descriptionid`),
  KEY `outpatientpk` (`outpatientid`),
  CONSTRAINT `outpatientpk` FOREIGN KEY (`outpatientid`) REFERENCES `outpatient` (`outpatientid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prescription
-- ----------------------------

-- ----------------------------
-- Table structure for prescription medication
-- ----------------------------
DROP TABLE IF EXISTS `prescription medication`;
CREATE TABLE `prescription medication` (
  `serialid` int NOT NULL AUTO_INCREMENT,
  `prescriptionid` int NOT NULL,
  `drugid` int NOT NULL,
  `number` int NOT NULL,
  `total` int NOT NULL,
  PRIMARY KEY (`serialid`),
  KEY `prescripationidpk` (`prescriptionid`),
  KEY `durgpk` (`drugid`),
  CONSTRAINT `durgpk` FOREIGN KEY (`drugid`) REFERENCES `drug` (`drugid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `prescripationidpk` FOREIGN KEY (`prescriptionid`) REFERENCES `prescription` (`descriptionid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prescription medication
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) NOT NULL,
  `worktype` varchar(20) NOT NULL,
  `state` varchar(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Ezio', '123', 'Admin', '1');
INSERT INTO `user` VALUES ('2', 'XU', '123', 'Doctor', '1');
