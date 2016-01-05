package com.example.taqtile.onboard;


import java.util.ArrayList;

public class Pessoa {

   private ArrayList<String> atributos;
   private final String first_name;
   private final String last_name;
   private final String avatar;
   private final Integer id;
   private Integer count = 0;



   public Pessoa(Integer i, String first, String last, String avat){
      first_name = first;
      last_name = last;
      avatar = avat;
      id = i;

      ArrayList<String> atributos = new ArrayList<String>();
      atributos.add(first);
      atributos.add(last);
      atributos.add(avat);

   }

   public void count (){
      count+=1;
   }

   public void reset(){
      count=0;
   }

   public ArrayList<String> getAtributos() {
      return atributos;
   }

   public Integer getCount() {
      return count;
   }

   public Integer getId() {
      return id;
   }
}
