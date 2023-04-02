package com.example.companyservice.domain.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Header {
    private String statut;
    private String message;
}
