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

import java.util.*;
import java.util.stream.Collectors;


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
    private List<Libro> libros;

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
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosDeterminadoTiempo();
                    break;
                case 5:
                    listarLibroPorIdioma();
                    break;
                case 0:
                    System.out.println("Gracias por utilizar el programa de libros, cerrando programa");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        }

    }

    private void listarLibroPorIdioma() {
        System.out.println("""
                Por favor escriba el idioma en que desea buscar los libros:
                es - Español
                en - Ingles
                fr - Frances
                it - Italiano
                """);
        var idioma = teclado.nextLine().trim();

        if (!idioma.matches("[a-zA-Z]+")) {
            System.out.println("Por favor ingresar solo texto sin números.");
            return;
        }

        try {
            List<Libro> libroPorIdioma = libroRepository.findByIdiomaIgnoreCase(idioma);
            if (libroPorIdioma.isEmpty()) {
                System.out.println("No se encontraron libros en ese idioma " + libroPorIdioma);
                return;
            }


            System.out.println("---------LOS LIBROS EN EL IDIOMA: " + idioma + "---------");
            libroPorIdioma.forEach(libro -> {
                System.out.println("-------------------LIBRO---------------------");
                System.out.println("TÍTULO: " + libro.getTitulo());
                System.out.println("AUTOR: " +
                        (libro.getAutor() != null ? libro.getAutor().getNombre() : "Desconocido"));
                System.out.println("IDIOMA: " + libro.getIdioma());
                System.out.println("NÚMERO DE DESCARGAS: " + libro.getNumeroDeDescargas());
                System.out.println("---------------------------------------------");
            });
        } catch (Exception e) {
            System.out.println("Se produjo un error al buscar el libro."+ e.getMessage());
        }
        }


    private void listarAutoresVivosDeterminadoTiempo() {
        System.out.println("Por favor escriba el año que desea validar si el autor estaba vivo:");
        String vidaTiempo = teclado.nextLine().trim();

        try {
            int vidaTiempo1 = Integer.parseInt(vidaTiempo);
            List<Autor> autoresVivos = autorRepository.listaAutoresPorVivos(vidaTiempo1);

            if (autoresVivos.isEmpty()) {
                System.out.println("No se encontraron autores vivos en el año " + vidaTiempo);
                return;
            }


        System.out.println    ("------------AUTORES VIVOS EN "+ vidaTiempo1+"------------");
        autoresVivos.forEach(autor -> {
            System.out.println("-------------------AUTOR---------------------");
            System.out.println("AUTOR: " + autor.getNombre());
            System.out.println("FECHA DE NACIMIENTO: " + autor.getFechaNacimiento());
            System.out.println("FECHA DE FALLECIMIENTO: " + autor.getFechaFallecimiento());
            System.out.println("LIBROS: " + autor.getLibros()
                    .stream()
                    .map(Libro::getTitulo)
                    .collect(Collectors.joining(", ")));
            System.out.println("---------------------------------------------");
        });

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debe ingresar un año numérico.");
        }
    }

    private void listarAutoresRegistrados() {
        List<Autor> autores = autorRepository.findAll();

        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados.");
            return;
        }
        System.out.println    ("--------------AUTORES REGISTRADOS------------");

        autores.stream().forEach(autor -> {
            System.out.println("-------------------AUTOR---------------------");
            System.out.println("AUTOR: " + autor.getNombre());
            System.out.println("FECHA DE NACIMIENTO: " + autor.getFechaNacimiento());
            System.out.println("FECHA DE FALLECIMIENTO: " + autor.getFechaFallecimiento());
            System.out.println("LIBROS: " + autor.getLibros()
                    .stream()
                    .map(Libro::getTitulo)
                    .collect(Collectors.joining(", ")));
            System.out.println("---------------------------------------------");
        });
    }

    private void listarLibrosRegistrados() {
        List<Libro> libros = libroRepository.findAll();

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        System.out.println("--------------LIBROS REGISTRADOS-------------");


        libros.stream().forEach(libro -> {
            System.out.println("-------------------LIBRO---------------------");
            System.out.println("TÍTULO: " + libro.getTitulo());
            System.out.println("AUTOR: " +
                    (libro.getAutor() != null ? libro.getAutor().getNombre() : "Desconocido"));
            System.out.println("IDIOMA: " + libro.getIdioma());
            System.out.println("NÚMERO DE DESCARGAS: " + libro.getNumeroDeDescargas());
            System.out.println("---------------------------------------------");
        });
    }

    private DatosLibro getDatosLibro() {
        System.out.println("Por favor escriba el nombre de la serie que desea buscar:");

        var nombreLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "?search="+ nombreLibro.replace(" ", "+"));
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
                System.out.println("------------------LIBRO-----------------");
                System.out.println("TÍTULO: " + libro.getTitulo());
                System.out.println("AUTOR: " +
                        (libro.getAutor() != null ? libro.getAutor().getNombre() : "Desconocido"));
                System.out.println("IDIOMA: " + libro.getIdioma());
                System.out.println("NÚMERO DE DESCARGAS: " + libro.getNumeroDeDescargas());
                System.out.println("----------------------------------------");
            } catch (Exception e) {
                System.out.println("No se puede registrar un libro más de una vez");
            }
        }else{
            System.out.println("El libro no se encuentra en la API");

        }
        }
    }
