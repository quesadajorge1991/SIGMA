package com.insmet.SIGMA.service;

import com.insmet.SIGMA.model.dto.MuestraRequestDTO;
import com.insmet.SIGMA.model.dto.MuestraResponseDTO;
import com.insmet.SIGMA.model.entity.Muestra;
import com.insmet.SIGMA.repository.MuestraRepository;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MuestraService {

private final MuestraRepository muestraRepository;
    private final GeometryFactory geometryFactory;
    
    public MuestraService(MuestraRepository muestraRepository, GeometryFactory geometryFactory) {
        this.muestraRepository = muestraRepository;
        this.geometryFactory = geometryFactory;
    }
    
    @Transactional
    public MuestraResponseDTO guardarMuestra(MuestraRequestDTO request, String variable) {
        // Convertir lat/lon a Point geometry
        Point punto = geometryFactory.createPoint(
            new Coordinate(request.longitud(), request.latitud())
        );
        
        // Crear la entidad
        Muestra muestra = new Muestra(
            request.valor(),
            punto,
            variable.toUpperCase()
        );
        
        // Guardar en BD
        Muestra guardada = muestraRepository.save(muestra);
        
        // Retornar DTO de respuesta
        return new MuestraResponseDTO(
            guardada.getId(),
            guardada.getValor(),
            guardada.getUbicacion().getX(),  // longitud
            guardada.getUbicacion().getY(),  // latitud
            guardada.getVariable(),
            guardada.getFechaCreacion()
        );
    }

}
