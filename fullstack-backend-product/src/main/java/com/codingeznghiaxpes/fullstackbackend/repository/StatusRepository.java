package com.codingeznghiaxpes.fullstackbackend.repository;

import com.codingeznghiaxpes.fullstackbackend.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
