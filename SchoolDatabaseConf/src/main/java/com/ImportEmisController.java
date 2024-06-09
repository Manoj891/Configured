//package com;
//
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/web/import/emis")
//public class ImportEmisController {
//
//    @Autowired
//    private EmisDataImportRepository repository;
//
//    @GetMapping()
//    public Object doConfigNew() {
//
////        String fileName = "E:/DigitalBeyond/MansinghEmis.xlsx";
//        String fileName = "/opt/tomcat/webapps/MansinghEmis.xlsx";
//
//        System.out.println(fileName);
//        try {
//            importDate(new XSSFWorkbook(new FileInputStream(fileName)));
//        } catch (IOException e) {
//            studentInsert();
//        }
//        return "Success";
//    }
//
//    private void importDate(Workbook excel) {
//        String address = "", registrationNo, gender;
//        String date;
//        long regNo;
//        int rollNo;
//        int sn = 1;
//        Sheet sheet;
////        for (int i = 1; i <= 16; i++) {
////            sheet = excel.getSheet(String.valueOf(i));
////            System.out.println(sheet.getHeader());
////            for (Row row : sheet) {
////                try {
////                    try {
////                        address = row.getCell(7).getStringCellValue();
////                    } catch (Exception e) {
////                        try {
////                            address = String.valueOf((long) row.getCell(7).getNumericCellValue());
////                        } catch (Exception ignored) {
////                        }
////                    }
////
////                    try {
////                        date = DateConveter.toString(row.getCell(2).getDateCellValue());
////                    } catch (Exception e) {
////                        date = row.getCell(2).getStringCellValue();
////                    }
////                    if (date.contains("00:00:00 NPT")) {
////                        date = date.replace("00:00:00 NPT ", "");
////                        date = date.substring(4);
////                        date = date.replace(" ", "-");
////                    }
////                    gender = row.getCell(3).getStringCellValue();
////                    if (gender.contains("Female")) gender = "F";
////                    else gender = "M";
////                    registrationNo = row.getCell(0).getStringCellValue();
////                    rollNo = Integer.parseInt(registrationNo.substring(registrationNo.indexOf("-") + 1));
////                    regNo = Long.parseLong(registrationNo.substring(registrationNo.indexOf("-") - 2).replace("-", ""));
////                    repository.save(new EmisDataImport(regNo, rollNo, sn, i, 79, row.getCell(1).getStringCellValue(), date, gender, row.getCell(4).getStringCellValue(), row.getCell(5).getStringCellValue(), row.getCell(6).getStringCellValue(), address));
////                    sn++;
////
////                } catch (Exception e) {
////                    System.out.println(e.getMessage());
////                }
////            }
////
////        }
//
//    }
//
//    private void studentInsert() {
//        for (String s : repository.findByCaste()) {
//            Optional<Long> castId = repository.findByCaste(s);
//            if (castId.isPresent()) {
//                repository.updateCasteId(castId.get(), s);
//            } else {
//                long cast = repository.findMaxCasteId();
//                repository.saveCaste(cast, s);
//                repository.updateCasteId(cast, s);
//            }
//        }
//        repository.saveStudent();
//        repository.saveClassTransfer();
//    }
//}