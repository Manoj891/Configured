package com.controller;

import com.model.setup.SubjectGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<SubjectGroup, Long> {
    @Query(value = "SELECT IFNULL(MAX(ID),0)+1 FROM subject_group", nativeQuery = true)
    long findNextId();
}
