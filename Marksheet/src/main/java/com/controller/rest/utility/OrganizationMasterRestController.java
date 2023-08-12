package com.controller.rest.utility;

import com.model.utility.OrganizationMaster;
import com.services.utility.OrganizationMasterServices;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("api/Utility/OrganizationMaster")
public class OrganizationMasterRestController {

    @Autowired
    OrganizationMasterServices service;

    @GetMapping
    public Object index(HttpServletRequest request, @RequestHeader(value = "Authorization") String Authorization) {

        return service.getAll(request, Authorization);
    }

    @PostMapping
    public ResponseEntity doSave(@RequestBody OrganizationMaster obj, HttpServletRequest request, @RequestHeader(value = "Authorization") String Authorization) throws IOException {
        return service.save(obj, request, Authorization);
    }

    @PostMapping("/Logo")
    public Object doLogo(HttpServletRequest request, @RequestParam MultipartFile logo, @RequestHeader(value = "Authorization") String Authorization) throws IOException {
        return service.logo(request, logo, Authorization);
    }
}
