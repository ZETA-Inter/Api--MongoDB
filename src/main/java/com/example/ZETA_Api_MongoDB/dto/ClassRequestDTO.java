package com.example.ZETA_Api_MongoDB.dto;

import com.example.ZETA_Api_MongoDB.model.FlashCard;
import com.example.ZETA_Api_MongoDB.model.Law;
import com.example.ZETA_Api_MongoDB.validation.OnCreate;
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
public class ClassRequestDTO {

    @Min(value = 0, message = "'ProgramId' can't be less than 1")
    private Integer programId;

    @NotNull(message = "field 'title' is null", groups = OnCreate.class)
    private String title;

    private List<String> images;

    @NotNull(message = "field 'text' is null", groups = OnCreate.class)
    private String text;

    private List<FlashCard> flashcards;

    private List<Law> laws;

}
