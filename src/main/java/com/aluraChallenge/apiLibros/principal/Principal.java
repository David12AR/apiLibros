package com.aluraChallenge.apiLibros.principal;

import com.aluraChallenge.apiLibros.dto.DatosAutor;
import com.aluraChallenge.apiLibros.dto.DatosLibro;
import com.aluraChallenge.apiLibros.dto.DatosResultado;
import com.aluraChallenge.apiLibros.model.Autor;
import com.aluraChallenge.apiLibros.model.Libro;
import com.aluraChallenge.apiLibros.repository.AutorRepository;
import com.aluraChallenge.apiLibros.repository.LibroRepository;
import com.aluraChallenge.apiLibros.service.ConsumoAPI;
import com.aluraChallenge.apiLibros.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;



public class Principal {
    @Autowired
    private final LibroRepository libroRepository;

    @Autowired
    private final AutorRepository autorRepository;

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();
    private String json;

public Principal(LibroRepository libroRepository, AutorRepository autorRepository){
    this.autorRepository = autorRepository;
    this.libroRepository = libroRepository;
}


    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    Elije la opción a través de su número
                    1 - Buscar libro por título
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarlibroPorTitulo();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        }

    }

    private DatosLibro getDatosLibro() {
        System.out.println("Por favor escriba el nombre de la serie que desea buscar:");

        var nombreLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "?search="+ nombreLibro.replace(" ", "+"));
        System.out.println(json);
        DatosResultado datos = conversor.obtenerDatos(json, DatosResultado.class);
        Optional<DatosLibro> libroBuscado = datos.resultados().stream()
                .filter(Libro -> Libro.titulo().toUpperCase().contains(nombreLibro.toUpperCase()))
                .findFirst();
        if (libroBuscado.isPresent()){
            return libroBuscado.get();

        }else
            return null;
    }

    private void buscarlibroPorTitulo() {
        DatosLibro datos = getDatosLibro();
        if(datos != null) {
            Libro libro;
            DatosAutor datosAutor = datos.autor().get(0);
            Autor autorExistente = autorRepository.findByNombre(datosAutor.nombre());
            if (autorExistente != null) {
                libro = new Libro(datos, autorExistente);
            } else {
                Autor nuevoAutor = new Autor(datosAutor);
                libro = new Libro(datos, nuevoAutor);
                autorRepository.save(nuevoAutor);
            }
            try {
                libroRepository.save(libro);
                System.out.println(libro);
            } catch (Exception e) {
                System.out.println("No se puede registrar un libro más de una vez");
            }
        }else{
            System.out.println("El libro no se encuentra en la API");

        }
        }
    }
