package com.hugoulloa.foro_hub.dto;

public record TopicoResponseDTO(
        Long id,
        String titulo,
        String mensaje,
        String status
) {}