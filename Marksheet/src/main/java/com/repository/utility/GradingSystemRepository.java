package com.repository.utility;

import com.model.utility.GradingSystem;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface GradingSystemRepository extends JpaRepository<GradingSystem, Long> {

    @Query(value = "SELECT IFNULL(MAX(ID), 0)+1 FROM grading_system", nativeQuery = true)
    Long findNextId();

    @Query(value = "SELECT * FROM grading_system ORDER BY RANG_FROM DESC", nativeQuery = true)
    List<GradingSystem> findCurrentSystem();
}
