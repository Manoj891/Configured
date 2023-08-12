package com.repository.utility;

import com.model.utility.GradeShett;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface GradeShettRepository extends JpaRepository<GradeShett, Long> {

    @Query(value = "SELECT IFNULL(MAX(ID), 0)+1 FROM grade_shett", nativeQuery = true)
    Long findNextId();

    @Query(value = "SELECT * FROM grade_shett where id=ifnull(?1,id) AND SCHOOL=?2", nativeQuery = true)
    List<GradeShett> findByTableId(Long id, String branch);

    @Query(value = " SELECT id FROM grade_shett", nativeQuery = true)
    List<Long> findAllRegNo();

    @Query(value = " SELECT IFNULL(th_obtain,0)+IFNULL(pr_obtain,0) FROM grade_shett_detail WHERE master_id=?1 AND subject_id=?2", nativeQuery = true)
    Double findPRMark(Long masterId, Long subjectId);

    @Modifying
    @Query(value = "UPDATE grade_shett_detail SET pr_obtain=?1 WHERE MASTER_ID=?2 AND SUBJECT_ID=?3", nativeQuery = true)
    void updatePRMark(double thObtain, Long masterId, Long subjectId);

    @Modifying
    @Query(value = "UPDATE grade_shett_detail SET final_grade='-' WHERE subject_id IN(?1)", nativeQuery = true)
    void updateFinalGrade(List<Long> prSubject);

    @Modifying
    @Query(value = "UPDATE grade_shett_detail SET grade_th=grade_pr WHERE subject_id IN(?1) and th_obtain=0 and pr_obtain>0", nativeQuery = true)
    void updatePRGrade(List<Long> prSubject);

    @Modifying
    @Query(value = "DELETE FROM grade_shett_detail  WHERE MASTER_ID=?1 AND SUBJECT_ID=?2", nativeQuery = true)
    void deleteSubject(Long masterId, Long subjectId);
}
