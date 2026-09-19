package com.example.recruitpro.service;

import com.example.recruitpro.dto.request.CandidateCreateDTO;
import com.example.recruitpro.entity.Candidate;
import com.example.recruitpro.repository.CandidateRepository;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Candidate createCandidate(CandidateCreateDTO candidateCreateDTO) {
        Candidate candidate = new Candidate();
        candidate.setFullName(candidateCreateDTO.getFullName());
        candidate.setEmail(candidateCreateDTO.getEmail());
        candidate.setAge(candidateCreateDTO.getAge());
        candidate.setYearsOfExperience(candidateCreateDTO.getYearsOfExperience());
        candidateRepository.save(candidate);
        return candidate;
    }
}
