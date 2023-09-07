CREATE TABLE IF NOT EXISTS`register1` (
  `account` varchar(20) NOT NULL,
  `pwd` varchar(45) NOT NULL,
  `age` int NOT NULL,
  `city` varchar(20) DEFAULT NULL,
  `reg_time` datetime NOT NULL,
  `active` tinyint DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
