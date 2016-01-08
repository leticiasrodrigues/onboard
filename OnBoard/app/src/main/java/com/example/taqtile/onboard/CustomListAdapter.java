package com.example.taqtile.onboard;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private ArrayList<User2> userList;
    private LayoutInflater layoutInflater;

    public CustomListAdapter(Context aContext, ArrayList<User2> userList){
        this.userList = userList;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public User2 getItem(int position) {
        return userList.get(position);
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


        holder.idView.setText("ID: " + userList.get(position).getId());

        if (userList.get(position).getAccess()){
            holder.idView.setTypeface(null, Typeface.BOLD_ITALIC);
        }
        else{
            holder.idView.setTypeface(null, Typeface.NORMAL);
        }


        holder.firstNameView.setText("First name: " + userList.get(position).getFirstName());
        holder.lastNameView.setText("Last name: " + userList.get(position).getLastName());
        return convertView;
    }

    static class ViewHolder {
        TextView idView;
        TextView firstNameView;
        TextView lastNameView;
    }
}
