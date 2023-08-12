package com.controller.rest.utility;

import com.model.utility.SubjectMaster;
import com.services.utility.SubjectMasterServices;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PatchMapping;

@RestController
@CrossOrigin
@RequestMapping("api/Utility/SubjectMaster")
public class SubjectMasterRestController {

    @Autowired
    SubjectMasterServices service;

    @GetMapping
    public Object index(HttpServletRequest request, @RequestHeader(value = "Authorization") String Authorization) {
        return service.getAll(request, Authorization);
    }

    @PostMapping
    public ResponseEntity doSave(@RequestBody SubjectMaster obj, HttpServletRequest request, @RequestHeader(value = "Authorization") String Authorization) throws IOException {
        return service.save(obj, request, Authorization);
    }

    @PutMapping("/{id}")
    public ResponseEntity doUpdate(@RequestBody SubjectMaster obj, @PathVariable Long id, HttpServletRequest request, @RequestHeader(value = "Authorization") String Authorization) throws IOException {
        return service.update(obj, id, request, Authorization);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity doDelete(@PathVariable Long id, HttpServletRequest request, @RequestHeader(value = "Authorization") String Authorization) {
        return service.delete(id, request, Authorization);
    }

    @PatchMapping
    public ResponseEntity thPrMap(@RequestBody SubjectMaster obj, HttpServletRequest request, @RequestHeader(value = "Authorization") String Authorization) {
        return service.mapThPr(obj, request, Authorization);
    }

    @PatchMapping("/{id}")
    public ResponseEntity thPrMap(@PathVariable Long id, HttpServletRequest request, @RequestHeader(value = "Authorization") String Authorization) {
        return service.mapThPr(id, request, Authorization);
    }

    @GetMapping("/PR")
    public ResponseEntity mapThPr(HttpServletRequest request, @RequestHeader(value = "Authorization") String Authorization) {
        return service.mapThPr(request, Authorization);
    }
}
