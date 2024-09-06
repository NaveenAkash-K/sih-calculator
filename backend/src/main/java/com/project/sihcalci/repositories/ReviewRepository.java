package com.project.sihcalci.repositories;

import com.project.sihcalci.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, String> {
}
