package com.controller.form.utility;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@ComponentScan
public class SchoolListController {

    @RequestMapping(value = "Utility/SchoolList", method = RequestMethod.GET)
    public String doGet() {
        return "Utility/SchoolList";
    }

    @RequestMapping(value = "Utility/SchoolListAdmin", method = RequestMethod.GET)
    public String schoolListAdmin() {
        return "Utility/SchoolListAdmin";
    }
    
    
    @RequestMapping(value = "MobileApp", method = RequestMethod.GET)
    public String mobileApp() {
        return "MobileApp";
    }
}
