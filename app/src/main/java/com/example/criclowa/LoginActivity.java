package com.example.criclowa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView input, input2,register;
    Button login;
    CheckBox rememberMe;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        rememberMe=findViewById(R.id.checkBox);

//      Initialize shared preferences
        sharedPreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);


        input=findViewById(R.id.input_email);
        input2=findViewById(R.id.input_password);
//        register= findViewById(R.id.btnGuest);
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent mainActivityIntent = new Intent(LoginActivity.this, HomepageActivity.class);
//                startActivity(mainActivityIntent);
//
//
//            }
//
//        });
        login=findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getName= input.getText().toString();
                String getPassword=input2.getText().toString();


                if (rememberMe.isChecked()){

                    Toast.makeText(LoginActivity.this,"Your login credential has successfully saved",Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor= sharedPreferences.edit();

                    editor.putString("Name", getName);
                    editor.putString("Password", getPassword);
                    editor.commit();
                }else {
                    Toast.makeText(LoginActivity.this,"Your login credential has not saved",Toast.LENGTH_SHORT).show();
                }

                Intent main = new Intent(LoginActivity.this,HomepageActivity.class);
                startActivity(main);



            }
        });


    }

}