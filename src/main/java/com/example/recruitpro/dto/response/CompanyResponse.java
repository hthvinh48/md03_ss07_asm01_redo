package com.example.recruitpro.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyResponse {
    private Long id;
    private String companyName;
    private String companyAddress;
    private String companyEmail;
    private String taxCode;
}
