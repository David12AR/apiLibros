# 📚 API Libros

<div align="center">
  <img src="https://github.com/David12AR/apiLibros/blob/main/imagenes/menu-api-libros.JPG?raw=true" width="500">
</div>

<div align="center">
  
[![GitHub stars](https://img.shields.io/github/stars/David12AR/apiLibros?style=social)](https://github.com/David12AR/apiLibros)  
[![GitHub forks](https://img.shields.io/github/forks/David12AR/apiLibros?style=social)](https://github.com/David12AR/apiLibros)  
[![License](https://img.shields.io/github/license/David12AR/apiLibros)](https://github.com/David12AR/apiLibros)  
[![Last commit](https://img.shields.io/github/last-commit/David12AR/apiLibros)](https://github.com/David12AR/apiLibros)  
[![Java](https://img.shields.io/badge/Java-21-orange)](https://www.oracle.com/java/)  
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)](https://spring.io/projects/spring-boot)  

</div>

---

## 📑 Índice
1. [📌 Acerca del proyecto](#-acerca-del-proyecto)  
2. [✨ Funcionalidades](#-funcionalidades)  
3. [🚀 ¿Cómo funciona?](#-cómo-funciona)  
4. [🛠️ Tecnologías utilizadas](#-tecnologías-utilizadas)  
5. [👤 Autor](#-autor)  

---

## 📌 Acerca del proyecto

Este proyecto desarrollado en **Java** y **Spring Boot**, conectado a la **GUTENDEX API** y a una base de datos **PostgreSQL**, permite registrar libros y autores en una BD a partir de una API completa.  
Además, se pueden consultar y filtrar libros y autores mediante un menú interactivo.  

El usuario puede:
- Consultar libros y autores registrados
- Filtrar por idioma
- Listar autores vivos en un año específico  

**🏁 Estado:** Proyecto finalizado ✅ con posibilidades de mejora y contribución.

---

## ✨ Funcionalidades

- 🔟 **Menú interactivo** con 5 opciones:
  - Buscar libro por título
  - Listar libros registrados
  - Listar autores registrados
  - Listar autores vivos en determinado año
  - Listar libros por idioma

- 📄 **Registro de libro**: Busca en la API y guarda los datos más importantes en la base de datos.  
- 🚪 **Opción 0 para salir**: Cierra la aplicación.  
- ⚠️ **Validaciones inteligentes**:
  - ❌ Rechazo de caracteres no permitidos
  - 🔢 Control de valores fuera de rango en el menú

---

## 🚀 ¿Cómo funciona?

1. **Selecciona una opción (1-5)** del menú.  
   Ejemplo: opción 3 → listar autores registrados.

2. **Buscar libro por título**  
   - Ingresa el nombre completo o parcial del libro.
     
     <img src="https://github.com/David12AR/apiLibros/blob/main/imagenes/primera-opcion.JPG?raw=true" width="500">
     
   - El sistema lo busca en la API y lo guarda en la BD.  
   - Soporta mayúsculas y minúsculas.
     
     <img src="https://github.com/David12AR/apiLibros/blob/main/imagenes/primera-opcion-busqueda-mayus.JPG?raw=true" width="500">
     
   - Valida datos inexistentes o incorrectos.
     
     <img src="https://github.com/David12AR/apiLibros/blob/main/imagenes/primera-opcion-validacion.JPG?raw=true" width="500">
     
3. **Consultar libros registrados**  
   - Muestra todos los libros guardados en la BD.
     
     <img src="https://github.com/David12AR/apiLibros/blob/main/imagenes/segunda-opcion.JPG?raw=true" width="500">
   
     <img src="https://github.com/David12AR/apiLibros/blob/main/imagenes/segunda-opcion-segunda-parte.JPG?raw=true" width="500">
     
4. **Consultar autores registrados**  
   - Lista autores, fechas de nacimiento y fallecimiento.
   - Muestra los libros escritos por los auotres y registrados.
     
     <img src="https://github.com/David12AR/apiLibros/blob/main/imagenes/tercera-opcion.JPG?raw=true" width="500">
     
     <img src="https://github.com/David12AR/apiLibros/blob/main/imagenes/tercera-opcion-segunda-parte.JPG?raw=true" width="500">

6. **Filtrar autores vivos en un año**  
   - Lista autores vivos en ese año.
     
     <img src="https://github.com/David12AR/apiLibros/blob/main/imagenes/cuarta-opcion.JPG?raw=true" width="500">
     
   - Valida año inexistente o tipo de dato incorrecto.
     
     <img src="https://github.com/David12AR/apiLibros/blob/main/imagenes/cuarta-opcion-validacion.JPG?raw=true" width="500">
     
     <img src="https://github.com/David12AR/apiLibros/blob/main/imagenes/cuarta-opcion-segunda-validacion.JPG?raw=true" width="500">
     
7. **Buscar libros por idioma**  
   - Idiomas disponibles: `es`, `en`, `fr`, `it`.
     
     <img src="https://github.com/David12AR/apiLibros/blob/main/imagenes/quinta-opcion.JPG?raw=true" width="500">
   
   - Soporta mayúsculas/minúsculas.
     
     <img src="https://github.com/David12AR/apiLibros/blob/main/imagenes/quinta-opcion-busqueda-mayus.JPG?raw=true" width="500">
     
   - Valida si el idioma no existe o no tiene resultados.
     
     <img src="https://github.com/David12AR/apiLibros/blob/main/imagenes/quinta-opcion-validacion.JPG?raw=true" width="500">
     
     <img src="https://github.com/David12AR/apiLibros/blob/main/imagenes/quinta-opcion-segunda-validacion.JPG?raw=true" width="500">

8. **Cerrar aplicación**
   -Cierra la aplicación con la ultima opción.
   
   <img src="https://github.com/David12AR/apiLibros/blob/main/imagenes/opcion-cero.JPG?raw=true" width="500">
   
---

## 🛠️ Tecnologías utilizadas

- **Java** → Lógica y ejecución por consola  
- **Spring Boot Initializr** → Estructura y dependencias  
- **Maven** → Gestión de dependencias y compilación  
- **Delivery queries** → Consultas personalizadas  
- **Gutendex API** → Fuente de datos de libros  
- **PostgreSQL** → Base de datos relacional

---

## 👤 Autor

| [<img src="imagenes/david_linkedin.jpg" width=115><br><sub>David Acosta</sub>](https://github.com/David12AR) |
| :---: |

💻 [GitHub](https://github.com/David12AR) • 🔗 [LinkedIn](https://linkedin.com/in/david-acosta01)

