package com.repository;

import com.mode.ServerUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerUrlRepository extends JpaRepository<ServerUrl, Long> {
}
