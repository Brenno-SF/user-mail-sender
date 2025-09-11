package com.bsf.email.dto;

import java.util.UUID;

public record EmailDto(
        UUID emailId,
        UUID userId,
        String emailFrom,
        String emailTo,
        String subject,
        String body
) {
}
