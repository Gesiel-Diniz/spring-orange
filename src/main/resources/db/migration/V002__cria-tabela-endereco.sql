CREATE TABLE `orange_talents`.`endereco` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` BIGINT(11) NOT NULL,
  `logradouro` VARCHAR(255) NOT NULL,
  `numero` VARCHAR(10) NOT NULL,
  `complemento` VARCHAR(255) NULL,
  `bairro` VARCHAR(150) NOT NULL,
  `cidade` VARCHAR(150) NOT NULL,
  `cep` VARCHAR(12) NULL,
  PRIMARY KEY (`id`),
  INDEX `usuario_id_idx` (`usuario_id` ASC),
  CONSTRAINT `usuario_id`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `orange_talents`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);