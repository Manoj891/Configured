package com;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class WelcomeController {

    @Autowired
    private ExamMarkEntryRepository repository;
    @Autowired
    private MarkEntryRepository markEntryRepository;

    @RequestMapping(value = "/web/import-stu", method = RequestMethod.GET)
    public String studentImport() throws IOException {
        File file = new File("C:\\Users\\DELL VOSTRO 3400\\Desktop\\GHORAHI-XI.xlsx");

        return "OK";
    }

    @RequestMapping(value = "/web/update-group", method = RequestMethod.GET)
    public List<Long> updateGroup(@RequestParam long groupId) throws IOException {
        File file = new File("D:/Msware/Grade11Managementmarksheet.xlsx");
        Workbook excel = new XSSFWorkbook(new FileInputStream(file));
//        Sheet excelSheet = excel.getSheetAt(0);

//        ScienceMarksheet
        long regNo, academicYear = 78, program = 3, classId = 11;
        List<Long> list = new ArrayList<>();

        Sheet excelSheet = excel.getSheet("ComputerScience");
        groupId = 2;
        for (Row row : excelSheet) {
            try {
                regNo = (long) row.getCell(0).getNumericCellValue();
                repository.saveClassTransfer(academicYear, regNo, classId, program, regNo, "", groupId);
            } catch (Exception ignored) {
            }
        }
        excelSheet = excel.getSheet("FinanceGroup");
        groupId = 5;
        for (Row row : excelSheet) {
            try {
                regNo = (long) row.getCell(0).getNumericCellValue();
                repository.saveClassTransfer(academicYear, regNo, classId, program, regNo, "", groupId);
            } catch (Exception ignored) {
            }
        }
        excelSheet = excel.getSheet("BusinessMath");
        groupId = 10;
        for (Row row : excelSheet) {
            try {
                regNo = (long) row.getCell(0).getNumericCellValue();
                repository.saveClassTransfer(academicYear, regNo, classId, program, regNo, "", groupId);
            } catch (Exception ignored) {
            }
        }
        return list;
    }

    @RequestMapping(value = "/web/import-mark", method = RequestMethod.GET)
    public String index() throws IOException {
        File file = new File("D:/Msware/Grade11Managementmarksheet.xlsx");
        Workbook excel = new XSSFWorkbook(new FileInputStream(file));
        long program = 3, classId = 11;
        saveData(excel.getSheet("ComputerScience"), program, classId, 2, 6);
        saveData(excel.getSheet("FinanceGroup"), program, classId, 5, 6);
        saveData(excel.getSheet("BusinessMath"), program, classId, 10, 6);
        return "index";
    }

    @RequestMapping(value = "/web/approve-mark", method = RequestMethod.GET)
    public String markApprove() {
        Date date = new Date();

        for (MarkEntry d : markEntryRepository.findByUnPosted()) {
            try {
                repository.postData("SYSTEM", date, "SYSTEM", date, d.getPk().getExam(), d.getExamRollNo(), d.getPrOm(), d.getPk().getRegNo(), d.getThOm(), d.getExamRegNo(), d.getSubId());
                repository.postData(d.getPk().getExam(), d.getPk().getRegNo(), d.getPk().getSubCode());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return "OK";
    }

    void saveData(Sheet excelSheet, long program, long classId, long groupId, long exam) {
        String subCode;
        double thOm, prOm;
        long regNo;
        for (Row row : excelSheet) {
            try {
                regNo = (long) row.getCell(0).getNumericCellValue();
                if (regNo > 0) {
                    try {
                        subCode = row.getCell(1).getStringCellValue();
                    } catch (Exception e) {
                        subCode = String.valueOf((long) row.getCell(1).getNumericCellValue());
                    }
                    thOm = row.getCell(2).getNumericCellValue();
                    prOm = row.getCell(3).getNumericCellValue();
                    repository.saveData(regNo, subCode, thOm, prOm, exam, "N", groupId, program, classId);
                }
            } catch (Exception ignored) {
            }
        }
        repository.updateSubId(program, classId, groupId);
        repository.updateExamRegId(exam);
        repository.updateExamRollNo(exam);
    }

}
