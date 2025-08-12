package com.aluraChallenge.apiLibros.model;

import com.aluraChallenge.apiLibros.dto.DatosAutor;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer fechaNacimiento;

    private Integer fechaFallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Libro> libros = new ArrayList();

    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.fechaNacimiento = datosAutor.fechaNacimiento() != null && !datosAutor.fechaNacimiento().isEmpty()
                ? Integer.valueOf(datosAutor.fechaNacimiento())
                : null;
        this.fechaFallecimiento = datosAutor.fechaFallecimiento() != null && !datosAutor.fechaFallecimiento().isEmpty()
                ? Integer.valueOf(datosAutor.fechaFallecimiento())
                : null;
    }
    @Override
    public String toString() {
        return
                "Nombre=" + nombre +
                        ", Fecha de nacimmiento=" + fechaNacimiento +
                        ", Fecha de fallecimiento=" + fechaFallecimiento +
                        ", Libros=" + libros + '\'';

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Integer fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}



