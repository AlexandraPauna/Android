package com.example.proiect_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

interface OnActivityFragmentCommunication {
    void onAddFragment(String tag);
    void onReplaceFragment(String tag);
    void onRemoveFragment(String tag);
}

public class SecondActivity extends AppCompatActivity implements OnActivityFragmentCommunication {

    private static final String FRAGMENT_TAG = "FRAGMENT_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer1,new F1A2(), FRAGMENT_TAG);
        fragmentTransaction.setTransition(fragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }

    @Override
    public void onAddFragment(String tag) {
        if(tag.equals("F2A2")) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer2, new F2A2());
            fragmentTransaction.setTransition(fragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onReplaceFragment(String tag) {
        if(tag.equals("F2A2")) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer2,new F3A2());
            fragmentTransaction.setTransition(fragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onRemoveFragment(String tag) {
        if(tag.equals("F1A2")) {

            Fragment fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
            if (fragment != null){
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            }

        }
    }

    @Override
    public void onBackPressed() {
        FirstActivity.getInstance().finish();
        finish();
        super.onBackPressed();

    }
}
