package gr.accenture.demo.controllers;


import com.google.zxing.WriterException;
import gr.accenture.demo.dto.InsuredDTO;
import gr.accenture.demo.dto.VaccinationDTO;
import gr.accenture.demo.models.*;
import gr.accenture.demo.services.InsuredService;
import gr.accenture.demo.services.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

@RestController
@RequestMapping("/insured")
public class InsuredController {

    @Autowired
    InsuredService insuredService;
    VaccinationService vaccinationService;

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/img/QRCode.png";


    //######################################### MAZI ME VACC ##################################
    @GetMapping("/vaccinationcoverage/{amka}")
//    @ResponseBody
    public Vaccination getInfoOfInsured(@PathVariable String amka){

       // VaccinationDTO vaccination = new VaccinationDTO(String amka);
        for(Insured insured: insuredService.getInfoOfInsured()) {
            //for (Vaccination vacc : vaccinationService.getInfoOfVacc()) {
                // VaccinationDTO vaccination = null;
                if (Objects.equals(insured.getAmka(), amka)) //&& vacc.getInsured().getAmka() == insured.getAmka())
                    if (insured.getVaccinationCoverage() != null) {

                        byte[] image = new byte[0];
                        try {

                            // Generate and Return Qr Code in Byte Array
                            image = QRCodeGenerator.getQRCodeImage("/vaccinationcoverage/"+amka+"/qrcode",250,250);

                            // Generate and Save Qr Code Image in static/image folder
                            QRCodeGenerator.generateQRCodeImage("/vaccinationcoverage/"+amka+"/qrcode",250,250, QR_CODE_IMAGE_PATH);

                        } catch (WriterException | IOException e) {
                            e.printStackTrace();
                        }
                        // Convert Byte Array into Base64 Encode String
                        String qrcode = Base64.getEncoder().encodeToString(image);


                        return insured.getVaccinationCoverage();
//                        return ((new InsuredDTO(insured.getAmka(), insured.getVaccinationCoverage())) (vacc.getExpirationDate()));
//                        return s;
                    } else
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This insured with AMKA: " +amka+", hasn't vaccinated yet");

            }
        //}

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error! This insured with AMKA: " +amka+", doesn't exists!");

    }



    //######################################### XORIS TO QRCODE ##################################
/*    @GetMapping("/vaccinationcoverage/{amka}")
    //@ResponseBody
    public InsuredDTO getInfoOfInsured(@PathVariable String amka){

        for(Insured insured: insuredService.getInfoOfInsured()){
            if(Objects.equals(insured.getAmka(), amka))
                if(insured.getVaccinationCoverage() != null )
                    return (new InsuredDTO(insured.getAmka(), insured.getVaccinationCoverage()));
                else
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error! This insured with AMKA: " +amka+", hasn't vaccinated yet!");

        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error! This insured with AMKA: " +amka+", doesn't exists!");

    }*/



    //######################################### ME TO QRCODE ##################################
  /*  @GetMapping("/vaccinationcoverage/{amka}/qrcode")
    //@ResponseBody
    public InsuredDTO getQrOfInsured(@PathVariable String amka){

        for(Insured insured: insuredService.getQrOfInsured()){
            if(Objects.equals(insured.getAmka(), amka))
                if(insured.getVaccinationCoverage() != null ){

                    byte[] image = new byte[0];
                    try {

                        // Generate and Return Qr Code in Byte Array
                        image = QRCodeGenerator.getQRCodeImage("/vaccinationcoverage/"+amka+"/qrcode",250,250);

                        // Generate and Save Qr Code Image in static/image folder
                        QRCodeGenerator.generateQRCodeImage("/vaccinationcoverage/"+amka+"/qrcode",250,250, QR_CODE_IMAGE_PATH);

                    } catch (WriterException | IOException e) {
                        e.printStackTrace();
                    }
                    // Convert Byte Array into Base64 Encode String
                    String qrcode = Base64.getEncoder().encodeToString(image);

                    return (new InsuredDTO(insured.getAmka(), insured.getVaccinationCoverage()));
                }
                else
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error! This insured with AMKA: " +amka+", hasn't vaccinated yet!");

        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error! This insured with AMKA: " +amka+", doesn't exists!");
        //return insuredService.getInfoOfInsured(amka);
    }




    //######################################### EXP DAY ##################################
    @GetMapping("/vaccinationcoverage/{amka}/expday")
    //@ResponseBody
    public VaccinationDTO getExpDayInfoOfInsured(@PathVariable String amka){

        for(Insured insured: insuredService.getInfoOfInsured()) {
            for (Vaccination vacc : vaccinationService.getInfoOfVacc()) {
                if (Objects.equals(insured.getAmka(), amka) && Objects.equals(vacc.getInsured().getAmka(), insured.getAmka())) {
                    if (insured.getVaccinationCoverage() != null) {
                        return new VaccinationDTO(vacc.getExpirationDate());
                    } else
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error! This insured with AMKA: " + amka + ", hasn't vaccinated yet!");
                }

            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error! This insured with AMKA: " +amka+", doesn't exists!");
    }

*/


}
