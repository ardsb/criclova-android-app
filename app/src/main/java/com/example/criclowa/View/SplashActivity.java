  package com.example.criclowa.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;

import com.example.criclowa.R;

  public class SplashActivity extends AppCompatActivity {
    Button login;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        sharedPreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();

        String name= sharedPreferences.getString("Name",null);
        String pswd= sharedPreferences.getString("Password",null);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pswd)){
                    startActivity(new Intent(SplashActivity.this, HomepageActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }


            }
        }, 2*1000);

    }
}