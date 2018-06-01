CREATE TABLE classe (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO classe (id, nome) VALUES(1, 'Domésticos');
INSERT INTO classe (id, nome) VALUES(2, 'Moda');
INSERT INTO classe (id, nome) VALUES(3, 'Inverno');


CREATE TABLE marca (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO marca (id, nome) VALUES (1, 'Tramontiona');
INSERT INTO marca (id, nome) VALUES (2, 'Skol');
INSERT INTO marca (id, nome) VALUES (3, 'Nelore');
INSERT INTO marca (id, nome) VALUES (4, 'Gringa');