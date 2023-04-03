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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CompanyServiceTest {

    @Mock
    private CompanyRepository companyRepository;
    @Mock
    private CompanyFeignClient companyFeignClient;
    @Mock
    private CompanyMapper companyMapper;
    @InjectMocks
    private CompanyService companyService;

    /**
     * Create Company Unit Test
     *
     * @throws Exception
     */
    @Test
    void createCompanyTest() throws Exception {
        CompanyOutput companyOutput =CompanyOutput.builder()
                .id("company_b665de1c-75ef-45b1-b7bf-db5e735b01e8")
                .nic("00014")
                .fullAddress("3 RUE ST FRANCOIS DE PAULE 06300 NICE")
                .fullName("NAFRev2")
                .tvaNumber(1).build();

        CompanyInput companyInput =CompanyInput.builder()
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

    /**
     * Get Company by Siret Unit Test
     *
     * @throws Exception
     */
    /*@Test
    void getCompanyBySiretTest() throws Exception {
        String token = "Bearer f09cd19a-26f5-3976-a7f0-7a26fa2b9711";
        String siret = "97080195700014";
        CompanyOutput companyOutput =CompanyOutput.builder()
                .id("97080195700014")
                .nic("00014")
                .creationDate("1970-01-01")
                .fullAddress("3 RUE ST FRANCOIS DE PAULE 06300 NICE")
                .fullName("NAFRev2")
                .tvaNumber(null).build();
        Header header = Header.builder()
                .statut("200")
                .message("ok")
                .build();
        Etablissement etablissement = Etablissement.builder()
                .siren("970801957")
                .nic("00014")
                .siret("siret")
                .statutDiffusionEtablissement("0")
                .dateCreationEtablissement("1970-01-01")
                .trancheEffectifsEtablissement("trancheEffectifsEtablissement")
                .build();
        ApiOutputResult apiOutputResult = ApiOutputResult.builder()
                .header(header)
                .etablissement(etablissement)
                .build();

        when(companyFeignClient.findBySiret(siret, token)).thenReturn(apiOutputResult);
        when(companyMapper.fromApiResponseToCompanyOutput(apiOutputResult)).thenReturn(companyOutput);

        CompanyOutput result = companyService.findCompanyBySiret(siret);

        assertEquals(companyOutput, result);
    }*/

}
