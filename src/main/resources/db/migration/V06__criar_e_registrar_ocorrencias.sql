CREATE TABLE ocorrencia(
    id BIGINT(20) PRIMARY KEY,
    descricao VARCHAR(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO ocorrencia (id, descricao) VALUES (1,'Unica');
INSERT INTO ocorrencia (id, descricao) VALUES (2,'Parcelada');
INSERT INTO ocorrencia (id, descricao) VALUES (3,'Mensal');
INSERT INTO ocorrencia (id, descricao) VALUES (4,'Semestral');
INSERT INTO ocorrencia (id, descricao) VALUES (5,'Anual');