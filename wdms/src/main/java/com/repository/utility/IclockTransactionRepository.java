package com.repository.utility;

import com.model.utility.IclockTransaction;

import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IclockTransactionRepository extends JpaRepository<IclockTransaction, Long> {

    @Query(value = "SELECT T.emp_code empId,CONCAT(ADDTIME(T.PUNCH_TIME, '00:15:00')) AS punchTime,T.id punchId,E.company_id companyId,T.terminal_alias companyName,CONCAT(IFNULL(E.first_name,''),' ',IFNULL(E.last_name,'')) AS empName FROM iclock_transaction T,personnel_employee E WHERE T.punch_time>=subdate(sysdate(),32) and T.synced is false and T.emp_code=E.emp_code  ORDER BY T.id LIMIT 1000", nativeQuery = true)
    List<Map<String, Object>> findSyncData();

    @Modifying
    @Transactional
    @Query(value = "UPDATE iclock_transaction SET synced=true  WHERE id in(?1)", nativeQuery = true)
    void updateSyncData(List<Long> ids);

}
