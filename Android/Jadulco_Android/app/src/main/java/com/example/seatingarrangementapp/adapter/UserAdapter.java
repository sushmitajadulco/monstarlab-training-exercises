package com.example.seatingarrangementapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.seatingarrangementapp.R;
import com.example.seatingarrangementapp.model.User;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    private List<User> users;

    private Context context;

    private int resource;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private static class ViewHolder {
        TextView fullNameTV;
    }

    public UserAdapter(Context context, int resource, List<User> users) {
        super(context, resource, users);
        this.context = context;
        this.resource = resource;
        this.users = users;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = this.users.get(position);

        ViewHolder viewHolder;

        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, parent, false);

            viewHolder.fullNameTV = convertView.findViewById(R.id.tv_full_name);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.fullNameTV.setText(user.getFullName());

        return convertView;
    }

}
