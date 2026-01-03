package com.hugoulloa.foro_hub.dto;

import org.hibernate.validator.constraints.NotBlank;

public record TopicoRequestDTO(
        @NotBlank String titulo,
        @NotBlank String mensaje
) {}