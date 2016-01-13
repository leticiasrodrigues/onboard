package com.example.taqtile.finalonboard;

/**
 * Created by taqtile on 1/13/16.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by taqtile on 1/12/16.
 */
public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }

    public String insereDado(String firstName, String lastName, String avatar) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.FIRSTNAME, firstName);
        valores.put(CriaBanco.LASTNAME, lastName);
        valores.put(CriaBanco.AVATAR, avatar);
        valores.put(CriaBanco.ACCESS, 0);
        resultado = db.insert(CriaBanco.TABELA,null,valores);
        db.close();

        if (resultado == -1)
            return "Fail ):";
        else
            return "Success (:";

    }

    public Cursor carregaDados() {
        Cursor cursor;
        String[] campos = {banco.ID, banco.FIRSTNAME, banco.LASTNAME};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

}

