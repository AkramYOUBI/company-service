package com.example.companyservice.service;

import com.example.companyservice.domain.Dto.CompanyInput;
import com.example.companyservice.domain.Dto.CompanyOutput;
import com.example.companyservice.domain.entities.Company;
import com.example.companyservice.domain.mapper.CompanyMapper;
import com.example.companyservice.domain.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public CompanyService(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
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

    public List<CompanyOutput> findBySiret(String siret) {
        return null;
    }
}
