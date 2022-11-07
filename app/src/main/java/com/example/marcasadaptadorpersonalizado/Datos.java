package com.example.marcasadaptadorpersonalizado;

/*
Autor: Juan Francisco Sánchez González
Fecha: 02/11/2022
Clase: Clase que contendrá los campos que se van a utilizar para el adaptador.
La fuente de información.
*/

public class Datos {
    private String marca;
    private String descripcion;

    public Datos(String texto1, String texto2) {
        marca = texto1;
        descripcion = texto2;
    }

    public String getMarca() {
        return marca;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
