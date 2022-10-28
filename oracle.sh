docker run -d --name oracle -p 1522:1521 -e ORACLE_PASSWORD=admin gvenzl/oracle-xe

docker volume create oracle-volume
docker run -d -v oracle-volume:/opt/oracle/oradate --name oracle -p 1522:1521 -e ORACLE_PASSWORD=admin gvenzl/oracle-xe