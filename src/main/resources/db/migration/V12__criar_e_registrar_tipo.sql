CREATE TABLE tipo(
 id BIGINT(20) PRIMARY KEY,
 descricao VARCHAR(50)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tipo VALUES (1,'Revenda');
INSERT INTO tipo VALUES (2,'Manufaturado');
INSERT INTO tipo VALUES (3,'Matéria Prima');
INSERT INTO tipo VALUES (4,'Ativo Imobilizado');
INSERT INTO tipo VALUES (5,'Material de uso e Consumo');