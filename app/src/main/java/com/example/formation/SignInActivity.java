package com.example.formation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {

    private TextView goToForgetPassword;
    private  TextView goToSignUpACT;


    private EditText email, password;
    private Button btnSignIn;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        goToForgetPassword = findViewById(R.id.goToForgetPassword);
        goToSignUpACT = findViewById(R.id.goToSignUp);
        email=findViewById(R.id.emailSignIn);
        password=findViewById(R.id.passwordSignIn);
        btnSignIn=findViewById(R.id.btnSignIn);

        firebaseAuth=FirebaseAuth.getInstance();


        goToForgetPassword.setOnClickListener(v -> {
            startActivity(new Intent(SignInActivity.this, ForgetPassword.class));

        });
        goToSignUpACT = findViewById(R.id.goToSignUp);


        goToSignUpACT.setOnClickListener(v -> {
            startActivity(new Intent(SignInActivity.this, SignUpActivity.class));

        });
        btnSignIn.setOnClickListener(view -> {
            firebaseAuth.signInWithEmailAndPassword(email.getText().toString().trim(),password.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        checkEmailVerification();
                    }
                    else {
                        Toast.makeText(SignInActivity.this, "Please verify that your data is correct!", Toast.LENGTH_LONG).show();
                    }

                }
            });

        });
    }

    private void checkEmailVerification() {
        FirebaseUser user=firebaseAuth.getCurrentUser();
        if(user.isEmailVerified()){
            startActivity(new Intent(SignInActivity.this,HomeActivity.class));
        }
        else{
            Toast.makeText(this, "Please verify your email!", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }

}