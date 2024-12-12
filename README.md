## Proyecto Backend

El obketivo principal de este proyecto es desarrollar una aplicación de gestión tomando como ejemplo una liga de futbol, que permita administrar equipos, jugadores, partidos, estadísticas y otras funcionalidades relacionadas, asegurando un rendimiento óptimo, escalabilidad y seguridad.

![Banner Technologies](Tecnologías.png) 

### Lenguaje:

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)


### Framework
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

### Database
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

### Otro
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)


## ¿Que contiene el Proyecto?
1. Capa de Repositorio (Interfaces que realizan consultas en Bases de Datos). 
2. Capa de Servicio (Interface y Clase que se encargan de la lógica de negocio, utiliza inyección de 
dependencias de la capa de Repositorio). 
3. Capa de Controladores (Clases Java que exponen los Endpoints para consumir servicios REST tipo 
POST, PUT, GET, DELETE) 
4. Pruebas unitarias Capas Repositorio. 

## Diagrama ER
![Diagrama ER](jogobonitodb_public.png) 