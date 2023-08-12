package com.repository;

import com.model.billing.StuBillingDetail;
import com.model.billing.StuBillingDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuBillingDetailRepository extends JpaRepository<StuBillingDetail, StuBillingDetailPK> {
}
