package com.example.recruitpro.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CompanyCreateDTO {
    @NotBlank(message = "Tên công ty là bắt buộc")
    private String companyName;

    @NotBlank(message = "Mã số thuế của công ty là bắt buộc")
    private String taxCode;
}
