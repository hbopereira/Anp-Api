ALTER TABLE produto ADD CONSTRAINT FK_classe FOREIGN KEY (id_classe) REFERENCES classe(id);
ALTER TABLE produto ADD CONSTRAINT FK_marca FOREIGN KEY (id_marca) REFERENCES marca(id);

UPDATE produto set id_classe = 1 where id = 1;
UPDATE produto set id_marca = 1 where id = 1;
