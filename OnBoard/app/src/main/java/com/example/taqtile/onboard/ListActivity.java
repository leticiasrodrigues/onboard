package com.example.taqtile.onboard;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    private String[] monthsArray = { "JAN", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY",
            "AUG", "SEPT", "OCT", "NOV", "DEC" };

    private ListView monthsListView;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Months List", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        monthsListView = (ListView) findViewById(R.id.months_list);

        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, monthsArray);
        monthsListView.setAdapter(arrayAdapter);


    }

}
