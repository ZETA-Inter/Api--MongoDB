package com.example.ZETA_Api_MongoDB.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramResponseDTO {

    private Integer id;

    private String name;

    private String description;

    private String segmentName;

}
