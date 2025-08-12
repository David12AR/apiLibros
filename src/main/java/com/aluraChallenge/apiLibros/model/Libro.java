package com.aluraChallenge.apiLibros.model;

//import com.aluracursos.screenmatch.service.ConsultaChatGPT;
import com.aluraChallenge.apiLibros.dto.DatosLibro;
import jakarta.persistence.*;

@Entity
@Table(name = "libros")


public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String titulo;

    @ManyToOne
    private Autor autor;
    private String idioma;
    private Double numeroDeDescargas;



    public Libro(){}
    public Libro(DatosLibro datos, Autor autor){
        this.titulo = datos.titulo();
        this.autor = autor;
        this.idioma = datos.idioma().get(0);
        this.numeroDeDescargas = datos.numeroDeDescargas();

    }

    @Override
    public String toString() {
        return
                "Título=" + titulo +
                        ", Autor" + autor +
                ", Idioma=" + idioma +
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }
}
