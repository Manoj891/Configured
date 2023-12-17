package com.repository;

import com.mode.IclockTransaction;

import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;

import com.mode.IclockTransactionRes;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IclockTransactionRepository extends JpaRepository<IclockTransaction, Long> {


    List<IclockTransactionRes> findBySyncedIsFalse(Pageable pageable);

    @Query(value = "SELECT emp_code empCode, emp_id empId, punch_time AS punchTime, id punchId FROM iclock_transaction WHERE synced is false order by id limit 1000", nativeQuery = true)
    List<Map<String, Object>> findSyncData();

    @Modifying
    @Transactional
    @Query(value = "UPDATE iclock_transaction SET synced=true  WHERE id in(?1)", nativeQuery = true)
    void updateSyncData(List<Long> ids);

}
