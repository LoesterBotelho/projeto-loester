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
