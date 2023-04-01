package com.example.companyservice.web;

import com.example.companyservice.domain.Dto.CompanyInput;
import com.example.companyservice.domain.Dto.CompanyOutput;
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
    private CompanyOutput saveCompany(@RequestBody CompanyInput companyInput){
        return companyService.saveCompany(companyInput);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    private List<CompanyOutput> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping("/findBySiret/{siret}")
    @ResponseStatus(HttpStatus.OK)
    private CompanyOutput findCompany(@PathVariable String siret){
        return companyService.findBySiret(siret);
    }
}
