package com.example.formation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {

    private TextView goToForgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        goToForgotPassword=findViewById(R.id.goToForgotPassword);

        goToForgotPassword.setOnClickListener(v->{
            startActivity(new Intent(SignInActivity.this,ForgotPasswordActivity.class));

        });
    }

}