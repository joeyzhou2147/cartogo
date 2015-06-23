CREATE DATABASE  IF NOT EXISTS `rest_demo` ;
USE `rest_demo`;
-- MySQL dump 10.13  Distrib 5.6.10, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: rest_demo
-- ------------------------------------------------------
-- Server version	5.6.10-log

;
;
;
;







--
-- Table structure for table `podcasts`
--

DROP TABLE IF EXISTS `podcasts`;


CREATE TABLE `podcasts` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(145) NOT NULL,
  `feed` varchar(145) NOT NULL,
  `insertion_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` varchar(500) DEFAULT NULL,
  `link_on_podcastpedia` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `feed_UNIQUE` (`feed`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


--
-- Dumping data for table `podcasts`
--

LOCK TABLES `podcasts` WRITE;

INSERT INTO `podcasts` VALUES (1,'Quarks & Co - zum Mitnehmen','http://podcast.wdr.de/quarks.xml','2014-01-09 20:21:10','Quarks & Co: Das Wissenschaftsmagazin','http://www.podcastpedia.org/podcasts/1/Quarks-Co-zum-Mitnehmen'),(2,'- The Naked Scientists Podcast - Stripping Down Science','http://www.thenakedscientists.com/naked_scientists_podcast.xml','2014-01-09 20:21:10','The Naked Scientists flagship science show brings you a lighthearted look at the latest scientific breakthroughs, interviews with the world top scientists, answers to your science questions and science experiments to try at home.','http://www.podcastpedia.org/podcasts/792/-The-Naked-Scientists-Podcast-Stripping-Down-Science'),(3,'NPR: TED Radio Hour Podcast','http://www.npr.org/rss/podcast.php?user_id=510298','2014-01-09 20:21:10','The TED Radio Hour is a journey through fascinating ideas: astonishing inventions, fresh approaches to old problems, new ways to think and create. Based on Talks given by riveting speakers on the world-renowned TED stage, each show is centered on a common theme - such as the source of happiness, crowd-sourcing innovation, power shifts, or inexplicable connections. The TED Radio Hour is hosted by Guy Raz, and is a co-production of NPR & TED. Follow the show @TEDRadioHour.','http://www.podcastpedia.org/podcasts/1183/NPR-TED-Radio-Hour-Podcast');

UNLOCK TABLES;




-- Dump completed on 2014-01-09 20:21:54
