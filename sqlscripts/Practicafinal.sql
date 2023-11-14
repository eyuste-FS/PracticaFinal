-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: practica
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `em_empleado`
--

DROP TABLE IF EXISTS `em_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `em_empleado` (
  `B_SERVMILITAR` char(1) NOT NULL,
  `CX_EDOCIVIL` char(1) NOT NULL,
  `F_ALTA` date NOT NULL,
  `F_BAJA` date DEFAULT NULL,
  `F_NACIMIENTO` date NOT NULL,
  `ID_EMPLEADO` int(7) NOT NULL,
  `N_TELEFONO1` varchar(12) NOT NULL,
  `N_TELEFONO2` varchar(12) NOT NULL,
  `TX_APELLIDO1` varchar(40) NOT NULL,
  `TX_APELLIDO2` varchar(40) NOT NULL,
  `TX_EMAIL` varchar(40) NOT NULL,
  `TX_NIF` varchar(9) DEFAULT NULL,
  `TX_NOMBRE` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_EMPLEADO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `em_empleado`
--

LOCK TABLES `em_empleado` WRITE;
/*!40000 ALTER TABLE `em_empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `em_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `em_empleados`
--

DROP TABLE IF EXISTS `em_empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `em_empleados` (
  `B_SERVMILITAR` char(1) NOT NULL,
  `CX_EDOCIVIL` char(1) NOT NULL,
  `F_ALTA` date NOT NULL,
  `F_BAJA` date DEFAULT NULL,
  `F_NACIMIENTO` date NOT NULL,
  `ID_EMPLEADO` int(7) NOT NULL,
  `N_TELEFONO1` varchar(12) NOT NULL,
  `N_TELEFONO2` varchar(12) NOT NULL,
  `TX_APELLIDO1` varchar(40) NOT NULL,
  `TX_APELLIDO2` varchar(40) NOT NULL,
  `TX_EMAIL` varchar(40) NOT NULL,
  `TX_NIF` varchar(20) DEFAULT NULL,
  `TX_NOMBRE` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_EMPLEADO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `em_empleados`
--

LOCK TABLES `em_empleados` WRITE;
/*!40000 ALTER TABLE `em_empleados` DISABLE KEYS */;
INSERT INTO `em_empleados` VALUES ('N','C','1976-10-13','2008-11-15','1986-02-18',1,'726303432','260219970','White','Phillips','alfred.white@gmail.com','88953399G','Alfred'),('N','C','1993-07-18',NULL,'1993-03-25',2,'218370049','434866459','Hamilton','Welch','leila.hamilton@gmail.com','42401933C','Leila'),('N','S','1996-08-18','2010-01-20','1978-10-23',3,'227605855','151699997','Fletcher','Wilson','bertie.fletcher@gmail.com','52971090P','Bertie'),('S','C','1981-01-09','2000-09-06','1991-10-17',4,'103324683','445420824','Adkins','Butler','barry.adkins@gmail.com','41056311G','Barry'),('N','C','2001-12-20',NULL,'1979-06-16',5,'620005126','597053420','Morgan','Bates','emma.morgan@gmail.com','70090020R','Emma'),('S','S','1988-10-10',NULL,'1994-10-11',6,'722329639','613416460','Soto','Gonzales','johanna.soto@gmail.com','39581105Y','Johanna'),('N','S','1967-07-22','2000-10-20','1971-12-09',7,'316243267','509643793','Doyle','Lawrence','willie.doyle@gmail.com','28488227G','Willie'),('S','C','1992-11-14','2002-05-26','1980-07-28',8,'731756880','246706348','Burton','Rios','maria.burton@gmail.com','43086195O','Maria'),('N','S','2003-10-17',NULL,'1984-07-22',9,'293847354','235029829','Ramsey','Bowman','josephine.ramsey@gmail.com','71097792Z','Josephine'),('N','S','1994-02-24',NULL,'1998-12-05',10,'799511847','526170278','Webb','McBride','lura.webb@gmail.com','50940281T','Lura'),('S','C','1983-05-08','2015-08-23','1981-05-10',11,'270215114','546059276','Clark','Cooper','adrian.clark@gmail.com','86501636G','Adrian'),('N','C','1991-09-22',NULL,'1989-01-17',12,'896531346','342017139','Leonard','Simon','cory.leonard@gmail.com','67412007O','Cory'),('N','S','1983-12-08','1994-09-06','1990-01-14',13,'524756051','549099408','Rogers','Hall','michael.rogers@gmail.com','26903374Y','Michael'),('N','C','2009-06-24',NULL,'1988-08-13',14,'798076600','456507656','McCarthy','Stevens','mary.mccarthy@gmail.com','66005749T','Mary'),('N','C','1983-06-27','2016-01-23','1994-12-02',15,'520431962','965275199','Bailey','Montgomery','beulah.bailey@gmail.com','40777634B','Beulah'),('N','S','1987-07-07','1999-03-24','1999-12-01',16,'256529417','862478971','Chandler','Logan','kyle.chandler@gmail.com','98148915Y','Kyle'),('N','S','1975-09-14','1978-03-28','1994-01-22',17,'807607485','273121900','Pena','Pierce','leah.pena@gmail.com','90151977P','Leah'),('N','S','1981-02-09','2009-09-18','1984-05-22',18,'791308513','956923442','Farmer','Guerrero','ina.farmer@gmail.com','27423078R','Ina'),('N','C','1980-10-13','2008-12-02','1978-01-06',19,'454369341','751589257','Valdez','White','owen.valdez@gmail.com','11098911Y','Owen'),('N','S','1978-12-17','2009-08-26','1976-02-13',20,'851652162','340184367','Pierce','Conner','jorge.pierce@gmail.com','27194980B','Jorge'),('N','S','1962-05-01','1992-06-25','1974-03-12',21,'333582970','411061816','Hawkins','Hawkins','troy.hawkins@gmail.com','37621966W','Troy'),('N','S','1971-11-26','1999-10-01','1979-07-13',22,'560622500','231344391','Lloyd','Morales','christine.lloyd@gmail.com','60418820C','Christine'),('S','C','1998-06-05',NULL,'1980-04-06',23,'181606389','149796478','Miles','Alvarez','dylan.miles@gmail.com','59244296E','Dylan'),('S','S','2001-11-18',NULL,'1987-06-09',24,'920400639','336879973','Austin','Phillips','chris.austin@gmail.com','76713311T','Chris'),('N','C','1999-07-09',NULL,'1976-12-20',25,'457394530','879204865','Keller','Hall','chris.keller@gmail.com','50976007N','Chris'),('N','C','2014-05-26',NULL,'2003-08-11',26,'101854196','447538171','Santos','Davidson','clara.santos@gmail.com','48825826D','Clara'),('N','C','2003-08-13','2008-01-27','1998-07-18',27,'692312167','368328058','Wallace','Clayton','verna.wallace@gmail.com','32243889T','Verna'),('N','C','1960-06-08','1990-08-27','1973-12-10',28,'380657083','178332915','Ross','Griffin','amanda.ross@gmail.com','36447179L','Amanda'),('N','C','1954-02-16','1982-12-16','1974-06-01',29,'924352529','264225443','Dean','Robbins','clayton.dean@gmail.com','73670062L','Clayton'),('S','C','1975-09-25','1991-10-28','1984-12-23',30,'972417609','455583084','Ruiz','Mendoza','micheal.ruiz@gmail.com','39489420X','Micheal'),('N','S','1954-02-14','1972-10-28','1983-06-08',31,'682302363','859021356','Soto','Perry','jeffrey.soto@gmail.com','47986253B','Jeffrey'),('S','C','1983-12-23','2006-11-28','1990-10-23',32,'322709823','185131895','Cohen','White','stella.cohen@gmail.com','81369158S','Stella'),('N','C','2001-10-15',NULL,'1976-10-01',33,'631419582','607643290','Garcia','Ortiz','katie.garcia@gmail.com','11004592E','Katie'),('N','C','2004-04-09',NULL,'1978-08-02',34,'463094918','844857293','Jennings','Vaughn','trevor.jennings@gmail.com','39366423K','Trevor'),('N','C','1966-05-27','1975-05-05','1975-12-27',35,'539679698','995811856','Beck','Lindsey','phoebe.beck@gmail.com','35746034W','Phoebe'),('S','C','1979-06-20','1998-11-17','1975-03-22',36,'670810412','459532146','Parker','Larson','allen.parker@gmail.com','95326377K','Allen'),('N','C','2001-08-17','2022-04-11','1979-03-01',37,'917037154','901574734','Lamb','Goodman','maud.lamb@gmail.com','92864188D','Maud'),('S','S','2003-03-27',NULL,'1996-10-15',38,'452232603','236691377','Sanders','Barnes','margaret.sanders@gmail.com','48822127X','Margaret'),('N','S','2019-05-15',NULL,'2000-06-09',39,'588859200','779130611','Nichols','Thornton','harvey.nichols@gmail.com','13701029X','Harvey'),('N','C','1976-01-28','1990-07-24','1978-03-27',40,'293595660','753286325','Silva','Morgan','nettie.silva@gmail.com','97607064G','Nettie'),('S','S','2014-07-20','2017-08-18','1996-12-16',41,'115606243','328473389','Lloyd','Jones','isabelle.lloyd@gmail.com','13761491E','Isabelle'),('N','S','2010-03-15',NULL,'1988-06-03',42,'540829648','616539514','Alexander','Collins','alma.alexander@gmail.com','47447522D','Alma'),('N','S','1972-11-15','1982-07-08','1986-01-01',43,'487523839','321528758','Wilkerson','Todd','esther.wilkerson@gmail.com','70866763E','Esther'),('N','S','1963-11-16','1991-09-21','1986-05-17',44,'711374643','852122890','Boyd','Sparks','jean.boyd@gmail.com','44279930F','Jean'),('N','C','1990-04-24',NULL,'1990-02-03',45,'236689283','318546385','Guzman','Franklin','roy.guzman@gmail.com','28370947P','Roy'),('N','S','1993-12-05','2007-10-18','1998-04-12',46,'900685583','150655595','Singleton','Watson','julian.singleton@gmail.com','35106139V','Julian'),('N','C','2014-08-09',NULL,'1999-10-07',47,'453662647','794629837','Bailey','Hunt','devin.bailey@gmail.com','87541974K','Devin'),('N','S','2007-03-04',NULL,'2000-08-08',48,'211685045','628069790','Reed','Pope','douglas.reed@gmail.com','70903799V','Douglas'),('N','C','1960-09-10','1979-08-14','1977-04-20',49,'371630061','366430459','Willis','Adkins','julian.willis@gmail.com','94343208E','Julian'),('N','S','1981-02-24','2006-08-15','1988-08-27',50,'442484764','848466438','Hughes','Zimmerman','ivan.hughes@gmail.com','36835190O','Ivan'),('N','C','1993-05-20',NULL,'1984-04-15',51,'543172251','219851054','Banks','Oliver','patrick.banks@gmail.com','28116799D','Patrick'),('N','C','1983-08-11','2001-04-13','1977-08-27',52,'169588254','603792876','Herrera','Jenkins','angel.herrera@gmail.com','96128200B','Angel'),('N','S','1985-12-10','1996-08-06','1980-11-20',53,'565953083','554593277','Spencer','Crawford','sue.spencer@gmail.com','76438292A','Sue'),('N','C','1985-08-13','1992-08-15','1993-10-02',54,'819432128','108332463','Richards','Gonzalez','steve.richards@gmail.com','98318129J','Steve'),('N','C','2015-10-01',NULL,'1999-05-17',55,'351459703','578697521','Wong','Schneider','jimmy.wong@gmail.com','79260073L','Jimmy'),('N','C','1973-07-23','2003-05-09','1987-11-03',56,'689532203','922539225','Ramirez','Boyd','etta.ramirez@gmail.com','25070679J','Etta'),('N','C','1979-03-03','1995-12-26','1985-08-27',57,'639057206','860533750','Stone','Rice','rebecca.stone@gmail.com','71210354Y','Rebecca'),('N','C','1963-10-24','1982-08-17','1981-05-24',58,'674640875','823667421','Fuller','Francis','francisco.fuller@gmail.com','74656829E','Francisco'),('N','S','2009-01-14',NULL,'1998-06-01',59,'625073365','877309428','Brock','Reed','clayton.brock@gmail.com','60061445S','Clayton'),('N','S','2000-04-11',NULL,'1999-09-06',60,'316108842','899138088','Jensen','Park','david.jensen@gmail.com','34065433J','David'),('N','C','1968-09-25','1991-03-05','1984-07-26',61,'352740490','783722825','George','Morgan','marguerite.george@gmail.com','75772108D','Marguerite'),('N','C','1952-01-14','1964-09-07','1975-03-14',62,'474629467','936104706','Hopkins','McBride','hattie.hopkins@gmail.com','26754843V','Hattie'),('N','C','1999-01-05',NULL,'1996-05-12',63,'287379795','630041067','Nelson','George','vera.nelson@gmail.com','51692259D','Vera'),('N','C','1980-03-01','1991-01-12','1991-04-01',64,'599347304','819825570','Jackson','Malone','mollie.jackson@gmail.com','36700275Z','Mollie'),('N','C','1954-06-23','1962-10-22','1983-07-04',65,'600784608','910342186','Padilla','Caldwell','effie.padilla@gmail.com','76690525T','Effie'),('N','S','2011-02-02',NULL,'1997-01-03',66,'201379813','341687401','Hardy','Scott','amanda.hardy@gmail.com','45848829G','Amanda'),('N','C','1991-12-16',NULL,'1998-02-02',67,'528495414','643760828','Copeland','Santos','glenn.copeland@gmail.com','47299129S','Glenn'),('N','C','1991-01-04',NULL,'1973-02-01',68,'750361430','218471615','Wilkerson','Lowe','eula.wilkerson@gmail.com','44704219U','Eula'),('N','C','1999-12-25',NULL,'1986-01-12',69,'140518430','499831337','Castro','Ford','lenora.castro@gmail.com','46842034K','Lenora'),('N','S','1969-03-26','1970-10-20','1976-10-19',70,'126971850','455642859','Gilbert','Moody','bruce.gilbert@gmail.com','71007634Z','Bruce'),('N','S','2013-07-22',NULL,'1997-01-21',71,'612683409','932208933','Allen','Cruz','isabelle.allen@gmail.com','83007275T','Isabelle'),('N','S','1999-08-01','2019-12-08','1996-04-24',72,'953226116','623590266','Gutierrez','Anderson','gilbert.gutierrez@gmail.com','16638807K','Gilbert'),('N','S','1953-06-13','1965-03-11','1970-12-13',73,'835515416','694047211','Boyd','Wells','cecilia.boyd@gmail.com','65770597D','Cecilia'),('N','C','1987-06-13','1988-08-05','1993-11-15',74,'276569445','403635936','Gonzales','Simon','leona.gonzales@gmail.com','21753788C','Leona'),('N','S','1979-03-09','1981-11-28','1991-12-04',75,'865387182','766710620','Ruiz','Fernandez','rebecca.ruiz@gmail.com','56683647H','Rebecca'),('N','S','1980-07-07','2007-10-19','1990-11-02',76,'408305826','336428927','Lawson','Ruiz','jim.lawson@gmail.com','44924233H','Jim'),('N','C','1955-02-09','1985-12-18','1973-06-01',77,'113646384','387947010','Knight','Neal','bryan.knight@gmail.com','30559162S','Bryan'),('N','S','1983-08-24','1999-04-25','1992-06-28',78,'810857448','381976759','Brock','Williamson','leah.brock@gmail.com','21225536A','Leah'),('S','S','1980-12-16','2001-05-24','1984-11-24',79,'463397938','604250190','Mack','Porter','emma.mack@gmail.com','45078725L','Emma'),('N','C','1994-08-08',NULL,'2003-02-02',80,'670995977','428532936','Mathis','Rhodes','rosa.mathis@gmail.com','82685909O','Rosa'),('S','C','2000-06-19',NULL,'1977-07-11',81,'852633900','335698354','Garner','Moran','isaac.garner@gmail.com','76859765D','Isaac'),('N','S','1942-09-21','1943-01-13','1975-08-14',82,'712403802','188271637','Bell','Lee','daisy.bell@gmail.com','94714323F','Daisy'),('N','S','1987-06-16','1990-03-21','1998-02-19',83,'121222154','301174342','Romero','Pierce','evan.romero@gmail.com','68774424K','Evan'),('S','C','1984-03-21','2013-10-16','1973-08-17',84,'778449460','599671207','Perkins','Howell','joshua.perkins@gmail.com','30644966W','Joshua'),('N','S','1994-06-20',NULL,'1975-06-04',85,'566210902','265301131','Benson','Luna','dylan.benson@gmail.com','26117201R','Dylan'),('N','S','1977-11-18','2003-03-04','1970-04-10',86,'866466434','341684229','Gonzalez','Moreno','ruby.gonzalez@gmail.com','47678685M','Ruby'),('N','C','1946-10-05','1978-08-16','1972-07-03',87,'766182300','863626512','Daniel','Townsend','franklin.daniel@gmail.com','18178099P','Franklin'),('N','C','1970-01-13','1985-03-04','1992-06-04',88,'869666355','914330156','Parker','Reynolds','theodore.parker@gmail.com','38245621S','Theodore'),('N','C','1955-03-17','1975-08-20','1982-09-07',89,'507411360','420660250','Jefferson','Thompson','adele.jefferson@gmail.com','16216380C','Adele'),('N','S','1995-02-12','2005-02-02','2000-09-07',90,'413483210','396569186','Carter','Chambers','evelyn.carter@gmail.com','14136084Y','Evelyn'),('N','S','2003-10-06','2017-10-14','2001-08-08',91,'802348507','391263554','Lawrence','Brewer','katie.lawrence@gmail.com','43167059Z','Katie'),('N','S','1977-06-28','2005-06-20','1975-09-26',92,'492518803','191357495','Fuller','Martin','roger.fuller@gmail.com','64893233H','Roger'),('N','C','1980-12-11','1993-01-28','1994-01-04',93,'638297679','994350483','Obrien','Russell','catherine.obrien@gmail.com','51652556X','Catherine'),('N','S','1957-11-26','1965-05-01','1983-02-12',94,'364313797','246189039','Long','Daniel','bertie.long@gmail.com','70040501X','Bertie'),('N','C','1984-05-25','2015-11-18','1987-08-22',95,'735407846','741182887','Patrick','Mills','betty.patrick@gmail.com','25863860F','Betty'),('N','C','1946-03-03','1953-12-11','1972-02-15',96,'790947139','130204734','Higgins','Burgess','jonathan.higgins@gmail.com','14153748T','Jonathan'),('N','S','1979-06-04','1980-05-11','1977-03-23',97,'914055118','854919455','Holt','Logan','elva.holt@gmail.com','93603475R','Elva'),('N','S','1986-09-16','1995-02-05','1999-07-10',98,'750227902','563190671','Gutierrez','Pearson','isabella.gutierrez@gmail.com','83677683X','Isabella'),('N','C','1964-10-09','1997-12-05','1976-09-10',99,'427137066','985992183','Hernandez','Wade','dominic.hernandez@gmail.com','14920129H','Dominic'),('N','C','2001-04-10','2009-07-13','1990-10-23',100,'793592061','604119919','McGee','Walker','roxie.mcgee@gmail.com','82280834H','Roxie');
/*!40000 ALTER TABLE `em_empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado-sequence`
--

DROP TABLE IF EXISTS `empleado-sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado-sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado-sequence`
--

LOCK TABLES `empleado-sequence` WRITE;
/*!40000 ALTER TABLE `empleado-sequence` DISABLE KEYS */;
INSERT INTO `empleado-sequence` VALUES (101);
/*!40000 ALTER TABLE `empleado-sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pr_empleados_proyecto`
--

DROP TABLE IF EXISTS `pr_empleados_proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pr_empleados_proyecto` (
  `F_ALTA` date DEFAULT NULL,
  `ID_EMPLEADO` int(7) NOT NULL,
  `ID_PROYECTO` int(5) NOT NULL,
  PRIMARY KEY (`ID_EMPLEADO`,`ID_PROYECTO`),
  KEY `FK8001943l1ns01bo5d4jmidg52` (`ID_PROYECTO`),
  CONSTRAINT `FK8001943l1ns01bo5d4jmidg52` FOREIGN KEY (`ID_PROYECTO`) REFERENCES `pr_proyectos` (`ID_PROYECTO`),
  CONSTRAINT `FK9u2qdi9mjxtki0d287uk9tkq3` FOREIGN KEY (`ID_EMPLEADO`) REFERENCES `em_empleados` (`ID_EMPLEADO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pr_empleados_proyecto`
--

LOCK TABLES `pr_empleados_proyecto` WRITE;
/*!40000 ALTER TABLE `pr_empleados_proyecto` DISABLE KEYS */;
INSERT INTO `pr_empleados_proyecto` VALUES ('1998-09-27',2,10),('2013-09-10',2,36),('2020-07-24',2,44),('2017-09-16',5,19),('2023-07-15',5,23),('2017-08-21',5,32),('2012-02-15',5,46),('1997-11-12',6,1),('2000-06-23',6,10),('2022-03-16',6,26),('2012-09-17',6,37),('2022-11-27',6,44),('2009-11-28',9,10),('2012-04-10',9,15),('2020-07-23',9,31),('2015-06-17',9,32),('2013-07-28',9,38),('2020-07-12',9,46),('2022-07-03',10,8),('2010-03-27',10,19),('2000-02-13',10,29),('2017-10-16',10,31),('2011-04-16',10,33),('2012-09-17',10,46),('2000-09-04',12,1),('2017-09-02',12,23),('2002-08-07',12,26),('2019-11-22',12,32),('2022-07-09',12,46),('2012-04-23',14,15),('2023-12-11',14,17),('2023-04-06',14,30),('2014-04-20',14,31),('2023-06-23',14,45),('2009-12-11',23,1),('2023-03-09',23,3),('2022-06-19',23,8),('2001-08-01',23,27),('2020-12-04',23,33),('2013-04-13',23,36),('2022-10-04',24,2),('2023-08-21',24,23),('2023-12-20',24,28),('2015-10-15',25,17),('2007-09-23',25,21),('2020-04-27',25,30),('2023-07-10',25,44),('2009-04-19',25,45),('2013-10-27',25,46),('2021-11-22',26,5),('2016-09-28',26,21),('2016-09-17',26,23),('2021-01-10',26,46),('2018-12-09',33,15),('2001-06-01',33,19),('2020-05-19',33,44),('2020-12-17',34,2),('2009-02-16',34,10),('2022-09-14',34,17),('2010-10-25',34,33),('2004-04-07',34,47),('2021-02-28',38,2),('2022-03-20',38,8),('2009-06-15',38,21),('2010-02-15',38,23),('2016-04-15',38,32),('2023-11-07',39,2),('2023-07-19',39,5),('2020-06-08',39,32),('2022-06-09',39,36),('2020-11-21',39,47),('2023-10-15',42,2),('2021-01-14',42,3),('2015-06-11',42,31),('2010-08-23',42,33),('2022-09-21',45,3),('1995-09-01',45,6),('2014-11-10',45,17),('2009-06-11',45,25),('2002-03-04',45,36),('1995-02-03',45,45),('2017-07-27',47,1),('2018-10-10',47,22),('2018-03-10',47,27),('2021-08-22',47,44),('2013-10-07',48,1),('2010-07-12',48,23),('2018-06-01',48,30),('2023-05-01',48,46),('2021-09-06',51,3),('2023-11-06',51,15),('2020-01-15',51,30),('2021-06-10',51,37),('2016-11-22',51,38),('2015-05-06',55,11),('2019-02-15',55,22),('2019-11-01',55,30),('2016-05-22',55,33),('2022-04-27',55,45),('2019-07-13',59,5),('2023-10-05',59,8),('2012-03-22',59,11),('2023-05-06',59,32),('2009-06-03',59,36),('2015-01-22',60,10),('2009-02-25',60,21),('2014-03-10',60,28),('2019-12-15',60,38),('2008-12-03',60,47),('2010-08-01',63,1),('2015-09-18',63,11),('2006-02-18',63,15),('2020-02-10',63,22),('2022-05-02',63,31),('2001-06-20',63,33),('2022-10-05',66,5),('2013-10-06',66,21),('2018-05-23',66,22),('2017-04-13',66,27),('2018-08-26',66,28),('2009-12-08',67,21),('2003-12-11',67,25),('2016-06-01',67,47),('2023-12-12',68,2),('2016-02-15',68,11),('2012-03-07',69,0),('1999-02-07',69,1),('2020-09-14',69,5),('2022-01-27',69,8),('2006-07-17',69,26),('2019-05-15',69,30),('2022-05-02',71,10),('2019-05-02',71,23),('2013-11-06',71,42),('2022-01-19',71,44),('2021-04-04',71,46),('2023-11-25',80,23),('2008-03-06',80,26),('1998-11-25',80,27),('2011-12-25',80,31),('2019-03-22',80,37),('2013-02-26',81,1),('2020-05-26',81,10),('2022-08-26',81,22),('2014-03-22',81,38),('2019-11-09',85,5),('2016-07-02',85,19),('2018-05-06',85,30),('2018-05-10',85,32),('2005-06-01',85,47);
/*!40000 ALTER TABLE `pr_empleados_proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pr_proyecto`
--

DROP TABLE IF EXISTS `pr_proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pr_proyecto` (
  `F_BAJA` date DEFAULT NULL,
  `F_FIN` date DEFAULT NULL,
  `F_INICIO` date NOT NULL,
  `ID_PROYECTO` int(5) NOT NULL,
  `TX_DESCRIPCION` varchar(125) NOT NULL,
  `TX_LUGAR` varchar(30) DEFAULT NULL,
  `TX_OBSERVACIONES` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ID_PROYECTO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pr_proyecto`
--

LOCK TABLES `pr_proyecto` WRITE;
/*!40000 ALTER TABLE `pr_proyecto` DISABLE KEYS */;
/*!40000 ALTER TABLE `pr_proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pr_proyectos`
--

DROP TABLE IF EXISTS `pr_proyectos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pr_proyectos` (
  `F_BAJA` date DEFAULT NULL,
  `F_FIN` date DEFAULT NULL,
  `F_INICIO` date NOT NULL,
  `ID_PROYECTO` int(5) NOT NULL,
  `TX_DESCRIPCION` varchar(125) NOT NULL,
  `TX_LUGAR` varchar(30) DEFAULT NULL,
  `TX_OBSERVACIONES` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ID_PROYECTO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pr_proyectos`
--

LOCK TABLES `pr_proyectos` WRITE;
/*!40000 ALTER TABLE `pr_proyectos` DISABLE KEYS */;
INSERT INTO `pr_proyectos` VALUES (NULL,'1966-09-24','1958-11-22',0,'Gone club temperature provide excellent nearer','Málaga','Gave send sad purple settle feet drawn sure ourselves solution rabbit doctor summer yes card expect tears dig fresh given round place primitive matter'),(NULL,'1971-01-08','1966-09-07',1,'Acres research fun track somehow','Barcelona','Little rubber fierce hearing baby one regular firm space nearly clay remove shot off basket stove rich entire police picture shaking oxygen religious month'),(NULL,'2027-02-02','2017-02-04',2,'Tent bent temperature itself identity grandfather could steep','Zaragoza','Universe answer lying pink price easier bread lips neighbor mixture fix too struggle let peace rough block gift paid distant silent wolf idea property'),(NULL,'2028-01-09','2021-11-19',3,'Extra vertical vowel count','Valencia','That directly hall cream nearly anyone plant behind root voice being satellites height cell some longer butter sail exciting solid chose port twelve obtain'),(NULL,'2031-01-11','2026-11-03',4,'Train inch raise are','Zaragoza','Invented properly weak cookies needed hung breathe tone television single exercise try key broken adult end hair learn fresh pan lips limited lost length'),(NULL,'2029-11-13','2019-01-01',5,'Means state','Madrid','Lack lips hour harbor regular cat familiar beyond pond positive habit daughter current discover fix shout handsome making series crack job specific shore out'),(NULL,'1967-02-12','1961-08-21',6,'Star garden jar duty ten grain','Sevilla','Well children tears usually caught noon paragraph park its golden order school whale football bank tube tone wealth these attention happened person behind start'),('2012-01-12','1976-06-23','1965-10-20',7,'Imagine cage','Madrid','Dot remove unhappy tobacco religious parallel already black look children if powder so hurry count possibly also far beautiful war anything wild select partly'),(NULL,'2029-02-05','2022-09-19',8,'Star equipment locate box no','Barcelona','Done cast welcome apart children lion prevent drive chamber skill ten period identity colony managed pass uncle shoot bus his rubber personal wood recognize'),(NULL,'2036-12-01','2028-10-13',9,'Knife nodded make terrible wait','Málaga','Themselves answer today move wind local respect enjoy regular whenever anybody nine mile force everybody saw leaving am hardly cloth bent lost fight thought'),(NULL,'2005-05-14','1998-12-25',10,'Cause member scale receive trail','Madrid','Individual upper harbor fifteen actually job lead prize we chair mirror situation being manufacturing suddenly smallest daughter my rod twice complex political pilot plan'),(NULL,'2017-06-14','2008-04-04',11,'Sold pencil ahead without third','Barcelona','Age nuts club anybody generally beyond around needed giving longer night wish buffalo golden difficult describe policeman star regular signal round kind cookies whistle'),('2019-07-21','2017-07-14','2013-08-12',12,'Screen monkey herd','Málaga','Engineer did problem living up equally molecular will official party several weak rabbit needed pool milk throw past material block given machinery wheel anyway'),('2019-02-19','2013-08-25','2003-07-03',13,'Held unhappy spin pull cause','Málaga','Class friend education alike create gradually forgotten five talk come apple lying dozen recent breeze function solution right character stove limited ill town thee'),(NULL,'2035-01-10','2027-10-04',14,'Animal cross wish forest give deal','Málaga','Since period getting youth making quickly vast globe lift pair though hang locate sand chart musical beneath successful boy nervous direction plural within jump'),(NULL,'1968-11-18','1963-09-08',15,'Push increase clothing jack straw','Valencia','Zero village power arrangement kitchen half describe women duck me box dug top deeply saddle lack frequently monkey location trick doubt chemical country tube'),('2011-10-02','1975-02-16','1968-11-05',16,'Quick oldest lesson','Barcelona','Plus gather relationship behavior period cool calm white thin weather silk limited plant imagine cent brick combine of against importance citizen birth were sit'),(NULL,'2020-01-27','2014-06-26',17,'Diameter too chest safety exchange','Barcelona','Regular public unhappy independent led promised signal above shirt sit importance mass truck nation whole massage president machinery interior shoe cannot pleasant bell all'),(NULL,'2029-03-09','2028-05-07',18,'Swing whether grew classroom share member','Zaragoza','Us accurate beautiful happy mad beat pain statement title thought couple ants nuts object could birth manufacturing price species previous brought dog shore girl'),(NULL,'1981-10-10','1980-05-20',19,'Setting tell angle stand minute natural','Barcelona','Only hunt enjoy pleasant water area else to cutting angle already ride by branch write sit please hope stranger is wheat grabbed select paid'),('2020-11-18','1992-02-05','1982-12-01',20,'Difference imagine wrapped tide low cup','Barcelona','Parallel whatever clay journey today floor clear wave suit simply correct guide breakfast smooth branch attempt selection gone sum progress current easier four wheel'),(NULL,'1986-05-20','1979-08-09',21,'Roll usually choice been further','Valencia','Sale hair treated hunter river while review none light equal mail found wrote stepped experience sets weak wolf walk clothing read wet saddle problem'),(NULL,'2020-12-08','2018-10-22',22,'Health graph from','Sevilla','Swing everyone lift negative pack main single till pole summer paragraph slide package tightly passage cover leather sometime contrast represent rubbed private upper doll'),(NULL,'1973-08-16','1962-09-02',23,'Bare disappear special dust folks realize practical','Málaga','Smell chest end president courage two taught flame seat such castle musical sum similar merely shape while experience chapter why fill west buy tongue'),('2002-04-17','1978-04-13','1971-12-12',24,'For particles your','Madrid','Amount place master pony mountain upward key bend development customs century slight needed trap first climb base bent fruit won discuss cookies highest between'),(NULL,'2000-09-21','1994-11-03',25,'Loose crop empty anyway','Zaragoza','Circle secret fact child sometime read loose upper price angry day enough dot wonderful handsome thrown mind simple touch public father label fort salt'),(NULL,'1986-10-02','1978-02-23',26,'Main surface quietly','Málaga','Desk corner mistake joy railroad fierce constantly moment scientific yourself drop replace native other managed additional note political plus church floor ready piano do'),(NULL,'1980-08-20','1977-03-21',27,'Worried chief how agree storm diameter','Sevilla','Throw stems face cow brave spoken forgotten flight square agree exact hold similar graph camera before clothing shoulder circle combination applied continued create flies'),(NULL,'1994-10-14','1983-05-24',28,'Wall setting gave mathematics','Málaga','Refused heavy shot correct eager area above copy pencil alive bite higher origin exist shall pitch longer pan handle book flat meet bottle distant'),(NULL,'1981-12-26','1969-01-20',29,'Identity west zoo stiff paint','Sevilla','Catch crowd light vote tiny clear condition figure quick table broad weight east lovely year perfectly damage fifth expect flat hour horn later circle'),(NULL,'2022-04-15','2018-10-11',30,'Temperature price south stream create','Zaragoza','Hundred mud shot state forgot that upon carry advice book physical exclaimed two atmosphere nails tears shop provide office loss combination dear about color'),(NULL,'2015-03-13','2008-10-06',31,'Agree first see quick impossible','Sevilla','Atomic indeed factory perhaps imagine number six potatoes aboard these rabbit double everywhere anything shown surface stand elephant nails available late various shade room'),(NULL,'2025-12-06','2015-10-20',32,'Did properly jungle price pet','Madrid','Nor let stranger related soon husband silk tribe mass neighborhood cool cold examine firm horse return salt usually train military here dinner white welcome'),(NULL,'1971-05-04','1960-12-04',33,'Origin tea fully does','Málaga','Environment clear shinning least mix through adventure began lion sent addition them continent wrong century including herself lost angry stone build kind progress nobody'),('1990-04-08','1988-10-15','1979-07-28',34,'Larger game size dull seems method','Málaga','Sky shells ability word poet duck got eat held wing dress built region traffic crowd circle yesterday itself pink thread diameter lower blue rapidly'),('1989-06-08','1982-02-12','1973-02-27',35,'Meal shade within require','Madrid','Obtain slip thirty has built lady either also crack village studied owner clothes sentence twelve expression weight possibly planned house adjective stage nature thousand'),(NULL,'1966-05-10','1957-03-21',36,'Whose became hill fine face activity','Zaragoza','Bow dinner gravity bread believed position failed represent up pan done dirt refer safe outside tape globe largest does transportation plastic sent spin pass'),(NULL,'2019-08-13','2011-04-19',37,'Getting deal lead garage bet','Valencia','Education pine cook count block settle barn stuck iron spent fewer cow source garden arrive sum duck signal judge might week whether generally who'),(NULL,'2016-06-05','2007-01-04',38,'What correctly show straw cold','Madrid','Same read necessary attempt mark once distance story depend muscle pool colony earn pupil pure my got different railroad addition electricity recognize because thee'),('2016-01-19','2014-02-09','2008-05-05',39,'Game saw rocky driver ought today','Barcelona','Phrase name stopped rest spent myself also member built cause quietly short eaten interest enemy open room if pocket cow vote load becoming bowl'),('1997-03-24','1971-10-16','1963-03-13',40,'Spider branch hat save origin','Málaga','Nose how solid red strike specific shoot firm since port have slept these play seven mind eleven bill given struggle lips hill end according'),('2001-07-25','1996-07-03','1993-02-02',41,'Harder reader effect saddle','Madrid','Maybe band wear won sky biggest home serve track continued you bell color contrast quite coming ever accept base brave anywhere begun breath produce'),(NULL,'1994-06-17','1989-01-09',42,'Pattern level hollow branch matter moment','Sevilla','Railroad bean wood individual explore easier joined simplest does part figure new immediately courage attention opinion thee mean rod according brass do special little'),('1988-07-06','1984-04-13','1979-11-02',43,'Course moment dig new gasoline business outer','Sevilla','Three farmer wagon silver consonant mirror classroom rain old would chart contain evidence product nice call pie slightly tea tone broken native excellent judge'),(NULL,'2026-05-11','2020-07-05',44,'Voyage spell slide yet few','Barcelona','Column equipment stomach world range mathematics pair prevent brother today hard turn tool toy straight trade cattle electric week interest pressure history court lady'),(NULL,'1987-01-11','1976-08-24',45,'Place anywhere temperature women line location','Málaga','Talk bell corn mad along winter replace save send classroom suit list crowd rough wish jack blue load motor just usually front watch running'),(NULL,'2021-03-22','2012-04-17',46,'Program common bring who','Málaga','Wonder gather none clay call forgot object giving somehow putting location anywhere slide sale paragraph deer failed palace exercise ground under wet reader wife'),(NULL,'2006-09-15','2000-09-26',47,'Vertical important giving','Sevilla','Trunk eleven station numeral top source fierce garage seven anybody should mostly halfway teeth snow stomach son simple activity greatly harder butter substance star');
/*!40000 ALTER TABLE `pr_proyectos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto-sequence`
--

DROP TABLE IF EXISTS `proyecto-sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyecto-sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto-sequence`
--

LOCK TABLES `proyecto-sequence` WRITE;
/*!40000 ALTER TABLE `proyecto-sequence` DISABLE KEYS */;
INSERT INTO `proyecto-sequence` VALUES (48);
/*!40000 ALTER TABLE `proyecto-sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-14 12:45:46
