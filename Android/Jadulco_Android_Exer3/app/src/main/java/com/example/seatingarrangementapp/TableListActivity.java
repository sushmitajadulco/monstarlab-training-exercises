package com.example.seatingarrangementapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.seatingarrangementapp.adapter.UserRecyclerAdapter;
import com.example.seatingarrangementapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class TableListActivity extends AppCompatActivity {

    private Context context;

    private ArrayList<User> table = new ArrayList<>();;

    private UserRecyclerAdapter userRecyclerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_list);

        context = this;

        table = getIntent().getParcelableArrayListExtra("table");

        RecyclerView usersRV = findViewById(R.id.recyclerview_users);
        userRecyclerAdapter = new UserRecyclerAdapter(context, table);
        usersRV.setLayoutManager(new LinearLayoutManager(context));
        usersRV.setAdapter(userRecyclerAdapter);
    }
}
