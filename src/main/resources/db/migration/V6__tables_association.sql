CREATE TABLE `volt_musique`.`aimer_album` (
  `idutilisateur` BIGINT(20) NOT NULL,
  `idalbum` BIGINT(20) NOT NULL,
  PRIMARY KEY (`idutilisateur`, `idalbum`),
  INDEX `idalbum_idx` (`idalbum` ASC) VISIBLE,
  CONSTRAINT `idutilisateur_aimer_album`
    FOREIGN KEY (`idutilisateur`)
    REFERENCES `volt_musique`.`utilisateur` (`idutilisateur`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idalbum_aimer_album`
    FOREIGN KEY (`idalbum`)
    REFERENCES `volt_musique`.`album` (`idalbum`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `volt_musique`.`featuring` (
  `idutilisateur` BIGINT(20) NOT NULL,
  `idmusique` BIGINT(20) NOT NULL,
  PRIMARY KEY (`idutilisateur`, `idmusique`),
  INDEX `idmusique_idx` (`idmusique` ASC) VISIBLE,
  CONSTRAINT `idutilisateur_featuring`
    FOREIGN KEY (`idutilisateur`)
    REFERENCES `volt_musique`.`utilisateur` (`idutilisateur`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idmusique_featuring`
    FOREIGN KEY (`idmusique`)
    REFERENCES `volt_musique`.`musique` (`idmusique`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `volt_musique`.`aimer_musique` (
  `idmusique` BIGINT(20) NOT NULL,
  `idutilisateur` BIGINT(20) NOT NULL,
  PRIMARY KEY (`idmusique`, `idutilisateur`),
  INDEX `idutilisateur_idx` (`idutilisateur` ASC) VISIBLE,
  CONSTRAINT `idmusique_aimer_musique`
    FOREIGN KEY (`idmusique`)
    REFERENCES `volt_musique`.`musique` (`idmusique`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idutilisateur_aimer_musique`
    FOREIGN KEY (`idutilisateur`)
    REFERENCES `volt_musique`.`utilisateur` (`idutilisateur`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `volt_musique`.`musique_plainte` (
  `idmusique` BIGINT(20) NOT NULL,
  `idplainte` BIGINT(20) NOT NULL,
  PRIMARY KEY (`idmusique`, `idplainte`),
  INDEX `idplainte_idx` (`idplainte` ASC) VISIBLE,
  CONSTRAINT `idmusique_musique_plainte`
    FOREIGN KEY (`idmusique`)
    REFERENCES `volt_musique`.`musique` (`idmusique`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idplainte_musique_plainte`
    FOREIGN KEY (`idplainte`)
    REFERENCES `volt_musique`.`plainte` (`idplainte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `volt_musique`.`playlist_musique` (
  `idplaylist` BIGINT(20) NOT NULL,
  `idmusique` BIGINT(20) NOT NULL,
  PRIMARY KEY (`idplaylist`, `idmusique`),
  INDEX `idmusique_idx` (`idmusique` ASC) VISIBLE,
  CONSTRAINT `idmusique_playlist_musique`
    FOREIGN KEY (`idmusique`)
    REFERENCES `volt_musique`.`musique` (`idmusique`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idplaylist_playlist_musique`
    FOREIGN KEY (`idplaylist`)
    REFERENCES `volt_musique`.`playlist` (`idplaylist`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
