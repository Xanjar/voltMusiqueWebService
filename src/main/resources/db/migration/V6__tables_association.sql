CREATE TABLE `heroku_d6d405d196910d3`.`aimer_album` (
  `idutilisateur` BIGINT(20) NOT NULL,
  `idalbum` BIGINT(20) NOT NULL,
  PRIMARY KEY (`idutilisateur`, `idalbum`),
  INDEX `idalbum_idx` (`idalbum` ASC) ,
  CONSTRAINT `idutilisateur_aimer_album`
    FOREIGN KEY (`idutilisateur`)
    REFERENCES `heroku_d6d405d196910d3`.`utilisateur` (`idutilisateur`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idalbum_aimer_album`
    FOREIGN KEY (`idalbum`)
    REFERENCES `heroku_d6d405d196910d3`.`album` (`idalbum`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `heroku_d6d405d196910d3`.`featuring` (
  `idutilisateur` BIGINT(20) NOT NULL,
  `idmusique` BIGINT(20) NOT NULL,
  PRIMARY KEY (`idutilisateur`, `idmusique`),
  INDEX `idmusique_idx` (`idmusique` ASC),
  CONSTRAINT `idutilisateur_featuring`
    FOREIGN KEY (`idutilisateur`)
    REFERENCES `heroku_d6d405d196910d3`.`utilisateur` (`idutilisateur`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idmusique_featuring`
    FOREIGN KEY (`idmusique`)
    REFERENCES `heroku_d6d405d196910d3`.`musique` (`idmusique`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `heroku_d6d405d196910d3`.`aimer_musique` (
  `idmusique` BIGINT(20) NOT NULL,
  `idutilisateur` BIGINT(20) NOT NULL,
  PRIMARY KEY (`idmusique`, `idutilisateur`),
  INDEX `idutilisateur_idx` (`idutilisateur` ASC),
  CONSTRAINT `idmusique_aimer_musique`
    FOREIGN KEY (`idmusique`)
    REFERENCES `heroku_d6d405d196910d3`.`musique` (`idmusique`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idutilisateur_aimer_musique`
    FOREIGN KEY (`idutilisateur`)
    REFERENCES `heroku_d6d405d196910d3`.`utilisateur` (`idutilisateur`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `heroku_d6d405d196910d3`.`musique_plainte` (
  `idmusique` BIGINT(20) NOT NULL,
  `idplainte` BIGINT(20) NOT NULL,
  PRIMARY KEY (`idmusique`, `idplainte`),
  INDEX `idplainte_idx` (`idplainte` ASC),
  CONSTRAINT `idmusique_musique_plainte`
    FOREIGN KEY (`idmusique`)
    REFERENCES `heroku_d6d405d196910d3`.`musique` (`idmusique`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idplainte_musique_plainte`
    FOREIGN KEY (`idplainte`)
    REFERENCES `heroku_d6d405d196910d3`.`plainte` (`idplainte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `heroku_d6d405d196910d3`.`playlist_musique` (
  `idplaylist` BIGINT(20) NOT NULL,
  `idmusique` BIGINT(20) NOT NULL,
  PRIMARY KEY (`idplaylist`, `idmusique`),
  INDEX `idmusique_idx` (`idmusique` ASC),
  CONSTRAINT `idmusique_playlist_musique`
    FOREIGN KEY (`idmusique`)
    REFERENCES `heroku_d6d405d196910d3`.`musique` (`idmusique`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idplaylist_playlist_musique`
    FOREIGN KEY (`idplaylist`)
    REFERENCES `heroku_d6d405d196910d3`.`playlist` (`idplaylist`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
