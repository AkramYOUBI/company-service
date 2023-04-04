package com.example.companyservice.web;

import com.example.companyservice.domain.dto.CompanyInput;
import com.example.companyservice.domain.dto.CompanyOutput;
import com.example.companyservice.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("api/company")
public class CompanyController {

    /**
     * Company Service
     */
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    /**
     * Save a Company
     * @return List of CompanyOutput
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyOutput saveCompany(@RequestBody CompanyInput companyInput){
        return companyService.saveCompany(companyInput);
    }
    /**
     * Get all Companies
     * @return List of CompanyOutput
     */
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<CompanyOutput> getAllCompanies(){
        return companyService.getAllCompanies();
    }
    /**
     * Get Company by Siret
     * @return CompanyOutput
     */
    @GetMapping("/findBySiret/{siret}")
    @ResponseStatus(HttpStatus.OK)
    public CompanyOutput findCompanyBySiret(@PathVariable String siret, HttpServletResponse servletResponse){
        return companyService.findCompanyBySiret(siret, servletResponse);
    }
}
