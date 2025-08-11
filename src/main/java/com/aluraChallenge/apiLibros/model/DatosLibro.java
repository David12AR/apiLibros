package com.aluraChallenge.apiLibros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosLibro(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatosAutores>autores,
        @JsonAlias("languages")String idiomas,
        @JsonAlias("download_count")String numeroDeDescargas
) {
}
