package com.example.experiment10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {

    EditText t1,t2,t3,t4;
    Button submit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_1, container, false);


        t1 = root.findViewById(R.id.name);
        t2 = root.findViewById(R.id.branch);
        t3 = root.findViewById(R.id.year);
        t4 = root.findViewById(R.id.review);
        submit =root.findViewById(R.id.frag1_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PassData passData =(PassData) getActivity();
                String name = t1.getText().toString();
                String branch = t2.getText().toString();
                String year = t3.getText().toString();
                String review = t4.getText().toString();
                passData.sendData(name,branch,year,review);
            }
        });

        return root;
    }
}