package com.example.taqtile.onboard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {
    public CriaBanco(Context context){
        super(context, BANCO,null,VERSAO);
    }

    public static final String BANCO = "banco.db";
    public static final String TABELA = "users";
    public static final String INTERNALID = "_id";
    //public static final String ID = "id";
    public static final String FIRSTNAME = "firstName";
    public static final String LASTNAME = "lastName";
    //public static final String AVATAR = "avatar";
    //public static final String ACCESSES = "accesses";
    public static final int VERSAO = 1;

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"(" +
                INTERNALID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                //ID + " INTEGER, " +
                FIRSTNAME + " TEXT, " +
                LASTNAME + " TEXT" +
                //AVATAR + " TEXT, " +
                //ACCESSES + " INTEGER
                 ")";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + TABELA);
        onCreate(db);

    }
}