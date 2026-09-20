package com.example.recruitpro.controller;

import com.example.recruitpro.dto.request.CandidateCreateDTO;
import com.example.recruitpro.dto.request.CandidateUpdateDTO;
import com.example.recruitpro.dto.response.ApiResponse;
import com.example.recruitpro.entity.Candidate;
import com.example.recruitpro.service.CandidateService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Candidate>> addCandidate(
            @Valid @RequestBody CandidateCreateDTO candidateCreateDTO
    ) {
        return ResponseEntity.ok(new ApiResponse<>(
                "SUCCESS",
                "Tạo mới dữ liệu thành công",
                candidateService.createCandidate(candidateCreateDTO)
        ));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<Candidate>> updateCandidate(
            @PathVariable Integer id,
            @Valid @ModelAttribute CandidateUpdateDTO candidateUpdateDTO
    ) {
        return ResponseEntity.ok(new ApiResponse<>(
                "SUCCESS",
                "Cập nhật thông tin candidate thành công",
                candidateService.updateCandidate(id, candidateUpdateDTO)
        ));
    }
}
