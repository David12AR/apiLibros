package com.aluraChallenge.apiLibros.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);

}
