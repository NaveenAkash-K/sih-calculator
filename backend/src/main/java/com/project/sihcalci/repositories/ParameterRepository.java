package com.project.sihcalci.repositories;

import com.project.sihcalci.models.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParameterRepository extends JpaRepository<Parameter, Long> {
}
