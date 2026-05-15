-- Crear la base de datos
CREATE DATABASE sigma_db;

-- Conectar a la base de datos
\c sigma_db;

-- Habilitar PostGIS
CREATE EXTENSION IF NOT EXISTS postgis;
CREATE EXTENSION IF NOT EXISTS postgis_topology;

-- Verificar instalación
SELECT PostGIS_Version();