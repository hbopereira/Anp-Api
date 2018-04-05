CREATE TABLE pessoa(
 id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
 nome VARCHAR(50)NOT NULL,
 cpf VARCHAR(20),
 cnpj VARCHAR(20),
 email varchar(50) NOT NULL,
 logradouro VARCHAR(50),
 numero varchar(30),
 complemento VARCHAR(30),
 bairro VARCHAR(20),
 cep VARCHAR(20),
 cidade VARCHAR(20),
 estado varchar(20),
 tipo VARCHAR(20) NOT NULL,
 ativo BOOLEAN NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, cpf, cnpj, email, logradouro, numero, complemento, bairro, cep, cidade, estado, tipo, ativo) values ('João Silva', '098.160.969-43', null , 'joaosilva@hotmail.com', 'Rua do Abacaxi', '10', null, 'Brasil', '38.400-121', 'Uberlândia', 'MG', 'FISICA', true);
INSERT INTO pessoa (nome, cpf, cnpj, email, logradouro, numero, complemento, bairro, cep, cidade, estado, tipo, ativo) values ('AP Vidraçaria LTDA', null, '122.131.2312', 'mariarita@gmail.com', 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-121', 'Ribeirão Preto', 'SP', 'JURIDICA', true);
INSERT INTO pessoa (nome, cpf, cnpj, email, logradouro, numero, complemento, bairro, cep, cidade, estado, tipo, ativo) values ('Pedro Santos', '098.160.966-43', null, 'pedrosantos@hotmail.com', 'Rua da Bateria', '23', null, 'Morumbi', '54.212-121', 'Goiânia', 'GO', 'FISICA', true);