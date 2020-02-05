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

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener ,OnValidDataListener{


        private EditText etUsername;
        private EditText etPass;
        private EditText etRepeatePass;

        private Button btnSave;
        private TextView tvCencel;
        private CheckBox checkBox;

        private ValidRegistrationPresenter registrationPresenter;
        @Override

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_in);
            etUsername = findViewById(R.id.et_username);
            etPass = findViewById(R.id.et_password);
            etRepeatePass = findViewById(R.id.et_repeat_password);
            btnSave = findViewById(R.id.btn_save);
            tvCencel = findViewById(R.id.tv_cancel);
            btnSave.setOnClickListener(this);
            tvCencel.setOnClickListener(this);
            registrationPresenter = new ValidRegistrationPresenter(this);
            checkBox = findViewById(R.id.check);
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.btn_save:
                    if(checkBox.isChecked()){
                    registrationPresenter.isValidData(etUsername.getText().toString(), etPass.getText().toString(),
                            etRepeatePass.getText().toString());}
                    break;
                case R.id.tv_cancel:
                    etPass.setText("");
                    etRepeatePass.setText("");
                    etUsername.setText("");
                default:
                    break;
            }
        }



    @Override
        public void isValidData() {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        @Override
        public void onDataError() {
            Toast.makeText(this, "not valid username or password", Toast.LENGTH_SHORT).show();
        }


    }