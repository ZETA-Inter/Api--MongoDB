package com.example.ZETA_Api_MongoDB.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    private String text;

}
