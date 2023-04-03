package com.example.companyservice.service;

import com.example.companyservice.domain.dto.ApiOutputResult;
import com.example.companyservice.domain.dto.CompanyInput;
import com.example.companyservice.domain.dto.CompanyOutput;
import com.example.companyservice.domain.entities.Company;
import com.example.companyservice.domain.mapper.CompanyMapper;
import com.example.companyservice.domain.repository.CompanyRepository;
import com.example.companyservice.service.client.CompanyFeignClient;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class CompanyService {

    public static final String token = "f09cd19a-26f5-3976-a7f0-7a26fa2b9711";
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final CompanyFeignClient companyFeignClient;
    private static final Logger log = Logger.getLogger(CompanyService.class);

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

    public CompanyOutput findCompanyBySiret(String siret, HttpServletResponse servletResponse) {
        CompanyOutput target = new CompanyOutput();
        String authorizationHeader = "Bearer " + token;
        ApiOutputResult apiOutputResult = companyFeignClient.findBySiret(siret, authorizationHeader);
        CompanyOutput companyOutput = companyMapper.fromApiResponseToCompanyOutput(apiOutputResult, target);
        writeEmployeesToCsv(servletResponse, companyOutput);
        return companyOutput;
    }
    public void writeEmployeesToCsv(HttpServletResponse servletResponse, CompanyOutput companyOutput) {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"company.csv\"");
        try (CSVPrinter csvPrinter = new CSVPrinter(servletResponse.getWriter(), CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("ID", "nic", "fullAddress","creationDate","fullName","tvaNumber");
            csvPrinter.printRecord(companyOutput.getId(), companyOutput.getNic(), companyOutput.getFullAddress(), companyOutput.getCreationDate(), companyOutput.getFullName(), companyOutput.getTvaNumber());
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }
}
