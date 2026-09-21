package com.example.recruitpro.service;

import com.example.recruitpro.dto.request.JobCreateDTO;
import com.example.recruitpro.dto.response.CompanyResponse;
import com.example.recruitpro.dto.response.JobResponse;
import com.example.recruitpro.entity.Company;
import com.example.recruitpro.entity.Job;
import com.example.recruitpro.exception.ResourceNotFoundException;
import com.example.recruitpro.repository.CompanyRepository;
import com.example.recruitpro.repository.JobRepository;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;

    public JobService(JobRepository jobRepository, CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
    }

    public JobResponse createJob(JobCreateDTO jobCreateDTO) {
        Company company = companyRepository.findCompanyByTaxCode(jobCreateDTO.getCompany().getTaxCode()).orElseThrow(
                () -> new ResourceNotFoundException("Company Not Found")
        );

        Job job = new Job();
        job.setTitle(jobCreateDTO.getTitle());
        job.setCompany(company);
        jobRepository.save(job);

        return new JobResponse(
                job.getId(),
                job.getTitle(),
                job.getDescription(),
                job.getCategory(),
                job.getLocation(),
                new CompanyResponse(
                        job.getCompany().getId(),
                        job.getCompany().getCompanyName(),
                        job.getCompany().getCompanyAddress(),
                        job.getCompany().getCompanyEmail(),
                        job.getCompany().getTaxCode()
                )
        );
    }
}
