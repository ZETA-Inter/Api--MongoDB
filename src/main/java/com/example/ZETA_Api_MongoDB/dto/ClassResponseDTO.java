package com.example.ZETA_Api_MongoDB.dto;

import com.example.ZETA_Api_MongoDB.model.Content;
import com.example.ZETA_Api_MongoDB.model.FlashCard;
import com.example.ZETA_Api_MongoDB.model.Law;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassResponseDTO {

    private Integer id;
    private String title;
    private List<Content> content;
    private String description;
    private List<FlashCard> flashcards;
    private List<Law> laws;

}
