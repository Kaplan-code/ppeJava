-- MariaDB dump 10.17  Distrib 10.4.13-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: ppedb
-- ------------------------------------------------------
-- Server version	10.4.13-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `ppedb`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ppedb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ppedb`;

--
-- Table structure for table `Medecin`
--

DROP TABLE IF EXISTS `Medecin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Medecin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `prenom` varchar(100) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `numeroTel` varchar(10) NOT NULL,
  `ville` varchar(100) NOT NULL,
  `codePostal` varchar(15) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Medecin`
--

LOCK TABLES `Medecin` WRITE;
/*!40000 ALTER TABLE `Medecin` DISABLE KEYS */;
INSERT INTO `Medecin` VALUES (1,'jeremy','logan','0647952134','lyon','69100','17 rue porteil'),(2,'henry','laurent','0647894130','paris','69005','12 rue kheil'),(3,'Garv','Stother','6895355665','Shiyang','69250','651 Novick Place'),(4,'April','Flewitt','9283070675','Oemanu','69250','95 Mallory Park'),(5,'Nell','Doley','8381176753','Lutun','69250','9 Memorial Lane'),(6,'Fulton','Conahy','8057807224','Cilolohan','69250','560 Larry Park'),(7,'Bradford','Cupitt','4649370365','Bergerac','24111','684 Vidon Trail'),(8,'Nancy','Smeeth','8828175682','Shaheying','69250','35291 Sommers Junction'),(9,'Buckie','Lackham','7065631816','Estaca','11123','72432 Waubesa Street'),(10,'Angela','Ellams','9421360619','Taquarituba','18740','79 Surrey Street'),(11,'Billie','Dabnor','2584191858','Krasnotorka','69250','6 Stone Corner Park'),(12,'Lanny','Capaldi','6458609468','Smålandsstenar','33324','4604 Coleman Place'),(13,'Dyanna','Balshen','3291978760','Lyon','69206','585 Dottie Court'),(14,'James','Hewson','3834854724','Raub','27620','750 La Follette Street'),(15,'Marnie','Cassar','9561396963','Lamawan','69250','070 Emmet Parkway'),(16,'Jourdan','Quaif','1589235253','Soko','69250','904 Monterey Plaza'),(17,'Adele','Thresh','5106899570','Buenaventura','764517','8 Schurz Trail'),(18,'Iolande','Filippo','6959344531','Cintra','25590','1 Gale Court'),(19,'Ina','Renwick','1849354708','Karlskrona','37147','210 Manitowish Street'),(20,'Gertrudis','Connold','8727298005','Ayna','69250','41 Kipling Avenue'),(21,'Harriott','Dare','1867398246','Primorka','34687','963 Bluestem Court'),(22,'Isador','Scholar','6231990764','Brétigny-sur-Orge','91229','06 Hovde Way'),(23,'Edgar','Boice','5156261388','Stockholm','101370','1 Lillian Court'),(24,'Sheffield','Vosper','5698656308','Gunjur','69250','1 Sommers Pass'),(26,'Hagen','Sofe','2241165585','Fedorovka','69250','65 Fairview Circle'),(27,'Delly','Drayton','2744362811','Pushchino','14226','9 Fisk Road'),(28,'Salomon','Furzey','5092849464','Jiangbu','69250','66 Warbler Junction'),(29,'Zacherie','Ballinghall','7066917047','Sudecki','58521','02799 Morning Junction'),(30,'Kalinda','M\'Chirrie','6154264880','Tsurib','36848','07 Towne Center'),(31,'Margret','Persich','8107316311','Liuxia','69250','71349 Thierer Crossing'),(32,'Martino','Comley','8056773286','Baugo','6017','6787 Onsgard Court');
/*!40000 ALTER TABLE `Medecin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RapportRdv`
--

DROP TABLE IF EXISTS `RapportRdv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RapportRdv` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `utilisateurId` int(11) NOT NULL,
  `medecinId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `RapportRdv_FK1` (`medecinId`),
  KEY `RapportRdv_FK2` (`utilisateurId`),
  CONSTRAINT `RapportRdv_FK1` FOREIGN KEY (`medecinId`) REFERENCES `Medecin` (`id`),
  CONSTRAINT `RapportRdv_FK2` FOREIGN KEY (`utilisateurId`) REFERENCES `Utilisateur` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RapportRdv`
--

LOCK TABLES `RapportRdv` WRITE;
/*!40000 ALTER TABLE `RapportRdv` DISABLE KEYS */;
INSERT INTO `RapportRdv` VALUES (9,'2021-02-03',1,2),(11,'2021-02-04',1,13),(12,'2021-02-16',1,16),(14,'2021-02-11',1,20),(17,'2021-02-01',1,3),(19,'2021-02-24',2,14),(20,'2021-02-25',1,1),(23,'2021-02-11',1,5),(26,'2021-02-24',1,3),(42,'2021-05-06',2,2),(43,'2021-05-12',2,4),(45,'2021-06-08',1,4);
/*!40000 ALTER TABLE `RapportRdv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(100) NOT NULL,
  `permission` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
INSERT INTO `Role` VALUES (1,'visiteur',1),(2,'délégué régional',2);
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Utilisateur`
--

DROP TABLE IF EXISTS `Utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prenom` varchar(100) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `numeroTel` varchar(10) NOT NULL,
  `login` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `idrole` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Utilisateur_FK` (`idrole`),
  CONSTRAINT `Utilisateur_FK` FOREIGN KEY (`idrole`) REFERENCES `Role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Utilisateur`
--

LOCK TABLES `Utilisateur` WRITE;
/*!40000 ALTER TABLE `Utilisateur` DISABLE KEYS */;
INSERT INTO `Utilisateur` VALUES (1,'diego','laurent','0656153479','m','6b51d431df5d7f141cbececcf79edf3dd861c3b4069f0b11661a3eefacbba918',2),(2,'kubilay','kaplan','0695478234','k','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',1);
/*!40000 ALTER TABLE `Utilisateur` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-08 17:38:42
