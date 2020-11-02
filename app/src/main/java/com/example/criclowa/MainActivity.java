package com.example.criclowa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView input, input2,register;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        input=findViewById(R.id.input_email);
        input2=findViewById(R.id.input_password);
        register= findViewById(R.id.btnGuest);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(MainActivity.this, HomepageActivity.class);
                startActivity(mainActivityIntent);


            }

        });
        login=findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String li = input.getText().toString();

                if (!TextUtils.isEmpty(li)){
                    Toast.makeText(getApplicationContext(), "Email address is " + li,Toast.LENGTH_SHORT).show();



                }else {
                    //Toast.makeText(getApplicationContext(), "text cant be empty",Toast.LENGTH_SHORT).show();
                    input.setError("Email field should be valid");

                }

                String lu = input2.getText().toString();

                if (!TextUtils.isEmpty(li)){
                    Toast.makeText(getApplicationContext(), "Email address is " + lu,Toast.LENGTH_SHORT).show();



                }else {
                    //Toast.makeText(getApplicationContext(), "text cant be empty",Toast.LENGTH_SHORT).show();
                    input2.setError("Password field should be valid");

                }
            }
        });


    }
}