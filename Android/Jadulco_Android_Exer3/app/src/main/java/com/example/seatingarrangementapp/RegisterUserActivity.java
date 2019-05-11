package com.example.seatingarrangementapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.seatingarrangementapp.model.User;

public class RegisterUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        final EditText userNameET = findViewById(R.id.et_full_name);
        Button registerUserBtn = findViewById(R.id.btn_register);

        registerUserBtn.setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                String userName = userNameET.getText().toString();

                User user = new User();
                user.setFullName(userName);

                Intent data = new Intent();
                data.putExtra( "user", user);
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }
}
