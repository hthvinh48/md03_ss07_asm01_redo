package com.example.recruitpro.dto.request;

import com.example.recruitpro.dto.response.CompanyDTO;
import jakarta.validation.Valid;
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

    @Valid
    @NotNull
    private CompanyDTO company;
}
