package com.bsf.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UserDTO(
        UUID userId,
        @NotNull @NotBlank String name,
        @NotNull @NotBlank @Email String email
) {
}
