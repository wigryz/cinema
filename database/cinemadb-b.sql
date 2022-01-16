-- MySQL dump 10.13  Distrib 8.0.27, for Linux (x86_64)
--
-- Host: localhost    Database: cinemadb
-- ------------------------------------------------------
-- Server version	8.0.27-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cinema_user`
--
DROP DATABASE IF EXISTS `cinemadb`;
CREATE DATABASE `cinemadb`;

USE cinemadb;

DROP TABLE IF EXISTS `cinema_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cinema_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(256) NOT NULL,
  `email` varchar(100) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cinema_user_username_uindex` (`username`),
  UNIQUE KEY `cinema_user_email_uindex` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinema_user`
--

LOCK TABLES `cinema_user` WRITE;
/*!40000 ALTER TABLE `cinema_user` DISABLE KEYS */;
INSERT INTO `cinema_user` VALUES (4,'username','$2a$10$4RRC.myAqxvenweqlMQZM.6YP6jQXwgAHtB2lubcgDKhUe.rqG7xi','email1','2021-10-16 21:39:14','firstname','lastname',1),(5,'admin','$2a$10$Tgy/hrztlUQrEkC7L0./RegZ/CSt/scEcF3UwlCYbpzlpWOpJzkYO','email2','2021-10-16 22:12:13','firstname','lastname',0),(13,'new-user','$2a$10$jIzBJIRwIzV9hce4nzUmDebxxNMf2VW7scv11nNvTrDV0./NBxOxK','email4','2021-10-17 15:13:24','asd','asd',1);
/*!40000 ALTER TABLE `cinema_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genre` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_genre` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (6,'Animation'),(4,'Comedy'),(3,'Documentary'),(1,'Horror'),(19,'NewGen123'),(5,'Romantic comedy'),(8,'Thriller'),(2,'War Film'),(7,'Western');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` char(100) NOT NULL,
  `content` blob,
  `type` char(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,'image.jpeg',_binary '�\��\�\0JFIF\0\0\0\0\0\0�\�\0�\0\n\Z!.%+!&8&+/1555\Z$;@;3?.4514+$+44414144444144444444444444444444444444444444444444��\0\0\�\0\�\"\0�\�\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0?\0\0\0\0\0\0!1AQqa�\"2Rr���#Bb��S�\�\���\�\�$3C�\��\�\0\Z\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0*\0\0\0\0\0\0\0!1Aa\"Q�R�2b�#�\�\0\0\0?\0\�8���\�0E\��3\�8���N%�\0�%7@w�\�\�\�$*\���f�\�Q�7�A�yL&l#\\�e!�\�B�\�$\�u�d7�gk\�p��FgM�A���	8\�4Y\�f�\ru	�q=%�)���0��\0��\0��\0��\0�\�zG\�6LG�:G��5�݉��\�	.�\�%.]a�Kq<\�<s=�&\"4�M\rReT\�uU�\�do\�A5\"r\�4R\�DS\��\�0�\r\�\�\�E�&e���QgH�>M�4D\�\�h\�s7\�\�x\�\Z&\�$\�\�K�kG=\�\���\"\"\0\"\"\0\"\"\0\"\"\0&-�\�#�~\�)���鉖;�ׂ\�	.�\�%�\�/.\�\�\\�<�\�:\'	��\����\'�\�+H5��X\�5e�dG&{0m\�9X\�tDN��S\�\ZX��\�D�jAY���\�BA\��\�H]	8�E\�:l�\�x\�yV�\�5�`86�\0���M�\���\"�\�l�}FW\Z\�J�\�b\�\�\�\�\�V�\�9��\'�S[$�\"��$�7b\���xɓ�K\�\��8�\"\"!�\"\"\0\"\"\0\"\"\0\"\"\0\"\"\0L�>�r$|�\�<\�p�bá�\�*N�\�kS�\Z\�[��;Ȃ�Ū\�y,�FUD�fn\�C�\�N\�H�\�\�\"�WDD\�z�6\���gj�o\�?\�tIO;\��\�\�S��7%\�3�:�O$R\�\�\�UnʧquSа\�>\�R���e�X�\0�\��\�M#F�S�\n���7_�S\�\�\0\�\"\�\�g\�-Uy/\�SJK�9\�of@�a��>\�K�#\�Y|�<%%^��M�9ݛT}\�\�\�A��t��\�\�\�9b\�\�<O��*f\�C\'=�\�uЇY\�m>\�2]\��\�n=\�?F��̖��`\�\�l\�\�+�Q�\�,y!�7Tņxr��}�\"\"9�\"\"��������\'���\��\�x�$G�~R(�c(\�F��_\�/\�(s���J�\�>\�dz%-�\�~9\�z9\��8�ɰ\�6\�\��/{�\�{)i�G��j��2S�\�z-vG\�\�\�\�J��\��OH\�+%`\�Fnfà�LeP���Fr|�\�\���W\�6t̢\� {K��\�\�N˲��\�A�r�)�T\�>�9\�;\�]�ĊU\�aɲU�\�|�\�\�_1c�g-L7\�k�GC��M�\0Gi$\�\�\��*E�dt��{���\�O�1���\���\�\�ٵ0�\�=:w�\�Qe\�\�\�\�\�#O��X�X�.\�G\�\��\�\Z \�\�)jZ���t\�\���SO�O\�.��SD\�\\0��\�)p�xJ\�g+֛;\�t՝���\�\�!\�m.��t��k��\nf;�Af=\0\�Οgv=\�͈qM}�d3�y\�/��ίg\�8qjT\�\���\�:�[6�8\\��=|˃�\���\�U��?=��\�\�\�|�O��3��f\�j\�����/�>\�&v]^I\��\�0�D-����̨�\�|=#�Lf\� \�\�ͼ�\�f�\�W\�dۉ�\��\'�\0\��Q\�ȕZC�Q�VCgF��.��$\�i���:BN-4}/d\�\�\�J��\�q\�h\�z��g\�;;��\�W\�?r\�\n��\�\��O��}F���x\�]N�~;�r,�M��΢\" +\�=��6&��jȣF]\0�C�\�9\�`@#PE�\Z�>�)۳R\�\�zL[(�UPnl���\�/\�ե\Z�n��q�\�m]\�A��w�\�wa�ߛ&s\�k\�i����*k\�����>n+�ݻ}&A��*�j�\�Ϧp��\�\�=�\0�\�Y\�0�u�\�V�\0\�bIҨ\�B��\0l�u\�3\�1x{�\0\����/\�\�q`&����)\�\�)�Teb=\�G�3\�)+2�L��\�c�\�%5\�M\��(Q~zI\�ʺrsʳٱ/�{���\��\0M�K�\�%\�J��ﲋ\\\�<\�Y�%L�瓫��������3s`L\�*\�4\�^�	���1�e\�\�rQ]�>�\0\�x\�\�w{<\�d�f~\�SԼ�\�c\�E\�\�$bgQ\�-����M���2�\�!\��9N\\\�o��\�6(\�\�0fx\�\�\�(�we{K|�lCz^�7kY�#�k�\�i\�c\�U\njU{�h�\�\�o\'\�Q}X\��L<�yB{Z6�58\�%\�\�C6Uϔ=�|�*	\�\�d\�\�\"\"\0\"\"\0\"\"\0\"\"\0\"\"\0\"\"\0\"\"\0\"%V\�\�C\�@��^�G�\�\�\�\��Jn�,���\�\'\�\�Q�rԨ�\�\�X)�H�%L\Z\�%\�e�Q�ٞ\�\�GK�\�/\�K\�\��e>1\�\�\�#�T{�f�i�\�2\�|܍\�\��@h\�%U�`\�\�\�r\�d��	�2\�-@,o���wfv{S��T�\�tL\�\�gD\�N���3�\�;?�\�RB.���\�l�\�}:f~C/H/\�\�\�E�����f\0tRI�&eDH�\�\�\"b)3\��\'�\�d�ҋ�T\"\"���\0��\0��\�\�\��\"�{\����\�\�}�jͅo�r\�f:;���\�v\�pc�&\�x�\�]z*\�\�\�J�;��!$��Bgiv��\��\�j��\0�\�\�t\�2���srY�gf%�\�\�ǉ�\�V�U\�1�C\�m\r\�7[h|T\�֤׆(\�?�&�4\�7\�]�y��6x�EKg4\�jc2y����\�\�\���\�#\�(dd2BEb3z\����ͯcmX裛|H�\�!&\�#�\�>\�\�b\�\�\"{��ͳ|\'S#\��(�J�!�\'�\Z�3s\�$O=�{\�6o\�ب�\�S\�rbq�p5O\�\nf�E��V��5\01�9K�\�\�\�\�\�\�ĩeV@��أ�%u\�Hm:\�G�\�\�j�	\�\�.\�\�\�֓\�UFf(\�=V�\�ᦾ2Obv�U�\�\�3\�`��r\�\�\�yN�z�����Z\�ňL\���d�R�w��|U\0��\�V�5M87�\0۶)7\�\�\�D\� DD\0DD\0�\��\�xl�ZN�R�\�\�]\�\'1#�� �\0��\rB�:��i�|�V�8�\�\�@\�\��\�bV\�m\���r˨\�{���\�\�\�U ԩR�\�;��\�\�6p4�$�(7%$�;^\�m�I\�,ie\�I�\��\�\�T��\�:�\�vʕ��`\�Q?2�bOLď#:����Q\�>�\"\'\09~\�\�=\ZX����\�FS\��1�ʼ�\�\�\�\�zԸ�0_z\�_�\�t�\�T\��͍�\�\��Z�|��\�}\�H\�\�K�L�*\\\�d�Y��v��5�=X)2T��mC$Ӛ$�k!�\�\�-v�\�PS�V5��j�\�+\�\'Q؊7���\�R^�w�Jڙm\�\�\�I\�W�N\�%~7kӦJ\�\�7���Rt��)J�@<\n�\�`�I���ɫH���u����\�\�̬.\�\r�J���f�0y\�n�\�bU�#�V\�ݻ\�+\�fO\�\'_9~���\Z\04\"4�N_\�\���\�ҠV���\�gkf\�a\�I�w`�/#3::�\�c�7 �Ѝ!�Eʦ\�\'�p\��-*\�\����9\�\��IӔ�\�1)\�J�]\�+P��\�A��\\�t�d|�\�\�v\�\"\'0�E]YC�2��a\�%\Z\�C6G\"\�\�j9O�\�xK�������\�@�*�\0\0��=� �a���J�Fߦ��\rS\�X/\�\�Ɍ\\�\"\�%-.\�!6tt����\�j��d`\�w	AǨJ�S9\����\�5\�\�/�\�8��\�>�8�\�\�r֣X]\r3\�P\�_�7\�^�|\�\�\������?5x�D\�1���ғ�9\�ȝ\�s2e�s2$n#q(\�	NIfħ#x9\ZR�\�CKV�\�\�Y�<� ��R�.\��=i\�ė�\�£�����_\�/�:��\�`-�\�̪�#pU�\�nb`ee\�\�\�Ľ��)Z���a\�\'a9m��j�\���7��L7:�S5nख़�\����\"\"s�v�lC0ø�EX�xT;\� \�\�@<L|x��\�&1rt��\�\�ͫ\�Ĺ\�Mf[�	\�ٙuJ��n�g�m�\�<�=<J���wj�+jӱ\��DoU\��\�2\�U�%����LDDP9�\�\�֐6[gͮ��K.{I�!����\�\�\�|��qV\�E\�)mT$���4\�_\�s��\�d	;b\�\�J\�G�����4�\�6Z\�\�\�J.\�a\�\�\��n��+�\0��\�^\�X��7C�td?�[\��qKlԼ���\�|û���\"\�x[\�_E�`\�&\�\�`<|��M\�N{LI\"I�[4�S!JH{h�E�\�9��7\�-\"\�&��\�_��K�U,=ڞ�?͜yJb&͓�\�q(\�\�*}\�\�7�OF��S�h\�E\�M�)\�;\n�t�,\�8\\^\�9H鲨�qM|\�G\�M���Ѹ�%\�m�p@\"\"A\" 5T�eʐ:�m9��\�\�ԅ�UJ0\�I<5�L\�q�7û֢��\'9���\�\�]\�ޖi\\_s�)(�I1!\�\��\Z��E��\�\�\�A\�3����\�Q{\�~�\��Q\�q\��T*#tX|\�E9��M�WlQVZj����>b��\r,\'A3\�2N|}\�;�+�b\�`:E��\��>�ޝB���u7uc9G�ќ�Т�\�\�}:��H�o\�e\��\�\"(U��x��$�\�]Y2��Ո��!\�ݪ\"��\Z��\�\�P��<�]v������\�\nz�߱5c�;W%g���̐�CV��\�#���^h2\���l^j\�\�DQ�����\�#�\�Ȏ�6y�\�JCFӴv{h}����C\�\��x\�\"\�\�YNa\���J�~��~�\�|\�w�+S�d�3\�\�\�\�A1�\�DD\0DD\0ш�R��\0r�7<\������ʠ�2P���E���IUXX���\"\"\0\"\"\0\"\"\0\"\"\0/�>`\�^ki�磫<\��\�{\�4\�26�{\�\�$.\�\�xa��&�\�\�b\�x\\ɢh\�T�%1�\�\"6\�|�\�\�\�{1HT\�\�\r�s\�Ul>�\�3\�\�\�6tJ�\�؈��\\\0\0\0\0\0\0\0\0\0?�\�','image/jpeg');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` char(100) DEFAULT NULL,
  `short_description` tinytext,
  `description` text,
  `year_of_production` int DEFAULT NULL,
  `duration` int DEFAULT NULL,
  `additional_info` char(50) DEFAULT NULL,
  `age_restriction` int DEFAULT NULL,
  `poster_path` char(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'John is visiting Mike.','Anne bought new car. Anne bought new car. Tony bought new car. Anne has free time. Anne is walking. ','Anne bought new car. Anne is shopping. Tony bought new car. Tony is walking. Tony has free time. ',2008,81,'Mike like sports. Rudi watches football.',13,'resources/posters/rqb.doc'),(2,'Cindy called Adrian.','John bought new car. Anne is shopping. Tony bought new car. Tony bought new car. Tony has free time. ','John is shopping. John is shopping. John bought new car. John is walking. ',2011,118,'I watches football. Mike loves flowers.',15,'resources/posters/mgbxc.asm'),(3,'John knows Adrian.','John has free time. Tony is shopping. ','Anne bought new car. Anne is walking. John bought new car. John has free time. Tony is walking. ',2012,159,'Mike watches football. Mike loves flowers.',15,'resources/posters/nak.txt'),(4,'John called Mike.','John bought new car. Anne is walking. John bought new car. Anne has free time. John has free time. ','John bought new car. Anne is walking. Anne is walking. John is shopping. John is shopping. ',2008,143,'Mike watches football. Rudi loves flowers.',18,'resources/posters/tqv.pdf'),(5,'Cindy met Adrian.','Anne bought new car. Anne is shopping. ','Tony bought new car. Tony has free time. Tony bought new car. ',2012,101,'I loves flowers. Mike loves flowers.',15,'resources/posters/qydm.asm'),(6,'Cindy called Rolph.','Anne bought new car. Tony has free time. Tony bought new car. Tony has free time. Anne bought new car. ','Anne bought new car. Tony is shopping. Tony is shopping. Tony has free time. Anne bought new car. ',2008,86,'Rudi watches football. Mike like swimming.',15,'resources/posters/ssh.xls'),(7,'Cindy met Mike.','Tony bought new car. John bought new car. Tony has free time. ','Anne bought new car. Anne has free time. John bought new car. ',2011,147,'Mike like swimming. Mike loves flowers.',15,'resources/posters/rxduh.bmp'),(8,'Cindy called Adrian.','John bought new car. John is walking. John bought new car. John bought new car. Tony is walking. ','John is shopping. John bought new car. ',2009,86,'Mike loves flowers. Mike watches football.',18,'resources/posters/tsuz.xls'),(9,'I knows Mike.','Anne bought new car. John is shopping. Tony is shopping. Anne bought new car. John is walking. ','Anne bought new car. Anne bought new car. Tony bought new car. John bought new car. ',2012,62,'Rudi watches football.',15,'resources/posters/odbe.txt'),(10,'I called Tony.','John bought new car. Tony is walking. John has free time. John has free time. Anne has free time. ','Anne bought new car. Anne is shopping. John bought new car. Tony has free time. John is walking. ',2012,107,'I loves flowers.',15,'resources/posters/ulpg.php'),(11,'John knows Tony.','John is walking. Anne bought new car. Tony is shopping. John has free time. Tony is walking. ','Tony has free time. Anne is walking. John bought new car. Tony bought new car. Tony is shopping. ',2011,139,'Mike watches football. Mike loves flowers.',18,'resources/posters/sdo.asm'),(12,'John is visiting Florian.','Tony is shopping. Anne is walking. ','John is walking. John bought new car. John has free time. John has free time. John has free time. ',2008,93,'I watches football.',15,'resources/posters/pyg.txt'),(13,'John knows Mike.','John has free time. Tony is walking. ','Tony bought new car. Tony is walking. Tony bought new car. Tony has free time. ',2008,67,'Mike watches football. Rudi loves flowers.',15,'resources/posters/ooji.doc'),(14,'Cindy called Adrian.','Anne bought new car. Anne bought new car. Anne is shopping. Anne has free time. Tony bought new car. ','Anne has free time. Anne bought new car. Tony bought new car. ',2008,121,'Rudi like sports. Mike watches football.',15,'resources/posters/jzp.bmp'),(15,'Cindy knows Poe.','Anne is shopping. Anne is walking. John bought new car. John bought new car. John has free time. ','Tony is shopping. John has free time. John is walking. Tony has free time. John has free time. ',2011,126,'Mike like swimming.',13,'resources/posters/tgf.bmp'),(16,'John called Mike.','Tony is shopping. Anne is shopping. Anne is shopping. Tony bought new car. Tony has free time. ','Tony has free time. Tony is walking. John bought new car. Tony has free time. John has free time. ',2011,141,'Mike watches football. Mike watches football.',18,'resources/posters/spn.asm'),(17,'I called Rolph.','Anne is shopping. Anne bought new car. Tony is shopping. ','John bought new car. Tony is shopping. ',2010,116,'Rudi watches football. Mike watches football.',15,'resources/posters/xja.asm'),(18,'Cindy called Florian.','John has free time. Anne has free time. Tony bought new car. Anne has free time. John bought new car. ','Anne bought new car. John has free time. Tony is walking. ',2011,96,'Mike like swimming. Mike loves flowers.',15,'resources/posters/izh.php'),(19,'Cindy knows Poe.','Anne has free time. John is shopping. Anne bought new car. Anne bought new car. Tony is walking. ','Anne bought new car. Tony is shopping. ',2011,73,'Mike watches football.',13,'resources/posters/fio.bmp'),(20,'Cindy called Adrian.','Anne bought new car. John has free time. Tony is shopping. Tony has free time. Anne bought new car. ','John bought new car. Anne is walking. ',2012,143,'Rudi like sports. I like sports.',13,'resources/posters/qlpnb.ini');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_actor`
--

DROP TABLE IF EXISTS `movie_actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_actor` (
  `movie_id` int NOT NULL,
  `person_id` int NOT NULL,
  PRIMARY KEY (`movie_id`,`person_id`),
  KEY `fk_movie_actor_person` (`person_id`),
  CONSTRAINT `fk_movie_actor_movie` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`),
  CONSTRAINT `fk_movie_actor_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_actor`
--

LOCK TABLES `movie_actor` WRITE;
/*!40000 ALTER TABLE `movie_actor` DISABLE KEYS */;
INSERT INTO `movie_actor` VALUES (6,1),(7,1),(11,3),(17,3),(6,4),(8,4),(13,4),(13,5),(3,6),(12,7),(6,8),(15,8),(5,9),(13,9),(4,10),(1,11),(12,12),(20,12),(3,14),(15,15),(16,15),(20,16),(1,18),(1,19),(7,19),(18,19),(19,19),(20,19),(8,20),(12,20);
/*!40000 ALTER TABLE `movie_actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_director`
--

DROP TABLE IF EXISTS `movie_director`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_director` (
  `movie_id` int NOT NULL,
  `person_id` int NOT NULL,
  PRIMARY KEY (`movie_id`,`person_id`),
  KEY `fk_director_movie_person` (`person_id`),
  CONSTRAINT `fk_director_movie_movie` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`),
  CONSTRAINT `fk_director_movie_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_director`
--

LOCK TABLES `movie_director` WRITE;
/*!40000 ALTER TABLE `movie_director` DISABLE KEYS */;
INSERT INTO `movie_director` VALUES (7,1),(17,3),(6,4),(8,4),(13,4),(13,5),(3,6),(3,7),(12,7),(6,8),(15,8),(5,9),(13,9),(4,10),(1,11),(20,12),(15,15),(16,15),(1,19),(7,19),(18,19),(19,19),(20,19),(8,20),(12,20);
/*!40000 ALTER TABLE `movie_director` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_genre`
--

DROP TABLE IF EXISTS `movie_genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_genre` (
  `movie_id` int NOT NULL,
  `genre_id` int NOT NULL,
  PRIMARY KEY (`movie_id`,`genre_id`),
  KEY `fk_movie_category_category` (`genre_id`),
  CONSTRAINT `fk_movie_category_category` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_movie_category_movie` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_genre`
--

LOCK TABLES `movie_genre` WRITE;
/*!40000 ALTER TABLE `movie_genre` DISABLE KEYS */;
INSERT INTO `movie_genre` VALUES (4,1),(5,1),(6,1),(9,1),(13,1),(1,2),(6,2),(20,2),(3,3),(12,3),(15,3),(6,4),(8,4),(13,4),(1,5),(12,5),(20,5),(7,6),(11,6),(17,6),(1,7),(7,7),(8,7),(12,7),(18,7),(19,7),(20,7),(3,8),(15,8),(16,8);
/*!40000 ALTER TABLE `movie_genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` char(20) NOT NULL,
  `second_name` char(20) DEFAULT NULL,
  `last_name` char(20) NOT NULL,
  `portrait_path` char(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Rapzapinex','Monfropepistor','Rapglibupentor','resources/portraits/tuwn.php'),(2,'Lombanamantor','Winbanepor','Adtumplazz','resources/portraits/ziiv.php'),(3,'Klibanollover','Incadadistor','Parsipplantor','resources/portraits/eudyrm.pdf'),(4,'Admunover',NULL,'Qwibanplor','resources/portraits/lhw.pdf'),(5,'Undudplazz','Doptanplar','Renipackin','resources/portraits/pdi.ini'),(6,'Aderplar','Revenollor','Trubanazz','resources/portraits/bat.ini'),(7,'Vartanentor','Haperover','Ciphupepin','resources/portraits/vkink.asm'),(8,'Happickamex','Moncadicistor','Ciperupower','resources/portraits/hoq.xls'),(9,'Rerobepicator','Repebin','Supquestplax','resources/portraits/ayq.php'),(10,'Thrukilanicator','Parwerpplor','Varglibommazz','resources/portraits/fpmy.bmp'),(11,'Parerupax','Parerupax','Frowerexentor','resources/portraits/shd.asm'),(12,'Tipdudower','Supmuninex','Varrobantor','resources/portraits/msyg.xls'),(13,'Monmunazz','Zeekilplar','Trucadplor','resources/portraits/fkv.bmp'),(14,'Varwerentor','Cipnipollar','Qwihupplicator','resources/portraits/gdrc.pdf'),(15,'Cipglibupicator','Dopquestplistor','Barglibplan','resources/portraits/neiyns.pdf'),(16,'Monwerazz',NULL,'Raperinover','resources/portraits/gsc.txt'),(17,'Grorobopicator','Unglibupover','Haphupupower','resources/portraits/mico.xls'),(18,'Emhupackor','Cipquestupazz','Hapquestupicator','resources/portraits/cqtw.php'),(19,'Gromunplor','Emsipax','Monvenamin',NULL),(20,'Tipfropanover','Barmunor','Trukilepan',NULL);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showtime`
--

DROP TABLE IF EXISTS `showtime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `showtime` (
  `id` int NOT NULL AUTO_INCREMENT,
  `movie_id` int NOT NULL,
  `technology_id` int NOT NULL,
  `language` enum('dubbing','subtitles') DEFAULT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_showtime_movie` (`movie_id`),
  KEY `fk_showtime_technology` (`technology_id`),
  CONSTRAINT `fk_showtime_movie` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`),
  CONSTRAINT `fk_showtime_technology` FOREIGN KEY (`technology_id`) REFERENCES `technology` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showtime`
--

LOCK TABLES `showtime` WRITE;
/*!40000 ALTER TABLE `showtime` DISABLE KEYS */;
INSERT INTO `showtime` VALUES (1,15,2,'dubbing','2021-05-25 14:08:20'),(2,3,1,'dubbing','2021-07-29 04:18:44'),(3,9,2,'dubbing','2021-08-02 05:56:04'),(4,9,1,'dubbing','2021-06-23 19:56:18'),(5,5,1,'subtitles','2021-08-02 04:59:56'),(6,1,2,'dubbing','2020-11-19 09:50:20'),(7,7,2,'dubbing','2021-05-06 22:55:16'),(8,14,1,'dubbing','2020-12-13 17:46:27'),(9,20,2,'subtitles','2020-09-29 12:40:36'),(10,15,2,'dubbing','2021-03-01 19:35:11'),(11,1,2,'subtitles','2020-09-09 23:22:00'),(12,4,1,'subtitles','2021-07-09 02:55:06'),(13,20,1,'dubbing','2021-05-14 03:26:40'),(14,4,2,'subtitles','2021-06-19 15:02:08'),(15,19,1,'subtitles','2021-06-21 17:14:53'),(16,12,2,'dubbing','2020-12-07 16:11:48'),(17,19,2,'subtitles','2020-10-26 02:47:34'),(18,19,1,'subtitles','2021-03-29 15:06:49'),(19,19,2,'dubbing','2021-08-04 09:19:47'),(20,10,2,'subtitles','2021-02-01 08:52:17'),(21,8,1,'subtitles','2021-06-06 17:11:54'),(22,19,1,'dubbing','2021-05-20 15:18:07'),(23,7,2,'subtitles','2020-09-02 03:36:52'),(24,4,2,'dubbing','2021-03-14 14:51:16'),(25,6,2,'subtitles','2021-05-27 17:04:01'),(26,8,1,'subtitles','2021-01-10 11:51:24'),(27,11,1,'subtitles','2021-08-15 22:29:18'),(28,18,1,'subtitles','2021-02-13 12:20:28'),(29,3,1,'subtitles','2021-06-28 13:09:58'),(30,11,2,'subtitles','2020-10-18 03:13:45'),(31,16,1,'dubbing','2020-11-08 18:51:45'),(32,12,2,'subtitles','2021-04-24 04:24:03'),(33,14,2,'subtitles','2020-12-28 22:37:30'),(34,1,2,'subtitles','2021-01-28 18:21:55'),(35,4,2,'dubbing','2021-06-02 05:33:52'),(36,16,1,'subtitles','2020-11-08 21:30:12'),(37,8,1,'dubbing','2020-12-12 06:28:30'),(38,13,2,'dubbing','2021-02-12 13:42:50'),(39,3,1,'subtitles','2020-11-23 21:47:51'),(40,18,1,'subtitles','2021-04-03 03:45:18'),(41,14,2,'subtitles','2021-06-22 16:46:57'),(42,10,1,'dubbing','2021-05-27 14:51:00'),(43,17,2,'subtitles','2021-06-05 00:42:07'),(44,1,2,'dubbing','2021-01-30 21:26:16'),(45,1,1,'subtitles','2021-06-13 02:51:29'),(46,18,1,'dubbing','2021-02-18 01:43:34'),(47,11,1,'dubbing','2021-07-23 21:25:13'),(48,1,2,'dubbing','2021-01-18 22:04:02'),(49,15,2,'dubbing','2021-03-11 04:38:56'),(50,15,2,'dubbing','2021-06-13 04:59:25'),(51,3,1,'dubbing','2020-09-19 16:26:13'),(52,6,2,'subtitles','2021-07-13 01:58:02'),(53,10,2,'subtitles','2021-01-05 12:05:56'),(54,2,1,'subtitles','2020-10-16 06:13:29'),(55,11,2,'dubbing','2021-02-23 04:40:35'),(56,13,2,'dubbing','2021-02-26 03:53:28'),(57,12,1,'dubbing','2021-07-28 19:39:13'),(58,20,2,'dubbing','2020-11-06 02:32:42'),(59,5,2,NULL,'2021-03-28 03:17:28'),(60,6,1,'dubbing','2021-03-16 09:34:21'),(61,13,2,'dubbing','2021-03-23 11:44:04'),(62,4,2,'subtitles','2021-07-04 14:06:41'),(63,4,2,'subtitles','2021-03-28 14:35:30'),(64,1,1,'dubbing','2021-08-28 23:37:09'),(65,1,1,'dubbing','2021-07-25 13:22:00'),(66,14,2,'dubbing','2021-03-17 11:39:29'),(67,4,1,'dubbing','2020-11-18 05:07:34'),(68,10,1,'dubbing','2021-07-14 13:40:14'),(69,4,1,'dubbing','2020-12-27 22:30:37'),(70,10,2,'subtitles','2020-10-17 09:18:46'),(71,11,2,'dubbing','2020-10-24 23:37:53'),(72,3,2,'subtitles','2021-03-04 12:23:11'),(73,20,1,'dubbing','2021-05-07 10:10:05'),(74,3,2,'dubbing','2021-02-13 00:20:52'),(75,5,2,'dubbing','2021-08-08 17:15:46'),(76,5,1,'subtitles','2021-01-16 15:04:03'),(77,8,1,'subtitles','2021-03-24 23:08:46'),(78,17,1,'dubbing','2021-03-25 12:03:29'),(79,5,1,'subtitles','2020-12-16 14:53:18'),(80,9,2,'dubbing','2021-06-30 12:33:28'),(81,9,1,'dubbing','2021-06-24 19:15:58'),(82,19,1,'subtitles','2021-03-26 12:00:09'),(83,5,1,'subtitles','2021-01-01 07:58:38'),(84,11,2,'dubbing','2021-02-23 16:40:34'),(85,18,1,'subtitles','2021-05-22 09:46:16'),(86,8,1,'subtitles','2021-01-30 02:07:13'),(87,1,1,'subtitles','2021-04-13 21:10:11'),(88,6,1,'subtitles','2020-10-26 01:31:36'),(89,12,1,'subtitles','2021-05-20 13:13:07'),(90,3,1,'subtitles','2021-07-04 21:47:25'),(91,14,1,'subtitles','2020-09-21 19:21:37'),(92,5,2,'dubbing','2021-05-02 07:35:45'),(93,3,2,'subtitles','2021-02-12 06:56:24'),(94,20,1,'subtitles','2021-05-22 21:15:01'),(95,14,2,'dubbing','2021-03-14 11:19:24'),(96,12,2,'subtitles','2021-04-04 04:00:36'),(97,20,1,'subtitles','2021-04-16 10:33:59'),(98,20,2,'dubbing','2020-09-02 11:42:45'),(99,5,2,'dubbing','2021-05-10 08:39:24'),(100,6,2,'dubbing','2021-08-28 13:26:54'),(101,8,2,'subtitles','2021-07-13 14:27:09'),(102,8,1,'subtitles','2020-12-22 00:14:47'),(103,10,1,'dubbing','2021-03-03 22:06:21'),(104,18,1,'subtitles','2020-12-29 16:06:21'),(105,7,1,'dubbing','2021-03-01 20:20:41'),(106,6,2,'dubbing','2021-07-11 09:39:29'),(107,9,1,'subtitles','2021-05-25 10:01:59'),(108,2,2,'subtitles','2021-01-06 18:22:01'),(109,11,1,'dubbing','2021-07-02 07:14:28'),(110,4,1,'subtitles','2021-07-26 03:03:59'),(111,20,2,'dubbing','2021-02-06 12:39:57'),(112,13,2,'dubbing','2021-02-20 19:20:07'),(113,13,1,'dubbing','2020-10-30 14:11:29'),(114,6,1,'subtitles','2020-12-27 10:05:13'),(115,19,1,'subtitles','2021-04-29 01:22:53'),(116,7,1,'dubbing','2021-01-30 07:18:57'),(117,11,2,'subtitles','2021-01-18 02:25:11'),(118,6,2,'dubbing','2021-04-17 16:05:26'),(119,10,2,'dubbing','2021-02-13 23:11:20'),(120,3,1,'dubbing','2020-09-13 20:30:27'),(121,9,1,'dubbing','2021-06-30 11:25:35'),(122,3,1,'subtitles','2021-08-22 23:07:47'),(123,7,2,'subtitles','2020-09-22 15:06:07'),(124,11,2,'dubbing','2021-02-19 23:26:59'),(125,15,2,'dubbing','2021-07-03 12:06:33'),(126,10,2,'dubbing','2020-10-13 15:06:43'),(127,20,1,'dubbing','2021-02-07 05:29:48'),(128,1,2,'subtitles','2020-10-04 05:38:35'),(129,5,2,'dubbing','2021-03-07 09:55:47'),(130,8,1,'subtitles','2021-02-21 00:39:25'),(131,4,1,'subtitles','2020-12-20 23:56:31'),(132,5,2,'dubbing','2021-05-07 15:59:01'),(133,11,1,'dubbing','2021-04-21 12:59:25'),(134,17,2,'subtitles','2021-06-16 07:50:45'),(135,12,1,'dubbing','2021-05-20 09:23:32'),(136,3,2,'dubbing','2020-12-19 15:22:12'),(137,12,2,'subtitles','2021-01-15 22:48:18'),(138,11,2,'dubbing','2021-01-14 06:31:14'),(139,16,1,'dubbing','2020-11-30 18:49:36'),(140,11,2,'dubbing','2021-01-28 17:34:07'),(141,14,2,'subtitles','2021-05-27 19:33:51'),(142,8,1,'dubbing','2020-12-24 11:41:29'),(143,5,2,'dubbing','2021-05-05 22:16:57'),(144,9,1,'dubbing','2021-01-27 11:03:40'),(145,6,2,'subtitles','2021-06-21 15:45:27'),(146,14,2,'dubbing','2021-06-15 21:27:12'),(147,16,2,'subtitles','2020-09-09 19:14:38'),(148,4,2,'subtitles','2021-01-10 04:27:11'),(149,5,1,'subtitles','2021-02-11 19:55:53'),(150,14,2,'dubbing','2021-06-09 21:13:33');
/*!40000 ALTER TABLE `showtime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technology`
--

DROP TABLE IF EXISTS `technology`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `technology` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` char(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_technology` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technology`
--

LOCK TABLES `technology` WRITE;
/*!40000 ALTER TABLE `technology` DISABLE KEYS */;
INSERT INTO `technology` VALUES (1,'2D'),(2,'3D');
/*!40000 ALTER TABLE `technology` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  KEY `fk_user_role_cinema_user` (`user_id`),
  KEY `fk_user_role_role` (`role_id`),
  CONSTRAINT `fk_user_role_cinema_user` FOREIGN KEY (`user_id`) REFERENCES `cinema_user` (`id`),
  CONSTRAINT `fk_user_role_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (4,1),(5,2),(13,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-26 19:16:48
