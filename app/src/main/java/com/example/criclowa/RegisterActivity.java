package com.example.criclowa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {
    Button login;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        login=findViewById(R.id.btnGuest);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"You have successfully Registered",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            //Back button
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}