package com.example.fitapp;

import android.provider.BaseColumns;

public class EstructuraBBDD {

    public static final String crearEjercicios =
            "CREATE TABLE IF NOT EXISTS " + EstructuraEjercicios.TABLE_NAME_EJERCICIOS + "(" +
                EstructuraEjercicios._ID + " integer PRIMARY KEY, " +
                EstructuraEjercicios.COLUMN_NAME_NOMBREEJER + " text, " +
                EstructuraEjercicios.COLUMN_NAME_ZONA + " text, " +
                EstructuraEjercicios.COLUMN_NAME_ENLACE + " text);";

    public static final String crearEntrenamientos =
            "CREATE TABLE IF NOT EXISTS " + EstructuraEntrenamientos.TABLE_NAME_ENTRENAMIENTOS + "(" +
                    EstructuraEntrenamientos._ID + " integer PRIMARY KEY, " +
                    EstructuraEntrenamientos.COLUMN_NAME_NOMBREENT + " text, " +
                    EstructuraEntrenamientos.COLUMN_NAME_NOMBREEJER + " text, " +
                    EstructuraEntrenamientos.COLUMN_NAME_SERIE + " text, " +
                    EstructuraEntrenamientos.COLUMN_NAME_REP + " text);";

    public static final String eliminarEjercicios =
            "DROP TABLE IF EXISTS " + EstructuraEjercicios.TABLE_NAME_EJERCICIOS;

    public static final String eliminarEntrenamientos =
            "DROP TABLE IF EXISTS " + EstructuraEntrenamientos.TABLE_NAME_ENTRENAMIENTOS;

    private EstructuraBBDD(){}

    public static class EstructuraEjercicios implements BaseColumns{
        public static final String TABLE_NAME_EJERCICIOS = "Ejercicios";
        public static final String COLUMN_NAME_NOMBREEJER = "nombre";
        public static final String COLUMN_NAME_ZONA = "zona";
        public static final String COLUMN_NAME_ENLACE = "enlace";
    }

    public static class EstructuraEntrenamientos implements BaseColumns{
        public static final String TABLE_NAME_ENTRENAMIENTOS = "Entrenamientos";
        public static final String COLUMN_NAME_NOMBREENT = "nombreEntrenamiento";
        public static final String COLUMN_NAME_NOMBREEJER = "nombreEjer";
        public static final String COLUMN_NAME_SERIE = "serie";
        public static final String COLUMN_NAME_REP = "repeticiones";
    }

}
