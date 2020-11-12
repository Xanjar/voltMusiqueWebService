ALTER TABLE `volt_musique`.`playlist`
ADD COLUMN `idutilisateur` BIGINT(20) NOT NULL AFTER `title`,
ADD INDEX `idutilisateur_playlist_idx` (`idutilisateur` ASC) VISIBLE;
;
ALTER TABLE `volt_musique`.`playlist`
ADD CONSTRAINT `idutilisateur_playlist`
  FOREIGN KEY (`idutilisateur`)
  REFERENCES `volt_musique`.`utilisateur` (`idutilisateur`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `volt_musique`.`musique`
    ADD COLUMN `idutilisateur` BIGINT(20) NOT NULL AFTER `date_sortie`,
    ADD INDEX `idutilisateur_musique_idx` (`idutilisateur` ASC) VISIBLE;
;
ALTER TABLE `volt_musique`.`musique`
    ADD CONSTRAINT `idutilisateur_musique`
    FOREIGN KEY (`idutilisateur`)
    REFERENCES `volt_musique`.`utilisateur` (`idutilisateur`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `volt_musique`.`album`
    ADD COLUMN `idutilisateur` BIGINT(20) NOT NULL AFTER `description`,
    ADD INDEX `idutilisateur_album_idx` (`idutilisateur` ASC) VISIBLE;
;
ALTER TABLE `volt_musique`.`album`
    ADD CONSTRAINT `idutilisateur_album`
    FOREIGN KEY (`idutilisateur`)
    REFERENCES `volt_musique`.`utilisateur` (`idutilisateur`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `volt_musique`.`musique`
    ADD COLUMN `idalbum` BIGINT(20) NOT NULL AFTER `idutilisateur`,
    ADD INDEX `idalbum_musique_idx` (`idalbum` ASC) VISIBLE;
;
ALTER TABLE `volt_musique`.`musique`
    ADD CONSTRAINT `idalbum_musique`
    FOREIGN KEY (`idalbum`)
    REFERENCES `volt_musique`.`album` (`idalbum`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;
