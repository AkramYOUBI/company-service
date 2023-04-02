package com.example.companyservice.domain.mapper;

import com.example.companyservice.domain.Dto.ApiOutputResult;
import com.example.companyservice.domain.Dto.CompanyInput;
import com.example.companyservice.domain.Dto.CompanyOutput;
import com.example.companyservice.domain.entities.Company;
import org.hibernate.annotations.Target;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    Company fromInputToDb(CompanyInput companyInput);

    CompanyOutput fromDbToOutput(Company result);
    List<CompanyOutput> fromDbToOutput(List<Company> result);

    CompanyOutput fromApiResponseToCompanyOutput(ApiOutputResult apiOutputResult);

    @AfterMapping
    default CompanyOutput fromApiResponseToCompanyOutput(ApiOutputResult source, @MappingTarget CompanyOutput target){
        if(source != null){

            if(source.getEtablissement().getSiret() != null) target.setId(source.getEtablissement().getSiret());

            if(source.getEtablissement().getNic() != null) target.setNic(source.getEtablissement().getNic());

            if(source.getEtablissement().getDateCreationEtablissement() != null) target.setCreationDate(source.getEtablissement().getDateCreationEtablissement());
            if(source.getEtablissement().getUniteLegale().getNomenclatureActivitePrincipaleUniteLegale() != null) target.setFullName(source.getEtablissement().getUniteLegale().getNomenclatureActivitePrincipaleUniteLegale());

            if(source.getEtablissement().getAdresseEtablissement() != null){
                String numeroVoie = source.getEtablissement().getAdresseEtablissement().getNumeroVoieEtablissement();
                String typeVoie = source.getEtablissement().getAdresseEtablissement().getTypeVoieEtablissement();
                String libelleVoie = source.getEtablissement().getAdresseEtablissement().getLibelleVoieEtablissement();
                String codePostal = source.getEtablissement().getAdresseEtablissement().getCodePostalEtablissement();
                String libelleCommune = source.getEtablissement().getAdresseEtablissement().getLibelleCommuneEtablissement();
                if(source.getEtablissement().getSiret() != null)target.setFullAddress(numeroVoie+" "
                        +typeVoie+" "+libelleVoie+" "+codePostal+" "+libelleCommune);
            }

        }
        return target;
    }
}
