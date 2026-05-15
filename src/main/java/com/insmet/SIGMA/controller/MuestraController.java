package com.insmet.SIGMA.controller;

import com.insmet.SIGMA.model.dto.MuestraRequestDTO;
import com.insmet.SIGMA.model.dto.MuestraResponseDTO;
import com.insmet.SIGMA.service.MuestraService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/muestras")
public class MuestraController {

     
    private final MuestraService muestraService;
    
    public MuestraController(MuestraService muestraService) {
        this.muestraService = muestraService;
    }
    
    @PostMapping("/temperatura")
    public ResponseEntity<MuestraResponseDTO> registrarTemperatura(
            @Valid @RequestBody MuestraRequestDTO request) {
        MuestraResponseDTO response = muestraService.guardarMuestra(request, "TEMPERATURA");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @PostMapping("/precipitacion")
    public ResponseEntity<MuestraResponseDTO> registrarPrecipitacion(
            @Valid @RequestBody MuestraRequestDTO request) {
        MuestraResponseDTO response = muestraService.guardarMuestra(request, "PRECIPITACION");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @PostMapping("/presion")
    public ResponseEntity<MuestraResponseDTO> registrarPresion(
            @Valid @RequestBody MuestraRequestDTO request) {
        MuestraResponseDTO response = muestraService.guardarMuestra(request, "PRESION");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    // Endpoint genérico
    @PostMapping("/{variable}")
    public ResponseEntity<MuestraResponseDTO> registrarMuestra(
            @PathVariable String variable,
            @Valid @RequestBody MuestraRequestDTO request) {
        MuestraResponseDTO response = muestraService.guardarMuestra(request, variable);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
