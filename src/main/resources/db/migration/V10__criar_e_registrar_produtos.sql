CREATE TABLE produto(
 id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
 codigo_barras VARCHAR(100),
 controla_estoque BOOLEAN,
 descricao VARCHAR(50) NOT NULL,
 aplicacao VARCHAR(50),
 estoque_minimo DECIMAL(10,2),
 estoque_maximo DECIMAL(10,2),
 ultimo_custo DECIMAL(10,2),
 custo_medio DECIMAL(10,2),
 valor_unitario DECIMAL(10,2) NOT NULL,
 data_cadastro VARCHAR(10),
 data_modificacao VARCHAR(10),
 ativo BOOLEAN,
 observacao VARCHAR(50),
 id_tipo BIGINT(20),
 id_unidade_medida BIGINT(20),
 id_grupo BIGINT(20),
 id_sub_grupo BIGINT(20),
 id_classe BIGINT(20),
 id_marca BIGINT(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into produto (id, codigo_barras, controla_estoque, descricao, aplicacao, estoque_minimo,
estoque_maximo, ultimo_custo, custo_medio, valor_unitario, data_cadastro, data_modificacao,
ativo, observacao)
values (1,'asasas111', true ,'Panela de Pressão','Panela de Pressão', null, null, null, null, 15.00, null, null, true, null);


