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
public class Law {

    @NotNull(message = "field 'number' is null")
    private String number;

    @NotNull(message = "field 'description' is null")
    private String description;
}
