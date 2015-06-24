-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: weibo_db
-- ------------------------------------------------------
-- Server version	5.6.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `atten_info`
--

DROP TABLE IF EXISTS `atten_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atten_info` (
  `NG_id` char(12) NOT NULL,
  `NG_datetime` datetime NOT NULL,
  `NG_num` int(11) NOT NULL,
  `NG_name` varchar(20) NOT NULL,
  PRIMARY KEY (`NG_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atten_info`
--

LOCK TABLES `atten_info` WRITE;
/*!40000 ALTER TABLE `atten_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `atten_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atten_member`
--

DROP TABLE IF EXISTS `atten_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atten_member` (
  `NG_id` char(12) NOT NULL,
  `user_id` char(11) NOT NULL,
  PRIMARY KEY (`NG_id`,`user_id`),
  KEY `FK2_idx` (`user_id`),
  CONSTRAINT `FK2` FOREIGN KEY (`NG_id`) REFERENCES `atten_info` (`NG_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK3` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atten_member`
--

LOCK TABLES `atten_member` WRITE;
/*!40000 ALTER TABLE `atten_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `atten_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attention`
--

DROP TABLE IF EXISTS `attention`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attention` (
  `user_id` char(11) NOT NULL,
  `attuser_id` char(11) NOT NULL,
  PRIMARY KEY (`user_id`,`attuser_id`),
  KEY `FK27_idx` (`attuser_id`),
  CONSTRAINT `FK26` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK27` FOREIGN KEY (`attuser_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attention`
--

LOCK TABLES `attention` WRITE;
/*!40000 ALTER TABLE `attention` DISABLE KEYS */;
/*!40000 ALTER TABLE `attention` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `copy`
--

DROP TABLE IF EXISTS `copy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `copy` (
  `c_id` char(11) NOT NULL,
  `user_id` char(11) NOT NULL,
  `m_id` char(16) NOT NULL,
  `cuser_id` char(11) NOT NULL,
  PRIMARY KEY (`c_id`),
  KEY `FK28_idx` (`user_id`),
  KEY `FK29_idx` (`m_id`),
  KEY `FK30_idx` (`cuser_id`),
  CONSTRAINT `FK28` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK29` FOREIGN KEY (`m_id`) REFERENCES `message` (`m_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK30` FOREIGN KEY (`cuser_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copy`
--

LOCK TABLES `copy` WRITE;
/*!40000 ALTER TABLE `copy` DISABLE KEYS */;
/*!40000 ALTER TABLE `copy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fav`
--

DROP TABLE IF EXISTS `fav`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fav` (
  `f_id` char(11) NOT NULL,
  `user_id` char(11) NOT NULL,
  `m_id` char(16) NOT NULL,
  PRIMARY KEY (`f_id`),
  KEY `FK24_idx` (`user_id`),
  KEY `FK25_idx` (`m_id`),
  CONSTRAINT `FK24` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK25` FOREIGN KEY (`m_id`) REFERENCES `message` (`m_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fav`
--

LOCK TABLES `fav` WRITE;
/*!40000 ALTER TABLE `fav` DISABLE KEYS */;
/*!40000 ALTER TABLE `fav` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_admin`
--

DROP TABLE IF EXISTS `group_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_admin` (
  `g_id` char(16) NOT NULL,
  `g_admin` char(11) NOT NULL,
  PRIMARY KEY (`g_id`),
  KEY `FK12_idx` (`g_admin`),
  CONSTRAINT `FK12` FOREIGN KEY (`g_admin`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_admin`
--

LOCK TABLES `group_admin` WRITE;
/*!40000 ALTER TABLE `group_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_info`
--

DROP TABLE IF EXISTS `group_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_info` (
  `g_id` char(16) NOT NULL,
  `g_name` varchar(20) NOT NULL,
  `g_label` char(11) NOT NULL,
  `g_num` int(11) NOT NULL,
  `g_datetime` datetime NOT NULL,
  PRIMARY KEY (`g_id`),
  KEY `FK10_idx` (`g_label`),
  CONSTRAINT `FK10` FOREIGN KEY (`g_label`) REFERENCES `label` (`l_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_info`
--

LOCK TABLES `group_info` WRITE;
/*!40000 ALTER TABLE `group_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_member`
--

DROP TABLE IF EXISTS `group_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_member` (
  `g_id` char(16) NOT NULL,
  `user_id` char(11) NOT NULL,
  PRIMARY KEY (`g_id`),
  KEY `FK9_idx` (`user_id`),
  CONSTRAINT `FK11` FOREIGN KEY (`g_id`) REFERENCES `group_info` (`g_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK9` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_member`
--

LOCK TABLES `group_member` WRITE;
/*!40000 ALTER TABLE `group_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_message`
--

DROP TABLE IF EXISTS `group_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_message` (
  `gm_id` char(17) NOT NULL,
  `g_id` char(16) NOT NULL,
  `user_id` char(11) NOT NULL,
  `gt_id` char(16) DEFAULT NULL,
  `c_id` char(11) NOT NULL,
  `m_content` varchar(150) NOT NULL,
  `m_http` varchar(150) NOT NULL,
  `m_reply` int(11) NOT NULL,
  `m_copy` int(11) NOT NULL,
  `gm_datetime` datetime NOT NULL,
  PRIMARY KEY (`gm_id`),
  KEY `FK24_idx` (`g_id`),
  KEY `FK32_idx` (`user_id`),
  KEY `FK33_idx` (`gt_id`),
  KEY `FK34_idx` (`c_id`),
  KEY `FK31_idx` (`g_id`),
  CONSTRAINT `FK31` FOREIGN KEY (`g_id`) REFERENCES `group_info` (`g_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK32` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK33` FOREIGN KEY (`gt_id`) REFERENCES `group_title` (`gt_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK34` FOREIGN KEY (`c_id`) REFERENCES `copy` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_message`
--

LOCK TABLES `group_message` WRITE;
/*!40000 ALTER TABLE `group_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_reply`
--

DROP TABLE IF EXISTS `group_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_reply` (
  `gr_id` char(17) NOT NULL,
  `gm_id` char(16) NOT NULL,
  `g_id` char(16) NOT NULL,
  `user_id` char(11) NOT NULL,
  `gr_datetime` datetime NOT NULL,
  `gr_content` varchar(200) NOT NULL,
  PRIMARY KEY (`gr_id`),
  KEY `FK21_idx` (`g_id`),
  KEY `FK22_idx` (`user_id`),
  KEY `FK23_idx` (`gm_id`),
  CONSTRAINT `FK21` FOREIGN KEY (`g_id`) REFERENCES `group_info` (`g_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK22` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK23` FOREIGN KEY (`gm_id`) REFERENCES `group_message` (`gm_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_reply`
--

LOCK TABLES `group_reply` WRITE;
/*!40000 ALTER TABLE `group_reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_title`
--

DROP TABLE IF EXISTS `group_title`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_title` (
  `gt_id` char(17) NOT NULL,
  `gt_num` int(11) NOT NULL,
  `gt_name` varchar(20) NOT NULL,
  `gt_content` varchar(1000) NOT NULL,
  PRIMARY KEY (`gt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_title`
--

LOCK TABLES `group_title` WRITE;
/*!40000 ALTER TABLE `group_title` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_title` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `label`
--

DROP TABLE IF EXISTS `label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `label` (
  `l_id` char(11) NOT NULL,
  `l_name` varchar(10) NOT NULL,
  PRIMARY KEY (`l_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `label`
--

LOCK TABLES `label` WRITE;
/*!40000 ALTER TABLE `label` DISABLE KEYS */;
/*!40000 ALTER TABLE `label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `m_id` char(16) NOT NULL,
  `user_id` char(11) NOT NULL,
  `t_id` char(16) DEFAULT NULL,
  `c_id` char(11) DEFAULT NULL,
  `m_content` varchar(150) NOT NULL,
  `m_http` varchar(150) DEFAULT NULL,
  `m_fav` int(11) NOT NULL,
  `m_reply` int(11) NOT NULL,
  `m_copy` int(11) NOT NULL,
  `m_datetime` datetime NOT NULL,
  PRIMARY KEY (`m_id`),
  KEY `FK15_idx` (`user_id`),
  KEY `FK16_idx` (`t_id`),
  KEY `FK18_idx` (`c_id`),
  CONSTRAINT `FK16` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK17` FOREIGN KEY (`t_id`) REFERENCES `message_title` (`t_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK18` FOREIGN KEY (`c_id`) REFERENCES `copy` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_title`
--

DROP TABLE IF EXISTS `message_title`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message_title` (
  `t_id` char(16) NOT NULL,
  `t_num` int(11) NOT NULL,
  `t_name` varchar(20) NOT NULL,
  `t_content` varchar(1000) NOT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_title`
--

LOCK TABLES `message_title` WRITE;
/*!40000 ALTER TABLE `message_title` DISABLE KEYS */;
/*!40000 ALTER TABLE `message_title` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messgae_reply`
--

DROP TABLE IF EXISTS `messgae_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messgae_reply` (
  `r_id` char(16) NOT NULL,
  `m_id` char(16) NOT NULL,
  `user_id` char(11) NOT NULL,
  `r_datetime` datetime NOT NULL,
  `r_content` varchar(200) NOT NULL,
  PRIMARY KEY (`r_id`),
  KEY `FK19_idx` (`m_id`),
  KEY `FK20_idx` (`user_id`),
  CONSTRAINT `FK19` FOREIGN KEY (`m_id`) REFERENCES `message` (`m_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK20` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messgae_reply`
--

LOCK TABLES `messgae_reply` WRITE;
/*!40000 ALTER TABLE `messgae_reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `messgae_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photo`
--

DROP TABLE IF EXISTS `photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `photo` (
  `p_id` char(11) NOT NULL,
  `p_name` varchar(20) NOT NULL,
  `photo` varbinary(5000) NOT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photo`
--

LOCK TABLES `photo` WRITE;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photo_folder`
--

DROP TABLE IF EXISTS `photo_folder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `photo_folder` (
  `pf_id` char(11) NOT NULL,
  `user_id` char(11) NOT NULL,
  `pf_name` varchar(20) NOT NULL,
  `pf_num` int(11) NOT NULL,
  `p_id` char(11) NOT NULL,
  PRIMARY KEY (`pf_id`),
  KEY `FK13_idx` (`user_id`),
  KEY `FK14_idx` (`p_id`),
  CONSTRAINT `FK13` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK14` FOREIGN KEY (`p_id`) REFERENCES `photo` (`p_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photo_folder`
--

LOCK TABLES `photo_folder` WRITE;
/*!40000 ALTER TABLE `photo_folder` DISABLE KEYS */;
/*!40000 ALTER TABLE `photo_folder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pri_message`
--

DROP TABLE IF EXISTS `pri_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pri_message` (
  `pm_id` char(12) NOT NULL,
  `user_id` char(11) NOT NULL,
  `ruser_id` char(11) NOT NULL,
  `pm_content` varchar(200) NOT NULL,
  `pm_datetime` datetime NOT NULL,
  PRIMARY KEY (`pm_id`),
  KEY `FK7_idx` (`user_id`),
  KEY `FK8_idx` (`ruser_id`),
  CONSTRAINT `FK7` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK8` FOREIGN KEY (`ruser_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pri_message`
--

LOCK TABLES `pri_message` WRITE;
/*!40000 ALTER TABLE `pri_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `pri_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school`
--

DROP TABLE IF EXISTS `school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `school` (
  `s_id` char(11) NOT NULL,
  `s_name` varchar(10) NOT NULL,
  `s_pro` varchar(10) NOT NULL,
  `s_city` varchar(10) NOT NULL,
  `s_country` varchar(20) NOT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skin`
--

DROP TABLE IF EXISTS `skin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skin` (
  `s_id` char(11) NOT NULL,
  `s_image` varbinary(2048) DEFAULT NULL,
  `s_color` char(9) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skin`
--

LOCK TABLES `skin` WRITE;
/*!40000 ALTER TABLE `skin` DISABLE KEYS */;
/*!40000 ALTER TABLE `skin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` char(11) NOT NULL,
  `user_nickname` varchar(20) NOT NULL,
  `user_image` varbinary(5000) NOT NULL,
  `user_email` varchar(30) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_sex` char(1) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_skin` char(11) NOT NULL,
  `user_qq` varchar(20) DEFAULT NULL,
  `user_school` char(11) DEFAULT NULL,
  `user_work` varchar(20) DEFAULT NULL,
  `user_tel` char(11) DEFAULT NULL,
  `user_info` varchar(100) DEFAULT NULL,
  `user_datetime` datetime NOT NULL,
  `user_blog` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK4_idx` (`user_school`),
  KEY `FK15_idx` (`user_skin`),
  CONSTRAINT `FK15` FOREIGN KEY (`user_skin`) REFERENCES `skin` (`s_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK4` FOREIGN KEY (`user_school`) REFERENCES `school` (`s_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_atten`
--

DROP TABLE IF EXISTS `user_atten`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_atten` (
  `user_id` char(11) NOT NULL,
  `NG_id` char(12) NOT NULL,
  PRIMARY KEY (`user_id`,`NG_id`),
  KEY `FK1_idx` (`NG_id`),
  CONSTRAINT `FK1` FOREIGN KEY (`NG_id`) REFERENCES `atten_member` (`NG_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_atten`
--

LOCK TABLES `user_atten` WRITE;
/*!40000 ALTER TABLE `user_atten` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_atten` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_label`
--

DROP TABLE IF EXISTS `user_label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_label` (
  `user_id` char(11) NOT NULL,
  `l_id` char(11) NOT NULL,
  PRIMARY KEY (`user_id`,`l_id`),
  KEY `FK5_idx` (`l_id`),
  CONSTRAINT `FK5` FOREIGN KEY (`l_id`) REFERENCES `label` (`l_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK6` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_label`
--

LOCK TABLES `user_label` WRITE;
/*!40000 ALTER TABLE `user_label` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_label` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-01 18:29:02
