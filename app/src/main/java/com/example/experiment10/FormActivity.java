package com.example.experiment10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FormActivity extends AppCompatActivity {

    EditText fname,sname;
    Button send;
    Spinner gender,lang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        gender = findViewById(R.id.form_gender);


        List<String> genders = new ArrayList<>();
        genders.add("Male");
        genders.add("Female");
        genders.add("Other");
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),R.layout.item,genders);
        gender.setAdapter(arrayAdapter);


        List<String> langs = new ArrayList<>();
        langs.add("Telugu");
        langs.add("English");
        langs.add("Hindi");
        lang = findViewById(R.id.form_langauge);
        ArrayAdapter arr = new ArrayAdapter(getApplicationContext(),R.layout.item,langs);
        lang.setAdapter(arr);

        fname = findViewById(R.id.form_firstname);
        sname = findViewById(R.id.form_secondname);
        send = findViewById(R.id.send_form);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fnamee = fname.getText().toString();
                if(fnamee.equals("")){
                    Toast.makeText(FormActivity.this, "First Name", Toast.LENGTH_SHORT).show();
                    fname.requestFocus();
                }

                String snamee = sname.getText().toString();
                if(snamee.equals("")){
                    Toast.makeText(FormActivity.this, "Second Name", Toast.LENGTH_SHORT).show();
                    sname.requestFocus();
                }


                String gen = gender.getSelectedItem().toString();
                String lan = lang.getSelectedItem().toString();

                Bundle bundle = new Bundle();
                bundle.putString("fname",fnamee);
                bundle.putString("sname",snamee);
                bundle.putString("gender",gen);
                bundle.putString("language",lan);
                Intent intent = new Intent(getApplicationContext(),FormDisplay.class);
                intent.putExtra("bundle",bundle);
                startActivity(intent);

            }
        });

    }
}