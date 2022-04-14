# ************************************************************
# Sequel Ace SQL dump
# Version 20031
#
# https://sequel-ace.com/
# https://github.com/Sequel-Ace/Sequel-Ace
#
# Host: localhost (MySQL 5.7.34)
# Database: OrderManagementPT
# Generation Time: 2022-04-02 11:46:31 +0000
# ************************************************************

# Database Credentials:
# Username: OrderManagementAdmin
# Host: localhost
# Port: 8889
# Password: KQ00ri_WR7Zs1q[a
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE='NO_AUTO_VALUE_ON_ZERO', SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table client
# ------------------------------------------------------------

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(20) DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;

INSERT INTO `client` (`id`, `last_name`, `first_name`, `phone_number`, `address`)
VALUES
	(1,'Moldovan','Radu','669635402','Observatorului 20'),
	(2,'Popescu','Andrei','1855573094','Observatorului 4'),
	(3,'Moldovan','Cristian','1478975474','Timpului 9'),
	(4,'Pascale','Cristian','393593100','Alunisului 62'),
	(5,'Moldovan','Radu','75094308','Alunisului 53'),
	(6,'Pascale','Bianca','1099695442','Lopatarului 53'),
	(7,'Popa','Marian','1985256418','Izvorului 80'),
	(8,'Toader','Radu','309111562','Izvorului 48'),
	(9,'Moldovan','Sebastian','1795764840','Observatorului 29'),
	(10,'Rusu','Daria','580694848','Dambovitei 40'),
	(11,'Rusu','Sebastian','1805708794','Lopatarului 35'),
	(12,'Ciocoiu','Daria','1306864468','Plopilor 28'),
	(13,'Rusu','Cristian','1192676846','Dambovitei 89'),
	(14,'Bunea','Sebastian','1344736044','Observatorului 100'),
	(15,'Bunea','Stefan','982260292','Dambovitei 89'),
	(16,'Moldovan','Lorena','2136283370','Lopatarului 57'),
	(17,'Ardelean','Cristian','1089024992','Plopilor 11'),
	(18,'Ardelean','Daria','1816277096','Timpului 65'),
	(19,'Moldovan','Radu','340624352','Frunzisului 17'),
	(20,'Popescu','Bianca','451352718','Timpului 95'),
	(21,'Ardelean','Sebastian','1806417950','Timpului 58'),
	(22,'Popescu','Marian','1764115830','Plopilor 33'),
	(23,'Toader','Sebastian','73577420','Salcamului 38'),
	(24,'Ciocoiu','Radu','77499318','Observatorului 38'),
	(25,'Moldovan','Daria','1341300832','Plopilor 75'),
	(26,'Toader','Daria','698541792','Plopilor 33'),
	(27,'Popescu','Cristian','2144336774','Memorandumului 69'),
	(28,'Toader','Radu','400345008','Dambovitei 7'),
	(29,'Ciocoiu','Miruna','671008740','Frunzisului 20'),
	(30,'Rusu','Stefan','1721182058','Observatorului 71'),
	(31,'Ardelean','Stefan','1900424504','Lopatarului 77'),
	(32,'Ardelean','Cristian','1960630898','Lopatarului 89'),
	(33,'Rusu','Bianca','1567004454','Plopilor 33'),
	(34,'Ciocoiu','Stefan','1933423776','Izvorului 17'),
	(35,'Pascale','Stefan','1656729202','Frunzisului 55'),
	(36,'Rusu','Miruna','1448759340','Dambovitei 75'),
	(37,'Feleac','Andrei','1620362518','Dambovitei 2'),
	(38,'Feleac','Radu','754570388','Memorandumului 59'),
	(39,'Bunea','Andrei','1832888408','Plopilor 46'),
	(40,'Bunea','Marian','1970958818','Alunisului 94'),
	(41,'Popescu','Bianca','1440912012','Timpului 76'),
	(42,'Ardelean','Stefan','1893387508','Frunzisului 68'),
	(43,'Moldovan','Daria','1103229952','Memorandumului 59'),
	(44,'Bunea','Daria','189613842','Alunisului 76'),
	(45,'Rusu','Bianca','1398161174','Memorandumului 67'),
	(46,'Popa','Cristian','1187926086','Observatorului 70'),
	(47,'Moldovan','Marian','646225044','Salcamului 31'),
	(48,'Ciocoiu','Sebastian','1020721664','Izvorului 68'),
	(49,'Rusu','Sebastian','169701498','Alunisului 61'),
	(50,'Popescu','Lorena','853962938','Izvorului 62'),
	(51,'Pascale','Marian','269411470','Lopatarului 59'),
	(52,'Ardelean','Bianca','905985070','Timpului 36'),
	(53,'Feleac','Daria','678638304','Lopatarului 71'),
	(54,'Pascale','Cristian','1387670726','Frunzisului 72'),
	(55,'Rusu','Miruna','67016966','Dambovitei 11'),
	(56,'Ciocoiu','Miruna','1403571730','Alunisului 14'),
	(57,'Ardelean','Lorena','1232523634','Timpului 59'),
	(58,'Ardelean','Stefan','33087372','Izvorului 95'),
	(59,'Bunea','Sebastian','1165777256','Alunisului 100'),
	(60,'Moldovan','Sebastian','797888834','Dambovitei 98'),
	(61,'Moldovan','Miruna','1964030448','Dambovitei 75'),
	(62,'Moldovan','Bianca','2085776992','Plopilor 71'),
	(63,'Pascale','Radu','1570609948','Salcamului 64'),
	(64,'Moldovan','Sebastian','1402969556','Plopilor 74'),
	(65,'Pascale','Stefan','1272356546','Timpului 22'),
	(66,'Ciocoiu','Stefan','198856812','Alunisului 70'),
	(67,'Moldovan','Cristian','1504292434','Lopatarului 47'),
	(68,'Ardelean','Sebastian','1380556840','Salcamului 9'),
	(69,'Rusu','Marian','1491447590','Lopatarului 93'),
	(70,'Feleac','Miruna','544049930','Lopatarului 84'),
	(71,'Bunea','Cristian','881767844','Alunisului 14'),
	(72,'Pascale','Daria','597944970','Dambovitei 77'),
	(73,'Bunea','Daria','1101631396','Lopatarului 36'),
	(74,'Toader','Stefan','1953372938','Salcamului 17'),
	(75,'Feleac','Sebastian','2084889422','Frunzisului 91'),
	(76,'Ciocoiu','Marian','387365358','Dambovitei 32'),
	(77,'Moldovan','Andrei','980237268','Dambovitei 19'),
	(78,'Popa','Radu','183513222','Dambovitei 36'),
	(79,'Ciocoiu','Daria','1018718888','Salcamului 81'),
	(80,'Toader','Marian','96877282','Izvorului 16'),
	(81,'Ciocoiu','Cristian','1368341128','Alunisului 95'),
	(82,'Popescu','Bianca','1797497902','Observatorului 63'),
	(83,'Popescu','Cristian','1815651746','Timpului 58'),
	(84,'Moldovan','Bianca','714528570','Lopatarului 41'),
	(85,'Ciocoiu','Daria','2121643268','Izvorului 63'),
	(86,'Bunea','Andrei','585901344','Timpului 93'),
	(87,'Popescu','Daria','1612985604','Memorandumului 92'),
	(88,'Bunea','Miruna','370099298','Alunisului 87'),
	(89,'Moldovan','Stefan','1767689270','Izvorului 46'),
	(90,'Popa','Daria','780583354','Alunisului 63'),
	(91,'Popescu','Bianca','395014808','Timpului 3'),
	(92,'Toader','Radu','1411886590','Observatorului 18'),
	(93,'Toader','Daria','1499984040','Plopilor 23'),
	(94,'Rusu','Bianca','986347354','Timpului 19'),
	(95,'Ciocoiu','Cristian','1779233480','Memorandumului 38'),
	(96,'Popescu','Andrei','622760206','Dambovitei 13'),
	(97,'Toader','Radu','1829930970','Frunzisului 74'),
	(98,'Rusu','Cristian','721126982','Frunzisului 18'),
	(99,'Ardelean','Bianca','293884474','Alunisului 37'),
	(100,'Moldovan','Sebastian','1615004784','Plopilor 2');

/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table orders
# ------------------------------------------------------------

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_client` int(11) DEFAULT NULL,
  `id_product` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_client` (`id_client`),
  KEY `id_product` (`id_product`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`) ON DELETE CASCADE,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table product
# ------------------------------------------------------------

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;

INSERT INTO `product` (`id`, `name`, `stock`, `price`)
VALUES
	(11,'Laptop',10,1000),
	(12,'Casti',4,600),
	(13,'Cuptor',5,800),
	(14,'Tigaie',12,30),
	(15,'Geaca',10,240),
	(16,'Mouse',2,60),
	(17,'Adidas',6,600),
	(18,'Frigider',1,900),
	(19,'Saltea',6,300),
	(20,'Hanorac',10,120);

/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
