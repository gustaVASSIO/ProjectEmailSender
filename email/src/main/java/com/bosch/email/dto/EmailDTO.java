package com.bosch.email.dto;

public record EmailDTO(
        String userId,
        String to,
        String subject,
        String text
) {
}
