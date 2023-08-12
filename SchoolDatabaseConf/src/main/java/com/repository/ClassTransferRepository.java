package com.repository;

import com.model.student.ClassTransfer;
import com.model.student.ClassTransferPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassTransferRepository extends JpaRepository<ClassTransfer, ClassTransferPK> {
}
