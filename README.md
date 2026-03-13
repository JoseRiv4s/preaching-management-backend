# Preaching Management Backend

Backend del **Sistema de Gestión de Predicación**.

Este servicio expone una API REST que permite gestionar las jornadas de predicación, los capitanes, los publicadores y las manzanas del territorio.

El backend se conecta a la base de datos **preaching_management_db**, donde se almacenan todas las jornadas, participantes y manzanas predicadas.

---

# Tecnologías Utilizadas

* Java
* Spring Boot
* PostgreSQL
* Maven

---

# Estructura del Proyecto

```
src/main/java/com/preaching/management
│
├── application      # Casos de uso / lógica de negocio
├── domain           # Entidades del dominio
├── infrastructure   # Acceso a base de datos y servicios externos
└── interfaces       # Controladores y capa API
```

---

# Base de Datos

Este backend utiliza la base de datos definida en el repositorio:

preaching-management-database

La base de datos contiene las siguientes entidades principales:

* captains
* publishers
* blocks
* preaching_days
* preaching_participants
* preached_blocks

---

# Ejecución del Proyecto

1. Clonar el repositorio

2. Configurar la conexión a la base de datos en:

```
src/main/resources/application.yml
```

3. Ejecutar la aplicación:

```
mvn spring-boot:run
```

---

# Objetivo del Sistema

Este backend permite:

* Gestionar capitanes de predicación
* Gestionar publicadores
* Registrar jornadas de predicación
* Registrar participantes en cada jornada
* Registrar las manzanas predicadas
* Consultar historial de predicación
