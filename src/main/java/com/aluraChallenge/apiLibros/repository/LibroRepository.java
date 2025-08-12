package com.aluraChallenge.apiLibros.repository;

import com.aluraChallenge.apiLibros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro,Long> {
}
