package com.example.recruitpro.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyDTO {
    @NotBlank(message = "Tên công ty là bắt buộc")
    private String name;

    @NotBlank
    @Size(min = 10, max = 13)
    private String taxCode;
}
