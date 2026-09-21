package com.example.recruitpro.controller;

import com.example.recruitpro.dto.request.JobCreateDTO;
import com.example.recruitpro.dto.response.ApiResponse;
import com.example.recruitpro.dto.response.JobResponse;
import com.example.recruitpro.entity.Job;
import com.example.recruitpro.service.JobService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<JobResponse>> createJob(
            @Valid @RequestBody JobCreateDTO jobCreateDTO
    ) {
        return ResponseEntity.ok(new ApiResponse<>(
                "SUCCESS",
                "Tạo mới công việc thành công",
                jobService.createJob(jobCreateDTO)
        ));
    }
}
