package com.repository.utility;

import com.model.utility.SMSSending;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SMSSendingRepository extends JpaRepository<SMSSending, Long> {

    @Query(value = "SELECT IFNULL(MAX(ID), 0)+1 FROM sms_sending", nativeQuery = true)
    Long findNextId();

    @Query(value = "SELECT * FROM sms_sending WHERE IFNULL(`STATUS`,'')!='Y'", nativeQuery = true)
    List<SMSSending> findPending();

    @Query(value = "SELECT * FROM sms_sending WHERE SCHOOL=?1 AND receive_date BETWEEN ?2 AND ?3 AND MOBILE_NO=IFNULL(?4,MOBILE_NO)", nativeQuery = true)
    List<SMSSending> findSent(String school, String dateFrom, String dateTo, String mobileNo);

    @Modifying
    @Query(value = "UPDATE sms_sending SET STATUS='Y',SENT_DATE=NOW() WHERE ID IN(?1);", nativeQuery = true)
    void updatePending(List ids);

}
