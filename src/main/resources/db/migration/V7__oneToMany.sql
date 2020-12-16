ALTER TABLE `heroku_d6d405d196910d3`.`playlist`
ADD COLUMN `idutilisateur` BIGINT(20) NOT NULL AFTER `title`,
ADD INDEX `idutilisateur_playlist_idx` (`idutilisateur` ASC);
;
ALTER TABLE `heroku_d6d405d196910d3`.`playlist`
ADD CONSTRAINT `idutilisateur_playlist`
  FOREIGN KEY (`idutilisateur`)
  REFERENCES `heroku_d6d405d196910d3`.`utilisateur` (`idutilisateur`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `heroku_d6d405d196910d3`.`musique`
    ADD COLUMN `idutilisateur` BIGINT(20) NOT NULL AFTER `date_sortie`,
    ADD INDEX `idutilisateur_musique_idx` (`idutilisateur` ASC);
;
ALTER TABLE `heroku_d6d405d196910d3`.`musique`
    ADD CONSTRAINT `idutilisateur_musique`
    FOREIGN KEY (`idutilisateur`)
    REFERENCES `volt_musique`.`utilisateur` (`idutilisateur`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `heroku_d6d405d196910d3`.`album`
    ADD COLUMN `idutilisateur` BIGINT(20) NOT NULL AFTER `description`,
    ADD INDEX `idutilisateur_album_idx` (`idutilisateur` ASC);
;
ALTER TABLE `heroku_d6d405d196910d3`.`album`
    ADD CONSTRAINT `idutilisateur_album`
    FOREIGN KEY (`idutilisateur`)
    REFERENCES `heroku_d6d405d196910d3`.`utilisateur` (`idutilisateur`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `heroku_d6d405d196910d3`.`musique`
    ADD COLUMN `idalbum` BIGINT(20) NOT NULL AFTER `idutilisateur`,
    ADD INDEX `idalbum_musique_idx` (`idalbum` ASC);
;
ALTER TABLE `heroku_d6d405d196910d3`.`musique`
    ADD CONSTRAINT `idalbum_musique`
    FOREIGN KEY (`idalbum`)
    REFERENCES `heroku_d6d405d196910d3`.`album` (`idalbum`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;
