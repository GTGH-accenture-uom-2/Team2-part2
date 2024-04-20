package com.example.part2.controllers;

import com.example.part2.model.Insured;
import com.example.part2.services.InsuredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insured")
public class InsuredController {
    @Autowired
    InsuredService insuredService;

    @PostMapping
    public List<Insured> addInsured(@RequestBody Insured insured) {
        return insuredService.addInsured(insured);
    }
    @GetMapping
    public List<Insured> getInsureds(){
        return insuredService.getInsureds();
    }

}
