package com.insmet.SIGMA.model.dto;

import java.time.LocalDateTime;

public record MuestraResponseDTO(
    Long id,
    Double valor,
    Double longitud,
    Double latitud,
    String variable,
    LocalDateTime fechaCreacion
) {}