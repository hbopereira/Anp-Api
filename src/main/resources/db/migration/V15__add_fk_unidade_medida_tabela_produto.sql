ALTER TABLE produto ADD CONSTRAINT FK_unidade_medida FOREIGN KEY (id_unidade_medida) REFERENCES unidade_medida(id);

UPDATE produto set id_unidade_medida = 1 where id = 1;
