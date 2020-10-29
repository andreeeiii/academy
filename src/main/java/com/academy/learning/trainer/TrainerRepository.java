package com.academy.learning.trainer;

import com.academy.learning.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Service in charge of Trainer database interaction
 */
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
}
