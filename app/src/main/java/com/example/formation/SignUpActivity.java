package com.example.formation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    //declaration des instances
    private TextView goToSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //affectation des views xml-> java
        goToSignIn=findViewById(R.id.goToSignIn);

        goToSignIn.setOnClickListener(v->{
            startActivity(new Intent(SignUpActivity.this,SignInActivity.class));
        });
    }
}