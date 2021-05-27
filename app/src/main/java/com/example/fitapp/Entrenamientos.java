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
import android.widget.Toast;

public class Entrenamientos extends AppCompatActivity {

    Toolbar toolbar;



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
    public void entrarPechoTriceps (View view){
        Intent i = new Intent(this, Ent_PechoTriceps.class);
        startActivity(i);
    }

    public void entrarEspaldaBiceps (View view){
        Intent i = new Intent(this, Ent_EspaldaBiceps.class);
        startActivity(i);
    }

    public void entrarPierna (View view){
        Intent i = new Intent(this, Ent_Pierna.class);
        startActivity(i);
    }

    public void entrarFullBody (View view){
        Intent i = new Intent(this, Ent_FullBody.class);
        startActivity(i);
    }
}