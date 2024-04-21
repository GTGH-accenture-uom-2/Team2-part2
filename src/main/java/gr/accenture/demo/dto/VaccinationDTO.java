package gr.accenture.demo.dto;

public class VaccinationDTO {
    private String expirationDate;

    public VaccinationDTO(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
