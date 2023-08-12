package com.services.utility;

import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import com.model.utility.GradeShett;

public interface GradeShettServices {

    public Object getAll(Long id, HttpServletRequest request, String Authorization);

    public ResponseEntity save(GradeShett obj, HttpServletRequest request, String Authorization);

    public ResponseEntity update(GradeShett obj, Long id, HttpServletRequest request, String Authorization);

    public ResponseEntity delete(Long id, HttpServletRequest request, String Authorization);

    public ResponseEntity updateAll(GradeShett obj, Long id, HttpServletRequest request, String Authorization);

    public ResponseEntity delete(Long id, Long subjectId, HttpServletRequest request, String Authorization);

}
