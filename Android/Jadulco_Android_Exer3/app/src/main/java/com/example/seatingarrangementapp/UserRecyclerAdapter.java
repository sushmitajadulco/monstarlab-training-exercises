package com.example.seatingarrangementapp;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.seatingarrangementapp.R;
import com.example.seatingarrangementapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public ArrayList<User> getUserList() {
        return userList;
    }

    private ArrayList<User> userList;

    public void setUserList(ArrayList<User> userList) { this.userList = userList; }

    public UserRecyclerAdapter() {
    }

    public UserRecyclerAdapter(ArrayList<User> userList) {
        this.userList = userList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.item_user, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        User user = this.userList.get(i);

        if(viewHolder instanceof ViewHolder) {
            ((ViewHolder) viewHolder).fullNameTV.setText(user.getFullName());
        }
    }

    @Override
    public int getItemCount() {
        return this.userList.size();
    }

    public void clearUsers() {
        this.userList.clear();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView fullNameTV;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            fullNameTV = itemView.findViewById(R.id.tv_full_name);
        }
    }
}
