package com.example.taqtile.onboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private ArrayList<User2> user;
    private LayoutInflater layoutInflater;

    public CustomListAdapter(Context aContext, ArrayList<User2> user){
        this.user = user;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return user.size();
    }

    @Override
    public Object getItem(int position) {
        return user.get(position);
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

        holder.idView.setText("ID: " + user.get(position).getId());
        holder.firstNameView.setText("First name: " + position+user.get(position).toString());
        holder.lastNameView.setText("Last name: "+user.get(position).getLast_name());
        return convertView;
    }

    static class ViewHolder {
        TextView idView;
        TextView firstNameView;
        TextView lastNameView;
    }
}
