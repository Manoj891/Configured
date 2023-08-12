package com.repository.utility;

import com.model.utility.PaymentGetwayLogin;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PaymentGetwayLoginRepository extends JpaRepository<PaymentGetwayLogin, Long> {

    @Query(value = "SELECT IFNULL(MAX(ID), 0)+1 FROM payment_getway_login", nativeQuery = true)
    Long findNextId();

    @Query(value = "SELECT ID userId,NAME userName,EMAIL email,LOGIN_PASS dbPassword,CONCAT('*', UPPER(SHA1(UNHEX(SHA1(?1))))) AS userPassword,IFNULL(STATUS,'N') status FROM payment_getway_login WHERE EMAIL=?2", nativeQuery = true)
    List findLogin(String userPassword, String userName);

    @Query(value = "SELECT LOGIN_PASS dbPassword,CONCAT('*', UPPER(SHA1(UNHEX(SHA1(?1))))) AS oldPassword FROM payment_getway_login WHERE ID=?2", nativeQuery = true)
    List findChangePassword(String userPassword, String userName);

    @Modifying
    @Query(value = "UPDATE payment_getway_login SET LOGIN_PASS=CONCAT('*', UPPER(SHA1(UNHEX(SHA1(?1))))) WHERE ID=?2", nativeQuery = true)
    void updateChangePassword(String userPassword, String userName);
}
