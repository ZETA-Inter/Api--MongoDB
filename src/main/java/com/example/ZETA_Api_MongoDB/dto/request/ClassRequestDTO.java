package com.example.ZETA_Api_MongoDB.dto.request;

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

    @NotNull(message = "field 'programId' is null", groups = OnCreate.class)
    @Min(value = 0, message = "'ProgramId' can't be less than 1")
    private Integer programId;

    @NotNull(message = "field 'title' is null", groups = OnCreate.class)
    private String title;

    @NotNull(message = "field 'content' is null", groups = OnCreate.class)
    private List<String> content;

    @NotNull(message = "field 'description' is null", groups = OnCreate.class)
    private String description;

    @NotNull(message = "field 'flashcards' is null", groups = OnCreate.class)
    private List<FlashCard> flashcards;

    @NotNull(message = "field 'laws' is null", groups = OnCreate.class)
    private List<Law> laws;

}
