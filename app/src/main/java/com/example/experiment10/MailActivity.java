package com.example.experiment10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MailActivity extends AppCompatActivity {

    EditText mailto,subject,body,cc;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);

        mailto = findViewById(R.id.mailto_mail);
        subject = findViewById(R.id.sub_mail);
        body =findViewById(R.id.body_mail);
        cc = findViewById(R.id.cc_mail);
        btn = findViewById(R.id.send_mail);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subj = subject.getText().toString();
                if(subj.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter Subject", Toast.LENGTH_SHORT).show();
                    subject.requestFocus();
                }

                String body_text = body.getText().toString();
                if(body_text.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter Body", Toast.LENGTH_SHORT).show();
                    body.requestFocus();
                }
                String mails[] = mailto.getText().toString().split(",");
                if(mails.length<1){
                    Toast.makeText(getApplicationContext(), "Enter Mail", Toast.LENGTH_SHORT).show();
                    mailto.requestFocus();
                }

                String ccs[] = cc.getText().toString().split(",");
                if(ccs.length<1){
                    Toast.makeText(getApplicationContext(), "Enter CC", Toast.LENGTH_SHORT).show();
                    cc.requestFocus();
                }

                Intent email= new Intent(Intent.ACTION_SENDTO);
                email.setData(Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_SUBJECT, subj);
                email.putExtra(Intent.EXTRA_TEXT, body_text);
                email.putExtra(Intent.EXTRA_EMAIL,mails);
                email.putExtra(Intent.EXTRA_CC,ccs);
                startActivity(email);

            }
        });
    }
}