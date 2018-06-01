CREATE TABLE grupo (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO grupo (id, nome) VALUES(1, 'Acessorios');
INSERT INTO grupo (id, nome) VALUES(2, 'Bebidas');
INSERT INTO grupo (id, nome) VALUES(3, 'Lanches');


CREATE TABLE subgrupo (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO subgrupo (id, nome) VALUES (1, 'Eletronico');
INSERT INTO subgrupo (id, nome) VALUES (2, 'Presentes');
INSERT INTO subgrupo (id, nome) VALUES (3, 'Feminino');
INSERT INTO subgrupo (id, nome) VALUES (4, 'Infantis');
INSERT INTO subgrupo (id, nome) VALUES (5, 'Cerveja');
INSERT INTO subgrupo (id, nome) VALUES (6, 'Refrigerante');
INSERT INTO subgrupo (id, nome) VALUES (7, 'Suco');
INSERT INTO subgrupo (id, nome) VALUES (8, 'Fritos');
INSERT INTO subgrupo (id, nome) VALUES (9, 'Assados');