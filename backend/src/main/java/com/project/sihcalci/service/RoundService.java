package com.project.sihcalci.service;

import com.project.sihcalci.models.Round;
import com.project.sihcalci.repositories.RoundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoundService {

    private final RoundRepository roundRepository;

    public List<Round> getRounds() {
        return roundRepository.findAll();
    }

    public void toggleRound(Long id) {
        Round round = roundRepository.findById(id).orElseThrow(() -> new RuntimeException("Round not found"));
        round.setActive(!round.isActive());
        roundRepository.save(round);
    }
}
