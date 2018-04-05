ALTER TABLE lancamento ADD CONSTRAINT FK_ocorrencia FOREIGN KEY (id_ocorrencia) REFERENCES ocorrencia(id);
