package com.example.taqtile.onboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by taqtile on 1/12/16.
 */
public class BancoControllerFinal {

    private SQLiteDatabase db;
    private CriaBancoFinal banco;

    public BancoControllerFinal(Context context) {
        banco = new CriaBancoFinal(context);
    }

    public String insereDado(String firstName, String lastName, String avatar) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBancoFinal.FIRSTNAME, firstName);
        valores.put(CriaBancoFinal.LASTNAME, lastName);
        valores.put(CriaBancoFinal.AVATAR, avatar);
        valores.put(CriaBancoFinal.ACCESSES, 0);
        resultado = db.insert(CriaBanco.TABELA,null,valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }

    //para fazer a listagem
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

    //para mostrar os detahes
    public Cursor carregaDadoById(int id){
        Cursor cursor;
        String[] campos = {banco.ID,banco.FIRSTNAME,banco.LASTNAME,banco.AVATAR,banco.ACCESSES};
        String where = CriaBancoFinal.ID + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA, campos, where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public void alteraRegistro(int id, String first, String last, String avatar){
        ContentValues valores;

        String where;

        db = banco.getWritableDatabase();

        where = CriaBancoFinal.ID + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBancoFinal.FIRSTNAME, first);
        valores.put(CriaBancoFinal.LASTNAME, last);
        valores.put(CriaBancoFinal.AVATAR, avatar);
        db.update(CriaBancoFinal.TABELA,valores,where,null);
        db.close();
    }

    public void deletaRegistro(int id) {
        String where = CriaBancoFinal.ID + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBancoFinal.TABELA, where, null);
        db.close();
    }

    public void alteraAccess(int id){
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = CriaBancoFinal.ID + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBancoFinal.ACCESSES, 1);
        db.update(CriaBancoFinal.TABELA, valores, where, null);
        db.close();
    }

    public int getCount(){
        Cursor mCount= db.rawQuery("SELECT COUNT(*) FROM " + CriaBancoFinal.TABELA, null);
        mCount.moveToFirst();
        int count= mCount.getInt(0);
        mCount.close();
        return count;
    }

    public String getFirstName(Integer id){
        String selectQuery =
                "SELECT * FROM " + CriaBancoFinal.TABELA +" WHERE " +CriaBancoFinal.ID+ " =?" ;
        String [] args = new String[] {id.toString()};

        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,args);

        cursor.moveToFirst();

        String nomeString = cursor.getString(cursor.getColumnIndex(CriaBancoFinal.FIRSTNAME));

        StringBuilder conversor = new StringBuilder();
        conversor.append(nomeString);
        return conversor.toString();
    }

    public String getLastName(Integer id){
        String selectQuery =
                "SELECT * FROM " + CriaBancoFinal.TABELA +" WHERE " +CriaBancoFinal.ID+ " =?" ;
        String [] args = new String[] {id.toString()};

        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,args);

        cursor.moveToFirst();

        String nomeString = cursor.getString(cursor.getColumnIndex(CriaBancoFinal.LASTNAME));

        StringBuilder conversor = new StringBuilder();
        conversor.append(nomeString);
        return conversor.toString();
    }

    public String getAvatar(Integer id){
        String selectQuery =
                "SELECT * FROM " + CriaBancoFinal.TABELA +" WHERE " +CriaBancoFinal.ID+ " =?" ;
        String [] args = new String[] {id.toString()};

        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,args);

        cursor.moveToFirst();

        String nomeString = cursor.getString(cursor.getColumnIndex(CriaBancoFinal.AVATAR));

        StringBuilder conversor = new StringBuilder();
        conversor.append(nomeString);
        return conversor.toString();
    }

    public String getAccess(Integer id){
        String selectQuery =
                "SELECT * FROM " + CriaBancoFinal.TABELA +" WHERE " +CriaBancoFinal.ID+ " =?" ;
        String [] args = new String[] {id.toString()};

        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,args);

        cursor.moveToFirst();

        String nomeString = cursor.getString(cursor.getColumnIndex(CriaBancoFinal.ACCESSES));

        StringBuilder conversor = new StringBuilder();
        conversor.append(nomeString);
        return conversor.toString();
    }


    public String getId(Cursor cursor){

        db = banco.getReadableDatabase();

        String nomeString = cursor.getString(cursor.getColumnIndex(CriaBancoFinal.ID));

        StringBuilder conversor = new StringBuilder();
        conversor.append(nomeString);
        return conversor.toString();
    }

    public String getFirstName(Cursor cursor){

        db = banco.getReadableDatabase();

        String nomeString = cursor.getString(cursor.getColumnIndex(CriaBancoFinal.FIRSTNAME));

        StringBuilder conversor = new StringBuilder();
        conversor.append(nomeString);
        return conversor.toString();
    }

    public String getLastName(Cursor cursor){
        db = banco.getReadableDatabase();

        String nomeString = cursor.getString(cursor.getColumnIndex(CriaBancoFinal.LASTNAME));

        StringBuilder conversor = new StringBuilder();
        conversor.append(nomeString);
        return conversor.toString();
    }

    public String getAvatar(Cursor cursor){
        db = banco.getReadableDatabase();

        String nomeString = cursor.getString(cursor.getColumnIndex(CriaBancoFinal.AVATAR));

        StringBuilder conversor = new StringBuilder();
        conversor.append(nomeString);
        return conversor.toString();
    }

    public Integer getAccess(Cursor cursor){
        db = banco.getReadableDatabase();

        String nomeString = cursor.getString(cursor.getColumnIndex(CriaBancoFinal.ACCESSES));

        StringBuilder conversor = new StringBuilder();
        conversor.append(nomeString);
        return Integer.parseInt(conversor.toString());
    }
}
