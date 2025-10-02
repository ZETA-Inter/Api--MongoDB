package com.example.ZETA_Api_MongoDB.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "classes")
public class Class {

    @Id
    private Integer id;

    @Field(name = "program_id")
    private Integer programId;

    private String title;

    private List<Content> content;

    private String description;

    private List<FlashCard> flashcards;

    private List<Law> laws;

}
