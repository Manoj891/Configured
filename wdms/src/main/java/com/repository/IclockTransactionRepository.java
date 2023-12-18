package com.repository;

import com.model.IclockTransaction;

import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;

import com.model.IclockTransactionRes;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IclockTransactionRepository extends JpaRepository<IclockTransaction, Long> {
    List<IclockTransactionRes> findBySyncedIsFalse(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "UPDATE iclock_transaction SET synced=true  WHERE id in(?1)", nativeQuery = true)
    void updateSyncData(List<Long> ids);

}
