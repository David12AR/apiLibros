package com.aluraChallenge.apiLibros.principal;

import com.aluraChallenge.apiLibros.model.DatosLibro;
import com.aluraChallenge.apiLibros.model.Libro;
import com.aluraChallenge.apiLibros.repository.LibroRepository;
import com.aluraChallenge.apiLibros.service.ConsumoAPI;
import com.aluraChallenge.apiLibros.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books";
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<DatosLibro> datosLibros = new ArrayList<>();
    private List<Libro> libros;
    private LibroRepository repositorio;
    private Optional<Libro> libroBuscado;

    public Principal (LibroRepository repository) {
        this.repositorio = repository;
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
        var json = consumoApi.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "+"));
        System.out.println(json);
        DatosLibro datos = conversor.obtenerDatos(json, DatosLibro.class);
        return datos;
    }

    private void buscarlibroPorTitulo() {
        DatosLibro datos = getDatosLibro();
        Libro libro = new Libro(datos);
        repositorio.save(libro);
//        datosSeries.add(datos);
        System.out.println(datos);
        }
    }
