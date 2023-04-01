package com.example.companyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompanyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyServiceApplication.class, args);
	}

}
/*
TODO:
	1- OpenFeign for the external API: https://api.insee.fr/catalogue/site/themes/wso2/subthemes/insee/pages/item-info.jag?name=Sirene&version=V3&provider=insee#!/Etablissement/findBySiret
	2- Update all information in the Swagger UI: http://localhost:8080/swagger-ui/index.html#/ && Docx: http://localhost:8080/v3/api-docs/
	3- Extract Data as a CSV File
	4- Docker File
	5- Actuator
	6- Jenkins File
	7- Unit Test + Integration Test
	8- Read Me File
 */