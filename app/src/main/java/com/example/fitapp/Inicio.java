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

        db.delete(EstructuraBBDD.EstructuraEjercicios.TABLE_NAME_EJERCICIOS, "_id>=1", null);
        db.delete(EstructuraBBDD.EstructuraEntrenamientos.TABLE_NAME_ENTRENAMIENTOS, "_id>=1", null);

        insertaEnt("Pecho/Tríceps", 4, 10);
        insertaEnt("Espalda/Bíceps", 4, 10);
        insertaEnt("Pierna", 4, 10);

        insertaEjer("Press banca", "Pecho", "7aQY3u0Dk-Q", "Pecho/Tríceps");
        insertaEjer("Press banca inclinado", "Pecho", "swMjJqFzxCQ", "Pecho/Tríceps");
        insertaEjer("Press banca declinado", "Pecho", "NNz3_wUMrvI", "Pecho/Tríceps");
        insertaEjer("Aperturas", "Pecho", "xyHdY99F640", "Pecho/Tríceps");
        insertaEjer("Press militar", "Hombro", "j_Buh54Sb-w", "Pecho/Tríceps");
        insertaEjer("Elevaciones laterales", "Hombro", "hgLpdwMtEEs", "Pecho/Tríceps");
        insertaEjer("Elevación frontal", "Hombro", "qIxtugfMI-E", "Espalda/Bíceps");
        insertaEjer("Elevación posterior", "Hombro", "zdLlyFb5YDI", "Espalda/Bíceps");
        insertaEjer("Dominadas", "Espalda", "8mhDd9Ahl1M", "Espalda/Bíceps");
        insertaEjer("Jalón al pecho", "Espalda", "xpIlNU4qZd8", "Espalda/Bíceps");
        insertaEjer("Remo", "Espalda", "I8-nqk81gwI", "Espalda/Bíceps");
        insertaEjer("Extensión lumbar", "Espalda", "Dd27xSYbjb8", "Espalda/Bíceps");
        insertaEjer("Curl bíceps", "Bíceps", "V1qprKjuNV8", "Espalda/Bíceps");
        insertaEjer("Curl estilo martillo", "Bíceps", "8ajGwhCkSss", "Espalda/Bíceps");
        insertaEjer("Curl concentrado", "Bíceps", "E6idMdmNyxI", "Espalda/Bíceps");
        insertaEjer("Fondos", "Tríceps", "1Vm1ATIi0AE", "Pecho/Tríceps");
        insertaEjer("Extensiones con mancuernas", "Tríceps", "rIlb_t6SVf0", "Pecho/Tríceps");
        insertaEjer("Polea tríceps", "Tríceps", "FspY_qJBXZc", "Pecho/Tríceps");
        insertaEjer("Extensión cuádriceps", "Pierna", "r7ZMTzfiICA", "Pierna");
        insertaEjer("Sentadilla", "Pierna", "0rgiePufo0A", "Pierna");
        insertaEjer("Prensa", "Pierna", "bKcV1I5rB_g", "Pierna");
        insertaEjer("Peso muerto", "Pierna", "7_Wm0YGQinw", "Pierna");
        insertaEjer("Zancada", "Pierna", "U2lK6PaJ0kA", "Pierna");
        insertaEjer("Curl femoral", "Pierna", "trEvYnS_tQg", "Pierna");
        insertaEjer("Elevación de gemelos", "Pierna", "S5amyzoG1O4", "Pierna");

    }

    private void insertaEjer(String nombre, String zona, String enlace, String ent) {
        ContentValues values= new ContentValues();
        values.put("nombre", nombre);
        values.put("zona", zona);
        values.put("enlace", enlace);
        values.put("nombreEntrenamiento", ent);
        db.insert("Ejercicios",null, values);
    }

    private void insertaEnt(String nombre, int serie, int rep){
        ContentValues values = new ContentValues();
        values.put("nombreEntrenamiento", nombre);
        values.put("serie", serie);
        values.put("repeticiones", rep);
    }

    //Funciones desplazamiento entre vistas
    public void entrar (View view){
        Intent i = new Intent(this, MenuInicio.class);
        startActivity(i);
    }
}