package com.example.revio.weightlogger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by revio on 11/11/15.
 */
public class MyDataBase extends SQLiteOpenHelper {

    private static final String DB_NOME = "WIP";

    private static final int DB_VERSIONE = 1;

    public MyDataBase(Context context) {
        super(context, DB_NOME, null, DB_VERSIONE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
		/*
		 * Stringa contenente la sintassi SQL per la
		 * creazione della tabella RUBRICA
		 */
        String sql = "CREATE TABLE rubrica";
        sql += "(_id INTEGER PRIMARY KEY,";
        sql += "nome TEXT NOT NULL,";
        sql += "cognome TEXT,";
        sql += "email TEXT);";

        //Eseguiamo la query
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub


    }
}
