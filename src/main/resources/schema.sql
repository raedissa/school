CREATE TABLE IF NOT EXISTS `school`.`app_user` (
  `uuid` char(36) NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL,
  `version` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `user_name` varchar(36) NOT NULL,
  `password` varchar(128) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;


CREATE TABLE IF NOT EXISTS `school`.`document` (
  `uuid` char(36) NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL,
  `version` int(11) NOT NULL,
  `name` char(64) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;


CREATE TABLE IF NOT EXISTS `school`.`ip_country` (
  `ip_from` bigint(20) NOT NULL,
  `ip_to` bigint(20) NOT NULL,
  `registry` varchar(12) NOT NULL,
  `assigned` bigint(20) NOT NULL,
  `iso` varchar(4) NOT NULL,
  `un` varchar(4) NOT NULL,
  `country` varchar(64) NOT NULL,
  `german_name` varchar(64) DEFAULT NULL,
  `continent` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`ip_from`),
  UNIQUE KEY `ip_from_UNIQUE` (`ip_from`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS `school`.`search_verify` (
  `uuid` char(36) NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL,
  `version` int(11) NOT NULL,
  `verify_id` char(5) NOT NULL,
  `ip` bigint(20) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `country` varchar(64) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;


CREATE TABLE IF NOT EXISTS `school`.`student` (
  `uuid` char(36) NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL,
  `version` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `first_name` char(64) NOT NULL,
  `last_name` char(64) NOT NULL,
  `birth_date` char(64) NOT NULL,
  `telephone_number` char(64) NOT NULL,
  `email` char(64) NOT NULL,
  `address` char(128) NOT NULL,
  `nationality` char(64) NOT NULL,
  `note` text,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;


CREATE TABLE IF NOT EXISTS `school`.`document_verify` (
  `uuid` char(36) NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL,
  `version` int(11) NOT NULL,
  `student_id` char(36) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `price1` int(11) DEFAULT NULL,
  `price2` int(11) DEFAULT NULL,
  `document_id` char(36) NOT NULL,
  `total_result` int(11) DEFAULT NULL,
  `level` char(36) DEFAULT NULL,
  `deleted` datetime DEFAULT NULL,
  `verify_id` char(5) NOT NULL,
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `verify` (`verify_id`),
  KEY `document_verify_student_id_FK` (`student_id`),
  KEY `document_verify_document_id_FK_idx` (`document_id`),
  CONSTRAINT `document_verify_document_id_FK` FOREIGN KEY (`document_id`) REFERENCES `document` (`uuid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `document_verify_student_id_FK` FOREIGN KEY (`student_id`) REFERENCES `student` (`uuid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;


CREATE TABLE IF NOT EXISTS `school`.`user_role` (
  `uuid` char(36) NOT NULL,
  `user_id` char(36) NOT NULL,
  `version` int(11) NOT NULL DEFAULT '1',
  `created_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL,
  `user_role` varchar(45) NOT NULL,
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `uuid_user_role_UNIQUE` (`uuid`),
  KEY `user_role_user_id_FK_idx` (`user_id`),
  KEY `user_idx` (`user_id`),
  CONSTRAINT `user_role_user_id_FK` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`uuid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;

