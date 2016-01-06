package com.example.taqtile.onboard;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class ListUserActivity extends AppCompatActivity {

    private ListView userListView;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        User user = new User();
        User.add(1, "Maria", "Santos", "wqe");
        User.add(5, "Antonio", "Rocha", "eqf");
        User.add(7, "Joao", "Nascimento", "wdqd");
        User.add(3, "José", "Silva", "edmw");



        ArrayList<String> ids = new ArrayList<String>();

        for(Map.Entry<Integer, String[]> cursor : user.list().entrySet()){
            ids.add("ID: "+Integer.toString(cursor.getKey()));
            System.out.println(ids.toString());
        }

        userListView = (ListView) findViewById(R.id.user_list);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ids);
        userListView.setAdapter(arrayAdapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

}
