package com.bsf.user.dto;

import java.util.UUID;

public record EmailDTO(
        UUID userId,
        String emailTo,
        String subject,
        String body
) {
}
