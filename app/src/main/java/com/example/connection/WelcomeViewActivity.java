package com.example.connection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeViewActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSignUp;
    TextView tvSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_view);
        tvSignIn = findViewById(R.id.tv_sign_in);
        btnSignUp = findViewById(R.id.bt_sign_up);
        btnSignUp.setOnClickListener(this);
        tvSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.tv_sign_in:
                goToSignInActivity();
                break;
            case R.id.bt_sign_up:
                goToRegistrationActivity();
            default:
                break;
        }
    }

    public void goToRegistrationActivity(){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void goToSignInActivity(){
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }
}
