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