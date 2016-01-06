package com.example.taqtile.onboard;

import android.util.Log;

import java.util.HashMap;

public class Users  {

    private static final String TAG = "Método: ";

    private static HashMap<Integer,Pessoa> cadastros;


    public static HashMap list (Integer pagina){

        Log.v(TAG, "list");

        return cadastros;

    }

    public static void incrementViewCount (Integer id) {

        cadastros.get(id).count();

        Log.v(TAG, "incrementViewCount");

    }

    public static void resetViewCount (Integer id){

        cadastros.get(id).reset();

        Log.v(TAG, "resetViewCount");

    }

    public static Integer getViewCount (Integer id){

        Log.v(TAG, "getViewCount");

        return cadastros.get(id).getCount();

    }
}
