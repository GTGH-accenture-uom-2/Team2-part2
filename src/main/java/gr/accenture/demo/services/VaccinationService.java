package gr.accenture.demo.services;

import gr.accenture.demo.models.Insured;
import gr.accenture.demo.models.Vaccination;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinationService {

    List<Vaccination> vaccination;
    public List<Vaccination> getInfoOfVacc(){
        return vaccination;
    }
}
