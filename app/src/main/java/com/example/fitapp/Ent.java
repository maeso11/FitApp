package com.example.fitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Ent extends AppCompatActivity {

    Toolbar toolbar;
    SQLiteDatabase db;
    SQLiteHelper helper;
    ListView lv;
    TextView titulo;
    Intent i = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ent);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        titulo = findViewById(R.id.tituloEnt);

        helper = new SQLiteHelper(this);
        db = helper.getReadableDatabase();

        lv = findViewById(R.id.listaEnt);

        consultaEnt();
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

    private void consultaEnt() {

        String nombreEnt = getIntent().getStringExtra("nombreEntrenamiento");
        //titulo.setText(nombreEnt);
        String consulta = "nombreEntrenamiento = '" + getIntent().getStringExtra("nombreEntrenamiento") + "'";

        Cursor cursor = db.query(EstructuraBBDD.EstructuraEntrenamientos.TABLE_NAME_ENTRENAMIENTOS, null, consulta, null, null, null, null);

        String[] from = {EstructuraBBDD.EstructuraEntrenamientos.COLUMN_NAME_NOMBREEJER, EstructuraBBDD.EstructuraEntrenamientos.COLUMN_NAME_SERIE, EstructuraBBDD.EstructuraEntrenamientos.COLUMN_NAME_REP};
        int[] to = {R.id.nombreEnt, R.id.series, R.id.reps};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.entlist, cursor, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adapter);

        db.close();
    }

}