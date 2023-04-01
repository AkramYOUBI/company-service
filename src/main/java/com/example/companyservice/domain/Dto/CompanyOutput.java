package com.example.companyservice.domain.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;


@RequiredArgsConstructor
@Getter
@Setter
public class CompanyOutput {
    private String id;
    private String nic;
    private String fullAddress;
    private Date creationDate;
    private String fullName;
    private Integer tvaNumber;
}
