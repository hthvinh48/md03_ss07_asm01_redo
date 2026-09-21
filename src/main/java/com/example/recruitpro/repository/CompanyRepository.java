package com.example.recruitpro.repository;

import com.example.recruitpro.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findCompanyByTaxCode(String taxCode);
}
