package com.example.companyservice.service;

import com.example.companyservice.domain.dto.ApiOutputResult;
import com.example.companyservice.domain.dto.CompanyInput;
import com.example.companyservice.domain.dto.CompanyOutput;
import com.example.companyservice.domain.entities.Company;
import com.example.companyservice.domain.mapper.CompanyMapper;
import com.example.companyservice.domain.repository.CompanyRepository;
import com.example.companyservice.service.client.CompanyFeignClient;
import com.example.companyservice.service.util.CSVExport;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class CompanyService {

    private static final Logger log = Logger.getLogger(CompanyService.class);

    @Value("${siret.api.token}")
    private String token;

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final CompanyFeignClient companyFeignClient;

    public CompanyService(CompanyRepository companyRepository, CompanyMapper companyMapper, CompanyFeignClient companyFeignClient) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
        this.companyFeignClient = companyFeignClient;
    }

    public CompanyOutput saveCompany(CompanyInput companyInput) {
        try {
            Company companydb = companyMapper.fromInputToDb(companyInput);
            Company result = companyRepository.save(companydb);
            CompanyOutput companyOutput = companyMapper.fromDbToOutput(result);
            return companyOutput;
        } catch (Exception e) {
            System.err.println("An error occurred while saving the company: " + e.getMessage());
            throw new RuntimeException("Failed to save company");
        }
    }


    public List<CompanyOutput> getAllCompanies() {
        try {
            List<Company> companiesList = companyRepository.findAll();
            List<CompanyOutput> companiesOutput = companyMapper.fromDbToOutput(companiesList);
            return companiesOutput;
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve companies", e);
        }
    }


    public CompanyOutput findCompanyBySiret(String siret, HttpServletResponse servletResponse) {
        if (siret == null || siret.isEmpty()) {
            throw new IllegalArgumentException("Siret argument cannot be null or empty");
        }

        try {
            CompanyOutput target = new CompanyOutput();
            String authorizationHeader = "Bearer " + token;
            ApiOutputResult apiOutputResult = companyFeignClient.findBySiret(siret, authorizationHeader);
            CompanyOutput companyOutput = companyMapper.fromApiResponseToCompanyOutput(apiOutputResult, target);
            CSVExport.writeToCsv(servletResponse, companyOutput);
            return companyOutput;
        } catch (Exception e) {
            throw new RuntimeException("Failed to find company by siret", e);
        }
    }


}
