package com.example.fitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {

    Toolbar toolbar;
    Button acceder;
    SQLiteDatabase db;
    SQLiteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        acceder = findViewById(R.id.btnEntrar);
        helper = new SQLiteHelper(this);
        db = helper.getWritableDatabase();

        db.delete(EstructuraBBDD.EstructuraEjercicios.TABLE_NAME_EJERCICIOS, "_id>1", null);

        insertaEjer("Press banca", "Pecho", "7aQY3u0Dk-Q&ab");
        insertaEjer("Press banca inclinado", "Pecho", "swMjJqFzxCQ&ab");
        insertaEjer("Press banca declinado", "Pecho", "NNz3_wUMrvI&ab");
        insertaEjer("Aperturas", "Pecho", "xyHdY99F640&ab");
        insertaEjer("Press militar", "Hombro", "j_Buh54Sb-w&ab");
        insertaEjer("Elevaciones laterales", "Hombro", "hgLpdwMtEEs&ab");
        insertaEjer("Elevación frontal", "Hombro", "qIxtugfMI-E&ab");
        insertaEjer("Elevación posterior", "Hombro", "zdLlyFb5YDI&ab");
        insertaEjer("Dominadas", "Espalda", "8mhDd9Ahl1M&ab");
        insertaEjer("Jalón al pecho", "Espalda", "xpIlNU4qZd8&ab");
        insertaEjer("Remo", "Espalda", "I8-nqk81gwI&ab");
        insertaEjer("Extensión lumbar", "Espalda", "Dd27xSYbjb8&ab");
        insertaEjer("Curl bíceps", "Bíceps", "V1qprKjuNV8&ab");
        insertaEjer("Curl estilo martillo", "Bíceps", "8ajGwhCkSss&ab");
        insertaEjer("Curl concentrado", "Bíceps", "E6idMdmNyxI&ab");
        insertaEjer("Fondos", "Tríceps", "1Vm1ATIi0AE&ab");
        insertaEjer("Extensiones con mancuernas", "Tríceps", "rIlb_t6SVf0&ab");
        insertaEjer("Polea tríceps", "Tríceps", "FspY_qJBXZc&ab");
        insertaEjer("Extensión cuádriceps", "Pierna", "r7ZMTzfiICA&ab");
        insertaEjer("Sentadilla", "Pierna", "0rgiePufo0A&ab");
        insertaEjer("Prensa", "Pierna", "bKcV1I5rB_g&ab");
        insertaEjer("Peso muerto", "Pierna", "7_Wm0YGQinw&ab");
        insertaEjer("Zancada", "Pierna", "U2lK6PaJ0kA&ab");
        insertaEjer("Curl femoral", "Pierna", "trEvYnS_tQg&ab");
        insertaEjer("Elevación de gemelos", "Pierna", "S5amyzoG1O4&ab");

    }

    private void insertaEjer(String nombre, String zona, String enlace) {
        ContentValues values= new ContentValues();
        values.put("nombre", nombre);
        values.put("zona", zona);
        values.put("enlace", enlace);
        db.insert("Ejercicios",null, values);
    }

    //Funciones desplazamiento entre vistas
    public void entrar (View view){
        Intent i = new Intent(this, MenuInicio.class);
        startActivity(i);
    }
}