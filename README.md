### Configurações do Docker-Compose
```
Faixa de IP : 192.168.1.0/24

pgadmin
 IP : 192.168.1.115
TCP : 8888

postgres
 IP : 192.168.1.100
TCP : 5432

backend (API)
  IP : 192.168.1.110
 TCP : 8080  

frontend
 IP : 192.168.1.120
TCP : 80 

rabbitmq
 IP : 192.168.1.101
 TCP : 5672 , 15672

 redis
 IP : 192.168.1.102
TCP : 6379  

mongodb
 IP : 192.168.1.103
TCP : 27017

flyway
 IP : 192.168.1.104
TCP :
```

### Testar com imagens do dockerhub
```
docker-compose up -D
```

### Devs - fazer build com source
```
docker-compose up --build
```

Frontend
- React
- Material UI
- Styled-Components
- Axios
- Typescript

Backend
- Java
- JUnit 5
- Springboot

Recursos
- Flyway
- Postgres
- RabbitMQ
- Redis
- MongoDB
