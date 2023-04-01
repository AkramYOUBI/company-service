package com.example.companyservice.domain.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class AdresseEtablissement {
        private String complementAdresseEtablissement;
        private String numeroVoieEtablissement;
        private String indiceRepetitionEtablissement;
        private String typeVoieEtablissement;
        private String libelleVoieEtablissement;
        private String codePostalEtablissement;
        private String libelleCommuneEtablissement;
        private String libelleCommuneEtrangerEtablissement;
        private String distributionSpecialeEtablissement;
        private String codeCommuneEtablissement;
        private String codeCedexEtablissement;
        private String libelleCedexEtablissement;
        private String codePaysEtrangerEtablissement;
        private String libellePaysEtrangerEtablissement;
}
