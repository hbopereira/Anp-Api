ALTER TABLE produto ADD CONSTRAINT FK_tipo FOREIGN KEY (id_tipo) REFERENCES tipo(id);

UPDATE produto set id_tipo = 1 where id = 1;
