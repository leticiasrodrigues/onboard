package com.example.taqtile.onboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowUserDetails extends AppCompatActivity {

    private ListView detailsListView;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        ArrayList details = new ArrayList<>();

        String message = intent.getStringExtra(UserInformationActivity.ID);
        details.add("ID: " + message);
        message = intent.getStringExtra(UserInformationActivity.FIRST_NAME);
        details.add("Name: " + message);
        message = intent.getStringExtra(UserInformationActivity.LAST_NAME);
        details.add("Last Name: "+ message);
        message = intent.getStringExtra(UserInformationActivity.AVATAR);
        details.add("Avatar: "+ message);
        message = intent.getStringExtra(UserInformationActivity.COUNTER);
        details.add("Counter: "+ message);


        detailsListView = (ListView) findViewById(R.id.user_detail2);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, details);
        detailsListView.setAdapter(arrayAdapter);
    }

}
