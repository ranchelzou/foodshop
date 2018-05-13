/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : food_project

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-13 19:38:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for buyer_info
-- ----------------------------
DROP TABLE IF EXISTS `buyer_info`;
CREATE TABLE `buyer_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buyer_info
-- ----------------------------
INSERT INTO `buyer_info` VALUES ('1', '13940517937', 'abc');

-- ----------------------------
-- Table structure for food_category
-- ----------------------------
DROP TABLE IF EXISTS `food_category`;
CREATE TABLE `food_category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  `ccreatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cupdatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ctype` int(12) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food_category
-- ----------------------------
INSERT INTO `food_category` VALUES ('1', '粮食', '2018-03-31 11:01:40', '2018-05-12 23:22:33', '1');
INSERT INTO `food_category` VALUES ('2', '水果', '2018-04-07 10:52:55', '2018-05-12 23:22:51', '2');
INSERT INTO `food_category` VALUES ('9', '面食', '2018-04-11 20:09:44', '2018-05-12 23:23:13', '3');
INSERT INTO `food_category` VALUES ('10', '海鲜', '2018-05-12 23:21:50', '2018-05-12 23:23:25', '4');

-- ----------------------------
-- Table structure for food_info
-- ----------------------------
DROP TABLE IF EXISTS `food_info`;
CREATE TABLE `food_info` (
  `fid` varchar(125) NOT NULL,
  `fname` varchar(64) NOT NULL,
  `fprice` decimal(8,2) NOT NULL,
  `fdescription` varchar(255) DEFAULT NULL,
  `fimage` varchar(512) DEFAULT NULL,
  `fstatus` tinyint(5) DEFAULT '0' COMMENT '在架商品',
  `ctype` int(12) DEFAULT NULL,
  `fcreatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fupdatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food_info
-- ----------------------------
INSERT INTO `food_info` VALUES ('1', '草莓', '11.50', '丹东大草莓', null, '0', '1', '2018-04-11 22:18:31', '2018-05-13 15:36:10');
INSERT INTO `food_info` VALUES ('10', '海鲜', '5.21', '大连特产', 'http://sea.jpg', '1', '6', '2018-04-11 22:31:53', '2018-05-13 15:37:12');
INSERT INTO `food_info` VALUES ('1526125872474927822', '西瓜', '2.90', '嘎嘎甜', null, '0', '6', '2018-05-12 19:51:12', '2018-05-12 19:51:12');
INSERT INTO `food_info` VALUES ('2', '菠萝', '7.00', '海南菠萝', null, '0', '2', '2018-04-11 22:19:08', '2018-05-11 09:31:45');
INSERT INTO `food_info` VALUES ('5210', '爱的味道', '5.21', '单身狗专属', 'http://xx.jpg', '0', '52', '2018-04-11 21:22:53', '2018-05-11 20:42:05');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `did` varchar(37) NOT NULL,
  `oid` varchar(255) NOT NULL,
  `fid` varchar(125) NOT NULL,
  `fname` varchar(64) DEFAULT NULL,
  `fprice` decimal(8,2) DEFAULT NULL,
  `fquantity` int(10) DEFAULT NULL,
  `fimage` varchar(512) DEFAULT NULL,
  `dcreatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `dupdatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('123', '789', '3', 'hate you', '88.50', '20', 'jajajaj', '2018-04-28 22:47:45', '2018-04-28 22:47:45');
INSERT INTO `order_detail` VALUES ('1525010450448779150', '1525010450329423320', '1', '草莓', '13.00', '1', null, '2018-04-29 22:00:50', '2018-04-29 22:00:50');
INSERT INTO `order_detail` VALUES ('1525010741674388734', '1525010741567876068', '1', '草莓', '13.00', '1', null, '2018-04-29 22:05:41', '2018-04-29 22:05:41');
INSERT INTO `order_detail` VALUES ('1525010900154562673', '1525010899913527474', '1', '草莓', '13.00', '1', null, '2018-04-29 22:08:20', '2018-04-29 22:08:20');
INSERT INTO `order_detail` VALUES ('1525010991642739779', '1525010991526574867', '1', '草莓', '13.00', '1', null, '2018-04-29 22:09:51', '2018-04-29 22:09:51');
INSERT INTO `order_detail` VALUES ('1525269041110821110', '1525269040859955831', '1', '草莓', '13.00', '2', null, '2018-05-02 21:50:41', '2018-05-02 21:50:41');
INSERT INTO `order_detail` VALUES ('1525664961512314235', '1525664961450213572', '1', '草莓', '13.00', '2', null, '2018-05-07 11:49:21', '2018-05-07 11:49:21');
INSERT INTO `order_detail` VALUES ('1525665371879602748', '1525665371822665879', '1', '草莓', '13.00', '2', null, '2018-05-07 11:56:11', '2018-05-07 11:56:11');
INSERT INTO `order_detail` VALUES ('1525665372245584183', '1525665372240546557', '1', '草莓', '13.00', '2', null, '2018-05-07 11:56:12', '2018-05-07 11:56:12');
INSERT INTO `order_detail` VALUES ('1525666061366156141', '1525666061307706277', '1', '草莓', '13.00', '2', null, '2018-05-07 12:07:41', '2018-05-07 12:07:41');
INSERT INTO `order_detail` VALUES ('1525666163203101461', '1525666163194574969', '1', '草莓', '13.00', '2', null, '2018-05-07 12:09:23', '2018-05-07 12:09:23');
INSERT INTO `order_detail` VALUES ('1525666188643413432', '1525666188582614745', '1', '草莓', '13.00', '3', null, '2018-05-07 12:09:48', '2018-05-07 12:09:48');
INSERT INTO `order_detail` VALUES ('1525669162318289767', '1525669162296602383', '2', '菠萝', '7.00', '3', null, '2018-05-07 12:59:22', '2018-05-07 12:59:22');
INSERT INTO `order_detail` VALUES ('1525687350538897808', '1525687350486931902', '2', '菠萝', '7.00', '3', null, '2018-05-07 18:02:30', '2018-05-07 18:02:30');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `oid` varchar(255) NOT NULL,
  `bname` varchar(32) NOT NULL,
  `bphone` varchar(11) NOT NULL,
  `baddress` varchar(128) NOT NULL,
  `bnickname` varchar(32) DEFAULT NULL,
  `oamount` decimal(10,2) NOT NULL,
  `ostatus` tinyint(4) DEFAULT '0' COMMENT '新下单',
  `pstatus` tinyint(4) DEFAULT '0' COMMENT '未支付',
  `ocreatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `oupdatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('123458', '22', '18804088689', '中心街道', '小麻烦888', '884.00', '0', '0', '2018-04-28 22:09:50', '2018-04-28 22:09:50');
INSERT INTO `order_master` VALUES ('1525010991526574867', '一页纸', '13352203529', '我的家', '我是女王', '13.00', '1', '1', '2018-05-10 23:36:41', '2018-05-10 23:36:41');
INSERT INTO `order_master` VALUES ('1525269040859955831', '一页纸', '13352203529', '我的家', '我是女王', '26.00', '2', '0', '2018-05-10 23:25:32', '2018-05-10 23:25:32');
INSERT INTO `order_master` VALUES ('1525665371822665879', 'tony', '13352203529', '来啊立顿', 'lala', '26.00', '2', '0', '2018-05-10 16:25:41', '2018-05-10 16:25:41');
INSERT INTO `order_master` VALUES ('1525665372240546557', 'tony', '13352203529', '来啊立顿', 'lala', '26.00', '2', '0', '2018-05-10 16:19:17', '2018-05-10 16:19:17');
INSERT INTO `order_master` VALUES ('1525666061307706277', 'tony', '13352203529', '来啊立顿', 'lala', '26.00', '0', '0', '2018-05-07 12:07:41', null);
INSERT INTO `order_master` VALUES ('1525666163194574969', 'tony', '13352203529', '来啊立顿', 'lala', '26.00', '1', '0', '2018-05-13 13:05:03', '2018-05-13 13:05:03');
INSERT INTO `order_master` VALUES ('1525666188582614745', 'tony', '13352203529', '来啊立顿', 'lala', '39.00', '2', '0', '2018-05-10 23:25:59', '2018-05-10 23:25:59');
INSERT INTO `order_master` VALUES ('1525669162296602383', 'tony', '13352203529', '来啊立顿', 'lala', '21.00', '2', '0', '2018-05-10 16:18:57', '2018-05-10 16:18:57');
INSERT INTO `order_master` VALUES ('1525687350486931902', 'sun', '13352203529', 'Ameriacan', '傻', '21.00', '2', '0', '2018-05-07 20:57:39', '2018-05-07 20:57:39');

-- ----------------------------
-- Table structure for seller_info
-- ----------------------------
DROP TABLE IF EXISTS `seller_info`;
CREATE TABLE `seller_info` (
  `sellerid` varchar(32) NOT NULL,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `openid` varchar(64) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`sellerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seller_info
-- ----------------------------
INSERT INTO `seller_info` VALUES ('1526178263204196371', 'admin', 'admin', 'admin', '2018-05-13 16:12:15', '2018-05-13 16:12:15');
