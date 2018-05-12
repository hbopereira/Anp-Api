CREATE TABLE produto(
 id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
 descricao VARCHAR(50)NOT NULL,
 valor_unitario DECIMAL(10,2) NOT NULL,
 marca VARCHAR(20) NOT NULL,
 quantidade INT NOT NULL,
 observacao VARCHAR(50)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO produto values (1,'Panela de pressão', 55.00,'Tramoltina', 12, 'aaa');