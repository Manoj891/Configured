package com.repository.utility;

import com.model.utility.GradeShettDetail;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface GradeShettDetailRepository extends JpaRepository<GradeShettDetail, Long> {

    @Modifying
    @Query(value = "UPDATE grade_shett_detail SET pr_obtain=?1 WHERE MASTER_ID=?2 AND SUBJECT_ID=?3", nativeQuery = true)
    void updatePRMark(double thObtain, Long masterId, Long subjectId);

}
