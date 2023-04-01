package com.example.companyservice.domain.Dto;

import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
public class CompanyInput {
    private String nic;
    private String fullAddress;
    private String fullName;
    private Integer tvaNumber;
}
