package com.example.companyservice.service;

import com.example.companyservice.domain.Dto.ApiOutputResult;
import com.example.companyservice.domain.Dto.CompanyInput;
import com.example.companyservice.domain.Dto.CompanyOutput;
import com.example.companyservice.domain.entities.Company;
import com.example.companyservice.domain.mapper.CompanyMapper;
import com.example.companyservice.domain.repository.CompanyRepository;
import com.example.companyservice.service.client.CompanyFeignClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    public static final String token = "f09cd19a-26f5-3976-a7f0-7a26fa2b9711";
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final CompanyFeignClient companyFeignClient;

    public CompanyService(CompanyRepository companyRepository, CompanyMapper companyMapper, CompanyFeignClient companyFeignClient) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
        this.companyFeignClient = companyFeignClient;
    }

    public CompanyOutput saveCompany(CompanyInput companyInput) {
        Company companydb = companyMapper.fromInputToDb(companyInput);
        Company result = companyRepository.save(companydb);
        CompanyOutput companyOutput = companyMapper.fromDbToOutput(result);
        return companyOutput;
    }

    public List<CompanyOutput> getAllCompanies() {
        List<Company> companiesList = companyRepository.findAll();
        List<CompanyOutput> companiesOutput = companyMapper.fromDbToOutput(companiesList);
        return companiesOutput;
    }

    public CompanyOutput findBySiret(String siret) {
        String authorizationHeader = "Bearer " + token;
        ApiOutputResult apiOutputResult = companyFeignClient.findBySiret(siret, authorizationHeader);
        CompanyOutput companyOutput = companyMapper.fromApiResponseToCompanyOutput(apiOutputResult);
        return companyOutput;
    }
}
