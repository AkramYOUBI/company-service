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
    //siret
    private String id;
    private String nic;
    //Object()
    private String fullAddress;
    private Date creationDate;
    private String fullName;
    private Integer tvaNumber;

    /*
    This method is used to:
        1-Generate the Id in a random format like "company_12355d1s3d154fs1"
        2-Update the creationDate field with the time when the user created this company
     */
    @PrePersist
    private void onPrePersiste(){
        if(this.getId() == null){
            this.setId("company_"+UUID.randomUUID().toString());
        }
        this.setCreationDate(new Date());
    }
}
