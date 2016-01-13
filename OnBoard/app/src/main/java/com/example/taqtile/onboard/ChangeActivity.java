package com.example.taqtile.onboard;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChangeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
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

        final EditText first;
        final EditText last;
        final EditText avatar;
        Button alterar;
        Button deletar;
        Cursor cursor;

        final BancoController crud;
        final String codigo;

        codigo = this.getIntent().getStringExtra("codigo");
        crud = new BancoController(getBaseContext());
        first = (EditText)findViewById(R.id.editText4);
        last = (EditText)findViewById(R.id.editText5);
        avatar = (EditText)findViewById(R.id.editText6);

        alterar = (Button)findViewById(R.id.button2);

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        first.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.FIRSTNAME)));
        last.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.LASTNAME)));
        avatar.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.AVATAR)));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                crud.alteraRegistro(Integer.parseInt(codigo),first.getText().toString(),last.getText().toString(),avatar.getText().toString());
                Intent intent = new Intent(ChangeActivity.this,InsertedActivity.class);
                startActivity(intent);
                finish();
            }
        });

        deletar = (Button)findViewById(R.id.button3);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(ChangeActivity.this,InsertedActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
