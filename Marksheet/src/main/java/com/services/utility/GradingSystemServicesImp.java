package com.services.utility;

import com.model.utility.GradingSystem;
import com.repository.utility.GradingSystemRepository;
import com.config.JWTToken;
import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;

@Service
public class GradingSystemServicesImp implements GradingSystemServices{
@Autowired
GradingSystemRepository repository;

    @Override
    public Object getAll(HttpServletRequest request, String Authorization) {
        return repository.findAll();
    }

    @Override
    public ResponseEntity save(GradingSystem obj, HttpServletRequest request, String Authorization) {
        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("Invalid Authorization");
        }
        String msg = "";
        try {
            obj.setId(repository.findNextId());
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
    public ResponseEntity update(GradingSystem obj, Long id, HttpServletRequest request, String Authorization) {

        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("Invalid Authorization");
        }
        String msg = "";
        try {
// repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AcademicYear", "id", id));
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
        String msg="";
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
}
