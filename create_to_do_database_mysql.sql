-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema todolist
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema todolist
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `todolistdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `todolistdb` ;

-- -----------------------------------------------------
-- Table `todolist`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `todolist`.`user` ;

CREATE TABLE IF NOT EXISTS `todolist`.`user` (
  `username` CHAR(255) NOT NULL,
  `password` CHAR(255) NULL,
  `adress` CHAR(10) NULL,
  `lastname` CHAR(200) NULL,
  `firstname` CHAR(200) NULL,
  `e-mail` CHAR(255) NULL,
  `passwordquestion` LONGTEXT NULL,
  `passwordanswer` LONGTEXT NULL,
  `fixnetwork` CHAR(200) NULL,
  `mobilnetwork` CHAR(200) NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `todolist`.`todolist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `todolist`.`todolist` ;

CREATE TABLE IF NOT EXISTS `todolist`.`todolist` (
  `todolistnr` INT NOT NULL AUTO_INCREMENT,
  `todolist` LONGTEXT NULL,
  `visible` TINYINT(1) NULL,
  `fk_user_username` CHAR(255) NULL,
  PRIMARY KEY (`todolistnr`),
  INDEX `fk_user_username_idx` (`fk_user_username` ASC),
  CONSTRAINT `fk_user_username`
    FOREIGN KEY (`fk_user_username`)
    REFERENCES `todolist`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `todolist`.`todo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `todolist`.`todo` ;

CREATE TABLE IF NOT EXISTS `todolist`.`todo` (
  `todonrabsolut` INT NOT NULL AUTO_INCREMENT,
  `todo` LONGTEXT NULL,
  `todocontent` LONGTEXT NULL,
  `status` CHAR(15) NULL,
  `priority` CHAR(15) NULL,
  `creationdate` DATE NULL,
  `lastmodifieddate` DATE NULL,
  `startdate` DATE NULL,
  `enddate` DATE NULL,
  `reminddate` DATE NULL,
  `reminderon` TINYINT(1) NULL,
  `todolistnr` INT(11) NULL,
  PRIMARY KEY (`todonrabsolut`),
  INDEX `todolist_todolistnr_idx` (`todolistnr` ASC),
  CONSTRAINT `todolist_todolistnr`
    FOREIGN KEY (`todolistnr`)
    REFERENCES `todolist`.`todolist` (`todolistnr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `todolist`.`documenttodolist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `todolist`.`documenttodolist` ;

CREATE TABLE IF NOT EXISTS `todolist`.`documenttodolist` (
  `documentnrabsolut` INT NOT NULL AUTO_INCREMENT,
  `uploaddate` DATE NULL,
  `comment` LONGTEXT NULL,
  `documentname` CHAR(255) NULL,
  `filedata` LONGBLOB NULL,
  `sizeoffile` INT(11) NULL,
  `fileextension` CHAR(5) NULL,
  `todolistnr` INT(11) NULL,
  PRIMARY KEY (`documentnrabsolut`),
  INDEX `fk_todolist_username_todolistnr_idx` (`todolistnr` ASC),
  CONSTRAINT `fk_todolist_username_todolistnr2`
    FOREIGN KEY (`todolistnr`)
    REFERENCES `todolist`.`todolist` (`todolistnr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `todolist`.`user_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `todolist`.`user_group` ;

CREATE TABLE IF NOT EXISTS `todolist`.`user_group` (
  `groupname` CHAR(255) NOT NULL,
  `username` CHAR(255) NOT NULL,
  PRIMARY KEY (`groupname`, `username`),
  INDEX `fk_user_username_idx` (`username` ASC),
  CONSTRAINT `fk_user_username2`
    FOREIGN KEY (`username`)
    REFERENCES `todolist`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `todolist`.`documenttodo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `todolist`.`documenttodo` ;

CREATE TABLE IF NOT EXISTS `todolist`.`documenttodo` (
  `documentnrabsolut` INT NOT NULL AUTO_INCREMENT,
  `uploaddate` DATE NULL,
  `comment` LONGTEXT NULL,
  `documentname` CHAR(255) NULL,
  `filedata` LONGBLOB NULL,
  `sizeoffile` INT(11) NULL,
  `fileextension` CHAR(5) NULL,
  `todonrabsolut` INT(11) NULL,
  PRIMARY KEY (`documentnrabsolut`),
  INDEX `fk_todo_todonr_idx` (`todonrabsolut` ASC),
  CONSTRAINT `fk_todo_todonr`
    FOREIGN KEY (`todonrabsolut`)
    REFERENCES `todolist`.`todo` (`todonrabsolut`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
