ALTER TABLE `heroku_d6d405d196910d3`.`playlist`
CHANGE COLUMN `idplaylist` `idplaylist` BIGINT(20) NOT NULL;

ALTER TABLE `heroku_d6d405d196910d3`.`album`
CHANGE COLUMN `idalbum` `idalbum` BIGINT(20) NOT NULL;

ALTER TABLE `heroku_d6d405d196910d3`.`musique`
CHANGE COLUMN `idmusique` `idmusique` BIGINT(20) NOT NULL;

ALTER TABLE `heroku_d6d405d196910d3`.`plainte`
CHANGE COLUMN `idplainte` `idplainte` BIGINT(20) NOT NULL;