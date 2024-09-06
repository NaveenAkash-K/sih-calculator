package com.project.sihcalci.repositories;

import com.project.sihcalci.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, String> {
}
