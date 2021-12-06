# job-service
Serviço responsável por monitorar os registros de jobs salvos em uma base de dados

A monitoria é feita automática e enviada por e-mail.

Pode ser feita também manualmente via swagger.

Build pelo Docker em nova versão

1 - Excluir o container
2 - Excluir a imagem
3 - mvn clean/install/package
4 - docker-compose -f docker-compose.yml up