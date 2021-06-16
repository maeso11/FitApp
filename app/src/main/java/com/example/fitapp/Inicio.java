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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {

    Toolbar toolbar;
    Button acceder;
    SQLiteDatabase db;
    SQLiteHelper helper;
    EditText user;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user = findViewById(R.id.edtAltura);
        pass = findViewById(R.id.edtPeso);

        acceder = findViewById(R.id.btnEntrar);
        helper = new SQLiteHelper(this);
        db = helper.getWritableDatabase();

        db.delete(EstructuraBBDD.EstructuraEjercicios.TABLE_NAME_EJERCICIOS, "_id>=1", null);
        db.delete(EstructuraBBDD.EstructuraEntrenamientos.TABLE_NAME_ENTRENAMIENTOS, "_id>=1", null);

        insertaEnt("Pecho/Tríceps", "Press banca", "Series: 4", "12 - 10 - 10 - 8");
        insertaEnt("Pecho/Tríceps", "Press banca inclinado", "Series: 4", "12 - 10 - 10 - 8");
        insertaEnt("Pecho/Tríceps", "Press banca declinado", "Series: 4", "12 - 10 - 10 - 8");
        insertaEnt("Pecho/Tríceps", "Aperturas", "Series: 4", "12 - 10 - 10 - 8");
        insertaEnt("Pecho/Tríceps", "Press militar", "Series: 4", "12 - 10 - 10 - 8");
        insertaEnt("Pecho/Tríceps", "Elevaciones laterales", "Series: 3", "10 - 10 - 10");
        insertaEnt("Pecho/Tríceps", "Fondos", "Series: 4", "12 - 10 - 10 - 8");
        insertaEnt("Pecho/Tríceps", "Extensiones con mancuernas", "Series: 4", "12 - 10 - 10 - 8");
        insertaEnt("Pecho/Tríceps", "Polea tríceps", "Series: 4", "12 - 10 - 10 - 8");

        insertaEnt("Espalda/Bíceps", "Dominadas", "Series: 4", "8 - 8 - 8 - 8");
        insertaEnt("Espalda/Bíceps", "Jalón al pecho", "Series: 4", "12 - 10 - 10 - 8");
        insertaEnt("Espalda/Bíceps", "Remo", "Series: 4", "12 - 10 - 10 - 8");
        insertaEnt("Espalda/Bíceps", "Extensión lumbar", "Series: 4", "12 - 12 - 12 - 12");
        insertaEnt("Espalda/Bíceps", "Elevación posterior", "Series: 4", "12 - 10 - 10 - 8");
        insertaEnt("Espalda/Bíceps", "Elevación frontal", "Series: 3", "10 - 10 - 10");
        insertaEnt("Espalda/Bíceps", "Curl bíceps", "Series: 4", "12 - 10 - 10 - 8");
        insertaEnt("Espalda/Bíceps", "Curl estilo martillo", "Series: 4", "12 - 10 - 10 - 8");
        insertaEnt("Espalda/Bíceps", "Curl concentrado", "Series: 4", "12 - 10 - 10 - 8");

        insertaEnt("Pierna", "Sentadilla", "Series: 4", "12 - 10 - 10 - 8");
        insertaEnt("Pierna", "Extensión cuádriceps", "Series: 4", "12 - 10 - 10 - 8");
        insertaEnt("Pierna", "Prensa", "Series: 4", "12 - 10 - 10 - 8");
        insertaEnt("Pierna", "Peso muerto", "Series: 4", "12 - 10 - 10 - 8");
        insertaEnt("Pierna", "Zancada", "Series: 4", "12 - 10 - 10 - 8");
        insertaEnt("Pierna", "Curl femoral", "Series: 4", "12 - 10 - 10 - 8");
        insertaEnt("Pierna", "Elevación de gemelos", "Series: 4", "12 - 10 - 10 - 8");

        insertaEjer("Press banca", "Pecho", "7aQY3u0Dk-Q");
        insertaEjer("Press banca inclinado", "Pecho", "swMjJqFzxCQ");
        insertaEjer("Press banca declinado", "Pecho", "NNz3_wUMrvI");
        insertaEjer("Aperturas", "Pecho", "xyHdY99F640");
        insertaEjer("Press militar", "Hombro", "j_Buh54Sb-w");
        insertaEjer("Elevaciones laterales", "Hombro", "hgLpdwMtEEs");
        insertaEjer("Elevación frontal", "Hombro", "qIxtugfMI-E");
        insertaEjer("Elevación posterior", "Hombro", "zdLlyFb5YDI");
        insertaEjer("Dominadas", "Espalda", "8mhDd9Ahl1M");
        insertaEjer("Jalón al pecho", "Espalda", "xpIlNU4qZd8");
        insertaEjer("Remo", "Espalda", "I8-nqk81gwI");
        insertaEjer("Extensión lumbar", "Espalda", "Dd27xSYbjb8");
        insertaEjer("Curl bíceps", "Bíceps", "V1qprKjuNV8");
        insertaEjer("Curl estilo martillo", "Bíceps", "8ajGwhCkSss");
        insertaEjer("Curl concentrado", "Bíceps", "E6idMdmNyxI");
        insertaEjer("Fondos", "Tríceps", "1Vm1ATIi0AE");
        insertaEjer("Extensiones con mancuernas", "Tríceps", "rIlb_t6SVf0");
        insertaEjer("Polea tríceps", "Tríceps", "FspY_qJBXZc");
        insertaEjer("Extensión cuádriceps", "Pierna", "r7ZMTzfiICA");
        insertaEjer("Sentadilla", "Pierna", "0rgiePufo0A");
        insertaEjer("Prensa", "Pierna", "bKcV1I5rB_g");
        insertaEjer("Peso muerto", "Pierna", "7_Wm0YGQinw");
        insertaEjer("Zancada", "Pierna", "U2lK6PaJ0kA");
        insertaEjer("Curl femoral", "Pierna", "trEvYnS_tQg");
        insertaEjer("Elevación de gemelos", "Pierna", "S5amyzoG1O4");

    }

    private void insertaEjer(String nombre, String zona, String enlace) {
        ContentValues values= new ContentValues();
        values.put("nombre", nombre);
        values.put("zona", zona);
        values.put("enlace", enlace);
        db.insert("Ejercicios",null, values);
    }

    private void insertaEnt(String nombre, String ejer, String serie, String rep){
        ContentValues values = new ContentValues();
        values.put("nombreEntrenamiento", nombre);
        values.put("nombreEjer", ejer);
        values.put("serie", serie);
        values.put("repeticiones", rep);
        db.insert("Entrenamientos", null, values);
    }

    //Funciones desplazamiento entre vistas
    public void entrar (View view){
        String usuario = "admin";
        String contrasena = "a";
        if (user.getText().toString().equals(usuario) && pass.getText().toString().equals(contrasena)){
            Intent i = new Intent(this, MenuInicio.class);
            startActivity(i);
        }else{
            Toast toast1 = Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT);

            toast1.show();
        }

    }
}