# ms-holiday

Project ms-holiday

## Comenzando 🏁

### Prerrequisitos 📋

* _Crear una cuenta de GitHub (opcional) -> [Registrar cuenta](https://github.com/join)_
* _Crear cuenta en Docker Hub (opcional) -> [Registrar cuenta](https://www.docker.com/products/docker-hub/)_
* _Docker -> [Descargar Docker](https://www.docker.com/products/docker-desktop/)_
* _JDK 21 -> [Descargar JDK 21](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/downloads-list.html)_
* _Maven -> [Descargar Maven](https://maven.apache.org/download.cgi)_
* _Junit_
* _Mockito_
* _OpenApi - Swagger_
* _Mysql_
* _Intellij_

## Instalación y configuración 🔧

### Java

_**1**. Para la primera instancia necesitaremos confirmar que la versión de JDK este correctamente instalada._

```
java -version
```

### Maven

_**2**. Validar versión de maven._

```
mvn -version
```

### Docker

_**3**. Validar versión de docker._

```
docker --version
```

## Compilación y despliegue ⚙️ 🚀

Ubicarse en la carpeta del proyecto

```
/ms-holiday
```

Construcción de imagen a nivel de docker

```
docker compose build
```

Despliegue de proyecto

```
docker compose up
```

## Como probar

para JSON

```
curl --location 'http://localhost:8080/ms-holiday/api/holiday?type=Religioso&from=2025-04-18&to=2025-04-19' \
--header 'Accept: application/json'
```

para XML

```
curl --location 'http://localhost:8080/ms-holiday/api/holiday?type=Religioso&from=2025-04-18&to=2025-04-19' \
--header 'Accept: application/xml'
```

## Documentación Swagger 📚

* _Swagger Ui -> [Ver](http://localhost:8080/ms-holiday/swagger-ui/index.html)_





