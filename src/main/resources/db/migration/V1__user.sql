CREATE TABLE `heroku_d6d405d196910d3`.`utilisateur` (
  `idutilisateur` INT NOT NULL,
  `pseudo` VARCHAR(50) NOT NULL,
  `nom` VARCHAR(255) NULL,
  `prenom` VARCHAR(255) NULL,
  `email` VARCHAR(50) NOT NULL,
  `date_naissance` DATE NULL,
  `role` VARCHAR(45) NOT NULL,
  `num_etu` VARCHAR(20) NULL,
  PRIMARY KEY (`idutilisateur`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));