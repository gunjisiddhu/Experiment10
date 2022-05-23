package com.example.experiment10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.EmptyStackException;

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,ba,bs,bm,bd,bmod,bdot,bopen,bclose,bback,bclear,bequal;
    EditText input;
    TextView resulttext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        setVals();

        input.setShowSoftInputOnFocus(false);

        input.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(input.hasFocus())
                    bequal.setText("Ok");
            }
        });

    }


    public void setVals(){
        b1 = findViewById(R.id.b1);
        b2  = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b0 = findViewById(R.id.b0);
        ba = findViewById(R.id.badd);
        bs = findViewById(R.id.bsub);
        bm = findViewById(R.id.bmul);
        bd = findViewById(R.id.bdiv);
        bmod = findViewById(R.id.bmod);
        bdot = findViewById(R.id.bdot);
        bopen = findViewById(R.id.bopen);
        bclose = findViewById(R.id.bclose);
        bback = findViewById(R.id.bback);
        input = findViewById(R.id.input);
        bclear = findViewById(R.id.bclear);
        bequal = findViewById(R.id.bequal);

        resulttext = findViewById(R.id.resultText);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        ba.setOnClickListener(this);
        bs.setOnClickListener(this);
        bm.setOnClickListener(this);
        bd.setOnClickListener(this);
        bmod.setOnClickListener(this);
        bdot.setOnClickListener(this);
        bopen.setOnClickListener(this);
        bclose.setOnClickListener(this);
        bback.setOnClickListener(this);;
        bclear.setOnClickListener(this);
        bequal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int pos=input.getText().toString().length();
        String str = "";
        String str2 ="";
        if(input.hasFocus()){
            int position = input.getSelectionStart();
            int end = input.getSelectionEnd();
            pos = end;
            String temp = input.getText().toString();
            str = new String(temp.toCharArray(),0,position);
            str2 = new String(temp.toCharArray(),end,temp.length()-position);
        }
        else
            str = input.getText().toString();
        switch(view.getId()){
            //Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,ba,bs,bm,bd,bmod,bdot,bopen,bclose,bback;
            case R.id.b1:
                str+=1;
                input.setText(str+str2);
                break;
            case R.id.b2:
                str+=2;
                input.setText(str+str2);
                break;
            case R.id.b3:
                str+=3;
                input.setText(str+str2);
                break;
            case R.id.b4:
                str+=4;
                input.setText(str+str2);
                break;
            case R.id.b5:
                str+=5;
                input.setText(str+str2);
                break;
            case R.id.b6:
                str+=6;
                input.setText(str+str2);
                break;
            case R.id.b7:
                str+=7;
                input.setText(str+str2);
                break;
            case R.id.b8:
                str+=8;
                input.setText(str+str2);
                break;
            case R.id.b9:
                str+=9;
                input.setText(str+str2);
                break;
            case R.id.b0:
                str+=0;
                input.setText(str+str2);
                break;
            case R.id.badd:
                str+='+';
                input.setText(str+str2);
                break;
            case R.id.bsub:
                str+='-';
                input.setText(str+str2);
                break;
            case R.id.bmul:
                str+='*';
                input.setText(str+str2);
                break;
            case R.id.bdiv:
                str+='/';
                input.setText(str+str2);
                break;
            case R.id.bmod:
                str+='%';
                input.setText(str+str2);
                break;
            case R.id.bdot:
                str+='.';
                input.setText(str+str2);
                break;
            case R.id.bopen:
                str+='(';
                input.setText(str+str2);
                break;
            case R.id.bclose:
                str+=')';
                input.setText(str+str2);
                break;
            case R.id.bback:
                str = new String(str.toCharArray(),0,str.length()-1);
                input.setText(str+str2);
                break;
            case R.id.bclear:
                input.setText("");
                break;
            case R.id.bequal:
                if(input.hasFocus()){
                    bequal.setText("=");
                    input.clearFocus();
                }
                else
                    displayresult();
                break;

        }
        if(input.hasFocus())
            input.setSelection(pos+1);

    }

    public void displayresult(){
        try {
            String str = input.getText().toString();
            infixevaluation infixevaluation = new infixevaluation();
            double ans = infixevaluation.infix(str, str.length());
            resulttext.setText(ans + "");
            input.clearFocus();
        }catch(EmptyStackException e){
            Toast.makeText(getApplicationContext(),"Please Check Expression..!",Toast.LENGTH_SHORT).show();

        }

    }
}