package com.example.taqtile.onboard;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.LruCache;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

public class InfoActivity extends AppCompatActivity {

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
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



        final TextView first;
        final TextView last;
        final TextView avatar;
        Button alterar;
        Button deletar;
        Cursor cursor;

        final BancoController crud;
        final String codigo;

        codigo = this.getIntent().getStringExtra("codigo");
        crud = new BancoController(getBaseContext());
        first = (TextView)findViewById(R.id.editText4);
        last = (TextView)findViewById(R.id.editText5);
        avatar = (TextView)findViewById(R.id.editText6);

        alterar = (Button)findViewById(R.id.button2);

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        first.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.FIRSTNAME)));
        last.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.LASTNAME)));
        avatar.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.AVATAR)));


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

        NetworkImageView avatarPicture = (NetworkImageView) findViewById(R.id.picture);
        avatarPicture.setImageUrl(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.AVATAR)), mImageLoader);

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                //crud.alteraRegistro(Integer.parseInt(codigo),first.getText().toString(),last.getText().toString(),avatar.getText().toString());
                Intent intent = new Intent(InfoActivity.this,ChangeActivity.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                //finish();
            }
        });

        deletar = (Button)findViewById(R.id.button3);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(InfoActivity.this, InsertedActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

}
