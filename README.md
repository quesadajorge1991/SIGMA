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


POST /api/v1/muestras/temperatura
POST /api/v1/muestras/precipitacion
POST /api/v1/muestras/presion

### Registrar variable personalizada
POST /api/v1/muestras/{variable}

### 📝 Ejemplo de Petición
POST /api/v1/muestras/temperatura
Content-Type: application/json

{
  "latitud": 40.4168,
  "longitud": -3.7038,
  "valor": 23.5
}

### 📊 Ejemplo de Respuesta
{
  "id": 1,
  "valor": 23.5,
  "longitud": -3.7038,
  "latitud": 40.4168,
  "variable": "TEMPERATURA",
  "fechaCreacion": "2026-05-15T10:30:00"
}
```http







POST /api/v1/muestras/temperatura
POST /api/v1/muestras/precipitacion
POST /api/v1/muestras/presion
