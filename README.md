# Preaching Management Backend

Backend del sistema **Preaching Management**, una aplicación diseñada para gestionar jornadas de predicación y el control de territorios.

El sistema permite registrar:

* Capitanes de grupo
* Publicadores que participan en la predicación
* Manzanas del territorio
* Jornadas de predicación
* Qué manzanas fueron predicadas
* Qué publicadores participaron

El objetivo es saber **qué territorios ya fueron predicados y cuáles faltan**, además de generar reportes de participación.

---

# Tecnologías

* Java 21
* Spring Boot
* PostgreSQL
* Maven

---

# Arquitectura

El proyecto sigue una **Clean Architecture pragmática inspirada en Hexagonal Architecture**, separando claramente las responsabilidades del sistema.

```
src/main/java/com/preaching/management
│
├── domain
│   ├── model
│   ├── repository
│   └── exception
│
├── application
│   └── service
│
├── infrastructure
│   ├── config
│   └── persistence
│       ├── entity
│       ├── mapper
│       ├── repository
│       └── adapter
│
├── interfaces
│   └── rest
│       ├── controller
│       ├── dto
│       │   ├── request
│       │   └── response
│       └── mapper
│
└── shared
    ├── exception
    └── util
```

---

# Capas del sistema

## Domain

Contiene las entidades del negocio y las interfaces de repositorio.
No depende de frameworks ni de infraestructura.

## Application

Contiene los **casos de uso** y la lógica de negocio de la aplicación.

## Infrastructure

Implementaciones técnicas como:

* acceso a base de datos
* configuración
* adaptadores

## Interfaces

Contiene los controladores REST y los DTOs utilizados por la API.

---

# Base de datos

El sistema utiliza **PostgreSQL** para almacenar la información de:

* Capitanes
* Publicadores
* Manzanas del territorio
* Jornadas de predicación
* Participantes de cada jornada

---

# Estado del proyecto

🚧 En desarrollo
