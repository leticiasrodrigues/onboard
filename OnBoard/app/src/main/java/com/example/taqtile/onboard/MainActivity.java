package com.example.taqtile.onboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    public static final String JSON_URL = "http://reqres.in/api/users?page=4";
    public final static String EXTRA_MESSAGE = "com.example.taqtile.onboard.MESSAGE";
    public final static String USER = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with something", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void showList(View view){
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);
    }

    public void users(View  view){
        //Intent intent = new Intent(this,ListUserActivity.class);
        Intent intent = new Intent(this,InsertedActivity.class);
        startActivity(intent);
    }

    public void usersInfo(View  view){
        sendRequest();
        //Intent intent = new Intent(this,UserInformationActivity.class);
        //startActivity(intent);
    }

    public void jsonVolley(View  view){
        Intent intent = new Intent(this,JsonVolleyActivity.class);
        startActivity(intent);
    }

    private void showJSON(String json){
//        ParseJSON pj = new ParseJSON(json);
//        pj.parseJSON();
//
//        ArrayList<User2> userList = new ArrayList<User2>();
//
//        for(int i=0; i<pj.size;i++){
//            userList.add(new User2(i,pj.names[i],pj.ids[i],pj.emails[i]));
//        }

        Intent intent = new Intent(this,UserInformationActivity.class);
        intent.putExtra(USER,json);
        startActivity(intent);

//        CustomList cl = new CustomList(this, ParseJSON.ids,ParseJSON.names,ParseJSON.emails);
//        listView.setAdapter(cl);
    }

    private void sendRequest(){

        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void addUser(View  view){
        Intent intent = new Intent(this,NewUserActivity.class);
        //Intent intent = new Intent(this,NewUser2.class);
        startActivity(intent);
    }

    public void complete(View  view){
        Intent intent = new Intent(this,UserInformationFinalActivity.class);
        startActivity(intent);
    }


}
