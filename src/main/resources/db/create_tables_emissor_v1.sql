create table t_emissor(
      id  SERIAL PRIMARY KEY,
      nome varchar2(50),
      usuario varchar2(200),
      senha varchar2(200),
      caminho varchar2(200),
      servico varchar2(200),
      isMonitorar varchar2(5)
);