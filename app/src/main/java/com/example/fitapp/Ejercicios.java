package com.example.fitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Ejercicios extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.ejercicios){
            Intent i = new Intent(this, Ejercicios.class);
            startActivity(i);
        }else if (id == R.id.entrenamientos){
            Intent i = new Intent(this, Entrenamientos.class);
            startActivity(i);
        }else{
            Intent i = new Intent(this, Inicio.class);
            startActivity(i);
        }
        return true;
    }

    //Funciones desplazamiento entre vistas


    public void entrarBiceps (View view){
        Intent i = new Intent(this, Ejer_Biceps.class);
        startActivity(i);
    }

    public void entrarEspalda (View view){
        Intent i = new Intent(this, Ejer_Espalda.class);
        startActivity(i);
    }

    public void entrarHombro (View view){
        Intent i = new Intent(this, Ejer_Hombro.class);
        startActivity(i);
    }

    public void entrarPecho (View view){
        Intent i = new Intent(this, Ejer_Pecho.class);
        startActivity(i);
    }

    public void entrarPierna (View view){
        Intent i = new Intent(this, Ejer_Pierna.class);
        startActivity(i);
    }

    public void entrarTriceps (View view){
        Intent i = new Intent(this, Ejer_Triceps.class);
        startActivity(i);
    }
}