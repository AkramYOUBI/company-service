package com.example.companyservice.web;

import com.example.companyservice.domain.entities.Company;
import com.example.companyservice.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    private Company saveCompany(@RequestBody Company company){
        return companyService.saveCompany(company);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    private List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }
}
