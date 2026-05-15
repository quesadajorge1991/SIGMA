package com.insmet.SIGMA.config;


import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GeoConfig {

    @Bean
    public GeometryFactory geometryFactory() {
        // SRID 4326 = WGS84 (coordenadas geográficas estándar)
        return new GeometryFactory(new PrecisionModel(), 4326);
    }
}
