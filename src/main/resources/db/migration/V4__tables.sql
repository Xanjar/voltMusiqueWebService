CREATE TABLE `heroku_d6d405d196910d3`.`playlist` (
  `idplaylist` INT NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idplaylist`));

CREATE TABLE `heroku_d6d405d196910d3`.`musique` (
  `idmusique` INT NOT NULL,
  `titre` VARCHAR(255) NOT NULL,
  `date_sortie` DATE NOT NULL,
  PRIMARY KEY (`idmusique`));

CREATE TABLE `heroku_d6d405d196910d3`.`album` (
  `idalbum` INT NOT NULL,
  `titre` VARCHAR(255) NOT NULL,
  `date_sortie` DATE NULL,
  `description` TEXT(400) NULL,
  PRIMARY KEY (`idalbum`));

CREATE TABLE `heroku_d6d405d196910d3`.`plainte` (
  `idplainte` INT NOT NULL,
  `message` VARCHAR(255) NOT NULL,
  `date_plainte` DATE NOT NULL,
  PRIMARY KEY (`idplainte`));

  ALTER TABLE `heroku_d6d405d196910d3`.`utilisateur`
CHANGE COLUMN `idutilisateur` `idutilisateur` BIGINT(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE `heroku_d6d405d196910d3`.`playlist`
    CHANGE COLUMN `idplaylist` `idplaylist` BIGINT(20) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `heroku_d6d405d196910d3`.`plainte`
    CHANGE COLUMN `idplainte` `idplainte` BIGINT(20) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `heroku_d6d405d196910d3`.`album`
    CHANGE COLUMN `idalbum` `idalbum` BIGINT(20) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `heroku_d6d405d196910d3`.`musique`
    CHANGE COLUMN `idmusique` `idmusique` BIGINT(20) NOT NULL AUTO_INCREMENT ;