package com.example.experiment10;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class DialogBoxOpen extends AppCompatActivity {

    EditText t1,t2,t3;
    Button b1;
    AlertDialog.Builder builder;
    AlertDialog alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_box_open);
        t1 = findViewById(R.id.Name);
        t2 = findViewById(R.id.mail);
        t3= findViewById(R.id.Branch);
        b1 = findViewById(R.id.button);
        builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        builder.setCancelable(false).setView(inflater.inflate(R.layout.demo, null)).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Bundle bundle =new Bundle();
                bundle.putString("name",t1.getText().toString());
                bundle.putString("mail",t2.getText().toString());
                bundle.putString("branch",t3.getText().toString());
                RadioButton male,female;
                male=alert.findViewById(R.id.male);
                female=alert.findViewById(R.id.female);
                CheckBox telugu,english;
                telugu=alert.findViewById(R.id.telugu);
                english=alert.findViewById(R.id.english);
                if(male.isSelected())
                    bundle.putString("gender","Male");
                else
                    bundle.putString("gender","Female");
                String langs = "";
                if(telugu.isChecked())
                    langs+="Telugu";
                if(english.isChecked())
                    langs+="   English";
                bundle.putString("languages",langs);
                Intent intent = new Intent(getApplicationContext(),DisplayActivity.class);
                intent.putExtra("bundle",bundle);
                startActivity(intent); }
        });
        alert = builder.create();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.show();
            }
        }); }
}