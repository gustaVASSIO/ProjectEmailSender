package com.bosch.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class EmailDTO {
    private String userId;
    private String to;
    private String subject;
    private String text;
}
