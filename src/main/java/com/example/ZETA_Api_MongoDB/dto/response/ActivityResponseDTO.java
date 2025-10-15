package com.example.ZETA_Api_MongoDB.dto.response;

import com.example.ZETA_Api_MongoDB.model.Activity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityResponseDTO {
    private Integer id;
    private Integer points;
    private List<Activity.Question> questions;
}
