package com.example.companyservice.domain.mapper;

import com.example.companyservice.domain.Dto.ApiOutputResult;
import com.example.companyservice.domain.Dto.CompanyInput;
import com.example.companyservice.domain.Dto.CompanyOutput;
import com.example.companyservice.domain.entities.Company;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    Company fromInputToDb(CompanyInput companyInput);

    CompanyOutput fromDbToOutput(Company result);
    List<CompanyOutput> fromDbToOutput(List<Company> result);

    CompanyOutput fromApiResponseToCompanyOutput(ApiOutputResult apiOutputResult);
}
