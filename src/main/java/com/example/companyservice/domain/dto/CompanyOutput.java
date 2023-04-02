package com.example.companyservice.domain.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CompanyOutput {
    private String id;
    private String nic;
    private String fullAddress;
    private String creationDate;
    private String fullName;
    private Integer tvaNumber;
}
