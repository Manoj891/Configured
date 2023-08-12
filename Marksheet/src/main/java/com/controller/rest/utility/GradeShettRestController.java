package com.controller.rest.utility;

import com.model.utility.GradeShett;
import com.services.utility.GradeShettServices;
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
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
@RequestMapping("api/Utility/GradeShett")
public class GradeShettRestController {

    @Autowired
    GradeShettServices service;
    @GetMapping
    public Object index(@RequestParam(required = false) Long id, HttpServletRequest request, @RequestHeader(value = "Authorization") String Authorization) {

        return service.getAll(id, request, Authorization);
    }

    @PostMapping
    public ResponseEntity doSave(@RequestBody GradeShett obj, HttpServletRequest request, @RequestHeader(value = "Authorization") String Authorization) throws IOException {
        return service.save(obj, request, Authorization);
    }

    @PutMapping("/{id}")
    public ResponseEntity doUpdate(@RequestBody GradeShett obj, @PathVariable Long id, HttpServletRequest request, @RequestHeader(value = "Authorization") String Authorization) throws IOException {
        return service.update(obj, id, request, Authorization);
    }

    @PatchMapping("/{id}")
    public ResponseEntity doUpdateAll(@RequestBody GradeShett obj, @PathVariable Long id, HttpServletRequest request, @RequestHeader(value = "Authorization") String Authorization) throws IOException {
        return service.updateAll(obj, id, request, Authorization);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity doDelete(@PathVariable Long id, HttpServletRequest request, @RequestHeader(value = "Authorization") String Authorization) {
        return service.delete(id, request, Authorization);
    }

    @DeleteMapping("/{id}/{subjectId}")
    public ResponseEntity doDelete(@PathVariable Long id, @PathVariable Long subjectId, HttpServletRequest request, @RequestHeader(value = "Authorization") String Authorization) {
        return service.delete(id, subjectId, request, Authorization);
    }
}
