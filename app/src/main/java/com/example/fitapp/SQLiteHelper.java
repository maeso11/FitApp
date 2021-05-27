package com.example.fitapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "dbFitApp.db";

    public SQLiteHelper(@Nullable Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EstructuraBBDD.crearEjercicios);
        db.execSQL(EstructuraBBDD.crearEntrenamientos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(EstructuraBBDD.eliminarEjercicios);
        db.execSQL(EstructuraBBDD.crearEjercicios);
        db.execSQL(EstructuraBBDD.eliminarEntrenamientos);
        db.execSQL(EstructuraBBDD.crearEntrenamientos);
    }
}
