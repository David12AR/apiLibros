package com.aluraChallenge.apiLibros.dto;

import com.aluraChallenge.apiLibros.model.DatosAutores;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record DtoLibro (
        String titulo,
        List<DatosAutores> autores,
        String idiomas,
        Double numeroDeDescargas
) {
}
