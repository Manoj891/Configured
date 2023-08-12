package com.repository.utility;

import com.model.utility.OrganizationMaster;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface OrganizationMasterRepository extends JpaRepository<OrganizationMaster, Long> {

    @Query(value = "SELECT * FROM organization_master where ID=?1", nativeQuery = true)
    List<OrganizationMaster> findBySchoolCode(String id);
}
