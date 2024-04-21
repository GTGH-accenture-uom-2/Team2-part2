package gr.accenture.demo.models;

public class Insured {
    private String amka;
    private String name;
    private Vaccination vaccinationCoverage = null;

    public Insured() {
    }

    public Insured(String amka, String name, Vaccination vaccinationCoverage) {
        this.amka = amka;
        this.name = name;
        this.vaccinationCoverage = vaccinationCoverage;
    }

    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        this.amka = amka;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vaccination getVaccinationCoverage() {
        return vaccinationCoverage;
    }

    public void setVaccinationCoverage(Vaccination vaccinationCoverage) {
        this.vaccinationCoverage = vaccinationCoverage;
    }
}
