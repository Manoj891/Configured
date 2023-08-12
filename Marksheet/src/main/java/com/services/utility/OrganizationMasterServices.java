
package com.services.utility;

import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import com.model.utility.OrganizationMaster ;
import org.springframework.web.multipart.MultipartFile;

public interface OrganizationMasterServices {

    public Object getAll(HttpServletRequest request,String Authorization);

    public ResponseEntity save(OrganizationMaster obj, HttpServletRequest request,String Authorization);

    public Object logo(HttpServletRequest request, MultipartFile logo, String Authorization);
}
