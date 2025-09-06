package com.farmatodo.farmatodo.repositories;

import com.farmatodo.farmatodo.models.entities.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
}
