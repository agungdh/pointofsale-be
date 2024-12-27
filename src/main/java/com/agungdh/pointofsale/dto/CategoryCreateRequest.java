package com.agungdh.pointofsale.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CategoryCreateRequest(
        @NotEmpty
        String name
) {
}
