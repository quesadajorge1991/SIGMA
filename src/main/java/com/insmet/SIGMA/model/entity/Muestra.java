package com.insmet.SIGMA.model.entity;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;
import java.time.LocalDateTime;

@Entity
@Table(name = "muestras", indexes = {
    @Index(name = "idx_ubicacion", columnList = "ubicacion")
})
public class Muestra {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Double valor;
    
    @Column(columnDefinition = "geometry(Point, 4326)", nullable = false)
    private Point ubicacion;
    
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
    
    @Column(nullable = false)
    private String variable; // TEMPERATURA, PRECIPITACION, PRESION, etc.
    
    // Constructores
    public Muestra() {}
    
    public Muestra(Double valor, Point ubicacion, String variable) {
        this.valor = valor;
        this.ubicacion = ubicacion;
        this.variable = variable;
        this.fechaCreacion = LocalDateTime.now();
    }
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
    
    public Point getUbicacion() { return ubicacion; }
    public void setUbicacion(Point ubicacion) { this.ubicacion = ubicacion; }
    
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    
    public String getVariable() { return variable; }
    public void setVariable(String variable) { this.variable = variable; }

}
