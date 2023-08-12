package com;

import com.model.exam.ExamMarkEntry;
import com.model.exam.ExamMarkEntryPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface ExamMarkEntryRepository extends JpaRepository<ExamMarkEntry, ExamMarkEntryPK> {

    @Modifying
    @Transactional
    @Query(value = "insert into exam_mark_entry (approve_by, approve_date, enter_by, enter_date, exam, exam_roll_no, pr_om, student_reg_no, th_om, exam_reg_id, subject) values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11)", nativeQuery = true)
    void postData(String approveBy, Date approveDate, String enterBy, Date enterDate, long exam, String examRollNo, double prOm, long studentRegNo, double thOm, long examRegId, long subject);

    @Modifying
    @Transactional
    @Query(value = "update mark_insert set POSTED ='Y' WHERE exam=?1 AND REG_NO=?2 AND SUBJECT_CODE=?3", nativeQuery = true)
    void postData(long exam, long regNo, String subCode);

    @Modifying
    @Transactional
    @Query(value = "insert into mark_insert(REG_NO,SUBJECT_CODE,TH_OM,PR_OM,exam,POSTED,GROUP_ID,program,class_id) values (?1,?2,?3,?4,?5,?6,?7,?8,?9);", nativeQuery = true)
    void saveData(long regNo, String subCode, double thOm, double prOm, long exam, String posted, long group, long program, long classId);

    @Modifying
    @Transactional
    @Query(value = "update mark_insert set SUBJECT_CODE=replace(SUBJECT_CODE,' ','');", nativeQuery = true)
    void updateSubjectMark();

    @Modifying
    @Transactional
    @Query(value = "update student_info set SUBJECT_GROUP=?1 where ID=?2", nativeQuery = true)
    void updateSubjectGroup(long groupId, long regNo);

    @Modifying
    @Transactional
    @Query(value = "update subject_group_detail set SUBJECT_CODE=replace(SUBJECT_CODE,' ','');", nativeQuery = true)
    void updateSubjectGroupDetail();

    @Modifying
    @Transactional
    @Query(value = "insert into class_transfer(ACADEMIC_YEAR, STUDENT_ID, CLASS_ID, PROGRAM, ROLL_NO, SECTION, SUBJECT_GROUP) values (?1,?2,?3,?4,?5,?6,?7)", nativeQuery = true)
    void saveClassTransfer(long ACADEMIC_YEAR, long STUDENT_ID, long CLASS_ID, long PROGRAM, long ROLL_NO, String SECTION, long SUBJECT_GROUP);


    @Modifying
    @Transactional
    @Query(value = "update mark_insert I set SUB_ID =(SELECT D.SUBJECT FROM subject_group_detail D where  PROGRAM=?1 and CLASS_ID=?2 and SUBJECT_GROUP=?3 and D.SUBJECT_CODE=I.SUBJECT_CODE) where SUB_ID is null", nativeQuery = true)
    void updateSubId(long programId, long classId, long groupId);

    @Modifying
    @Transactional
    @Query(value = "update mark_insert I set EXAM_REG_ID =(SELECT D.ID FROM exam_student_registration D where EXAM=?1 and D.STUDENT_ID=I.REG_NO) where EXAM_REG_ID is null", nativeQuery = true)
    void updateExamRegId(long exam);

    @Modifying
    @Transactional
    @Query(value = "update mark_insert I set EXAM_ROLL_NO =(SELECT D.EXAM_ROLL_NO FROM exam_student_registration D where D.STUDENT_ID=I.REG_NO AND EXAM=?1) where EXAM_ROLL_NO is null", nativeQuery = true)
    void updateExamRollNo(long exam);
}
