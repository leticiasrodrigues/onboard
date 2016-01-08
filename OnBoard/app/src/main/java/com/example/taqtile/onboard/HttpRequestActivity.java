package com.example.taqtile.onboard;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class HttpRequestActivity extends AppCompatActivity {

    public final static String HTTP_MESSAGE = "com.example.taqtile.onboard.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_request);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        makeGetRequest();

    }

    private void makeGetRequest(){
        HttpClient client = new DefaultHttpClient();
        HttpUriRequest request = new HttpGet("http://reqres.in/api/users?page=1");

        HttpResponse response;
         try{
             response = client.execute(request);

             String message = "dwd";
             TextView textView = new TextView(this);
             textView.setTextSize(40);
             textView.setText(message);

             RelativeLayout layout = (RelativeLayout) findViewById(R.id.http_content);
             layout.addView(textView);


         } catch (ClientProtocolException e){
             String message = "erro1";
             TextView textView = new TextView(this);
             textView.setTextSize(40);
             textView.setText(message);

             RelativeLayout layout = (RelativeLayout) findViewById(R.id.http_content);
             layout.addView(textView);

         }catch (IOException e){
             String message = "erro2";
             TextView textView = new TextView(this);
             textView.setTextSize(40);
             textView.setText(message);

             RelativeLayout layout = (RelativeLayout) findViewById(R.id.http_content);
             layout.addView(textView);

         }
    }


}

