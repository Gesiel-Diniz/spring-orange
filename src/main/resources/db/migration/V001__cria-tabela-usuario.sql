CREATE TABLE `orange_talents`.`usuario` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC));