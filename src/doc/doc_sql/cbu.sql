/*
Navicat MySQL Data Transfer

Source Server         : zigong
Source Server Version : 50508
Source Host           : localhost:3307
Source Database       : cbu

Target Server Type    : MYSQL
Target Server Version : 50508
File Encoding         : 65001

Date: 2016-05-21 19:18:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `actor`
-- ----------------------------
DROP TABLE IF EXISTS `actor`;
CREATE TABLE `actor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 NOT NULL,
  `sex` tinyint(1) NOT NULL COMMENT '0:male1:female',
  `country` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  `birthday` year(4) DEFAULT NULL,
  `introduction` text CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of actor
-- ----------------------------

-- ----------------------------
-- Table structure for `actorsinmovie`
-- ----------------------------
DROP TABLE IF EXISTS `actorsinmovie`;
CREATE TABLE `actorsinmovie` (
  `id` int(40) NOT NULL,
  `actorId` int(40) NOT NULL,
  `movieId` int(40) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `actorId` (`actorId`),
  KEY `movieId` (`movieId`),
  CONSTRAINT `actorId` FOREIGN KEY (`actorId`) REFERENCES `actor` (`id`),
  CONSTRAINT `movieId` FOREIGN KEY (`movieId`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of actorsinmovie
-- ----------------------------

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `keyword` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `clicks` int(11) unsigned NOT NULL COMMENT 'the number of click',
  `detail` mediumtext CHARACTER SET utf8 NOT NULL,
  `ownerId` int(11) NOT NULL,
  `created` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `movieId` int(11) NOT NULL,
  `preuserId` int(11) DEFAULT NULL,
  `status` int(11) unsigned zerofill NOT NULL COMMENT '状态。0：未审批 1：已审批',
  PRIMARY KEY (`id`),
  KEY `ownerId` (`ownerId`),
  KEY `moiveId` (`movieId`),
  KEY `preuserId` (`preuserId`),
  CONSTRAINT `moiveId` FOREIGN KEY (`movieId`) REFERENCES `movie` (`id`),
  CONSTRAINT `ownerId` FOREIGN KEY (`ownerId`) REFERENCES `member` (`id`),
  CONSTRAINT `preuserId` FOREIGN KEY (`preuserId`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `director`
-- ----------------------------
DROP TABLE IF EXISTS `director`;
CREATE TABLE `director` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 NOT NULL,
  `sex` tinyint(1) NOT NULL COMMENT '0:male 1:female',
  `country` char(10) CHARACTER SET utf8 DEFAULT NULL,
  `birthday` year(4) DEFAULT NULL,
  `introduction` text CHARACTER SET utf8,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of director
-- ----------------------------

-- ----------------------------
-- Table structure for `directorinmovie`
-- ----------------------------
DROP TABLE IF EXISTS `directorinmovie`;
CREATE TABLE `directorinmovie` (
  `id` int(11) NOT NULL,
  `directorId` int(11) NOT NULL,
  `movieId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `directorId` (`directorId`),
  KEY `movie_Id` (`movieId`),
  CONSTRAINT `directorId` FOREIGN KEY (`directorId`) REFERENCES `director` (`id`),
  CONSTRAINT `movie_Id` FOREIGN KEY (`movieId`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of directorinmovie
-- ----------------------------

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 NOT NULL,
  `password` char(40) CHARACTER SET utf8 NOT NULL,
  `sex` tinyint(1) DEFAULT NULL COMMENT '0:male 1:female',
  `email` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `money` int(40) NOT NULL DEFAULT '100' COMMENT '余额',
  `rank` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', 'manager', '96e79218965eb72c92a549dd5a330112', '1', '1111@qq.com', null, '100', '0');
INSERT INTO `member` VALUES ('2', 'boss', '96e79218965eb72c92a549dd5a330112', '1', 'dsjkfjs@gamil.com', '1993-03-08', '0', '1');
INSERT INTO `member` VALUES ('3', 'manager2', '96e79218965eb72c92a549dd5a330112', '1', null, null, '100', '2');
INSERT INTO `member` VALUES ('4', 'user', '96e79218965eb72c92a549dd5a330112', '1', '1', '1995-09-23', '0', '0');
INSERT INTO `member` VALUES ('5', 'user1', '96e79218965eb72c92a549dd5a330112', '1', '1', '1995-09-23', '0', '0');
INSERT INTO `member` VALUES ('6', 'user2', '96e79218965eb72c92a549dd5a330112', '1', '1', '1998-09-23', '0', '0');
INSERT INTO `member` VALUES ('7', 'user3', '96e79218965eb72c92a549dd5a330112', '1', '1', '1998-09-23', '0', '0');
INSERT INTO `member` VALUES ('8', 'user8', '96e79218965eb72c92a549dd5a330112', '1', 'asdfad', '1998-09-23', '100', '0');
INSERT INTO `member` VALUES ('9', 'user10', '96e79218965eb72c92a549dd5a330112', '1', 'asdfad', '1998-09-23', '100', '0');
INSERT INTO `member` VALUES ('10', 'user11', '96e79218965eb72c92a549dd5a330112', '1', 'asdfad', '1998-09-23', '100', '0');

-- ----------------------------
-- Table structure for `movie`
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `score` float(2,1) NOT NULL,
  `status` tinyint(2) NOT NULL COMMENT '0:will show;1:no show plan;2:showing;3:have been showed',
  `introduction` text CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES ('1', '大闹天宫', '4.5', '1', '很好看');
INSERT INTO `movie` VALUES ('2', '归来', '4.8', '1', '不错');
INSERT INTO `movie` VALUES ('3', '愤怒的小鸟', '3.9', '1', '还行');

-- ----------------------------
-- Table structure for `ordertable`
-- ----------------------------
DROP TABLE IF EXISTS `ordertable`;
CREATE TABLE `ordertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `planId` int(11) NOT NULL,
  `memberId` int(11) NOT NULL,
  `seatId` int(11) NOT NULL,
  `money` int(4) NOT NULL,
  `state` tinyint(1) NOT NULL COMMENT '0:success\r\n1:failed\r\n',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_OT_PLAN` (`planId`),
  KEY `FK_OT_SEAT` (`seatId`),
  KEY `FK_OT_MEM` (`memberId`),
  CONSTRAINT `FK_OT_MEM` FOREIGN KEY (`memberId`) REFERENCES `member` (`id`),
  CONSTRAINT `FK_OT_PLAN` FOREIGN KEY (`planId`) REFERENCES `plan` (`id`),
  CONSTRAINT `FK_OT_SEAT` FOREIGN KEY (`seatId`) REFERENCES `seat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ordertable
-- ----------------------------

-- ----------------------------
-- Table structure for `parameter`
-- ----------------------------
DROP TABLE IF EXISTS `parameter`;
CREATE TABLE `parameter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeId` tinyint(2) NOT NULL,
  `movieId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_TYPE_MOVIE` (`movieId`),
  CONSTRAINT `FK_TYPE_MOVIE` FOREIGN KEY (`movieId`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of parameter
-- ----------------------------
INSERT INTO `parameter` VALUES ('1', '2', '1');
INSERT INTO `parameter` VALUES ('2', '3', '2');

-- ----------------------------
-- Table structure for `plan`
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staffId` int(11) NOT NULL,
  `movieId` int(11) NOT NULL,
  `beginning` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ending` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `money` int(11) NOT NULL COMMENT '票价',
  `state` tinyint(1) NOT NULL COMMENT '0:In  Approval  1:yes   2:rejected ',
  `income` int(11) unsigned zerofill NOT NULL,
  `leftTickets` int(11) NOT NULL DEFAULT '100' COMMENT '余票',
  `soldTickets` int(11) unsigned zerofill NOT NULL COMMENT '已经出售的票数',
  PRIMARY KEY (`id`),
  KEY `FK_PLAN_MOVIE` (`movieId`),
  KEY `FK_PLAN_MEMBER` (`staffId`),
  CONSTRAINT `FK_PLAN_MEMBER` FOREIGN KEY (`staffId`) REFERENCES `member` (`id`),
  CONSTRAINT `FK_PLAN_MOVIE` FOREIGN KEY (`movieId`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of plan
-- ----------------------------

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(11) NOT NULL,
  `score` tinyint(1) NOT NULL,
  `memberId` int(11) NOT NULL,
  `movieId` int(11) NOT NULL,
  `created` time NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SR_MOVIE` (`movieId`),
  KEY `FK_SR_MEM` (`memberId`),
  CONSTRAINT `FK_SR_MEM` FOREIGN KEY (`memberId`) REFERENCES `member` (`id`),
  CONSTRAINT `FK_SR_MOVIE` FOREIGN KEY (`movieId`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of score
-- ----------------------------

-- ----------------------------
-- Table structure for `seat`
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `line` tinyint(2) NOT NULL,
  `column` tinyint(2) NOT NULL,
  `state` tinyint(1) NOT NULL COMMENT '0:empty\r\n1:locked\r\n2:ordered\r\n',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of seat
-- ----------------------------
