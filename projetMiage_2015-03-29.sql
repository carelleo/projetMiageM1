# ************************************************************
# Sequel Pro SQL dump
# Version 4135
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: localhost (MySQL 5.5.42)
# Database: projetMiage
# Generation Time: 2015-03-29 21:15:23 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table attutilisateurs
# ------------------------------------------------------------

DROP TABLE IF EXISTS `attutilisateurs`;

CREATE TABLE `attutilisateurs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`,`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table demandes
# ------------------------------------------------------------

DROP TABLE IF EXISTS `demandes`;

CREATE TABLE `demandes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinytext NOT NULL,
  `sujet` tinytext NOT NULL,
  `contenu` text NOT NULL,
  `date` date NOT NULL,
  `etat` tinytext NOT NULL,
  `positif` int(11) NOT NULL,
  `negatif` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `demandes` WRITE;
/*!40000 ALTER TABLE `demandes` DISABLE KEYS */;

INSERT INTO `demandes` (`id`, `type`, `sujet`, `contenu`, `date`, `etat`, `positif`, `negatif`)
VALUES
	(1,'Travaux','salle de bain','dÃ©truire la douche existante pour en faire une nouvelle.','2014-12-15','non lu',0,0),
	(2,'rÃ©clamation','espace pour chiens','besoin de crÃ©ation d\'un espace pour que les animaux fassent leurs besoins','2014-12-16','non lu',0,0);

/*!40000 ALTER TABLE `demandes` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table evenements
# ------------------------------------------------------------

DROP TABLE IF EXISTS `evenements`;

CREATE TABLE `evenements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) NOT NULL,
  `dateD` date NOT NULL,
  `dateF` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`,`titre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table utilisateurs
# ------------------------------------------------------------

DROP TABLE IF EXISTS `utilisateurs`;

CREATE TABLE `utilisateurs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`,`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `utilisateurs` WRITE;
/*!40000 ALTER TABLE `utilisateurs` DISABLE KEYS */;

INSERT INTO `utilisateurs` (`id`, `mail`, `nom`, `prenom`, `type`, `mdp`, `date`)
VALUES
	(1,'cboudier91@gmail.com','Boudier','Christopher','admin','lotus91600','2015-03-21'),
	(2,'carelleoko@gmail.com','OKO','helena carelle','admin','M2Mez938','2015-03-29');

/*!40000 ALTER TABLE `utilisateurs` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
