INSERT INTO permissao (codigo, descricao) values (11, 'ROLE_PESQUISAR_OCORRENCIA');

INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 11);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 11);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (3, 11);
