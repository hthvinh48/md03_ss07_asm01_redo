package com.example.recruitpro.dto.request;

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
public class CandidateUpdateDTO {
    @NotBlank(message = "Thông tin địa chỉ là bắt buộc")
    private String address;

    @Size(max = 200, message = "Độ dài tối đa của tiểu sử tối đa 200 ký tự")
    private String bio;
}
