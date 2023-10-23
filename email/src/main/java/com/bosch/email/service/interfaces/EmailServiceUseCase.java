package com.bosch.email.service.interfaces;

import com.bosch.email.models.EmailModel;
import org.springframework.stereotype.Service;

@Service
public interface EmailServiceUseCase {
    void sendEmail(EmailModel emailModel);
}
