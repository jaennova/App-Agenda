package com.jaennova.app_agenda.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contacts.db";
    private static final int DATABASE_VERSION = 1;

    // Nombre de la tabla y columnas
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";

    // Consulta SQL para crear la tabla
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_CONTACTS + " ("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT NOT NULL, "
            + COLUMN_EMAIL + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // Elimina la tabla existente y crea una nueva
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(sqLiteDatabase);
    }
}
