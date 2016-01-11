package com.example.taqtile.onboard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.LruCache;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class UserDetails extends AppCompatActivity {

    private ListView detailsListView;
    private ArrayAdapter arrayAdapter;

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        ArrayList details = new ArrayList<>();

        String message = intent.getStringExtra(UserInformationActivity.ID);
        details.add("ID: " + message);
        message = intent.getStringExtra(UserInformationActivity.FIRST_NAME);
        details.add("Name: " + message);
        message = intent.getStringExtra(UserInformationActivity.LAST_NAME);
        details.add("Last Name: " + message);
        //message = intent.getStringExtra(UserInformationActivity.AVATAR);
        //details.add("Avatar: "+ message);
        message = intent.getStringExtra(UserInformationActivity.COUNTER);
        details.add("Accesses: " + message);


        detailsListView = (ListView) findViewById(R.id.user_detail);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, details);
        detailsListView.setAdapter(arrayAdapter);

        mRequestQueue = Volley.newRequestQueue(this);
        mImageLoader = new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);
            public void putBitmap(String url, Bitmap bitmap) {
                mCache.put(url, bitmap);
            }
            public Bitmap getBitmap(String url) {
                return mCache.get(url);
            }
        });

        NetworkImageView avatar = (NetworkImageView) findViewById(R.id.picture);
        avatar.setImageUrl(intent.getStringExtra(UserInformationActivity.AVATAR),mImageLoader);
    }

    public void back(View view){
        onBackPressed();
    }
}
