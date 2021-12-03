INSERT INTO t_emissor (ID,CAMINHO, NOME, usuario, SENHA, servico)
VALUES ((select max(id) from t_emissor)+1,'0.0.0.0','emissor1', 'asd', '123','dbdados','S');


INSERT INTO t_emissor (ID,CAMINHO, NOME, usuario, SENHA, servico)
VALUES ((select max(id) from t_emissor)+1,'0.0.0.0','emissor2', 'asd', '123','dbdados','S');


INSERT INTO t_emissor (ID,CAMINHO, NOME, usuario, SENHA, servico)
VALUES ((select max(id) from t_emissor)+1,'0.0.0.0','emissor3', 'asd', '123','dbdados','S');




