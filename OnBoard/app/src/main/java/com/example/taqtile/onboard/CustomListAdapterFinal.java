package com.example.taqtile.onboard;

/**
 * Created by taqtile on 1/12/16.
 */
import android.content.Context;
import android.database.Cursor;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomListAdapterFinal extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private BancoControllerFinal crud;
    private Cursor cursor;
    private String[] nomeCampos;
    //private int[] idViews

    public CustomListAdapterFinal(Context aContext){

        crud = new BancoControllerFinal(aContext);
        cursor = crud.carregaDados();
        layoutInflater = LayoutInflater.from(aContext);
        //idViews = new int[]{R.id.userId, R.id.firstName};
    }



    @Override
    public int getCount() {
        return crud.getCount();
    }

    @Override
    public Cursor getItem(int position) {
        return crud.carregaDadoById(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_row_layout, null);
            holder = new ViewHolder();
            holder.idView = (TextView) convertView.findViewById(R.id.id);
            holder.firstNameView = (TextView) convertView.findViewById(R.id.first_name);
            holder.lastNameView = (TextView) convertView.findViewById(R.id.last_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.idView.setText("ID: " + position);

        if (Integer.parseInt(crud.getAccess(position))==1){
            holder.idView.setTypeface(null, Typeface.NORMAL);
        }
        else{
            holder.idView.setTypeface(null, Typeface.BOLD_ITALIC);
        }


        holder.firstNameView.setText("First name: " + crud.getFirstName(position));
        holder.lastNameView.setText("Last name: " + crud.getLastName(position));
        return convertView;
    }

    static class ViewHolder {
        TextView idView;
        TextView firstNameView;
        TextView lastNameView;
    }
}

