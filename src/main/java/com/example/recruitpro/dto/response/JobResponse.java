package com.example.recruitpro.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobResponse {
    private Long id;
    private String title;
    private String description;
    private String category;
    private String location;
    private CompanyResponse company;
}
