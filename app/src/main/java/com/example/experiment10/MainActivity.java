package com.example.experiment10;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
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
    }
}