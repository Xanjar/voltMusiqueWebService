Drop table musique_plainte;

ALTER TABLE `heroku_d6d405d196910d3`.`plainte`
    ADD COLUMN `idmusique` BIGINT(20) NOT NULL AFTER `date_plainte`,
    ADD INDEX `idmusique_plainte_idx` (`idmusique` ASC);
;
ALTER TABLE `heroku_d6d405d196910d3`.`plainte`
    ADD CONSTRAINT `idmusique_plainte`
        FOREIGN KEY (`idmusique`)
            REFERENCES `heroku_d6d405d196910d3`.`musique` (`idmusique`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;