package com.example.companyservice.domain.dto;

import com.example.companyservice.domain.response.Header;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ApiOutputResult {
    private Header header;
    private Etablissement etablissement;
}
