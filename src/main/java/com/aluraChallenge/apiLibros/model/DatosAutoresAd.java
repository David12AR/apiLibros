package com.aluraChallenge.apiLibros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosAutoresAd(
        @JsonAlias("name") String autor,
        @JsonAlias("birth_year") String fechaNacimiento,
        @JsonAlias("death_year")String fechaFallecimiento
) {
}
