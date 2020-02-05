package com.example.connection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener,OnValidDataListener{
    private Button btnSignIn;
    private Button btnSignUp;
    private CheckBox checkBox;
    private EditText etUsername;
    private EditText etPass;
    private ValidRegistrationPresenter registrationPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        etUsername = findViewById(R.id.et_username);
        etPass = findViewById(R.id.et_password);
        btnSignIn = findViewById(R.id.btn_sign_in);
        btnSignUp = findViewById(R.id.btn_sign_up);
        btnSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
        registrationPresenter = new ValidRegistrationPresenter(this);
        checkBox = findViewById(R.id.check);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_sign_in:
                if(checkBox.isChecked()){
                    registrationPresenter.isValidLogin(etUsername.getText().toString(), etPass.getText().toString());
                           }
                break;
            case R.id.btn_sign_up:
                goToRegistrationActivity();
            default:
                break;
        }
    }



    @Override
    public void isValidData() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
    public void goToRegistrationActivity(){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }
    @Override
    public void onDataError() {
        Toast.makeText(this, "not valid username or password", Toast.LENGTH_SHORT).show();
    }
}
