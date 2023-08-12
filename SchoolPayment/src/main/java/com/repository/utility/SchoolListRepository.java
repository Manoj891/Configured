package com.repository.utility;

import com.model.utility.SchoolList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SchoolListRepository extends JpaRepository<SchoolList, Long> {

    @Query(value = "SELECT IFNULL(SCHOOL_API,'') api FROM school_list WHERE ID=?1", nativeQuery = true)
    String findSchoolCode(String schoolCode);

    @Query(value = "SELECT * FROM school_list WHERE STATUS='Y'", nativeQuery = true)
    List<SchoolList> findAllActive();

}
