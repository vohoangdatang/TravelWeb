-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: datvexe
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `chuyenxe`
--

DROP TABLE IF EXISTS `chuyenxe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chuyenxe` (
  `idCX` int NOT NULL AUTO_INCREMENT,
  `tenCX` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `mota` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `hinhanh` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `ngaydi` date NOT NULL,
  `diemdi` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `diemden` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `giaghe` decimal(10,0) NOT NULL,
  `soluong` int NOT NULL,
  `idTX` int DEFAULT NULL,
  PRIMARY KEY (`idCX`),
  KEY `fk_cx_tx_idx` (`idTX`),
  CONSTRAINT `fk_cx_user` FOREIGN KEY (`idTX`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chuyenxe`
--

LOCK TABLES `chuyenxe` WRITE;
/*!40000 ALTER TABLE `chuyenxe` DISABLE KEYS */;
INSERT INTO `chuyenxe` VALUES (1,'14C32323','dadadfd','https://tintucxeco.net/wp-content/uploads/2019/05/xe-khach-thai-minh.jpg','2022-01-18','Đà Lạt','Đà Lạt',400000,18,16),(7,'59C1-14722','hhhhh','https://dixere.vn/wp-content/uploads/2019/08/xe-khach-mai-linh-176700_result.jpg','2022-01-10','Hồ Chí Minh','Đà Lạt',300000,15,16),(8,'47c44444','abc','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQElwPRYI0QfHc6V4fCBL6dWlZ13w1XaityewYBmI2Zl-DAhsZXIj5jhiRlsfz2XGxj2G8&usqp=CAU','2022-11-11','Hồ Chí Minh','Nha Trang',300000,8,16),(9,'51C12345','ewqe','https://kenhhomestay.com/wp-content/uploads/2019/12/xe-khach-sai-gon-soc-trang-5.jpg','2022-11-11','Hồ Chí Minh','Đà Lạt',300000,0,19),(11,'51C123333','adada','https://kenhhomestay.com/wp-content/uploads/2019/11/xe-khach-ca-mau-5.jpg','2022-11-18','Hồ Chí Minh','Đà Nẵng',400000,20,16);
/*!40000 ALTER TABLE `chuyenxe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctdonphong`
--

DROP TABLE IF EXISTS `ctdonphong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ctdonphong` (
  `id` int NOT NULL AUTO_INCREMENT,
  `iddonphong` int NOT NULL,
  `idphong` int NOT NULL,
  `soluong` int NOT NULL,
  `gia` double NOT NULL,
  `tinhtrang` binary(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ct_donphong_idx` (`iddonphong`),
  KEY `fk_ct_phong_idx` (`idphong`),
  CONSTRAINT `fk_ct_dp` FOREIGN KEY (`iddonphong`) REFERENCES `donphong` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ct_p` FOREIGN KEY (`idphong`) REFERENCES `phong` (`idPhong`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctdonphong`
--

LOCK TABLES `ctdonphong` WRITE;
/*!40000 ALTER TABLE `ctdonphong` DISABLE KEYS */;
INSERT INTO `ctdonphong` VALUES (19,51,16,1,1000001,_binary '1');
/*!40000 ALTER TABLE `ctdonphong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctdontour`
--

DROP TABLE IF EXISTS `ctdontour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ctdontour` (
  `id` int NOT NULL AUTO_INCREMENT,
  `iddontour` int NOT NULL,
  `idtour` int DEFAULT NULL,
  `soluong` int NOT NULL,
  `gia` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ctdontour_dontour_idx` (`iddontour`),
  KEY `fk_ctdt_idchuyenxe_idx` (`idtour`),
  CONSTRAINT `fk_ctdontour_dontour` FOREIGN KEY (`iddontour`) REFERENCES `dontour` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctdontour`
--

LOCK TABLES `ctdontour` WRITE;
/*!40000 ALTER TABLE `ctdontour` DISABLE KEYS */;
INSERT INTO `ctdontour` VALUES (19,27,1,1,300000),(64,72,NULL,2,300000);
/*!40000 ALTER TABLE `ctdontour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhgia`
--

DROP TABLE IF EXISTS `danhgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danhgia` (
  `id` int NOT NULL AUTO_INCREMENT,
  `noidung` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `idCX` int DEFAULT NULL,
  `idU` int DEFAULT NULL,
  `sao` int NOT NULL,
  `ngaytao` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_dg_idx` (`idU`),
  KEY `fk_cx_dg_idx` (`idCX`),
  CONSTRAINT `fk_cx_dg` FOREIGN KEY (`idCX`) REFERENCES `chuyenxe` (`idCX`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `fk_user_dg` FOREIGN KEY (`idU`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhgia`
--

LOCK TABLES `danhgia` WRITE;
/*!40000 ALTER TABLE `danhgia` DISABLE KEYS */;
INSERT INTO `danhgia` VALUES (1,'xe chat luong',1,NULL,5,'2022-11-08');
/*!40000 ALTER TABLE `danhgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donphong`
--

DROP TABLE IF EXISTS `donphong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donphong` (
  `id` int NOT NULL AUTO_INCREMENT,
  `iduser` int DEFAULT NULL,
  `ngaytao` date NOT NULL,
  `hoten` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sdt` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ngaynhan` date DEFAULT NULL,
  `ngaytra` date DEFAULT NULL,
  `tongtien` decimal(10,0) DEFAULT NULL,
  `phuongthuc` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `tinhtrang` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_donphong_user_idx` (`iduser`),
  CONSTRAINT `fk_donphong_user` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donphong`
--

LOCK TABLES `donphong` WRITE;
/*!40000 ALTER TABLE `donphong` DISABLE KEYS */;
INSERT INTO `donphong` VALUES (51,NULL,'2022-11-18','nguyen pham quoc khanh','quockhanh@gmail.com','0941165623','2022-11-18','2022-11-20',2000002,'offline','chưa thanh toán'),(55,20,'2022-11-23','nguyen pham quoc khanh','quockhanh@gmail.com','0941193166','2022-11-25','2022-11-30',2500000,'paypal','đã thanh toán');
/*!40000 ALTER TABLE `donphong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dontour`
--

DROP TABLE IF EXISTS `dontour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dontour` (
  `id` int NOT NULL AUTO_INCREMENT,
  `iduser` int DEFAULT NULL,
  `hoten` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `sdt` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `tongtien` decimal(10,0) NOT NULL,
  `phuongthuc` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `tinhtrang` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `ngaytao` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dontour_user_idx` (`iduser`),
  CONSTRAINT `fk_dontour_user` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dontour`
--

LOCK TABLES `dontour` WRITE;
/*!40000 ALTER TABLE `dontour` DISABLE KEYS */;
INSERT INTO `dontour` VALUES (26,NULL,'nguyen pham quoc khanh','quockhanh@gmail.com','0941193169',300000,'paypal','đã thanh toán','2022-11-12'),(27,NULL,'nguyen pham quoc khanh','quockhanh@gmail.com','0941193169',300000,'paypal','đã thanh toán','2022-11-12'),(72,16,'taixe1','taixe1@gmail.com','0941193166',600000,'offline','chưa thanh toán','2022-11-26');
/*!40000 ALTER TABLE `dontour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachsan`
--

DROP TABLE IF EXISTS `khachsan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachsan` (
  `idkhachsan` int NOT NULL AUTO_INCREMENT,
  `tenKS` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `diachi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `hinhanh` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `thanhPho` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`idkhachsan`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachsan`
--

LOCK TABLES `khachsan` WRITE;
/*!40000 ALTER TABLE `khachsan` DISABLE KEYS */;
INSERT INTO `khachsan` VALUES (1,'Sammy Đà Lạt Hotel','01 Lê Hồng Phong','https://ik.imagekit.io/tvlk/apr-asset/dgXfoyh24ryQLRcGq00cIdKHRmotrWLNlvG-TxlcLxGkiDwaUSggleJNPRgIHCX6/hotel/asset/10019967-b5d421db7e4736d3a7d390a50f854215.jpeg?tr=q-40,w-740,h-465&_src=imagekit','Đà Lạt'),(2,'Swiss-Belresort Tuyền Lâm Đà Lạt','Phân khu chức năng 7&8, Khu du lịch hồ Tuyền Lâm','https://ik.imagekit.io/tvlk/apr-asset/dgXfoyh24ryQLRcGq00cIdKHRmotrWLNlvG-TxlcLxGkiDwaUSggleJNPRgIHCX6/hotel/asset/10022273-fc65adc1b701af38ee5a18f8c8f19ca3.jpeg?tr=q-40,w-740,h-465&_src=imagekit','Đà Lạt'),(3,'SAM Tuyền Lâm Resort','Khu 7 & 8, Hồ Tuyền Lâm','https://ik.imagekit.io/tvlk/apr-asset/dgXfoyh24ryQLRcGq00cIdKHRmotrWLNlvG-TxlcLxGkiDwaUSggleJNPRgIHCX6/hotel/asset/10021356-32083ec7c5b54dd0c7bb635ac72b7380.jpeg?tr=q-40,w-740,h-465&_src=imagekit','Đà Lạt'),(4,'Eco Villa Dalat','37 Trạng Trình','https://luhanhvietnam.com.vn/tour-du-lich/vnt_upload/tour/04_2021/khach-san-phadin-dien-bien.jpg','Đà Lạt'),(6,'Le Pavillon Hoi An Paradise Hotel & Spa','508 Hai Bà Trưng','https://bloghoian.com/wp-content/uploads/2017/06/2.jpg','Đà Nẵng'),(7,'Vinpearl Resort & Spa Hoi An','đường Cửa Đại','https://bloghoian.com/wp-content/uploads/2017/06/2-1.jpg','Đà Nẵng'),(8,'Hội An Central Boutique Hotel and Spa','91 Hùng Vương','https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2018/03/1-khachsan-hoian-royal-vntrip-e1520503214788.jpg','Đà Nẵng'),(9,'Thanh Bình Riverside','05 Nguyễn Du, Cẩm Phô','https://cf.bstatic.com/xdata/images/hotel/270x200/203518510.jpg?k=d49a67b0a6ee8348d803b27d76ab227e4c4270ef87b62749e6357c316be30512&o=','Đà Nẵng'),(10,'Sunrise Premium Resort Hội An','Đường Âu Cơ','https://bloghoian.com/wp-content/uploads/2017/06/1-1.jpg','Đà Nẵng'),(11,'Cherry Hotel And Apartment','212B/D37 Nguyễn Trãi','https://ik.imagekit.io/tvlk/apr-asset/Ixf4aptF5N2Qdfmh4fGGYhTN274kJXuNMkUAzpL5HuD9jzSxIGG5kZNhhHY-p7nw/hotel/asset/67794229-80a1e7965533ae380489e7dc5979bfea.jpeg?tr=q-40,w-740,h-465&_src=imagekit','Hồ Chí Minh'),(12,'Cozrum Homes Ambera House','740/15a - 17 Sư Vạn Hạnh','https://ik.imagekit.io/tvlk/apr-asset/Ixf4aptF5N2Qdfmh4fGGYhTN274kJXuNMkUAzpL5HuD9jzSxIGG5kZNhhHY-p7nw/hotel/asset/67793450-a4de48b3af482fb7da70e0d3a57cf8d1.jpeg?tr=q-40,w-740,h-465&_src=imagekit','Hồ Chí Minh'),(13,'Sunshine Antique Hotel Saigon','549 Tran Hung Dao Street, Cau Kho Ward, District 1','https://ik.imagekit.io/tvlk/apr-asset/Ixf4aptF5N2Qdfmh4fGGYhTN274kJXuNMkUAzpL5HuD9jzSxIGG5kZNhhHY-p7nw/hotel/asset/67792711-3765f3f97824086bc068e3b748e0c99b.jpeg?tr=q-40,w-740,h-465&_src=imagekit','Hồ Chí Minh');
/*!40000 ALTER TABLE `khachsan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaiphong`
--

DROP TABLE IF EXISTS `loaiphong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaiphong` (
  `idloaiphong` int NOT NULL AUTO_INCREMENT,
  `tenLoaiPhong` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `hinhanh` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idloaiphong`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaiphong`
--

LOCK TABLES `loaiphong` WRITE;
/*!40000 ALTER TABLE `loaiphong` DISABLE KEYS */;
INSERT INTO `loaiphong` VALUES (1,'1 giường đôi','https://ik.imagekit.io/tvlk/apr-asset/Ixf4aptF5N2Qdfmh4fGGYhTN274kJXuNMkUAzpL5HuD9jzSxIGG5kZNhhHY-p7nw/hotel/asset/67793966-d0ed0ae3b95add790cf44675d042205f.jpeg?tr=q-40,w-740,h-465&_src=imagekit'),(2,'2 giường đơn','https://ik.imagekit.io/tvlk/apr-asset/Ixf4aptF5N2Qdfmh4fGGYhTN274kJXuNMkUAzpL5HuD9jzSxIGG5kZNhhHY-p7nw/hotel/asset/67793966-b75de37236c92364bd31cacd75d8c61a.jpeg?tr=q-40,w-740,h-465&_src=imagekit'),(3,'1 giuong don 1 giuong doi','https://ik.imagekit.io/tvlk/apr-asset/Ixf4aptF5N2Qdfmh4fGGYhTN274kJXuNMkUAzpL5HuD9jzSxIGG5kZNhhHY-p7nw/hotel/asset/67793966-5c4021a19cacfd96992db0e3bd5a19b0.jpeg?tr=q-40,w-740,h-465&_src=imagekit'),(6,'1 giuong don','https://chumy.vn/wp-content/uploads/2019/12/giuong-khach-san-single-size.jpg');
/*!40000 ALTER TABLE `loaiphong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phong`
--

DROP TABLE IF EXISTS `phong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phong` (
  `idPhong` int NOT NULL AUTO_INCREMENT,
  `tenPhong` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `giaPhong` decimal(10,0) NOT NULL,
  `tinhTrang` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `idLoaiPhong` int DEFAULT NULL,
  `idKhachSan` int DEFAULT NULL,
  PRIMARY KEY (`idPhong`),
  KEY `fk_phong_khachsan_idx` (`idKhachSan`),
  KEY `fk_phong_loaiphong_idx` (`idLoaiPhong`),
  CONSTRAINT `fk_phong_khachsan` FOREIGN KEY (`idKhachSan`) REFERENCES `khachsan` (`idkhachsan`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_phong_loaiphong` FOREIGN KEY (`idLoaiPhong`) REFERENCES `loaiphong` (`idloaiphong`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phong`
--

LOCK TABLES `phong` WRITE;
/*!40000 ALTER TABLE `phong` DISABLE KEYS */;
INSERT INTO `phong` VALUES (1,'phong 1',500000,'1',1,2),(2,'phong 2',1000000,'1',2,2),(3,'phong 3',2000000,'1',3,2),(4,'phong 1',500000,'1',1,3),(5,'phong 2',1000000,'1',2,3),(6,'phong 3',2000000,'1',3,3),(7,'phong 1',500000,'1',1,4),(8,'phong 2',1000000,'1',2,4),(9,'phong 3',2000000,'1',3,4),(11,'phong 1',500000,'0',1,1),(15,'phong 4',1000000,'0',3,1),(16,'phong 4',1000001,'0',2,1),(18,'phong 404',125000,'1',6,1),(19,'phong 10',500000,'1',2,9);
/*!40000 ALTER TABLE `phong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thanhpho`
--

DROP TABLE IF EXISTS `thanhpho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thanhpho` (
  `idthanhpho` int NOT NULL AUTO_INCREMENT,
  `tentp` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idthanhpho`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thanhpho`
--

LOCK TABLES `thanhpho` WRITE;
/*!40000 ALTER TABLE `thanhpho` DISABLE KEYS */;
INSERT INTO `thanhpho` VALUES (1,'Đà Lạt'),(2,'Đà Nẵng'),(3,'Hồ Chí Minh'),(4,'Nha Trang'),(5,'Hà Nội'),(6,'Củ Chi'),(7,'Sapa');
/*!40000 ALTER TABLE `thanhpho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour`
--

DROP TABLE IF EXISTS `tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour` (
  `idtour` int NOT NULL AUTO_INCREMENT,
  `nametour` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `place` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `start` date NOT NULL,
  `finish` date NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `quantity` int DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phuongtien` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idtour`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour`
--

LOCK TABLES `tour` WRITE;
/*!40000 ALTER TABLE `tour` DISABLE KEYS */;
INSERT INTO `tour` VALUES (1,'Vũng Tàu - Hồ Chí Minh','Vũng Tàu','Vũng Tàu - Hồ Chí Minh','2022-11-01','2022-12-02',300000,50,'https://luhanhvietnam.com.vn/tour-du-lich/vnt_upload/tour/03_2021/thumbs/380_crop_bai_nhat3.jpg','Máy Bay'),(2,'Hà Nội -  Đà Nẵng',' Đà Nẵng','Hà Nội -  Đà Nẵng','2022-11-01','2022-11-02',300000,50,'https://luhanhvietnam.com.vn/tour-du-lich/vnt_upload/tour/02_2020/thumbs/380_crop_du-lich-da-nang-tour.jpg','Máy Bay'),(5,'Hồ Chí Minh - Đà Nẵng','Đà Nẵng','Hồ Chí Minh - Đà Nẵng','2022-11-01','2022-11-02',300000,50,'https://luhanhvietnam.com.vn/tour-du-lich/vnt_upload/tour/02_2020/thumbs/380_crop_cau-tinh-yen-2.jpg','Máy Bay'),(6,'SaPa - Hồ Chí Minh','SaPa ','SaPa - Hồ Chí Minh','2022-11-01','2022-12-02',300000,50,'https://luhanhvietnam.com.vn/tour-du-lich/vnt_upload/tour/04_2021/thumbs/380_crop_swing-sapa-2.jpg','Máy Bay'),(7,'Vũng Tàu -  Hà Nội','Vũng Tàu','Vũng Tàu -  Hà Nội','2022-11-01','2022-12-02',300000,50,'https://luhanhvietnam.com.vn/tour-du-lich/vnt_upload/File/Image/hoi_an_ve_dem.jpg','Máy Bay'),(8,'Cần Thơ - Hà Nội','Cần Thơ ','Cần Thơ - Hà Nội','2022-11-01','2022-12-02',300000,50,'https://luhanhvietnam.com.vn/tour-du-lich/vnt_upload/tour/09_2020/cho-noi-cai-rang-can-tho.jpg','Máy Bay'),(9,'Cần Thơ -  Hồ Chí Minh','Cần Thơ ','Cần Thơ -  Hồ Chí Minh','2022-11-01','2022-12-02',300000,50,'https://luhanhvietnam.com.vn/tour-du-lich/vnt_upload/tour/02_2020/thumbs/780_crop_can_tho.jpg','Máy Bay');
/*!40000 ALTER TABLE `tour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userRole` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `hoten` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sdt` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ngaysinh` date DEFAULT NULL,
  `hinhanh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (16,'taixe1','$2a$10$qbIRvL7FouSfqfFil0ZrlOjul7Ay95Ws9SI9YPrALR36Ekg3oBO.q','ROLE_TX','taixe1','0941193166','taixe1@gmail.com','2000-01-14','https://res.cloudinary.com/ttfon1432/image/upload/v1632296774/zniysinxqefnaenrv8cb.png'),(19,'admin','$2a$10$qbIRvL7FouSfqfFil0ZrlOjul7Ay95Ws9SI9YPrALR36Ekg3oBO.q','ROLE_ADMIN','nguyen pham quoc khanh','0941193169','quockhanh@gmail.com','1999-09-02',NULL),(20,'nhanvien1','$2a$10$qbIRvL7FouSfqfFil0ZrlOjul7Ay95Ws9SI9YPrALR36Ekg3oBO.q','ROLE_NV','nhanvien1','0941193166','nhanvien1@gmail.com','2000-01-14','https://i1.wp.com/rookiepencil.xyz/wp-content/uploads/2021/04/demon-slayer-kimetsu-no-yaiba-movie-mugen-train-kyojuro-rengoku-1241212-1280x0-1.jpeg?resize=1140%2C641&ssl=1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-26 12:50:12
