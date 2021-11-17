# job-service
Serviço responsável por monitorar os registros de jobs salvos em uma base de dados

Consumo no postman
curl --location --request GET 'http://localhost:8806/job-service/' \
--header 'Content-Type: application/json' \
--data-raw '{
"dataInicio": "2021-11-01T11:45:04.391Z",
"dataFinal": "2021-11-18T11:45:04.391Z",
"statusExecucao": "E"
}'