package com.example.companyservice.domain.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
