package com.example.companyservice.domain.dto;

import com.example.companyservice.domain.response.Header;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiOutputResult {
    private Header header;
    private Etablissement etablissement;
}
