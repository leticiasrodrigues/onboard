package com.example.taqtile.onboard;

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

    public String insereDado(String firstName, String lastName) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.FIRSTNAME, firstName);
        valores.put(CriaBanco.LASTNAME, lastName);
        resultado = db.insert(CriaBanco.TABELA,null,valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }

    public Cursor carregaDados() {
        Cursor cursor;
        String[] campos = {banco.INTERNALID, banco.FIRSTNAME};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public Cursor carregaDadoById(int id){
        Cursor cursor;
        String[] campos = {banco.INTERNALID,banco.FIRSTNAME,banco.LASTNAME};
        String where = CriaBanco.INTERNALID + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public void alteraRegistro(int id, String first, String last){
        ContentValues valores;

        String where; db = banco.getWritableDatabase();

        where = CriaBanco.INTERNALID + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.FIRSTNAME, first);
        valores.put(CriaBanco.LASTNAME, last);
        db.update(CriaBanco.TABELA,valores,where,null);
        db.close();
    }

    public void deletaRegistro(int id) {
        String where = CriaBanco.INTERNALID + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.TABELA, where, null);
        db.close();
    }

}
