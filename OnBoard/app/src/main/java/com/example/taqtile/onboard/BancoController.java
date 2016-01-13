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

    public String insereDado(String firstName, String lastName, String avatar) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        int i = 0;
        valores = new ContentValues();
        valores.put(CriaBanco.FIRSTNAME, firstName);
        valores.put(CriaBanco.LASTNAME, lastName);
        valores.put(CriaBanco.AVATAR, avatar);
        valores.put(CriaBanco.ACCESSES, i);
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
        String[] campos = {banco.INTERNALID,banco.FIRSTNAME,banco.LASTNAME, banco.AVATAR, banco.ACCESSES};
        String where = CriaBanco.INTERNALID + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public int getId (Cursor cursor){

        String idString = cursor.getString(cursor.getColumnIndex(CriaBanco.INTERNALID));

        StringBuilder conversor = new StringBuilder();
        conversor.append(idString);
        return Integer.parseInt(conversor.toString());
    }

    public String getFirstName(Cursor cursor){

        String idString = cursor.getString(cursor.getColumnIndex(CriaBanco.FIRSTNAME));

        StringBuilder conversor = new StringBuilder();
        conversor.append(idString);
        return conversor.toString();
    }

    public String getLastName (Cursor cursor){

        String idString = cursor.getString(cursor.getColumnIndex(CriaBanco.LASTNAME));

        StringBuilder conversor = new StringBuilder();
        conversor.append(idString);
        return conversor.toString();
    }

    public String getAvatar (Cursor cursor){

        String idString = cursor.getString(cursor.getColumnIndex(CriaBanco.AVATAR));

        StringBuilder conversor = new StringBuilder();
        conversor.append(idString);
        return conversor.toString();
    }

    public int getAcesso (Cursor cursor){

        String idString = cursor.getString(cursor.getColumnIndex(CriaBanco.ACCESSES));

        StringBuilder conversor = new StringBuilder();
        conversor.append(idString);
        return Integer.parseInt(conversor.toString());
    }

    public void alteraAcesso(int id){
        ContentValues valores;

        String where;
        db = banco.getWritableDatabase();

        where = CriaBanco.INTERNALID + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.AVATAR, 1);
        db.update(CriaBanco.TABELA,valores,where,null);
        db.close();
    }

    public void alteraRegistro(int id, String first, String last, String avatar){
        ContentValues valores;

        String where; db = banco.getWritableDatabase();

        where = CriaBanco.INTERNALID + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.FIRSTNAME, first);
        valores.put(CriaBanco.LASTNAME, last);
        valores.put(CriaBanco.AVATAR, avatar);
        db.update(CriaBanco.TABELA,valores,where,null);
        db.close();
    }

    public void deletaRegistro(int id) {
        String where = CriaBanco.INTERNALID + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.TABELA, where, null);
        db.close();
    }

    public int getCount(){
        Cursor mCount= db.rawQuery("SELECT COUNT(*) FROM " + CriaBanco.TABELA, null);
        mCount.moveToFirst();
        int count= mCount.getInt(0);
        mCount.close();
        return count;
    }

}
