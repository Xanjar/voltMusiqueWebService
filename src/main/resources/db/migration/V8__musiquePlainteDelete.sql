Drop table musique_plainte;

ALTER TABLE `volt_musique`.`plainte`
    ADD COLUMN `idmusique` BIGINT(20) NOT NULL AFTER `date_plainte`,
    ADD INDEX `idmusique_plainte_idx` (`idmusique` ASC) VISIBLE;
;
ALTER TABLE `volt_musique`.`plainte`
    ADD CONSTRAINT `idmusique_plainte`
        FOREIGN KEY (`idmusique`)
            REFERENCES `volt_musique`.`musique` (`idmusique`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;