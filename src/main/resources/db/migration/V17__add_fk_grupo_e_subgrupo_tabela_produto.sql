ALTER TABLE produto ADD CONSTRAINT FK_grupo FOREIGN KEY (id_grupo) REFERENCES grupo(id);
ALTER TABLE produto ADD CONSTRAINT FK_sub_grupo FOREIGN KEY (id_sub_grupo) REFERENCES subgrupo(id);

UPDATE produto set id_grupo = 1 where id = 1;
UPDATE produto set id_sub_grupo = 1 where id = 1;
