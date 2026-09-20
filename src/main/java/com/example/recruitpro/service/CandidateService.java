package com.example.recruitpro.service;

import com.example.recruitpro.dto.request.CandidateCreateDTO;
import com.example.recruitpro.dto.request.CandidateUpdateDTO;
import com.example.recruitpro.entity.Candidate;
import com.example.recruitpro.exception.ResourceNotFoundException;
import com.example.recruitpro.repository.CandidateRepository;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Candidate findCandidateById(Integer id) {
        return candidateRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Không tìm thấy ứng viên với id: " + id)
        );
    }

    public Candidate createCandidate(CandidateCreateDTO candidateCreateDTO) {
        Candidate candidate = new Candidate();
        candidate.setFullName(candidateCreateDTO.getFullName());
        candidate.setEmail(candidateCreateDTO.getEmail());
        candidate.setAge(candidateCreateDTO.getAge());
        candidate.setYearsOfExperience(candidateCreateDTO.getYearsOfExperience());
        candidate.setPhone(candidateCreateDTO.getPhone());
        candidateRepository.save(candidate);
        return candidate;
    }

    public Candidate updateCandidate(Integer id, CandidateUpdateDTO candidateUpdateDTO) {
        Candidate candidate = findCandidateById(id);

        candidate.setAddress(candidateUpdateDTO.getAddress());
        candidate.setBio(candidateUpdateDTO.getBio());
        candidateRepository.save(candidate);

        return candidate;
    }
}
