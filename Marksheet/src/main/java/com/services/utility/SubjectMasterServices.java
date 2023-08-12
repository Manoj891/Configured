package com.services.utility;

import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import com.model.utility.SubjectMaster;

public interface SubjectMasterServices {

    public Object getAll(HttpServletRequest request, String Authorization);

    public ResponseEntity save(SubjectMaster obj, HttpServletRequest request, String Authorization);

    public ResponseEntity update(SubjectMaster obj, Long id, HttpServletRequest request, String Authorization);

    public ResponseEntity delete(Long id, HttpServletRequest request, String Authorization);

    public ResponseEntity mapThPr(SubjectMaster obj, HttpServletRequest request, String Authorization);

    public ResponseEntity mapThPr(Long obj, HttpServletRequest request, String Authorization);

    public ResponseEntity mapThPr(HttpServletRequest request, String Authorization);
}
