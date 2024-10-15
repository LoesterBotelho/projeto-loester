### Testar com imagens do dockerhub
```bash
docker-compose up -D -f compose.full.yml
```

### Devs - fazer build com source
```bash
docker-compose up --build -d -f compose.full.yml
```

### Caso queria rodar todos serviços exceto o backend 
```bash
docker-compose up --build -d -f compose.nobackend.yml
```

### Assim você pode executar o backend como desenvolvedor ou pela ide eclipse
```bat
@echo off

REM Finalizar java e javaw
call cmd /c _0_kill.bat

REM Navegar para o diretório v1-backend
cd v1-backend

REM Executar o Maven para verificar dependências do projeto
call cmd /c mvn dependency:tree

REM Executar o Maven para compilar o projeto
call cmd /c mvn package

REM Executar o Maven para rodar a aplicação Spring Boot em um novo processo
start cmd /c "mvn spring-boot:run"

REM Voltar ao diretório anterior
cd ..
```

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
