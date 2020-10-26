package com.example.criclowa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class HomepageActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        dl = (DrawerLayout)findViewById(R.id.d1);
        abdt = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nav_view= (NavigationView)findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              int id =item.getItemId();

              if (id ==R.id.imgProfile){

                  Toast.makeText(HomepageActivity.this,"Home",Toast.LENGTH_SHORT).show();
              }
               else if (id ==R.id.imgHome){

                    Toast.makeText(HomepageActivity.this,"News and Videos",Toast.LENGTH_SHORT).show();
                }
                else if (id ==R.id.imgSetting){

                    Toast.makeText(HomepageActivity.this,"Settings",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}

