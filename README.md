```markdown
# 🌦️ API de Registro de Muestras Meteorológicas

API REST para el registro y gestión de datos meteorológicos con soporte geoespacial, desarrollada con **Spring Boot** y **PostGIS**. Permite almacenar mediciones de temperatura, precipitación, presión atmosférica y otras variables ambientales con su ubicación geográfica exacta.

## 🚀 Características Principales

- **Registro de variables meteorológicas**: Temperatura, precipitación, presión, humedad, etc.
- **Soporte geoespacial**: Almacenamiento de coordenadas geográficas usando PostGIS
- **Validación de datos**: Control de rangos válidos para latitud/longitud y valores meteorológicos
- **Arquitectura RESTful**: Endpoints bien definidos siguiendo buenas prácticas
- **Persistencia eficiente**: Uso de índices espaciales para consultas optimizadas

## 🛠️ Tecnologías Utilizadas

- **Java 17** - Lenguaje de programación
- **Spring Boot 3.x** - Framework principal
- **Spring Data JPA** - Capa de persistencia
- **Hibernate Spatial** - Soporte para datos geoespaciales
- **PostgreSQL + PostGIS** - Base de datos con extensiones espaciales
- **Maven** - Gestor de dependencias
- **JTS (Java Topology Suite)** - Manejo de geometrías

## 📦 Endpoints Disponibles

### Registrar muestras específicas

```http
POST /api/v1/muestras/temperatura
POST /api/v1/muestras/precipitacion
POST /api/v1/muestras/presion
```

### Registrar variable personalizada

```http
POST /api/v1/muestras/{variable}
```

## 📝 Ejemplo de Petición

```http
POST /api/v1/muestras/temperatura
Content-Type: application/json

{
  "latitud": 40.4168,
  "longitud": -3.7038,
  "valor": 23.5
}
```

## 📊 Ejemplo de Respuesta

```json
{
  "id": 1,
  "valor": 23.5,
  "longitud": -3.7038,
  "latitud": 40.4168,
  "variable": "TEMPERATURA",
  "fechaCreacion": "2026-05-15T10:30:00"
}
```

## 🗄️ Configuración de Base de Datos

### Requisitos previos

- PostgreSQL 12+ instalado
- Extensión PostGIS habilitada

### Activar PostGIS en PostgreSQL

```sql
CREATE EXTENSION postgis;
```

### Configuración de conexión

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tu_bd
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.database-platform=org.hibernate.spatial.dialect.postgis.PostgisPG10Dialect
```

## 🚦 Validaciones Implementadas

- **Latitud**: Entre -90° y 90°
- **Longitud**: Entre -180° y 180°
- **Valor meteorológico**: Campo obligatorio (permite valores negativos para temperatura)

## 🧪 Pruebas con cURL

```bash
# Registrar temperatura
curl -X POST http://localhost:8080/api/v1/muestras/temperatura \
  -H "Content-Type: application/json" \
  -d '{"latitud": 40.4168, "longitud": -3.7038, "valor": 23.5}'

# Registrar precipitación
curl -X POST http://localhost:8080/api/v1/muestras/precipitacion \
  -H "Content-Type: application/json" \
  -d '{"latitud": 41.3851, "longitud": 2.1734, "valor": 12.3}'
```

## 📁 Estructura del Proyecto

```
src/main/java/com/tuempresa/muestras/
├── controller/
│   └── MuestraController.java
├── config/
│   └── GeoConfig.java
├── service/
│   └── MuestraService.java
├── repository/
│   └── MuestraRepository.java
├── model/
│   └── Muestra.java
└── dto/
    ├── MuestraRequestDTO.java
    └── MuestraResponseDTO.java
```

## 🔄 Mejoras Futuras

- [ ] Endpoints GET para consultar muestras por rango de fechas
- [ ] Consultas espaciales (muestras cercanas a un punto)
- [ ] Estadísticas agregadas por región
- [ ] Autenticación y autorización (Spring Security)
- [ ] Documentación interactiva con Swagger/OpenAPI
- [ ] Tests unitarios y de integración

## 🛠️ Stack Tecnológico

- Java 17 ☕
- Spring Boot 🍃
- PostgreSQL 🐘
- PostGIS 🌍

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo LICENSE.md para más detalles.

## ✒️ Autores

- **Jorge Adrián Quesada Perdomo**
- **Jenice Medinilla Padrón**





