package com.aluraChallenge.apiLibros.model;

//import com.aluracursos.screenmatch.service.ConsultaChatGPT;
import jakarta.persistence.*;

import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name = "libros")


public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String titulo;
    private List<DatosAutores> autores;
    private String idiomas;
    private Double numeroDeDescargas;



    public Libro(){}
    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.autores = datosLibro.autores();
        this.idiomas = datosLibro.idiomas();
        this.numeroDeDescargas = OptionalDouble.of(Double.valueOf(datosLibro.numeroDeDescargas())).orElse(0);

    }

    @Override
    public String toString() {
        return
                "Título=" + titulo +
                ", Autor='" + autores + '\'' +
                ", Idioma=" + idiomas +
                ", Numero de descargas=" + numeroDeDescargas + '\'';

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<DatosAutores> getAutores() {
        return autores;
    }

    public void setAutores(List<DatosAutores> autores) {
        this.autores = autores;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }
}
