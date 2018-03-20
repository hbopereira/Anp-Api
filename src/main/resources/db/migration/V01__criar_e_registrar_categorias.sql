CREATE TABLE categoria(
  id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(50)NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria (descricao) VALUES ('Alimentação');
INSERT INTO categoria (descricao) VALUES ('Lazer');
INSERT INTO categoria (descricao) VALUES ('Outros');