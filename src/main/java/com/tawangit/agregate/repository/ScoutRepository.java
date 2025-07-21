package com.tawangit.agregate.repository;

import com.tawangit.agregate.entity.Scout.Scout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ScoutRepository extends JpaRepository<Scout, UUID> {

}
