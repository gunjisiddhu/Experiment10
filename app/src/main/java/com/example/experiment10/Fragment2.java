package com.example.experiment10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    TextView t1,t2,t3,t4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root =  inflater.inflate(R.layout.fragment_2, container, false);

        t1 = root.findViewById(R.id.nameDisplay);
        t2 = root.findViewById(R.id.branchDisplay);
        t3 = root.findViewById(R.id.yearDisplay);
        t4 = root.findViewById(R.id.reviewDisplay);

        Bundle bundle = this.getArguments();
        if(bundle.getString("haveData").equalsIgnoreCase("yes")){
            t1.setText(bundle.getString("name"));
            t2.setText(bundle.getString("branch"));
            t3.setText(bundle.getString("year"));
            t4.setText(bundle.getString("review"));
        }
        else{
            t1.setText("No Data Received");
        }
        return root;
    }
}