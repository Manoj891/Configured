package com.repository;

import com.model.student.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<StudentInfo, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO class_transfer (ACADEMIC_YEAR, STUDENT_ID, CLASS_ID, PROGRAM,  SUBJECT_GROUP,ROLL_NO, SECTION) SELECT ACADEMIC_YEAR,ID,CLASS_ID,PROGRAM,SUBJECT_GROUP,ROLL_NO,SECTION FROM student_info where id not in(SELECT STUDENT_ID FROM class_transfer)", nativeQuery = true)
    void saveClassTransfer();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO class_transfer (ACADEMIC_YEAR, STUDENT_ID, CLASS_ID, PROGRAM,  SUBJECT_GROUP,ROLL_NO, SECTION) VALUES(?1, ?2, ?3, ?4,  ?5,?6, ?7)", nativeQuery = true)
    void saveClassTransfer(long academicYear, long studentId, long classId, long program, long subjectGroup, int rollNo, String section);
}
