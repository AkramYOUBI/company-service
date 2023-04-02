package com.example.companyservice.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CompanyInput {
    private String nic;
    private String fullAddress;
    private String fullName;
    private Integer tvaNumber;
}
