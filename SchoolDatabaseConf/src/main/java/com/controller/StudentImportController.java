package com.controller;

import com.model.setup.SubjectGroup;
import com.model.student.StudentInfo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/web/student/import")
public class StudentImportController {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private StudentSaved repository;
    List<SubjectGroup> groups = new ArrayList<>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping()
    public ResponseEntity<List<Long>> doConfigNew() throws IOException {
//        System.out.println(fileName);
        String fileName = "E://student-details-Lamahi.xlsx";
//     String   fileName = "/opt/tomcat/webapps/" + fileName;
        XSSFWorkbook sheetAt = new XSSFWorkbook(new FileInputStream(fileName));
        List<Long> list = new ArrayList<>();
        for (Long aLong : importDate(sheetAt, 0)) {
            list.add(aLong);
        }
//        for (Long aLong : importDate(sheetAt, 1)) {
//            list.add(aLong);
//        }
        return ResponseEntity.status(HttpStatus.OK).body(list);


    }

    private List<Long> importDate(Workbook excel, int sheetAt) {

        List<Long> ids = new ArrayList<>();
        long academicYear;
        long id, program, Class;

        Sheet sheet;
        groups = groupRepository.findAll();
//        for (int i = 1; i <= 2; i++) {
        sheet = excel.getSheetAt(sheetAt);
        int i = 1;
        for (Row row : sheet) {
            int rollNo = 0;

            String name = "", district = "", municipal = "", fathersMobile = "", email, tol = "", sex = "", section, fathersname = "", occupation = "", contactnumber = "", mothersname = "", montheroccupation = "", monthercontactnumber = "", permanentaddress = "", previousschool = "";

            StudentInfo obj = new StudentInfo();
            try {

                try {
                    id = Long.parseLong(row.getCell(0).getStringCellValue());
                } catch (Exception e) {
                    try {
                        id = (long) row.getCell(0).getNumericCellValue();
                    } catch (Exception ex) {
                        continue;
                    }
                }
                if (id <= 0) {
                    continue;
                }

                try {
                    academicYear = (long) row.getCell(1).getNumericCellValue();
                } catch (Exception e) {
                    academicYear = Long.parseLong(row.getCell(1).getStringCellValue());
                }
                try {
                    program = (long) row.getCell(2).getNumericCellValue();
                } catch (Exception e) {
                    try {
                        program = Long.parseLong(row.getCell(2).getStringCellValue());
                    } catch (Exception ex) {
                        program = 1;
                    }
                }
                try {
                    Class = (long) row.getCell(3).getNumericCellValue();
                } catch (Exception e) {
                    Class = getClassId(row.getCell(3).getStringCellValue());
                }
                try {
                    section = row.getCell(4).getStringCellValue();
                } catch (Exception e) {
                    section = "";
                }
                try {
                    rollNo = (int) row.getCell(5).getNumericCellValue();
                } catch (Exception e) {
                    try {
                        rollNo = Integer.parseInt(row.getCell(5).getStringCellValue());
                    } catch (Exception ignored) {
                    }
                }
                name = row.getCell(6).getStringCellValue();
                try {
                    obj.setDateOfBirth(row.getCell(7).getStringCellValue());
                } catch (Exception e) {
                    try {
                        obj.setDateOfBirth(dateFormat.format(row.getCell(7).getDateCellValue()));
                    } catch (Exception ignored) {
                    }
                }
                try {
                    sex = row.getCell(8).getStringCellValue();
                } catch (Exception e) {
                    sex = "";
                }
                if (sex.equalsIgnoreCase("Male")) {
                    sex = "M";
                } else if (sex.equalsIgnoreCase("Female")) {
                    sex = "F";
                }
                try {
                    contactnumber = row.getCell(9).getStringCellValue();
                } catch (Exception e) {
                    try {
                        contactnumber = String.valueOf((long) row.getCell(9).getNumericCellValue());
                    } catch (Exception ex) {
                        contactnumber = "";
                    }
                }
                try {
                    email = row.getCell(10).getStringCellValue();
                } catch (Exception e) {
                    email = "";
                }
                try {
                    fathersname = row.getCell(11).getStringCellValue();
                } catch (Exception e) {
                    fathersname = "";
                }
                try {
                    fathersMobile = row.getCell(12).getStringCellValue();
                } catch (Exception e) {
                    fathersMobile = "";
                }

                try {
                    mothersname = row.getCell(13).getStringCellValue();
                } catch (Exception e) {
                    mothersname = "";
                }
                try {
                    district = row.getCell(15).getStringCellValue().toUpperCase();
                } catch (Exception e) {
                    district = "";
                }
                try {
                    municipal = row.getCell(16).getStringCellValue().toUpperCase();
                } catch (Exception e) {
                    municipal = "";
                }

                obj.setId(id);
                obj.setSn(rollNo);
                obj.setProgram(program);
                obj.setClassId(Class);
                obj.setSection(section);
                obj.setSubjectGroup(1L);
                obj.setRollNo(rollNo);
                obj.setStuName(name);
                obj.setEmail(email);
                obj.setGender(sex);
                obj.setMobileNo(contactnumber);
                obj.setFathersName(fathersname);
                obj.setFathersOccupation(occupation);
                obj.setFathersMobile(fathersMobile);
                obj.setMothersName(mothersname);
                obj.setMothersOccupation(montheroccupation);
                obj.setMothersMobile(monthercontactnumber);
                obj.setTol(permanentaddress);
                obj.setPreSchool(previousschool);
                obj.setAcademicYear(academicYear);
                obj.setAdmissionYear(String.valueOf(academicYear));
                obj.setStatus("Y");
                obj.setDropOut("N");
                obj.setEnterBy("SYSTEM");
                obj.setCastEthnicity(1);
                obj.setReligion(1);
                obj.setMobileNo(obj.getFathersMobile());
                obj.setProvince(5);
                obj.setDistrict(district);
                obj.setMunicipal(municipal);
                obj.setWardNo("");
                obj.setTol(tol);
                obj.setProvincet(5);
                obj.setDistrictt(district);
                obj.setMunicipalt(municipal);
                obj.setWardNot("");

                obj.setPreSchool(previousschool);
                obj.setEnterDateAD(new Date());
                if (repository.save(obj) > 0)
                    ids.add(obj.getId());
            } catch (Exception e) {
//                e.printStackTrace();

            }
            i++;
        }
//        }

//        repository.saveAll(list);

        System.out.println(ids.size());
        return ids;
    }

    long getClassId(String name) {
        if (name.contains("Nur") || name.contains("Nursery")) {
            return 13;
        } else if (name.contains("LKG")) {
            return 14;
        } else if (name.contains("UKG")) {
            return 15;
        } else if (name.contains("XI")) {
            return 11;
        }
        return Long.parseLong(name);
    }
//
//    private long getGroup(String groupName) {
//        if (groupName.length() < 3) return 1;
//        for (SubjectGroup group : groups) {
//            if (group.getGroupName().replace(" ", "").equalsIgnoreCase(groupName.replace(" ", ""))) {
//                return group.getId();
//            }
//        }
//        SubjectGroup group = new SubjectGroup();
//        group.setGroupName(groupName);
//        group.setId(groupRepository.findNextId());
//        groupRepository.save(group);
//        groups.add(group);
//        return group.getId();
//    }
}