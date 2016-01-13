package com.example.taqtile.onboard;

/**
 * Created by taqtile on 1/12/16.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBancoFinal extends SQLiteOpenHelper {
    public CriaBancoFinal(Context context){
        super(context, BANCO,null,VERSAO);
    }

    public static final String BANCO = "banco1.db";
    public static final String TABELA = "users1";
    public static final String ID = "id";
    public static final String FIRSTNAME = "firstName";
    public static final String LASTNAME = "lastName";
    public static final String AVATAR = "avatar";
    public static final String ACCESSES = "accesses";
    public static final int VERSAO = 1;

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FIRSTNAME + " TEXT, " +
                LASTNAME + " TEXT, " +
                AVATAR + " TEXT, " +
                ACCESSES + " INTEGER)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + TABELA);
        onCreate(db);

    }
}
