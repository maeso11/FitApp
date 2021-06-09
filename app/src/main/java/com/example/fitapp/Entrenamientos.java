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

public class Entrenamientos extends AppCompatActivity {

    Toolbar toolbar;
    Intent i = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamientos);

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
    public void ent1 (View view){
        i = new Intent(this, Ent.class);
        i.putExtra("nombreEntrenamiento", "Pecho/Tríceps");
        startActivity(i);
    }

    public void ent2 (View view){
        i = new Intent(this, Ent.class);
        i.putExtra("nombreEntrenamiento", "Espalda/Bíceps");
        startActivity(i);
    }

    public void ent3 (View view){
        i = new Intent(this, Ent.class);
        i.putExtra("nombreEntrenamiento", "Pierna");
        startActivity(i);
    }

}