package com.example.taqtile.onboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class UserInformationActivity extends AppCompatActivity {

    public static String ID = "id";
    public static String FIRST_NAME = "firstName";
    public static String LAST_NAME = "lastName";
    public static String AVATAR = "avatar";
    public ArrayList<User2> userList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        userList = getListData();
        final ListView lv1 = (ListView) findViewById(R.id.user_list_info);
        final CustomListAdapter adapter = new CustomListAdapter(this, userList);
        lv1.setAdapter(new CustomListAdapter(this, userList));
        lv1.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                User2 o = adapter.getItem(position);
                details(o);

                //Toast.makeText(UserInformationActivity.this, "Selected :" + " " + o, Toast.LENGTH_LONG).show();

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private ArrayList<User2> getListData() {

        ArrayList<User2> userList= new ArrayList<User2>();
        User2 user2 = new User2(5, "Antonio", "Rocha", "eqf");
        User2 user1 = new User2(2, "Maria", "Santos", "wqe");
        User2 user3 = new User2(7, "Joao", "Nascimento", "wdqd");
        User2 user4 = new User2(3, "José", "Silva", "edmw");

        userList.add(user2);
        userList.add(user1);
        userList.add(user4);
        userList.add(user3);

        return userList;
    }

    public void details(User2 user2){
        Intent intent = new Intent(this,UserDetails.class);

        intent.putExtra(ID, user2.getId().toString());
        intent.putExtra(FIRST_NAME, user2.getFirstName());
        intent.putExtra(LAST_NAME, user2.getLastName());
        intent.putExtra(AVATAR, user2.getAvatar());

        startActivity(intent);
    }

}
