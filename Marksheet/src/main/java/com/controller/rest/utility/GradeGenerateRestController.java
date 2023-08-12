/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.rest.utility;

import com.config.JWTToken;
import com.model.utility.GradeSheetDetailPk;
import com.model.utility.GradeShett;
import com.model.utility.GradeShettDetail;
import com.model.utility.GradingSystem;
import com.model.utility.SubjectMaster;
import com.repository.utility.GradeShettRepository;
import com.repository.utility.GradingSystemRepository;
import com.repository.utility.SubjectMasterRepository;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class GradeGenerateRestController {

    @Autowired
    SubjectMasterRepository subjectMasterRepository;
    @Autowired
    GradeShettRepository repository;
    List<SubjectMaster> masters;
    @Autowired
    GradingSystemRepository systemRepository;
    List<GradingSystem> gradingSystems = new ArrayList<>();
    private final DecimalFormat df = new DecimalFormat("#.##");

    @PutMapping("api/Utility/Grade")
    public ResponseEntity doSave(@RequestHeader(value = "Authorization") String Authorization) {

        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("Invalid Authorization");
        }
        List<Long> prSubject = new ArrayList<>();
        try {
            gradingSystems = systemRepository.findCurrentSystem();
            List<Long> regNos = repository.findAllRegNo();
            masters = subjectMasterRepository.findAll();
            SubjectMaster subjectMaster;

            double prMark;
            /*  for (int i = 0; i < masters.size(); i++) {
                try {
                    if (masters.get(i).getPrSubject() > 0) {
                        subjectMaster = masters.get(i);
                        prSubject.add(subjectMaster.getPrSubject());
                        for (int j = 0; j < regNos.size(); j++) {
                            try {
                                prMark = repository.findPRMark(regNos.get(j), subjectMaster.getPrSubject());
                                repository.updatePRMark(prMark, regNos.get(j), subjectMaster.getId());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }*/
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        List<GradeShett> gradeShetts = repository.findAll();
        GradeShett obj;
        SubjectMaster subject;
        SubjectMaster subjectPr;
        GradingSystem gradingSystem;
        GradingSystem gradingSystemPr;
        List<GradeShettDetail> detail;
        GradeShettDetail detailPr;

        double totalGPA, totalCredithour = 0;

        long id;
        for (int i = 0; i < gradeShetts.size(); i++) {
            obj = gradeShetts.get(i);
//            System.out.println("---" + obj.getRegNo());
//            if (!obj.getRegNo().equalsIgnoreCase("00503251")) {
//                break;
//            }
            detail = obj.getDetail();
            totalGPA = 0;
            totalCredithour = 0;
            id = gradeShetts.get(i).getId();
            for (int j = 0; j < detail.size(); j++) {
                subject = getSubject(detail.get(j).getSubjectId());

                if (subject.getPrSub() > 0) {
                    double temp, temp2;
                    subjectPr = getSubject(subject.getPrSub());
                    gradingSystem = findGrading(detail.get(j).getThObtain(), subject.getThFm());

                    detail.get(j).setGeadeTh(gradingSystem.getGrade());
                    totalGPA += (gradingSystem.getGpa() * subject.getCreditHour());
                    totalCredithour = totalCredithour + subject.getCreditHour();
                    detail.get(j).setGeadePoint(gradingSystem.getGpa().toString());
                    detailPr = getPrMark(detail, subjectPr.getId());
                    gradingSystemPr = findGrading(detailPr.getPrObtain(), subjectPr.getPrFm());
                    temp = (Double.parseDouble(df.format(gradingSystemPr.getGpa())) * Double.parseDouble(df.format(subjectPr.getCreditHour()))) + (Double.parseDouble(df.format(gradingSystem.getGpa())) * Double.parseDouble(df.format(subject.getCreditHour())));
                    temp2 = Double.parseDouble(df.format(subjectPr.getCreditHour())) + Double.parseDouble(df.format(subject.getCreditHour()));

                    detail.get(j).setFinalGrade(findGrading((temp / temp2)));
//                    detail.get(j).setRemark(gradingSystemPr.getGpa() + " *" + subjectPr.getCreditHour() + "+" + gradingSystem.getGpa() + " *" + subject.getCreditHour() + " / " + subjectPr.getCreditHour() + " + " + subject.getCreditHour());
                    detail.get(j).setRemark("-");
                } else if (subject.getThFm() > 0) {
                    gradingSystem = findGrading(detail.get(j).getThObtain(), subject.getThFm());
                    detail.get(j).setGeadeTh(gradingSystem.getGrade());
                    totalGPA += (gradingSystem.getGpa() * subject.getCreditHour());
                    totalCredithour = totalCredithour + subject.getCreditHour();
                    detail.get(j).setGeadePoint(gradingSystem.getGpa().toString());
                    detail.get(j).setFinalGrade(gradingSystem.getGrade());
                    detail.get(j).setRemark("-");
                } else {
                    gradingSystem = findGrading(detail.get(j).getPrObtain(), subject.getPrFm());
                    detail.get(j).setGeadeTh(gradingSystem.getGrade());
                    totalGPA += (gradingSystem.getGpa() * subject.getCreditHour());
                    totalCredithour = totalCredithour + subject.getCreditHour();
                    detail.get(j).setGeadePoint(gradingSystem.getGpa().toString());
                    detail.get(j).setFinalGrade("-");
                    detail.get(j).setRemark("-");
                }

                detail.get(j).setSubjectCode(subject.getSubjectCode());
                detail.get(j).setSubjectName(subject.getSubjectName());
                detail.get(j).setCreditHour(subject.getCreditHour());
                detail.get(j).setPk(new GradeSheetDetailPk(id, detail.get(j).getSubjectId()));
            }
            obj.setDetail(detail);

            obj.setGpa(df.format(totalGPA / totalCredithour));
            repository.save(obj);
        }
        try {
            repository.updateFinalGrade(prSubject);
            repository.updatePRGrade(prSubject);
        } catch (Exception e) {
        }
        return message.respondWithMessage("Success");
    }

    private GradingSystem findGrading(double obtainMark, double fm) {
        double percent = 0;
        if (fm > 0) {
            percent = (obtainMark / fm) * 100;
        }
        for (int i = 0; i < gradingSystems.size(); i++) {
            if (percent >= gradingSystems.get(i).getRangFrom()) {
                return gradingSystems.get(i);
            }
        }

        return GradingSystem.builder()
                .effectiveDateFrom(new Date())
                .grade("-")
                .rangFrom(0.0001f)
                .remark("")
                .gpa(0.0001f)
                .build();
    }

    private String findGrading(double GP) {
        if (GP > 3.6) {
            return "A+ ";
        } else if (GP > 3.2) {
            return "A";
        } else if (GP > 2.8) {
            return "B+";
        } else if (GP > 2.4) {
            return "B";
        } else if (GP > 2.0) {
            return "C+";
        } else if (GP > 1.6) {
            return "C";
        } else if (GP > 1.2) {
            return "D+";
        } else if (GP > 0.8) {
            return "D";
        } else {
            return "E" ;
        }
    }

    SubjectMaster getSubject(long id) {
        for (int i = 0; i < masters.size(); i++) {
            if (id == masters.get(i).getId()) {
                return masters.get(i);
            }
        }
        return null;
    }

    private GradeShettDetail getPrMark(List<GradeShettDetail> details, long prSubjectId) {
        for (int i = 0; i < details.size(); i++) {
            if (details.get(i).getSubjectId() == prSubjectId) {
                return details.get(i);
            }
        }
        return null;
    }

}
