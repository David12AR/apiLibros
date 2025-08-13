package com.aluraChallenge.apiLibros.repository;

import com.aluraChallenge.apiLibros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    Autor findByNombre(String nombreAutor);

    @Query("SELECT a\n" +
            "FROM Autor a\n" +
            "WHERE :vidaTiempo BETWEEN a.fechaNacimiento AND a.fechaFallecimiento")
    List<Autor> listaAutoresPorVivos(@Param("vidaTiempo")int vidaTiempo);
}
