package com.controller.form.utility;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@ComponentScan
public class GradeShettController {

    @RequestMapping(value = "Utility/GradeShett", method = RequestMethod.GET)
    public String doGet() {
        return "Utility/GradeShett";
    }

    @RequestMapping(value = "Utility/MarksheetPrint", method = RequestMethod.GET)
    public String marksheetPrint() {
        return "Utility/MarksheetPrint";
    }

    @RequestMapping(value = "Utility/MarkEntry", method = RequestMethod.GET)
    public String markEntry() {
        return "Utility/MarkEntry";
    }

    @RequestMapping(value = "Utility/MarkEntryEdit", method = RequestMethod.GET)
    public String markEntryEdit() {
        return "Utility/MarkEntryEdit";
    }

    @RequestMapping(value = "Utility/ThPRMap", method = RequestMethod.GET)
    public String thPRMap() {
        return "Utility/ThPRMap";
    }

    @RequestMapping(value = "Utility/GenerateGrade", method = RequestMethod.GET)
    public String generateGrade() {
        return "Utility/GenerateGrade";
    }

}
