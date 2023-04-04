package com.example.companyservice.service;

import com.example.companyservice.domain.dto.ApiOutputResult;
import com.example.companyservice.domain.dto.CompanyInput;
import com.example.companyservice.domain.dto.CompanyOutput;
import com.example.companyservice.domain.dto.Etablissement;
import com.example.companyservice.domain.entities.Company;
import com.example.companyservice.domain.mapper.CompanyMapper;
import com.example.companyservice.domain.repository.CompanyRepository;
import com.example.companyservice.domain.response.Header;
import com.example.companyservice.service.client.CompanyFeignClient;
import com.example.companyservice.service.util.CSVExport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CompanyServiceTest {

    @Mock
    private CompanyRepository companyRepository;
    @Mock
    private CompanyFeignClient companyFeignClient;
    @Mock
    private CompanyMapper companyMapper;
    @Mock
    private HttpServletResponse servletResponse;
    @Mock
    private CSVExport csvExport;
    @InjectMocks
    private CompanyService companyService;

    /**
     * Create Company Unit Test
     *
     * @throws Exception
     */
    @Test
    void createCompanyTest() throws Exception {
        CompanyOutput companyOutput = CompanyOutput.builder()
                .id("company_b665de1c-75ef-45b1-b7bf-db5e735b01e8")
                .nic("00014")
                .fullAddress("3 RUE ST FRANCOIS DE PAULE 06300 NICE")
                .fullName("NAFRev2")
                .tvaNumber(1).build();

        CompanyInput companyInput = CompanyInput.builder()
                .nic("00014")
                .fullAddress("3 RUE ST FRANCOIS DE PAULE 06300 NICE")
                .fullName("NAFRev2")
                .tvaNumber(1).build();

        Company company = Company.builder()
                .id("company_b665de1c-75ef-45b1-b7bf-db5e735b01e8")
                .nic("00014")
                .fullAddress("3 RUE ST FRANCOIS DE PAULE 06300 NICE")
                .fullName("NAFRev2")
                .tvaNumber(1).build();

        when(companyRepository.save(any(Company.class))).thenReturn(company);
        when(companyMapper.fromInputToDb(companyInput)).thenReturn(company);
        when(companyMapper.fromDbToOutput(company)).thenReturn(companyOutput);

        CompanyOutput result = companyService.saveCompany(companyInput);

        Assertions.assertEquals(result.getId(), company.getId());
        Assertions.assertEquals(result.getNic(), company.getNic());
        Assertions.assertEquals(result.getFullName(), company.getFullName());
    }

    /**
     * Get All Companies Unit Test
     *
     * @throws Exception
     */
    @Test
    void getAllCompaniesTest() throws Exception {

        List<Company> companies = new ArrayList<>();
        companies.add(new Company("company_0b23a643-2475-437a-a646-2b3ee0ee48c0", "nic3", "company adress3", "30/11/1997", "company3", 3));
        companies.add(new Company("company_079be237-62f6-4b6a-a818-44c8ce7b3c17", "nic2", "company adress2", "20/12/2000", "company2", 2));

        List<CompanyOutput> expected = new ArrayList<>();
        expected.add(new CompanyOutput("company_0b23a643-2475-437a-a646-2b3ee0ee48c0", "nic3", "company adress3", "30/11/1997", "company3", 3));
        expected.add(new CompanyOutput("company_079be237-62f6-4b6a-a818-44c8ce7b3c17", "nic2", "company adress2", "20/12/2000", "company2", 2));

        when(companyRepository.findAll()).thenReturn(companies);
        when(companyMapper.fromDbToOutput(companies)).thenReturn(expected);

        List<CompanyOutput> result = companyService.getAllCompanies();

        Assertions.assertEquals(companies.size(), result.size());
    }
}
