package gr.accenture.demo.dto;

import gr.accenture.demo.models.Vaccination;

public class InsuredDTO {

    private String amka;
    private Vaccination vaccinationCoverage = null;

    public InsuredDTO(String amka, Vaccination vaccinationCoverage) {
        this.amka = amka;
        this.vaccinationCoverage = vaccinationCoverage;
    }


    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        this.amka = amka;
    }

    public Vaccination getVaccinationCoverage() {
        return vaccinationCoverage;
    }

    public void setVaccinationCoverage(Vaccination vaccinationCoverage) {
        this.vaccinationCoverage = vaccinationCoverage;
    }
}
