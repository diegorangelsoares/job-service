INSERT INTO t_emissor (ID,CAMINHO, NOME, usuario, SENHA, servico)
VALUES ((select max(id) from t_emissor)+1,'172.30.0.250','emissor1', 'asd', '123','dbdados','S');


INSERT INTO t_emissor (ID,CAMINHO, NOME, usuario, SENHA, servico)
VALUES ((select max(id) from t_emissor)+1,'172.30.0.222','emissor2', 'asd', '123','dbdados','S');


INSERT INTO t_emissor (ID,CAMINHO, NOME, usuario, SENHA, servico)
VALUES ((select max(id) from t_emissor)+1,'10.0.11.38','emissor3', 'asd', '123','dbdados','S');




