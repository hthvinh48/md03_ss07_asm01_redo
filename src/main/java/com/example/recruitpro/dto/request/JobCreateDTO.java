package com.example.recruitpro.dto.request;

import com.example.recruitpro.dto.response.CompanyDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobCreateDTO {
    @NotBlank(message = "Tên công việc là bắt buộc")
    private String title;

    @Min(value = 0, message = "Lương tối thiểu phải lớn hơn hoặc bằng 0")
    private Double salaryMin;

    @Min(value = 0, message = "Lương tối đa phải lớn hơn hoặc bằng 0")
    private Double salaryMax;

    @Valid
    @NotNull
    private CompanyDTO company;
}
