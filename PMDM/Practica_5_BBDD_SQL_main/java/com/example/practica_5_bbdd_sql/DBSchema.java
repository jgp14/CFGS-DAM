package com.example.practica_5_bbdd_sql;

import android.provider.BaseColumns;

public final class DBSchema {

    private DBSchema() {
    }

    public static class Citas implements BaseColumns {
        public static final String TABLE_NAME = "citas";
        public static final String ID = "id";
        public static final String DATE = "fecha";
        public static final String HOUR = "hora";
    }

    public static final String SQL_CREATE_ENTREIS =
            "CREATE TABLE " + Citas.TABLE_NAME + " (" +
                    Citas.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Citas.DATE + " TEXT, " +
                    Citas.HOUR + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Citas.TABLE_NAME;
}
