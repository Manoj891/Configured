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
@Transactional
public interface IclockTransactionRepository extends JpaRepository<IclockTransaction, Long> {
    List<IclockTransactionRes> findBySyncedIsFalse(Pageable pageable);

    List<IclockTransactionRes> findByUpdatedFalse();

    @Modifying
    @Query(value = "update iclock_transaction set synced=true  where id=?1", nativeQuery = true)
    void updateSyncData(long id);

    @Modifying
    @Query(value = "update iclock_transaction set updated=true  where id=?1", nativeQuery = true)
    void updateData(Long id);
}
