
package com.services.utility;

import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import com.model.utility.GradingSystem ;

public interface GradingSystemServices {

    public Object getAll(HttpServletRequest request,String Authorization);

    public ResponseEntity save(GradingSystem obj, HttpServletRequest request,String Authorization);

    public ResponseEntity update(GradingSystem obj,Long id,HttpServletRequest request, String Authorization);

    public ResponseEntity delete(Long id,HttpServletRequest request,String Authorization);

}
