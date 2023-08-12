package com.services.utility;

import com.model.utility.OrganizationMaster;
import com.repository.utility.OrganizationMasterRepository;
import com.config.JWTToken;
import java.io.File;
import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.multipart.MultipartFile;

@Service
public class OrganizationMasterServicesImp implements OrganizationMasterServices {
    
    @Autowired
    OrganizationMasterRepository repository;
    
    @Override
    public Object getAll(HttpServletRequest request, String Authorization) {
        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("Invalid Authorization");
        }
        return repository.findBySchoolCode(td.getBranch());
    }
    
    @Override
    public ResponseEntity save(OrganizationMaster obj, HttpServletRequest request, String Authorization) {
        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("Invalid Authorization");
        }
        String msg = "";
        try {
            obj.setId(Long.parseLong(td.getBranch()));
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
    
    @Override
    public Object logo(HttpServletRequest request, MultipartFile logo, String Authorization) {
        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("Invalid Authorization");
        }
        try {
            if (logo.getSize() < 100) {
                return message.respondWithError("Please provide file");
            }
            
            File f = new File("");
            String location = f.getAbsolutePath();
            location = location.replace("\\", "/");
            if (location.lastIndexOf("/bin") > 10) {
                location = location.substring(0, location.lastIndexOf("/bin")) + "/webapps" + request.getContextPath() + "Document";
            }
            f = new File(location + "/Organization");
            try {
                if (!f.exists()) {
                    f.mkdirs();
                }
            } catch (Exception e) {
                return message.respondWithError(e.getMessage());
            }
            f = new File(location + "/Organization/Logo-" + td.getBranch() + ".png");
            try {
                if (f.exists()) {
                    f.deleteOnExit();
                }
            } catch (Exception e) {
            }
             f = new File(location + "/Organization/Logo-" + td.getBranch() + ".png");
            System.out.println(f.getAbsolutePath());
            logo.transferTo(f);
            OrganizationMaster master = repository.findById(Long.parseLong(td.getBranch())).get();
            master.setLogo("Organization/Logo-" + td.getBranch() + ".png");
            repository.save(master);
            return message.respondWithMessage("Success");
        } catch (Exception e) {
            return message.respondWithError(e.getMessage());
        }
    }
    
}
