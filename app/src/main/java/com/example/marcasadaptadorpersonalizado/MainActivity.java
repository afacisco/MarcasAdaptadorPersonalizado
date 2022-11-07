package com.example.marcasadaptadorpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

/*
Autor: Juan Francisco Sánchez González
Fecha: 02/11/2022
Clase: Única actividad del proyecto, dónde se cargan los datos para el Adaptador personalizado
que vamos a utilizar para rellenar el control ListView.
*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Datos a mostrar en el listado
        Datos[] datos = new Datos[] {
                new Datos(getString(R.string.marca_nike), getString(R.string.descripcion_nike)),
                new Datos(getString(R.string.marca_hurley), getString(R.string.descripcion_hurley)),
                new Datos(getString(R.string.marca_levis), getString(R.string.descripcion_levis)),
                new Datos(getString(R.string.marca_nsp), getString(R.string.descripcion_nsp)),
                new Datos(getString(R.string.marca_quick), getString(R.string.descripcion_quick)),
                new Datos(getString(R.string.marca_vans), getString(R.string.descripcion_vans))};


        ListView listadoMarcas = (ListView) findViewById(R.id.gvMarcas);

        // Cabecera del listado
        View cabeceraGV = getLayoutInflater().inflate(R.layout.cabecera_gv, null);
        listadoMarcas.addHeaderView(cabeceraGV);

        // Instanciamos y asignamos el adaptador personalizado
        AdaptadorGV adaptador = new AdaptadorGV(this, datos);
        listadoMarcas.setAdapter(adaptador);

        /* Listener para controlar el pulsado de alguna de las opciones del listado. Recogemos los textos
        del ítem pulsado y los mostramos en 2 controles TextView */
        listadoMarcas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView marcaSeleccionada = (TextView) findViewById(R.id.tvMensajeMarca);
                String marca = ((Datos)adapterView.getItemAtPosition(i)).getMarca();
                marcaSeleccionada.setText(marca);

                TextView descripcionSeleccionada = (TextView) findViewById(R.id.tvMensajeDescripcion);
                String descripcion = ((Datos)adapterView.getItemAtPosition(i)).getDescripcion();
                descripcionSeleccionada.setText(descripcion);
            }
        });
    }
}