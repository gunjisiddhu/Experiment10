package com.example.experiment10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FormDisplay extends AppCompatActivity {

    TextView fname,sname,gen,lang;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_display);

        Bundle bundle = getIntent().getBundleExtra("bundle");
        Toast.makeText(this, ""+bundle.getString("fname"), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+bundle.getString("sname"), Toast.LENGTH_SHORT).show();

        fname = findViewById(R.id.display_fname);
        sname = findViewById(R.id.display_sname);
        gen = findViewById(R.id.display_gender);
        lang = findViewById(R.id.display_lang);


        fname.setText(bundle.getString("fname"));
        sname.setText(bundle.getString("sname"));
        gen.setText(bundle.getString("gender"));
        lang.setText(bundle.getString("language"));


        button = findViewById(R.id.display_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Experiment_3.class));
                finish();
            }
        });
    }
}