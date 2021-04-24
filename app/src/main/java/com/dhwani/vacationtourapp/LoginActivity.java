package com.dhwani.vacationtourapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnlogin;
    EditText etEmailL, etPassL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin = findViewById(R.id.btnlogin);
        etEmailL = findViewById(R.id.etEmailL);
        etPassL = findViewById(R.id.etPassL);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmailL.getText().toString();
                String pass = etPassL.getText().toString();

                if(email.isEmpty() || pass.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Please enter all the details correctly", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }

            }

        });
    }
}