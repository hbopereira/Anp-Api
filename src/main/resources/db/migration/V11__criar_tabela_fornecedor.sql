CREATE TABLE fornecedor(
 id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
 id_produto BIGINT(20) NOT NULL,
 nome VARCHAR(50)NOT NULL,
 cnpj VARCHAR(20) NOT NULL,
 email VARCHAR(20) NOT NULL,
 telefone VARCHAR(20) NOT NULL,
 FOREIGN KEY(id_produto) REFERENCES produto(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO fornecedor values (1, 1, 'JR Work Center', '865421452365', 'jrwork@gmail.com', '34631254');