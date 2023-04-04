package com.example.companyservice.controller;


import com.example.companyservice.domain.dto.CompanyInput;
import com.example.companyservice.domain.dto.CompanyOutput;
import com.example.companyservice.domain.entities.Company;
import com.example.companyservice.service.CompanyService;
import com.example.companyservice.web.CompanyController;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {

    @Mock
    private CompanyService companyService;

    @InjectMocks
    private CompanyController companyController;

    /**
     * Create Company Unit Test
     *
     * @throws Exception
     */
    @Test
    void saveCompany() throws Exception {
        CompanyInput companyInput =CompanyInput.builder()
                .nic("00014")
                .fullAddress("3 RUE ST FRANCOIS DE PAULE 06300 NICE")
                .fullName("NAFRev2")
                .tvaNumber(1).build();
        CompanyOutput companyOutput =CompanyOutput.builder()
                .id("")
                .nic("00014")
                .fullAddress("3 RUE ST FRANCOIS DE PAULE 06300 NICE")
                .fullName("NAFRev2")
                .tvaNumber(1).build();
        when(companyService.saveCompany(any(CompanyInput.class))).thenReturn(companyOutput);
        CompanyOutput controllerResponse = companyController.saveCompany(companyInput);

        //assertion
        assertEquals(controllerResponse.getNic(), companyOutput.getNic());
        assertEquals(controllerResponse.getFullName(), companyOutput.getFullName());
    }

    /**
     * Get All Companies Unit Test
     *
     * @throws Exception
     */
    @Test
    public void testGetAllCompanies() throws Exception {
        // arrange
        List<Company> companies = new ArrayList<>();
        companies.add(new Company("company_0b23a643-2475-437a-a646-2b3ee0ee48c0", "nic3", "company adress3", "30/11/1997", "company3", 3));
        companies.add(new Company("company_079be237-62f6-4b6a-a818-44c8ce7b3c17", "nic2", "company adress2", "20/12/2000", "company2", 2));

        List<CompanyOutput> expected = new ArrayList<>();
        expected.add(new CompanyOutput("company_0b23a643-2475-437a-a646-2b3ee0ee48c0", "nic3", "company adress3", "30/11/1997", "company3", 3));
        expected.add(new CompanyOutput("company_079be237-62f6-4b6a-a818-44c8ce7b3c17", "nic2", "company adress2", "20/12/2000", "company2", 2));

        when(companyController.getAllCompanies()).thenReturn(expected);

        // act
        List<CompanyOutput> result = companyService.getAllCompanies();

        // assertion
        assertEquals(expected, result);
    }
}
