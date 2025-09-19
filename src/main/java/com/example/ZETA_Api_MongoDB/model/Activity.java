package com.example.ZETA_Api_MongoDB.model;

import jakarta.validation.constraints.NotNull;
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
@Document(collection = "activities")
public class Activity {

    @Id
    private Integer id;

    @Field(name = "class_id")
    private Integer classId;

    private List<String> images;

    private Integer points;

    private List<Question> questions;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Question {

        @NotNull(message = "field 'question' is null")
        private String question;

        @NotNull(message = "field 'answers' is null")
        private List<Answer> answers;

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Answer {

            @NotNull(message = "field 'answer' is null")
            private String answer;

            @NotNull(message = "field 'correct' is null")
            private boolean correct;
        }
    }

}
