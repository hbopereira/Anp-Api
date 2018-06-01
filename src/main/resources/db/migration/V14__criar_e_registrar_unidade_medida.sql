CREATE TABLE unidade_medida(
 id BIGINT(20) PRIMARY KEY,
 descricao VARCHAR(50)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO unidade_medida VALUES (1,'Unidade');
INSERT INTO unidade_medida VALUES (2,'Litro');
INSERT INTO unidade_medida VALUES (3,'Quilo');
INSERT INTO unidade_medida VALUES (4,'Metro');
INSERT INTO unidade_medida VALUES (5,'Grama');
INSERT INTO unidade_medida VALUES (6,'Miligrama');