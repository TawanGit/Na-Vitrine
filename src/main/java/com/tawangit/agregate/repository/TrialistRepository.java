package com.tawangit.agregate.repository;

import com.tawangit.agregate.entity.Trialist.Trialist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrialistRepository extends JpaRepository<Trialist, UUID> {
}
