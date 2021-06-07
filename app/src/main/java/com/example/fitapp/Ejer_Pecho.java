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

public class Ejer_Pecho extends AppCompatActivity implements AdapterView.OnItemClickListener{

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
        setContentView(R.layout.activity_ejer__pecho);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        titulo = findViewById(R.id.titulo);

        helper = new SQLiteHelper(this);
        db = helper.getReadableDatabase();

        lv = findViewById(R.id.listaEjer);

        consultaZona();

        lv.setOnItemClickListener(this);
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

    public void vistaEjercicio(){
        i = new Intent(this, DetalleEjer.class);
        startActivity(i);
    }

    private void consultaZona() {

        String nombreTitulo = getIntent().getStringExtra("zona");
        titulo.setText(nombreTitulo);
        String consulta = "zona = '" + getIntent().getStringExtra("zona") + "'";

        Cursor cursor = db.query(EstructuraBBDD.EstructuraEjercicios.TABLE_NAME_EJERCICIOS, null, consulta, null, null, null, null);

        String[] from = {EstructuraBBDD.EstructuraEjercicios.COLUMN_NAME_NOMBREEJER};
        int[] to = {R.id.nombreEjer};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(this, R.layout.ejerlist, cursor, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adaptador);

        db.close();
    }

    @Override
    public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
        Cursor cursor = (Cursor) listView.getItemAtPosition(position);
        int _id = cursor.getInt(0);
        String nombre = cursor.getString(1);
        String zona = cursor.getString(2);
        String enlace = cursor.getString(3);
        i.putExtra("idVideo", enlace);

        vistaEjercicio();
    }

}