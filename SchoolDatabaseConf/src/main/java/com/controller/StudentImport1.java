package com.controller;

import com.model.setup.SubjectGroup;
import com.model.student.StudentInfo;
import com.repository.StudentRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentImport1 {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private StudentRepository repository;
    List<SubjectGroup> groups = new ArrayList<>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private List<Long> importDate(Workbook excel, long academicYear, int sheetAt) {

        List<Long> ids = new ArrayList<>();

        long id, program, Class;

        Sheet sheet;
        groups = groupRepository.findAll();
//        for (int i = 1; i <= 2; i++) {
        sheet = excel.getSheetAt(sheetAt);
        int i = 1;
        for (Row row : sheet) {
            int rollNo = 0;
            String name = "", email, tol = "", sex = "", groupName, fathersname = "", occupation = "", contactnumber = "", mothersname = "", montheroccupation = "", monthercontactnumber = "", permanentaddress = "", previousschool = "";

            StudentInfo obj = new StudentInfo();
            try {

                try {
                    name = row.getCell(1).getStringCellValue();
                    id = Long.parseLong(row.getCell(2).getStringCellValue());
                } catch (Exception e) {
                    try {
                        id = (long) row.getCell(2).getNumericCellValue();
                    } catch (Exception ex) {
                        continue;
                    }
                }
                try {
                    rollNo = (int) row.getCell(0).getNumericCellValue();
                } catch (Exception e) {
                    try {
                        rollNo = Integer.parseInt(row.getCell(0).getStringCellValue());
                    } catch (Exception ex) {
                    }
                }


                try {
                    program = (long) row.getCell(3).getNumericCellValue();
                } catch (Exception e) {
                    program = Long.parseLong(row.getCell(3).getStringCellValue());
                }
                try {
                    Class = (long) row.getCell(4).getNumericCellValue();
                } catch (Exception e) {
                    Class = Long.parseLong(row.getCell(4).getStringCellValue());
                }
                email = row.getCell(5).getStringCellValue();
                groupName = row.getCell(6).getStringCellValue();
                try {
                    sex = row.getCell(7).getStringCellValue();
                } catch (Exception e) {
                }
                try {
//
                    obj.setDateOfBirth(row.getCell(9).getStringCellValue());
                } catch (Exception e) {
                    try {
                        obj.setDateOfBirth(dateFormat.format(row.getCell(9).getDateCellValue()));
                    } catch (Exception ex) {
                    }
                }

                try {
                    fathersname = row.getCell(10).getStringCellValue();
                } catch (Exception e) {
                }
                try {
                    occupation = row.getCell(11).getStringCellValue();
                } catch (Exception e) {
                }
                try {
                    contactnumber = row.getCell(12).getStringCellValue();
                } catch (Exception e) {
                    try {
                        contactnumber = String.valueOf((long) row.getCell(12).getNumericCellValue());
                    } catch (Exception ex) {
                    }
                }
                try {
                    mothersname = row.getCell(13).getStringCellValue();
                } catch (Exception e) {
                }
                try {
                    montheroccupation = row.getCell(14).getStringCellValue();
                } catch (Exception e) {
                }

                try {
                    monthercontactnumber = row.getCell(15).getStringCellValue();
                } catch (Exception e) {
                    try {
                        monthercontactnumber = String.valueOf((long) row.getCell(15).getNumericCellValue());
                    } catch (Exception ex) {
                        monthercontactnumber = "";
                    }
                }
                try {
                    tol = row.getCell(16).getStringCellValue();
                } catch (Exception ex) {
                }
                try {
                    previousschool = row.getCell(17).getStringCellValue();
                } catch (Exception ex) {
                }
                obj.setId(id);
                obj.setSn(rollNo);
                obj.setProgram(program);
                obj.setClassId(Class);
                obj.setSubjectGroup(getGroup(groupName));
                obj.setRollNo(rollNo);
                obj.setStuName(name);
                obj.setEmail(email);
                obj.setGender(sex);
                obj.setFathersName(fathersname);
                obj.setFathersOccupation(occupation);
                obj.setFathersMobile(contactnumber);
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
                obj.setDistrict("");
                obj.setMunicipal("");
                obj.setWardNo("");
                obj.setTol(tol);
                obj.setProvincet(5);
                obj.setDistrictt("");
                obj.setMunicipalt("");
                obj.setWardNot("");
                obj.setPreSchool(previousschool);
                obj.setEnterDateAD(new Date());
//                    System.out.println(obj);
                repository.save(obj);
                ids.add(id);
            } catch (Exception e) {
                e.printStackTrace();
//                System.out.println(i + "   " + e.getMessage());
//                    e.printStackTrace();
            }
            i++;
        }
//        }

//        repository.saveAll(list);
        repository.saveClassTransfer();
        System.out.println(ids.size());
        return ids;
    }


    private long getGroup(String groupName) {
        if (groupName.length() < 3) return 1;
        for (SubjectGroup group : groups) {
            if (group.getGroupName().replace(" ", "").equalsIgnoreCase(groupName.replace(" ", ""))) {
                return group.getId();
            }
        }
        SubjectGroup group = new SubjectGroup();
        group.setGroupName(groupName);
        group.setId(groupRepository.findNextId());
        groupRepository.save(group);
        groups.add(group);
        return group.getId();
    }
}

