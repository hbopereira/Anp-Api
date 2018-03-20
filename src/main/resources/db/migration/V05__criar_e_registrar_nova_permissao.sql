INSERT INTO permissao (codigo, descricao) values (9, 'ROLE_CADASTRAR_USUARIO');
INSERT INTO permissao (codigo, descricao) values (10, 'ROLE_PESQUISAR_USUARIO');

INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 9);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 10);