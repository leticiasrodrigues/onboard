package com.example.taqtile.onboard;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by taqtile on 1/6/16.
 */
public class User {

    private static final String TAG = "TESTE";
    //private static String first_name;
    //private static String last_name;
    //private String avatar;
    //private Integer count;
    //private Integer id;
    //private String[] atributos={first_name, last_name, avatar, Integer.toString(count)};
    private static HashMap<Integer, String[]> lista;

    public User(){
        lista = new HashMap<Integer,String[]>();
    }

    public static void add (Integer i, String first, String last, String avat){
        String first_name = first;
        String last_name = last;
        String avatar = avat;
        Integer id = i;
        Integer count = 0;
        String[] atributos={first_name, last_name, avatar, Integer.toString(count)};
        lista.put(id, atributos);
    }

    public HashMap<Integer,String[]> list(){

        Log.v(TAG, "list");

        return lista;

    }

    public void incrementViewCount (Integer id) {

        String numString = lista.get(id)[3];
        Integer num =Integer.parseInt(numString);
        lista.get(id)[3]=Integer.toString(num);

        Log.v(TAG, "incrementViewCount");

    }

    public void resetViewCount (Integer id){

        lista.get(id)[3]=Integer.toString(0);

        Log.v(TAG, "resetViewCount");

    }

    public Integer getViewCount (Integer id){

        Log.v(TAG, "getViewCount");

        return Integer.parseInt(lista.get(id)[3]);

    }

    public String getFirstName (Integer id){
        return lista.get(id)[0];
    }

    public String getLasttName (Integer id){
        return lista.get(id)[1];
    }


}
