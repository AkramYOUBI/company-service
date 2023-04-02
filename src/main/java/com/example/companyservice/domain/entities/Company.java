package com.example.companyservice.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Company {
    @Id
    private String id;
    private String nic;
    private String fullAddress;
    private String creationDate;
    private String fullName;
    private Integer tvaNumber;

    /*
    This method is used to generate the Id in a random format like "company_12355d1s3d154fs1" in case the Post API
     */
    @PrePersist
    private void onPrePersiste(){
        if(this.getId() == null){
            this.setId("company_"+UUID.randomUUID().toString());
        }
    }
}
