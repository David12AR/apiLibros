package com.aluraChallenge.apiLibros.repository;

import com.aluraChallenge.apiLibros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    Autor findByNombre(String nombreAutor);

}
