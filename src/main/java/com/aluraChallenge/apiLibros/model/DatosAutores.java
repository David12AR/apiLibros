package com.aluraChallenge.apiLibros.model;

public class DatosAutores {
    private String autor;
    private String fechaNacimiento;
    private String fechaFallecimiento;

    public DatosAutores(){}
    public DatosAutores(DatosAutoresAd datosAutoresAd){
        this.autor = datosAutoresAd.autor();
        this.fechaNacimiento = datosAutoresAd.fechaNacimiento();
        this.fechaFallecimiento = datosAutoresAd.fechaFallecimiento();

    }

    @Override
    public String toString() {
        return
                "Autor =" + autor +
                        ", Fecha de nacimiento ='" + fechaNacimiento + '\'' +
                        ", Fecha de fallecimiento =" + fechaFallecimiento + '\'';

    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(String fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }
}




