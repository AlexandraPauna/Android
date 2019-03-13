package com.example.proiect_1;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class F1A2 extends Fragment {

    OnActivityFragmentCommunication onActivityFragmentCommunication;

    public F1A2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f1_a2, container, false);
        Button F1A2 = (Button) view.findViewById(R.id.BtnF1A2);
        F1A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onActivityFragmentCommunication.onAddFragment("F2A2");
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnActivityFragmentCommunication){
            onActivityFragmentCommunication = (OnActivityFragmentCommunication) context;
        }
    }
}


