package com.example.ZETA_Api_MongoDB.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityResponseDTO {
    private Integer id;
    private String ClassTitle;
    private Integer points;
}
