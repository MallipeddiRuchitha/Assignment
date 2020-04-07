-- MySQL Workbench Forward Engineering


SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dbms_demo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbms_demo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbms_demo` DEFAULT CHARACTER SET latin1 ;
USE `dbms_demo` ;

-- -----------------------------------------------------
-- Table `dbms_demo`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbms_demo`.`course` (
  `course_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `provider` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`course_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `dbms_demo`.`course_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbms_demo`.`course_details` (
  `duration` INT(11) NOT NULL,
  `fee` INT(11) NOT NULL,
  `description` VARCHAR(250) NOT NULL,
  `course_id` INT(11) NOT NULL,
  PRIMARY KEY (`course_id`),
  CONSTRAINT `fk_course_details_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `dbms_demo`.`course` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `dbms_demo`.`teacher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbms_demo`.`teacher` (
  `teacher_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`teacher_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `dbms_demo`.`teacher_course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbms_demo`.`teacher_course` (
  `course_id` INT(11) NOT NULL,
  `teacher_id` INT(11) NOT NULL,
  PRIMARY KEY (`course_id`, `teacher_id`),
  
  CONSTRAINT `teacher_course_ibfk_1`
    FOREIGN KEY (`course_id`)
    REFERENCES `dbms_demo`.`course` (`course_id`),
  CONSTRAINT `teacher_course_ibfk_2`
    FOREIGN KEY (`teacher_id`)
    REFERENCES `dbms_demo`.`teacher` (`teacher_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `dbms_demo`.`teacher_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbms_demo`.`teacher_details` (
  `highest_qualification` VARCHAR(20) NOT NULL,
  `email` VARCHAR(20) NOT NULL,
  `phone` VARCHAR(11) NOT NULL,
  `address` VARCHAR(30) NOT NULL,
  `city` VARCHAR(30) NOT NULL,
  `state` VARCHAR(30) NOT NULL,
  `zip` VARCHAR(10) NOT NULL,
  `teacher_id` INT(11) NOT NULL,
  UNIQUE INDEX `email` (`email` ASC) ,
  PRIMARY KEY (`teacher_id`),
  CONSTRAINT `fk_teacher_id`
    FOREIGN KEY (`teacher_id`)
    REFERENCES `dbms_demo`.`teacher` (`teacher_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;




