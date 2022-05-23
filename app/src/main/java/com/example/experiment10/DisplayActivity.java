package com.example.experiment10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        t1 = findViewById(R.id.name);
        t2 = findViewById(R.id.gender);
        t3 = findViewById(R.id.langs);
        t4 = findViewById(R.id.branch);
        t5 = findViewById(R.id.mailid);

        Bundle bundle = getIntent().getBundleExtra("bundle");
        t1.setText(bundle.getString("name"));
        t2.setText(bundle.getString("gender"));
        t3.setText(bundle.getString("languages"));
        t4.setText(bundle.getString("branch"));
        t5.setText(bundle.getString("mail"));


    }
}