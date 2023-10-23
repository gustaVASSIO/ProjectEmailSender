package com.bosch.email.repository;

import com.bosch.email.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailModel, String> {
}
