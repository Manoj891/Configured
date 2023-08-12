package com.services.utility;

import com.model.utility.SubjectMaster;
import com.repository.utility.SubjectMasterRepository;
import com.config.JWTToken;
import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;

@Service
public class SubjectMasterServicesImp implements SubjectMasterServices {

    @Autowired
    SubjectMasterRepository repository;

    @Override
    public Object getAll(HttpServletRequest request, String Authorization) {
        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("Invalid Authorization");
        }
        return repository.findSchool(td.getBranch());
    }

    @Override
    public ResponseEntity save(SubjectMaster obj, HttpServletRequest request, String Authorization) {
        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("Invalid Authorization");
        }
        String msg = "";
        try {
            obj.setId(repository.findNextId());
            obj.setSchool(Long.parseLong(td.getBranch()));
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
    public ResponseEntity update(SubjectMaster obj, Long id, HttpServletRequest request, String Authorization) {

        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("Invalid Authorization");
        }
        String msg = "";
        try {
            obj.setId(id);
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
    public ResponseEntity delete(Long id, HttpServletRequest request, String Authorization) {
        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("Invalid Authorization");
        }
        String msg = "";
        try {
            repository.deleteById(id);
            return message.respondWithMessage("Success");
        } catch (DataIntegrityViolationException e) {
            msg = message.exceptionMsg(e);
        } catch (Exception e) {
            msg = e.getMessage().toLowerCase();
        }
        if (msg.contains("foreign key")) {
            msg = "It has been used in another place,you cannot delete!!";
        }
        return message.respondWithError(msg);
    }

    @Override
    public ResponseEntity mapThPr(SubjectMaster obj, HttpServletRequest request, String Authorization) {
        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("Invalid Authorization");
        }
        repository.updatePR(obj.getPrSubject(), obj.getId(), td.getBranch());
        return message.respondWithMessage("Success");
    }

    @Override
    public ResponseEntity mapThPr(Long id, HttpServletRequest request, String Authorization) {
        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("Invalid Authorization");
        }
        repository.updatePR(0l, id, td.getBranch());
        return message.respondWithMessage("Success");
    }

    @Override
    public ResponseEntity mapThPr(HttpServletRequest request, String Authorization) {
        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("Invalid Authorization");
        }
//        obj.setSchool(Long.parseLong(td.getBranch()));
        return ResponseEntity.ok(repository.findPRSubject(td.getBranch()));
    }
}
