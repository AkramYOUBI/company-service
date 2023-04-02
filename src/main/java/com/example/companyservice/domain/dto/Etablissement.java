package com.example.companyservice.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Etablissement {
        private String siren;
        private String nic;
        private String siret;
        private String statutDiffusionEtablissement;
        private String dateCreationEtablissement;
        private String trancheEffectifsEtablissement;
        private String anneeEffectifsEtablissement;
        private String activitePrincipaleRegistreMetiersEtablissement;
        private String dateDernierTraitementEtablissement;
        private String etablissementSiege;
        private String nombrePeriodesEtablissement;
        private UniteLegale uniteLegale;
        private AdresseEtablissement adresseEtablissement;
        private List<PeriodesEtablissement> periodesEtablissement;
}
