CREATE TABLE contato (
 id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	id_pessoa BIGINT(20) NOT NULL,
	email VARCHAR(100) NOT NULL,
	telefone VARCHAR(20) NOT NULL,
  FOREIGN KEY (id_pessoa) REFERENCES pessoa(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into contato (id, id_pessoa, email, telefone) values (1, 1, 'marcos@algamoney.com', '00 0000-0000');
