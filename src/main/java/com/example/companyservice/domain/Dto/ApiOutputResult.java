package com.example.companyservice.domain.Dto;

import com.example.companyservice.domain.Response.Header;
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
