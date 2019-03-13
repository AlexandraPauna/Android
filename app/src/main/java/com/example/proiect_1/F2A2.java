package com.example.proiect_1;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class F2A2 extends Fragment {

    OnActivityFragmentCommunication onActivityFragmentCommunication;

    public F2A2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f2_a2, container, false);
        Button F2A2_1 = (Button) view.findViewById(R.id.BtnF2A2_1);
        F2A2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onActivityFragmentCommunication.onReplaceFragment("F2A2");

            }
        });

        Button F2A2_2 = (Button) view.findViewById(R.id.BtnF2A2_2);
        F2A2_2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onActivityFragmentCommunication.onRemoveFragment("F1A2");
            }
        });

        Button F2A2_3 = (Button) view.findViewById(R.id.BtnF2A2_3);
        F2A2_3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });


        return  view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnActivityFragmentCommunication){
            onActivityFragmentCommunication = (OnActivityFragmentCommunication) context;
        }
    }

}
