package com.example.taqtile.onboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserInformationActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        ArrayList<User2> user = getListData();
        final ListView lv1 = (ListView) findViewById(R.id.user_list_info);
        lv1.setAdapter(new CustomListAdapter(this, user));
        lv1.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                User newsData = (User) o;
                Toast.makeText(UserInformationActivity.this, "Selected :" + " " + newsData, Toast.LENGTH_LONG).show();
            }
        });
    }

    private ArrayList<User2> getListData() {

        ArrayList<User2> user= new ArrayList<User2>();
        User2 user2 = new User2(1, "Antonio", "Rocha", "eqf");
        user.add(0,user2);
        User2 user1 = new User2(2, "Maria", "Santos", "wqe");
        user.add(1,user1);

        //User2 user3 = new User2(7, "Joao", "Nascimento", "wdqd");
        //User2 user4 = new User2(3, "José", "Silva", "edmw");
        
        //ArrayList<User2> user= new ArrayList<User2>();
        //user.add(user1);
        //user.add(user2);
        //user.add(user1);
        //user.add(user4);
       // user.add(user3);
        return user;
    }

}
