SET FOREIGN_KEY_CHECKS = 0;

ALTER TABLE `volt_musique`.`album`
CHANGE COLUMN `idalbum` `idalbum` BIGINT(20) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `volt_musique`.`musique`
CHANGE COLUMN `idmusique` `idmusique` BIGINT(20) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `volt_musique`.`plainte`
CHANGE COLUMN `idplainte` `idplainte` BIGINT(20) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `volt_musique`.`playlist`
CHANGE COLUMN `idplaylist` `idplaylist` BIGINT(20) NOT NULL AUTO_INCREMENT ;

SET FOREIGN_KEY_CHECKS = 1;
