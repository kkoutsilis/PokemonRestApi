package com.example.PokemonDB.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Pokemon {

    private final UUID id;
    @NotBlank
    private final String name;
    private final String type;


    public Pokemon(@JsonProperty("id") UUID id, @JsonProperty("name")String name,@JsonProperty("type") String type) {
        this.id=id;
        this.name=name;
        this.type=type;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
