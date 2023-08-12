package com;

import com.model.utility.AboutApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface TestRepository extends JpaRepository<AboutApp, Long> {
    @Modifying
    @Query(value = "delete from mark_insert", nativeQuery = true)
    void deleteData();

    @Modifying
    @Query(value = "insert into mark_insert(REG_NO,SUBJECT_CODE,TH_OM,PR_OM) values (?1,?2,?3,?4);", nativeQuery = true)
    void saveData(long regNo, String subCode, double thOm, double prOm);

    @Modifying
    @Query(value = "update subject_group_detail set SUBJECT_CODE=replace(SUBJECT_CODE,' ','');", nativeQuery = true)
    void updateSubjectGroupDetail();

    @Modifying
    @Query(value = "update mark_insert set SUBJECT_CODE=replace(SUBJECT_CODE,' ','');", nativeQuery = true)
    void updateSubjectMark();

    @Modifying
    @Query(value = "update mark_insert I set SUB_ID =(SELECT D.SUBJECT FROM gipss_ghorahi.subject_group_detail D where D.SUBJECT_CODE=I.SUBJECT_CODE) where SUB_ID is null;", nativeQuery = true)
    void updateSubId();

    @Modifying
    @Query(value = "update mark_insert I set EXAM_REG_ID =(SELECT D.ID FROM gipss_ghorahi.exam_student_registration D where D.STUDENT_ID=I.REG_NO) where EXAM_REG_ID is null", nativeQuery = true)
    void updateExamRegId();

    @Modifying
    @Query(value = "update mark_insert I set EXAM_ROLL_NO =(SELECT D.EXAM_ROLL_NO FROM gipss_ghorahi.exam_student_registration D where D.STUDENT_ID=I.REG_NO) where EXAM_ROLL_NO is null", nativeQuery = true)
    void updateExamRollNo();



}
