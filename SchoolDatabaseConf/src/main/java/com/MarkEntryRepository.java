package com;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MarkEntryRepository extends JpaRepository<MarkEntry, MarkEntryPK> {
    @Query(value = "SELECT * FROM mark_insert WHERE POSTED='N'", nativeQuery = true)
    List<MarkEntry> findByUnPosted();
}
