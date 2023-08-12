package com.repository.utility;

import com.model.utility.OrganizationUser;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface OrganizationUserRepository extends JpaRepository<OrganizationUser, Long> {

    @Query(value = "SELECT IFNULL(MAX(ID), 0)+1 FROM organization_user", nativeQuery = true)
    Long findNextId();
    
    @Query(value = "SELECT CONCAT('*', UPPER(SHA1(UNHEX(SHA1(?1))))) AS userPassword,LOGIN_PASS,LOGIN_ID,NAME,STATUS,IFNULL(SCHOOL,1)  FROM organization_user WHERE EMAIL=?2 OR LOGIN_ID=?2", nativeQuery = true)
    List findLogin(String userPassword, String userName);

    @Modifying
    @Query(value = "UPDATE organization_user SET LOGIN_PASS=CONCAT('*', UPPER(SHA1(UNHEX(SHA1(?1)))))  WHERE EMAIL=?2 OR LOGIN_ID=?2", nativeQuery = true)
    void updatePassword(String userPassword, String userName);

    @Query(value = "SELECT CONCAT('*', UPPER(SHA1(UNHEX(SHA1(?1))))) AS userPassword,LOGIN_PASS FROM organization_user WHERE EMAIL=?2 OR LOGIN_ID=?2", nativeQuery = true)
    List findChangePassword(String oldPassword, String userId);

    @Modifying
    @Query(value = "UPDATE organization_user SET LOGIN_PASS=CONCAT('*', UPPER(SHA1(UNHEX(SHA1(?1))))) WHERE EMAIL=?2 OR LOGIN_ID=?2", nativeQuery = true)
    void updateChangePassword(String rePassword, String userId);

}
