package com.example.proiect_1;

import android.os.AsyncTask;

import com.example.proiect_1.database.User;

public class InsertTask extends AsyncTask<User, Void, Void> {

    OnUserRepositoryActionListener listener;

    InsertTask(OnUserRepositoryActionListener listener){
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(User... users) {
        ApplicationController.getAppDatabase().userDao().insertTask(users[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.actionSucces();
    }
}
