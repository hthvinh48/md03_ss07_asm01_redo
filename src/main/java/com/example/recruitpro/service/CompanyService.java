package com.example.recruitpro.service;

import com.example.recruitpro.dto.request.CompanyCreateDTO;
import com.example.recruitpro.entity.Company;
import com.example.recruitpro.exception.ResourceNotFoundException;
import com.example.recruitpro.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Company with id: " + id + " not found")
        );
    }

    public Company createCompany(CompanyCreateDTO companyCreateDTO) {
        Company company = new Company();
        company.setCompanyName(companyCreateDTO.getCompanyName());
        company.setTaxCode(companyCreateDTO.getTaxCode());
        return companyRepository.save(company);
    }
}
