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
