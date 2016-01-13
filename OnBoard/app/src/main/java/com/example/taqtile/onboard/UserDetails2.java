package com.example.taqtile.onboard;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

public class UserDetails2 extends AppCompatActivity {

    private ListView detailsListView;
    private ArrayAdapter arrayAdapter;

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    public Cursor cursor;
    public final BancoController crud = new BancoController(getBaseContext());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        final String codigo;

        codigo = this.getIntent().getStringExtra("codigo");

        //informacoes
        cursor = crud.carregaDadoById(Integer.parseInt(codigo));

        ArrayList details = new ArrayList<>();

        details.add("ID: "+cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.INTERNALID)));
        details.add("First Name: "+cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.FIRSTNAME)));
        details.add("Last Name: "+cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.LASTNAME)));


        detailsListView = (ListView) findViewById(R.id.user_detail2);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, details);
        detailsListView.setAdapter(arrayAdapter);

//        mRequestQueue = Volley.newRequestQueue(this);
//        mImageLoader = new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {
//            private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);
//            public void putBitmap(String url, Bitmap bitmap) {
//                mCache.put(url, bitmap);
//            }
//            public Bitmap getBitmap(String url) {
//                return mCache.get(url);
//            }
//        });
//
//        NetworkImageView avatar = (NetworkImageView) findViewById(R.id.picture2);
//        avatar.setImageUrl(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.AVATAR)), mImageLoader);
    }

    public void back(View view){
        onBackPressed();
    }
}

