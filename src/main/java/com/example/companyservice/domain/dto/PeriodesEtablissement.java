package com.example.companyservice.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class PeriodesEtablissement {
        private String dateFin;
        private String dateDebut;
        private String etatAdministratifEtablissement;
        private String changementEtatAdministratifEtablissement;
        private String enseigne1Etablissement;
        private String enseigne2Etablissement;
        private String enseigne3Etablissement;
        private String changementEnseigneEtablissement;
        private String denominationUsuelleEtablissement;
        private String changementDenominationUsuelleEtablissement;
        private String activitePrincipaleEtablissement;
        private String nomenclatureActivitePrincipaleEtablissement;
        private String changementActivitePrincipaleEtablissement;
        private String caractereEmployeurEtablissement;
        private String changementCaractereEmployeurEtablissement;
}
