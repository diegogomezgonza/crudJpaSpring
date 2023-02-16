-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: tareas
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nif` char(9) DEFAULT NULL,
  `ROL` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nif` (`nif`),
  CONSTRAINT `roles_ibfk_1` FOREIGN KEY (`nif`) REFERENCES `usuario` (`NIF`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'11111111A','USUARIO'),(2,'22222222A','USUARIO'),(3,'33333333A','USUARIO'),(4,'33333333A','ADMINISTRADOR'),(5,'31321','USUARIO');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarea`
--

DROP TABLE IF EXISTS `tarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarea` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(200) DEFAULT NULL,
  `DESCRIPCION` varchar(1000) DEFAULT NULL,
  `ESTADO` tinyint DEFAULT NULL,
  `NIF` char(9) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `NIF` (`NIF`),
  CONSTRAINT `tarea_ibfk_1` FOREIGN KEY (`NIF`) REFERENCES `usuario` (`NIF`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarea`
--

LOCK TABLES `tarea` WRITE;
/*!40000 ALTER TABLE `tarea` DISABLE KEYS */;
INSERT INTO `tarea` VALUES (1,'Realizar aplicación Spring Boot','Aplicación de gestión de tareas',1,'11111111A'),(2,'Comprar ordenador','Pedir presupuestos y comprar',2,'22222222A'),(3,'Cambiar teclados','Investigar',3,'33333333A');
/*!40000 ALTER TABLE `tarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `NIF` char(9) NOT NULL,
  `NOMBRE` varchar(30) DEFAULT NULL,
  `APELLIDOS` varchar(50) DEFAULT NULL,
  `PW` varchar(200) DEFAULT NULL,
  `ACTIVO` tinyint DEFAULT NULL,
  PRIMARY KEY (`NIF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('11111111A','Diego','Gomez','$2a$10$Fd1JudBtqz9moqDxhxLoEOSiSZYqJ5vk.7.08i15oup1wFjClVgsW',1),('22222222A','Joselito','ROBLES DURAN','$2a$10$Fd1JudBtqz9moqDxhxLoEOSiSZYqJ5vk.7.08i15oup1wFjClVgsW',1),('31321','r','r','$2a$10$4xmZ0d7chKWatIuswwmrD.2Kcx1jg/qPW8VkXFA06s95O8WF/0KJa',1),('33333333A','ROSA','PEREZ DELGADO','$2a$10$Fd1JudBtqz9moqDxhxLoEOSiSZYqJ5vk.7.08i15oup1wFjClVgsW',1),('55555555','Harry','Potter','$2a$10$Fd1JudBtqz9moqDxhxLoEOSiSZYqJ5vk.7.08i15oup1wFjClVgsW',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-14 14:38:15
