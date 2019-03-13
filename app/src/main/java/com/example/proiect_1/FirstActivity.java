
package com.example.proiect_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FirstActivity extends AppCompatActivity {

    static FirstActivity firstActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        firstActivity = this;

    }

    public static  FirstActivity getInstance(){
        return firstActivity;
    }
}
