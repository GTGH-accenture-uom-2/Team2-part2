package gr.accenture.demo.services;

import gr.accenture.demo.models.Insured;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class InsuredService {

    List<Insured> insured;
    public List<Insured> getInfoOfInsured(){
        return insured;
    }

    public List<Insured> getQrOfInsured(){
        return insured;
    }





}
