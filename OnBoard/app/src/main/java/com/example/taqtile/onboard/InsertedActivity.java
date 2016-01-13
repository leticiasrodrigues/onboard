package com.example.taqtile.onboard;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class InsertedActivity extends AppCompatActivity {

    public SimpleCursorAdapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserted);
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

        ListView lista;

        BancoController crud = new BancoController(getBaseContext());
        final Cursor cursor = crud.carregaDados();
        String[] nomeCampos = new String[]{CriaBanco.INTERNALID, CriaBanco.FIRSTNAME};
        int[] idViews = new int[]{R.id.userId, R.id.firstName};
        adaptador = new SimpleCursorAdapter(getBaseContext(), R.layout.user_layout, cursor, nomeCampos, idViews, 0);
        lista = (ListView) findViewById(R.id.listView);
        lista.setAdapter(adaptador);

        adaptador.notifyDataSetChanged();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.INTERNALID));
                Intent intent = new Intent(InsertedActivity.this, UserDetails2.class);
                //Intent intent = new Intent(InsertedActivity.this, UserDetails2.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });

    }

    public void novo (View view){
        Intent intent = new Intent(this, NewUser2.class);
        startActivity(intent);
    }

}
