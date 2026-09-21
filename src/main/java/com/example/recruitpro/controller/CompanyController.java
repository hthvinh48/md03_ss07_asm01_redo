package com.example.recruitpro.controller;

import com.example.recruitpro.dto.request.CompanyCreateDTO;
import com.example.recruitpro.dto.response.ApiResponse;
import com.example.recruitpro.entity.Company;
import com.example.recruitpro.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Company>> createCompany(@RequestBody CompanyCreateDTO companyCreateDTO) {
        return ResponseEntity.ok(new ApiResponse<>(
                "SUCCESS",
                "Tạo mới công ty thành công",
                companyService.createCompany(companyCreateDTO)
        ));
    }
}
