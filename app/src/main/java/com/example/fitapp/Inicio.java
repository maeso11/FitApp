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

        insertaEjer("Press banca", "Pecho", "https://www.youtube.com/watch?v=7aQY3u0Dk-Q&ab_channel=Powerexplosive");
        insertaEjer("Press banca inclinado", "Pecho", "https://www.youtube.com/watch?v=swMjJqFzxCQ&ab_channel=FNTLifeFNTLifeVerificada");
        insertaEjer("Press banca declinado", "Pecho", "https://www.youtube.com/watch?v=NNz3_wUMrvI&ab_channel=MyproteinEspa%C3%B1aMyproteinEspa%C3%B1a");
        insertaEjer("Aperturas", "Pecho", "https://www.youtube.com/watch?v=xyHdY99F640&ab_channel=HSNstore.comHSNstore.com");
        insertaEjer("Press militar", "Hombro", "https://www.youtube.com/watch?v=j_Buh54Sb-w&ab_channel=PowerexplosivePowerexplosiveVerificada");
        insertaEjer("Elevaciones laterales", "Hombro", "https://www.youtube.com/watch?v=hgLpdwMtEEs&ab_channel=Jes%C3%BAsL%C3%B3pezTrainerJes%C3%BAsL%C3%B3pezTrainerVerificada");
        insertaEjer("Elevación frontal", "Hombro", "https://www.youtube.com/watch?v=qIxtugfMI-E&ab_channel=MyproteinEspa%C3%B1aMyproteinEspa%C3%B1a");
        insertaEjer("Elevación posterior", "Hombro", "https://www.youtube.com/watch?v=zdLlyFb5YDI&ab_channel=FNTLifeFNTLife");
        insertaEjer("Dominadas", "Espalda", "https://www.youtube.com/watch?v=8mhDd9Ahl1M&ab_channel=CalisTechniXCalisTechniX");
        insertaEjer("Jalón al pecho", "Espalda", "https://www.youtube.com/watch?v=xpIlNU4qZd8&ab_channel=AnthoniMontalvanAnthoniMontalvanVerificada");
        insertaEjer("Remo", "Espalda", "https://www.youtube.com/watch?v=I8-nqk81gwI&ab_channel=NinoliftNinolift");
        insertaEjer("Extensión lumbar", "Espalda", "https://www.youtube.com/watch?v=Dd27xSYbjb8&ab_channel=MUSCULOTUBEMUSCULOTUBE");
        insertaEjer("Curl bíceps", "Bíceps", "https://www.youtube.com/watch?v=V1qprKjuNV8&ab_channel=MyproteinEspa%C3%B1aMyproteinEspa%C3%B1a");
        insertaEjer("Curl estilo martillo", "Bíceps", "https://www.youtube.com/watch?v=8ajGwhCkSss&ab_channel=Iv%C3%A1nTamaritIv%C3%A1nTamarit");
        insertaEjer("Curl concentrado", "Bíceps", "https://www.youtube.com/watch?v=E6idMdmNyxI&ab_channel=AnthoniMontalvanAnthoniMontalvan");
        insertaEjer("Fondos", "Tríceps", "https://www.youtube.com/watch?v=1Vm1ATIi0AE&ab_channel=PowerexplosivePowerexplosiveVerificada");
        insertaEjer("Extensiones con mancuernas", "Tríceps", "https://www.youtube.com/watch?v=rIlb_t6SVf0&ab_channel=Team.0lympusTeam.0lympus");
        insertaEjer("Polea tríceps", "Tríceps", "https://www.youtube.com/watch?v=FspY_qJBXZc&ab_channel=PowerexplosivePowerexplosive");
        insertaEjer("Extensión cuádriceps", "Pierna", "https://www.youtube.com/watch?v=r7ZMTzfiICA&ab_channel=FNTLifeFNTLifeVerificada");
        insertaEjer("Sentadilla", "Pierna", "https://www.youtube.com/watch?v=0rgiePufo0A&ab_channel=Powerexplosive");
        insertaEjer("Prensa", "Pierna", "https://www.youtube.com/watch?v=bKcV1I5rB_g&ab_channel=AnthoniMontalvan");
        insertaEjer("Peso muerto", "Pierna", "https://www.youtube.com/watch?v=7_Wm0YGQinw&ab_channel=Powerexplosive");
        insertaEjer("Zancada", "Pierna", "https://www.youtube.com/watch?v=U2lK6PaJ0kA&ab_channel=AnthoniMontalvan");
        insertaEjer("Curl femoral", "Pierna", "https://www.youtube.com/watch?v=trEvYnS_tQg&ab_channel=Kardagar%2aCoachingforLife");
        insertaEjer("Elevación de gemelos", "Pierna", "https://www.youtube.com/watch?v=S5amyzoG1O4&ab_channel=MUSCULOTUBEMUSCULOTUBE");

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