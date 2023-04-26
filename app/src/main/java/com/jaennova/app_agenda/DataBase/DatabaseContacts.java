package com.jaennova.app_agenda.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.jaennova.app_agenda.database.DatabaseHelper;

public class DatabaseContacts {

    private final DatabaseHelper dbHelper; // Instancia de la clase DatabaseHelper

    public DatabaseContacts(Context context) {
        dbHelper = new DatabaseHelper(context); // Se crea una instancia de la clase DatabaseHelper
    }

    public long insertContact(String name, String phone, String email) {
        SQLiteDatabase db = dbHelper.getWritableDatabase(); // Se obtiene la base de datos en modo escritura

        ContentValues values = new ContentValues(); // Se crean los valores a insertar en la tabla
        values.put(DatabaseHelper.COLUMN_NAME, name); // Se agrega el nombre del contacto
        values.put(DatabaseHelper.COLUMN_PHONE, phone); // Se agrega el teléfono del contacto
        values.put(DatabaseHelper.COLUMN_EMAIL, email); // Se agrega el correo electrónico del contacto

        return db.insert(DatabaseHelper.TABLE_CONTACTS, null, values); // Se inserta el nuevo contacto en la tabla y se retorna el id generado
    }
}
