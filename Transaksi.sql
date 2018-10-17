/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.0.27-community-nt-log : Database - transaksi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`transaksi` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `transaksi`;

/*Table structure for table `laptop` */

DROP TABLE IF EXISTS `laptop`;

CREATE TABLE `laptop` (
  `Kode_Laptop` varchar(50) NOT NULL,
  `Merek` varchar(50) default NULL,
  PRIMARY KEY  (`Kode_Laptop`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `laptop` */

/*Table structure for table `pembeli` */

DROP TABLE IF EXISTS `pembeli`;

CREATE TABLE `pembeli` (
  `ID_Pembeli` char(8) NOT NULL,
  `Nama_Pembeli` varchar(50) default NULL,
  PRIMARY KEY  (`ID_Pembeli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pembeli` */

/*Table structure for table `penjual` */

DROP TABLE IF EXISTS `penjual`;

CREATE TABLE `penjual` (
  `ID_Penjual` char(8) NOT NULL,
  `Nama_Penjual` varchar(50) default NULL,
  PRIMARY KEY  (`ID_Penjual`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `penjual` */

/*Table structure for table `transaksi` */

DROP TABLE IF EXISTS `transaksi`;

CREATE TABLE `transaksi` (
  `Kode_Transaksi` char(8) NOT NULL,
  `ID_Penjual` char(8) default NULL,
  `ID_Pembeli` char(8) default NULL,
  `Kode_Laptop` varchar(50) default NULL,
  `Harga` int(11) default NULL,
  `Tanggal_Transaksi` date default NULL,
  `Stok` int(11) default NULL,
  PRIMARY KEY  (`Kode_Transaksi`),
  KEY `penjual` (`ID_Penjual`),
  KEY `pembeli` (`ID_Pembeli`),
  KEY `laptop` (`Kode_Laptop`),
  CONSTRAINT `laptop` FOREIGN KEY (`Kode_Laptop`) REFERENCES `laptop` (`Kode_Laptop`),
  CONSTRAINT `pembeli` FOREIGN KEY (`ID_Pembeli`) REFERENCES `pembeli` (`ID_Pembeli`),
  CONSTRAINT `penjual` FOREIGN KEY (`ID_Penjual`) REFERENCES `penjual` (`ID_Penjual`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `transaksi` */

/* Procedure structure for procedure `HapusTransaksi` */

/*!50003 DROP PROCEDURE IF EXISTS  `HapusTransaksi` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `HapusTransaksi`()
BEGIN
Delete from pembeli WHERE ID_Pembeli = id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `SimpanTransaksi` */

/*!50003 DROP PROCEDURE IF EXISTS  `SimpanTransaksi` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `SimpanTransaksi`()
BEGIN
insert into pembeli values(id, nama);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `TampilTransaksi` */

/*!50003 DROP PROCEDURE IF EXISTS  `TampilTransaksi` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `TampilTransaksi`()
BEGIN
SELECT * FROM pembeli;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `UbahTransaksi` */

/*!50003 DROP PROCEDURE IF EXISTS  `UbahTransaksi` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `UbahTransaksi`()
BEGIN
update pembeli set Nama_Pembeli = nama where ID_Pembeli = id;
    END */$$
DELIMITER ;

/*Table structure for table `vtransaksi` */

DROP TABLE IF EXISTS `vtransaksi`;

/*!50001 DROP VIEW IF EXISTS `vtransaksi` */;
/*!50001 DROP TABLE IF EXISTS `vtransaksi` */;

/*!50001 CREATE TABLE  `vtransaksi`(
 `Kode_Transaksi` char(8) ,
 `ID_Penjual` char(8) ,
 `Nama_Penjual` varchar(50) ,
 `ID_Pembeli` char(8) ,
 `Nama_Pembeli` varchar(50) ,
 `Kode_Laptop` varchar(50) ,
 `Merek` varchar(50) ,
 `Harga` int(11) ,
 `Tanggal_Transaksi` date ,
 `Stok` int(11) 
)*/;

/*View structure for view vtransaksi */

/*!50001 DROP TABLE IF EXISTS `vtransaksi` */;
/*!50001 DROP VIEW IF EXISTS `vtransaksi` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vtransaksi` AS (select `transaksi`.`Kode_Transaksi` AS `Kode_Transaksi`,`transaksi`.`ID_Penjual` AS `ID_Penjual`,`penjual`.`Nama_Penjual` AS `Nama_Penjual`,`transaksi`.`ID_Pembeli` AS `ID_Pembeli`,`pembeli`.`Nama_Pembeli` AS `Nama_Pembeli`,`transaksi`.`Kode_Laptop` AS `Kode_Laptop`,`laptop`.`Merek` AS `Merek`,`transaksi`.`Harga` AS `Harga`,`transaksi`.`Tanggal_Transaksi` AS `Tanggal_Transaksi`,`transaksi`.`Stok` AS `Stok` from (((`transaksi` join `pembeli` on((`transaksi`.`ID_Pembeli` = `pembeli`.`ID_Pembeli`))) join `penjual` on((`transaksi`.`ID_Penjual` = `penjual`.`ID_Penjual`))) join `laptop` on((`transaksi`.`Kode_Laptop` = `laptop`.`Kode_Laptop`)))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
