package com.controller.rest.utility;

import com.config.JWTToken;
import com.model.utility.SchoolList;
import com.repository.utility.SchoolListRepository;
import java.util.List;
import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("api/Utility/SchoolList")
public class SchoolListRestController {

    @Autowired
    SchoolListRepository repository;

    @GetMapping
    public Object index() {
        List<SchoolList> list = repository.findAllActive();
        SchoolList obj;
        String logo, schoolRegistrationCertificate, panRegistrationCertificate, taxClearanceCertificate;
        for (int i = 0; i < list.size(); i++) {
            obj = list.get(i);
            logo = obj.getSchoolLogo();
            if (logo.contains("Organization/Logo.png")) {
                logo = logo.replace("Organization/Logo.png", "");
                schoolRegistrationCertificate = logo + "Organization/SchoolRegistrationCertificate.png";
                panRegistrationCertificate = logo + "Organization/PanRegistrationCertificate.png";
                taxClearanceCertificate = logo + "Organization/TaxClearanceCertificate.png";
                obj.setSchoolRegistrationCertificate(schoolRegistrationCertificate);
                obj.setTaxClearanceCertificate(taxClearanceCertificate);
                obj.setPanRegistrationCertificate(panRegistrationCertificate);
                list.remove(i);
                list.add(i, obj);
            }
        }
        return list;
    }

    @PostMapping
    public Object doSave(@RequestBody SchoolList obj, @RequestHeader(value = "Authorization") String Authorization) {
        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("Invalid Authorization");
        }
        if (!td.getUserName().equalsIgnoreCase("ADMIN")) {
            return message.respondWithError("Invalid Authorization");
        }
        String msg = "";
        try {
            repository.save(obj);
            return message.respondWithMessage("Success");
        } catch (DataIntegrityViolationException e) {
            msg = message.exceptionMsg(e);
        } catch (Exception e) {
            msg = e.getMessage().toLowerCase();
        }
        if (msg.contains("primary") || msg.contains("duplicate entry")) {
            msg = "Record Alredy Exist";
        }
        return message.respondWithError(msg);

    }

}
