package com.example.part2.services;

import com.example.part2.model.Insured;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsuredService {
    List<Insured> insureds = new ArrayList<>();

    public List<Insured> addInsured(Insured insured) {
        insureds.add(insured);
        return insureds;
    }

    public List<Insured> getInsureds() {
        return insureds;
    }
}
