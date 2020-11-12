CREATE TABLE `volt_musique`.`playlist` (
  `idplaylist` INT NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idplaylist`));

CREATE TABLE `volt_musique`.`musique` (
  `idmusique` INT NOT NULL,
  `titre` VARCHAR(255) NOT NULL,
  `date_sortie` DATE NOT NULL,
  PRIMARY KEY (`idmusique`));

CREATE TABLE `volt_musique`.`album` (
  `idalbum` INT NOT NULL,
  `titre` VARCHAR(255) NOT NULL,
  `date_sortie` DATE NULL,
  `description` TEXT(400) NULL,
  PRIMARY KEY (`idalbum`));

CREATE TABLE `volt_musique`.`plainte` (
  `idplainte` INT NOT NULL,
  `message` VARCHAR(255) NOT NULL,
  `date_plainte` DATE NOT NULL,
  PRIMARY KEY (`idplainte`));

  ALTER TABLE `volt_musique`.`utilisateur`
CHANGE COLUMN `idutilisateur` `idutilisateur` BIGINT(20) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `volt_musique`.`playlist`
    CHANGE COLUMN `idplaylist` `idplaylist` BIGINT(20) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `volt_musique`.`plainte`
    CHANGE COLUMN `idplainte` `idplainte` BIGINT(20) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `volt_musique`.`album`
    CHANGE COLUMN `idalbum` `idalbum` BIGINT(20) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `volt_musique`.`musique`
    CHANGE COLUMN `idmusique` `idmusique` BIGINT(20) NOT NULL AUTO_INCREMENT ;