package com.insmet.SIGMA.repository;

import com.insmet.SIGMA.model.entity.Muestra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MuestraRepository extends JpaRepository<Muestra, Long> {

    // Buscar muestras dentro de un polígono
    @Query(value = "SELECT m FROM Muestra m WHERE within(m.ubicacion, :poligono) = true")
    List<Muestra> findMuestrasDentroDePoligono(@Param("poligono") String poligonoWKT);
    
    // Buscar muestras por variable meteorológica
    List<Muestra> findByVariableOrderByFechaCreacionDesc(String variable);
    
    // Buscar las muestras más recientes
    @Query(value = "SELECT * FROM muestras ORDER BY fecha_creacion DESC LIMIT :limite", nativeQuery = true)
    List<Muestra> findUltimasMuestras(@Param("limite") int limite);

}
