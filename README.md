# Hambre Cero Services

Servicios web en formato JSON para la apicación del Hackaton en la categoría Hambre Cero.
Desarrollador con las siguientes tecnologías:

- Java
- Gradle
- Spring Boot
- PostgreSQL
- JWT

## Instalación

A continuación una guía de como ejecutar el servicio web en un ambiente local.

### Requisitos

- Java 11 instalado
- Código fuente del proyecto
- Base de datos PostgreSQL

Se puede descargar Java Open Source desde las siguientes fuentes:

- [OpenJDK](https://openjdk.java.net/)
- [Amazon Corretto](https://aws.amazon.com/es/corretto/)

### ¿Cómo Ejecutar?

Dentro del directorio principal del proyecto ejecutar lo siguiente: `./gradlew bootRun` con los
siguientes argumentos:

- `spring.datasource.url`
- `spring.datasource.username`
- `spring.datasource.password`

Comando completo:

```
./gradlew bootRun --args='--spring.datasource.url=jdbc:postgresql://localhost:5432/hambre_cero_hackaton --spring.datasource.username=postgres --spring.datasource.password=postgres'
```

### Variables de entorno o argumentos

Las siguientes variables de entorno o argumentos son necesarias:

__SPRING_DATASOURCE_URL:__ Cadena de conexión a base de datos
__SPRING_DATASOURCE_USERNAME:__ Nombre de usuario de base de datos
__SPRING_DATASOURCE_PASSWORD:__ Contraseña de base de datos

Ejemplo de cadena de conexión a base de
datos: `jdbc:postgresql://localhost:5432/hambre_cero_hackaton`