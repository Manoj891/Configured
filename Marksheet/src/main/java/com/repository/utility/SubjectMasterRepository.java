package com.repository.utility;

import com.model.utility.SubjectMaster;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface SubjectMasterRepository extends JpaRepository<SubjectMaster, Long> {

    @Query(value = "SELECT IFNULL(MAX(ID), 0)+1 FROM subject_master", nativeQuery = true)
    Long findNextId();

    @Modifying
    @Query(value = "UPDATE subject_master SET PR_SUBJECT=?1 WHERE ID=?2 AND school=?3", nativeQuery = true)
    void updatePR(Long pr, Long th, String school);

    @Query(value = "SELECT * FROM subject_master where SCHOOL=?1 ORDER BY SUBJECT_CODE", nativeQuery = true)
    List<SubjectMaster> findSchool(String school);

    @Query(value = "SELECT id,subject_code,subject_name,(SELECT CONCAT(P.subject_name,'(',P.subject_code,')') AS pr FROM subject_master P WHERE P.id=T.pr_subject) AS pr FROM subject_master T WHERE IFNULL(pr_subject,0)>0 AND school=?1", nativeQuery = true)
    List<Object[]> findPRSubject(String school);
}
