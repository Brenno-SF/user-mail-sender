package com.bsf.email.dto;

import java.util.UUID;

public record EmailDTO(
        UUID emailId,
        UUID userId,
        String emailFrom,
        String emailTo,
        String subject,
        String body
) {
}
