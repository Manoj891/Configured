package com;

import com.model.utility.EmisDataImport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmisDataImportRepository extends JpaRepository<EmisDataImport, Long> {

    @Query(value = "SELECT caste FROM emis_data_import GROUP BY caste", nativeQuery = true)
    List<String> findByCaste();

    @Query(value = "SELECT id FROM cast_ethnicity_master WHERE `NAME` =?1", nativeQuery = true)
    Optional<Long> findByCaste(String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE emis_data_import SET caste_id=?1 WHERE caste=?2", nativeQuery = true)
    void updateCasteId(long id, String name);

    @Query(value = "SELECT IFNULL(max(`ID`),0)+1 FROM cast_ethnicity_master", nativeQuery = true)
    long findMaxCasteId();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cast_ethnicity_master(`ID`,`NAME`) VALUES(?1,?2)", nativeQuery = true)
    void saveCaste(long id, String name);

    @Modifying
    @Transactional
    @Query(value = "insert into student_info (ID, ACADEMIC_YEAR, ADMISSION_YEAR, CAST_ETHNICITY, CITIZENSHIP, CLASS_ID, DATE_OF_BIRTH, DISABILITY, DISTRICT, DISTRICTT,  EMAIL, ENTER_BY, ENTER_DATE,  FATHERS_NAME, GENDER, MARITAL_STATUS, MOTHERS_NAME, MUNICIPAL,  PROGRAM, PROVINCE,  RELIGION, ROLL_NO, SECTION, SN, STATUS, STU_NAME, SUBJECT_GROUP, TOL) SELECT reg_no,academic_year,academic_year,caste_id,'Nepalese',class_id,date_of_birth,'Normal',3,'KATHMANDU',CONCAT(replace(stu_name,' ','_'),'@gmail.com'),'SYSTEM',now(),fathers_name,gender,'',mothers_name,'TARAKESHWOR MUNICIPLAITY',1,'3',1,roll_no,'A',sn,'Y',stu_name,1,address FROM emis_data_import", nativeQuery = true)
    void saveStudent();


    @Modifying
    @Transactional
    @Query(value =  "INSERT INTO class_transfer (ACADEMIC_YEAR, STUDENT_ID, CLASS_ID, PROGRAM,  SUBJECT_GROUP,ROLL_NO, SECTION) SELECT ACADEMIC_YEAR,ID,CLASS_ID,PROGRAM,SUBJECT_GROUP,ROLL_NO,SECTION FROM student_info", nativeQuery = true)
    void saveClassTransfer();

}
