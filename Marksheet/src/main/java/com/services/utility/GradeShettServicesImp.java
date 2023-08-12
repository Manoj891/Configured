package com.services.utility;

import com.config.DateConvert;
import com.model.utility.GradeShett;
import com.repository.utility.GradeShettRepository;
import com.config.JWTToken;
import com.model.utility.GradeSheetDetailPk;
import com.model.utility.GradeShettDetail;
import com.model.utility.GradingSystem;
import com.model.utility.SubjectMaster;
import com.repository.utility.GradingSystemRepository;
import com.repository.utility.SubjectMasterRepository;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;

@Service
public class GradeShettServicesImp implements GradeShettServices {

    @Autowired
    GradeShettRepository repository;

    @Autowired
    GradingSystemRepository systemRepository;
    List<GradingSystem> gradingSystems = new ArrayList<>();
    @Autowired
    SubjectMasterRepository masterRepository;
    List<SubjectMaster> subjectMasters = new ArrayList<>();
    private final DecimalFormat df = new DecimalFormat("#.##");

    @Override
    public Object getAll(Long id, HttpServletRequest request, String Authorization) {
        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("Invalid Authorization");
        }
//             obj.setSchool(Long.parseLong(td.getBranch()));
        return repository.findByTableId(id, td.getBranch());
    }

    @Override
    public ResponseEntity save(GradeShett obj, HttpServletRequest request, String Authorization) {
        long id = repository.findNextId();
        return saveOrUpdate(id, obj, Authorization);
    }

    @Override
    public ResponseEntity update(GradeShett obj, Long id, HttpServletRequest request, String Authorization) {
        return saveOrUpdate(id, obj, Authorization);
    }

    @Override
    public ResponseEntity delete(Long id, HttpServletRequest request, String Authorization) {
        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("Invalid Authorization");
        }
        String msg = "";
        try {
            repository.deleteById(id);
            return message.respondWithMessage("Success");
        } catch (DataIntegrityViolationException e) {
            msg = message.exceptionMsg(e);
        } catch (Exception e) {
            msg = e.getMessage().toLowerCase();
        }
        if (msg.contains("foreign key")) {
            msg = "It has been used in another place,you cannot delete!!";
        }
        return message.respondWithError(msg);
    }

    private ResponseEntity saveOrUpdate(long id, GradeShett obj, String Authorization) {
        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("Invalid Authorization");
        }
        String msg = "";
        try {

            gradingSystems = systemRepository.findCurrentSystem();
            subjectMasters = masterRepository.findSchool(td.getBranch());
            GradingSystem gradingSystem;
            SubjectMaster subjectMaster;
            obj.setId(id);
            obj.setEnterBy(td.getUserName());
            obj.setEnterDate(DateConvert.toDay());
            obj.setSchool(Long.parseLong(td.getBranch()));
            List<GradeShettDetail> detail = obj.getDetail();
            double totalSubject = 0, totalGPA = 0;
            for (int i = 0; i < detail.size(); i++) {
                subjectMaster = findSubject(detail.get(i).getSubjectId());
                if (subjectMaster.getThFm() > 0) {
                    gradingSystem = findGrading(detail.get(i).getThObtain(), subjectMaster.getThFm());
                    detail.get(i).setGeadeTh(gradingSystem.getGrade());
                } else {
                    detail.get(i).setGeadeTh("-");
                }
                if (subjectMaster.getPrFm() > 0) {
                    gradingSystem = findGrading(detail.get(i).getPrObtain(), subjectMaster.getPrFm());
                    detail.get(i).setGeadePr(gradingSystem.getGrade());
                } else {
                    detail.get(i).setGeadePr("-");
                }
                gradingSystem = findGrading(detail.get(i).getThObtain() + detail.get(i).getPrObtain(), subjectMaster.getThFm() + subjectMaster.getPrFm());

                detail.get(i).setFinalGrade(gradingSystem.getGrade());
                detail.get(i).setGeadePoint(gradingSystem.getGpa().toString());
                detail.get(i).setRemark(gradingSystem.getRemark());
                detail.get(i).setSubjectCode(subjectMaster.getSubjectCode());
                detail.get(i).setSubjectName(subjectMaster.getSubjectName());
                detail.get(i).setCreditHour(subjectMaster.getCreditHour());
                detail.get(i).setPk(new GradeSheetDetailPk(id, detail.get(i).getSubjectId()));
                totalGPA += gradingSystem.getGpa();
                totalSubject++;
            }

            obj.setDetail(detail);

            obj.setGpa(df.format(totalGPA / totalSubject));
            repository.save(obj);
            return message.respondWithMessage("Success");
        } catch (DataIntegrityViolationException e) {
            msg = message.exceptionMsg(e);
        } catch (Exception e) {
            msg = e.getMessage().toLowerCase();
        }
        System.out.println(msg);
        if (msg.contains("primary") || msg.contains("duplicate entry")) {
            msg = "Record Alredy Exist";
        } else if (msg.contains("Duplicate entry")) {
            msg = "Reg Number lredy Exist";
        } else if (msg.contains("multiple representations of the same entity")) {
            msg = "multiple subject not support in same student";
        }
        return message.respondWithError(msg);
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

    private SubjectMaster findSubject(long subCode) {
        for (int i = 0; i < subjectMasters.size(); i++) {
            if (subCode == subjectMasters.get(i).getId()) {
                return subjectMasters.get(i);
            }
        }
        return subjectMasters.get(subjectMasters.size() - 1);
    }

    @Override
    public ResponseEntity updateAll(GradeShett obj, Long id, HttpServletRequest request, String Authorization) {
        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("Invalid Authorization");
        }
        Optional<GradeShett> gradeShett = repository.findById(id);
        if (!gradeShett.isPresent()) {
            return message.respondWithError("Invalid ID");
        }
        obj.setId(id);
        List<GradeShettDetail> detail = obj.getDetail();

        for (int i = 0; i < detail.size(); i++) {
            detail.get(i).setPk(new GradeSheetDetailPk(id, detail.get(i).getSubjectId()));
        }
        repository.save(obj);
        return message.respondWithMessage("Success");
    }

    @Override
    public ResponseEntity delete(Long id, Long subjectId, HttpServletRequest request, String Authorization) {
        repository.deleteSubject(id, subjectId);
        return new Message().respondWithMessage("Success");
    }
}
