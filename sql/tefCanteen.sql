-- -------------------------------------------------------------
-- TablePlus 3.12.2(358)
--
-- https://tableplus.com/
--
-- Database: tefCanteen
-- Generation Time: 2021-10-31 12:58:03.0320
-- -------------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


CREATE TABLE `food` (
  `id` int NOT NULL AUTO_INCREMENT,
  `food_name` varchar(45) DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `price` decimal(20,2) DEFAULT NULL,
  `available` bit(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `transaction` (
  `id` int NOT NULL AUTO_INCREMENT,
  `food_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `total_price` decimal(2,0) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `group_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `goup_id_UNIQUE` (`group_id`),
  KEY `food_id` (`food_id`),
  CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`food_id`) REFERENCES `food` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `surn_name` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `isAdmin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

INSERT INTO `food` (`id`, `food_name`, `unit`, `price`, `available`) VALUES
('1', 'Jollof Rice', 'Plate', '500.00', b'01'),
('2', 'Beams', 'Plate', '200.00', b'01'),
('3', 'Goat Meat', 'Portion', '200.00', b'01');

INSERT INTO `user` (`id`, `first_name`, `surn_name`, `phone_number`, `user_name`, `password`, `isAdmin`) VALUES
('1', 'Timothy', 'Zinwota', '08127820880', 'timtim', 'timtim', '1');



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;