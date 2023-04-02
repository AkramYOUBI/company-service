package com.example.companyservice.domain.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Header {
    private String statut;
    private String message;
}
