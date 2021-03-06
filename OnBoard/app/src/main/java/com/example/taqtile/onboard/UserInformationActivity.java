package com.example.taqtile.onboard;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class UserInformationActivity extends AppCompatActivity {



    public static String ID = "id";
    public static String FIRST_NAME = "firstName";
    public static String LAST_NAME = "lastName";
    public static String AVATAR = "avatar";
    public static String COUNTER = "counter";
    public ArrayList<User2> userList;
    public Context context = this;
    public SimpleCursorAdapter adaptador;

    public CustomListAdapter mAdapter;
    //public CustomListAdapterFinal mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         Intent intent = getIntent();
         String message = intent.getStringExtra(MainActivity.USER);

         //userList = getListData(message);
        userList = getUserList();


        ListView lv1 = (ListView) findViewById(R.id.user_list_info);
        mAdapter = new CustomListAdapter(context, userList);
        lv1.setAdapter(mAdapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                User2 o = mAdapter.getItem(position);

                o.setAccess(true);
                o.addCounter();

                mAdapter.notifyDataSetChanged();

                details(o);




                //Toast.makeText(UserInformationActivity.this, "Selected :" + " " + o, Toast.LENGTH_LONG).show();

            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private ArrayList<User2> getListData(String json) {

//        ArrayList<User2> userList= new ArrayList<User2>();
//        User2 user2 = new User2(5, "Antonio", "Rocha", "eqf");
//        User2 user1 = new User2(2, "Maria", "Santos", "wqe");
//        User2 user3 = new User2(7, "Joao", "Nascimento", "wdqd");
//        User2 user4 = new User2(3, "José", "Silva", "edmw");
//        User2 user5 = new User2(5, "Antonio", "Rocha", "eqf");
//        User2 user6 = new User2(2, "Maria", "Santos", "wqe");
//        User2 user7 = new User2(7, "Joao", "Nascimento", "wdqd");
//        User2 user8 = new User2(3, "José", "Silva", "edmw");
//        User2 user9 = new User2(5, "Antonio", "Rocha", "eqf");
//        User2 user10= new User2(2, "Maria", "Santos", "wqe");
//        User2 user11= new User2(7, "Joao", "Nascimento", "wdqd");
//        User2 user12= new User2(3, "José", "Silva", "edmw");
//
//        userList.add(user2);
//        userList.add(user1);
//        userList.add(user4);
//        userList.add(user3);
//        userList.add(user5);
//        userList.add(user6);
//        userList.add(user7);
//        userList.add(user8);
//        userList.add(user9);
//        userList.add(user10);
//        userList.add(user11);
//        userList.add(user12);

        ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();

        String[] ids = ParseJSON.ids;
        String[] names = ParseJSON.names;
        String[] lastNames = ParseJSON.lastNames;
        String[] emails = ParseJSON.emails;

        ArrayList<User2> user = new ArrayList<User2>();

        for(int i=0; i<ParseJSON.size;i++){
            user.add(new User2(Integer.parseInt(ids[i]),names[i], lastNames[i], emails[i]));
        }

        return user;
    }



    public void details(User2 user2){
        Intent intent = new Intent(this,UserDetails.class);

        intent.putExtra(ID, user2.getId().toString());
        intent.putExtra(FIRST_NAME, user2.getFirstName());
        intent.putExtra(LAST_NAME, user2.getLastName());
        intent.putExtra(AVATAR, user2.getAvatar());
        intent.putExtra(COUNTER, Integer.toString(user2.getCounter()));

        startActivity(intent);
    }

    public void details(Cursor cursor){
        Intent intent = new Intent(this,UserDetails.class);

        BancoController crud = new BancoController(getBaseContext());

        intent.putExtra(ID, crud.getId(cursor));
        intent.putExtra(FIRST_NAME, crud.getFirstName(cursor));
        intent.putExtra(LAST_NAME, crud.getLastName(cursor));
        intent.putExtra(AVATAR, crud.getAvatar(cursor));
        //intent.putExtra(COUNTER, Integer.toString(user2.getCounter()));
        intent.putExtra(COUNTER, crud.getAcesso(cursor));

        startActivity(intent);

    }

    protected Context getContext(){
        return this;
    }

    public ArrayList<User2> getUserList(){

        ArrayList<User2> user = new ArrayList<>();

        BancoController crud = new BancoController(getBaseContext());
        int size = crud.getCount();
        for (int i = 0; i<size; i++){
            Cursor cursor = crud.carregaDadoById(i);
            user.add(new User2(i, cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.FIRSTNAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.LASTNAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.AVATAR))));
        }

        return user;
    }

}
