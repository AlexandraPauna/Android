package com.example.proiect_1;

import android.app.Application;
import android.provider.SyncStateContract;

import com.example.proiect_1.database.AppDatabase;
import com.example.proiect_1.utils.Constants;

import androidx.room.Room;

public class ApplicationController extends Application {

    private static ApplicationController mInstance;

    private static AppDatabase mAppDatabase;

    public static ApplicationController getInstance(){
        return  mInstance;
    }

    @Override
    public void onCreate() {

        super.onCreate();

        mInstance  = this;

        mAppDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
    }

    public static AppDatabase getAppDatabase(){
        return mAppDatabase;
    }
}
