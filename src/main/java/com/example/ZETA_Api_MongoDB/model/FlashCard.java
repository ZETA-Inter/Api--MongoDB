package com.example.ZETA_Api_MongoDB.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlashCard {

    @NotNull(message = "field 'question' is null")
    private String question;

    @NotNull(message = "field 'answer' is null")
    private String answers;
}