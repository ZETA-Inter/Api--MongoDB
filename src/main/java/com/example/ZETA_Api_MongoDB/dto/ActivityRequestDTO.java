package com.example.ZETA_Api_MongoDB.dto;

import com.example.ZETA_Api_MongoDB.model.Activity;
import com.example.ZETA_Api_MongoDB.validation.OnCreate;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityRequestDTO {

    @JsonProperty("class_id")
    @NotNull(message = "field 'classId' is null", groups = OnCreate.class)
    @Min(value = 0, message = "'ClassId' can't be less than 1")
    private Integer classId;

    @NotNull(message = "field 'points' is null", groups = OnCreate.class)
    @Min(value = 0, message = "'Points' can't be less than 1")
    private Integer points;

    @NotNull(message = "field 'questions' is null", groups = OnCreate.class)
    private List<Activity.Question> questions;
}
