
package com.services.utility;

import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import com.model.utility.OrganizationUser ;

public interface OrganizationUserServices {

    public Object getAll(HttpServletRequest request,String Authorization);

    public ResponseEntity save(OrganizationUser obj, HttpServletRequest request,String Authorization);

    public ResponseEntity update(OrganizationUser obj,Long id,HttpServletRequest request, String Authorization);

    public ResponseEntity delete(Long id,HttpServletRequest request,String Authorization);

}
