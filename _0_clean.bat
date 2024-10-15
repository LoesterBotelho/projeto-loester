cls
@echo off
REM Parar e remover todos os contêineres
for /f "tokens=*" %%i in ('docker ps -aq') do (
    docker stop %%i
    docker rm %%i
)

REM Remover todos os volumes
for /f "tokens=*" %%i in ('docker volume ls -q') do (
    docker volume rm %%i
)

REM Remover todas as redes não utilizadas
docker network prune -f

echo Todos os conteineres, volumes e redes foram removidos com sucesso.

REM Remover todas as imagens não utilizadas
REM for /f "tokens=*" %%i in ('docker images -q') do (
REM     docker rmi %%i
REM )
REM echo Todos as imagens foram removidos com sucesso.




