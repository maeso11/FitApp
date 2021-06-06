package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuInicio extends AppCompatActivity {

    Button cerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicio);

        cerrarSesion = findViewById(R.id.btnCerrarSesion);
    }

    //Funciones desplazamiento entre vistas
    public void entrarEjercicios (View view){
        Intent i = new Intent(this, Ejercicios.class);
        startActivity(i);
    }

    public void entrarEntrenamientos (View view){
        Intent i = new Intent(this, Entrenamientos.class);
        startActivity(i);
    }

    public void volver (View view) {
        Intent i = new Intent (this, Inicio.class);
        startActivity(i);
    }
}