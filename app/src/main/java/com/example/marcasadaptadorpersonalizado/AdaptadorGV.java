package com.example.marcasadaptadorpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/*
Autor: Juan Francisco Sánchez González
Fecha: 02/11/2022
Clase: Adaptador personalizado, al que le pasaremos los datos a mostrar y se encargará de
convertirlos en vistas que se desplegarán en el listado.
*/

public class AdaptadorGV extends ArrayAdapter<Datos> {
    private Datos[] datos;

    public AdaptadorGV(Context context, Datos[] datos) {
        super(context, R.layout.gridview_marcas, datos);
        this.datos = datos;
    }

    // Método que inflará cada elemento del listado (con sus campos) en la interfaz
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View elemento = mostrado.inflate(R.layout.gridview_marcas, parent, false);
        TextView textoMarca = (TextView) elemento.findViewById(R.id.tvMarca);
        textoMarca.setText(datos[position].getMarca());
        TextView textoDescripcion = (TextView) elemento.findViewById(R.id.tvDescripcion);
        textoDescripcion.setText(datos[position].getDescripcion());
        return elemento;
    }
}
