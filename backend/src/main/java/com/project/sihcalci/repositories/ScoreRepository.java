package com.project.sihcalci.repositories;

import com.project.sihcalci.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, String> {
}
