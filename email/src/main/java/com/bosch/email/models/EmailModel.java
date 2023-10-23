package com.bosch.email.models;

import com.bosch.email.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "emails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailModel {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;
    private String userId;
    private String emailFrom;
    @Column(name = "email_to")
    private String to;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;

}