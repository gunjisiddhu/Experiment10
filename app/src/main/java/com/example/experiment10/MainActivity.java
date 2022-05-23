package com.example.experiment10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements PassData{


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerlayout);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("ALL EXPERIMENTS");
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawerLayout,toolbar,R.string.navigation_bar_open,R.string.navigation_bar_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.navigationlayout);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case(R.id.exp1):
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new Fragment1()).commit();
                        break;
                    case(R.id.exp2):
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new Fragment2()).commit();
                        break;
                    case(R.id.exp3):
                        startActivity(new Intent(getApplicationContext(),Experiment_3.class));
                        break;
                    case(R.id.exp4):
                        Toast.makeText(getApplicationContext(),"EXP-4",Toast.LENGTH_LONG).show();
                        break;
                    case(R.id.exp5):
                        startActivity(new Intent(getApplicationContext(),DialogBoxOpen.class));
                        break;
                    case(R.id.exp6):
                        startActivity(new Intent(getApplicationContext(),Calculator.class));
                        break;
                    case(R.id.exp7):
                        Toast.makeText(getApplicationContext(),"EXP-7",Toast.LENGTH_LONG).show();
                        break;
                    case(R.id.exp8):
                        Toast.makeText(getApplicationContext(),"EXP-8",Toast.LENGTH_LONG).show();
                        break;
                    case(R.id.exp9):
                        Toast.makeText(getApplicationContext(),"EXP-9",Toast.LENGTH_LONG).show();
                        break;
                    default:


                    }
                if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                    return true;


            }
        });

    }
    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
            super.onBackPressed();
    }

    @Override
    public void sendData(String name, String branch, String year, String review) {
        Bundle bundle = new Bundle();
        bundle.putString("haveData","yes");
        bundle.putString("name",name);
        bundle.putString("branch",branch);
        bundle.putString("year",year);
        bundle.putString("review",review);
        Fragment2 fragment2 = new Fragment2();
        fragment2.setArguments(bundle);
        navigationView.setCheckedItem(R.id.exp2);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment2).commit();
    }
}