package com.example.ZETA_Api_MongoDB.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Content {

    @JsonProperty("image_url")
    private String imageUrl;

    @NotNull(message = "field 'text' is null")
    private String text;

}
