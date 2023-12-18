package com.repository;

import com.model.DaywiseBiomatrix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaywiseBiomatrixRepository extends JpaRepository<DaywiseBiomatrix, String> {
    int countByEmpIdAndAttDate(long empId, String atDate);
}
