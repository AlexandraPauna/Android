package com.example.proiect_1;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proiect_1.database.AppDatabase;
import com.example.proiect_1.database.User;
import com.example.proiect_1.database.UserDao_Impl;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class F3A2 extends Fragment {

    ArrayList<User> users;

    UsersAdapter usersAdapter;

    public F3A2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_f3_a2, container, false);

        final EditText firstName = view.findViewById(R.id.et_first_name);
        final EditText lastName = view.findViewById(R.id.et_last_name);

        Button F3A2_add = (Button) view.findViewById(R.id.btn_add_user);
        F3A2_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(firstName.getText().toString(), lastName.getText().toString());

                new UserRepository(getContext()).insertTask(user, new OnUserRepositoryActionListener() {
                    @Override
                    public void actionSucces() {
                        Toast.makeText(getContext(), "Adaugat cu succes", Toast.LENGTH_SHORT).show();
                        usersAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void actionFailed() {
                        Toast.makeText(getContext(), "Nu a putut fi adaugat!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        Button F3A2_remove = (Button) view.findViewById(R.id.btn_remove_user);
        F3A2_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new UserRepository(getContext()).getUserByNameString(firstName.getText().toString(), lastName.getText().toString());

                new UserRepository(getContext()).deleteTask(user, new OnUserRepositoryActionListener() {
                    @Override
                    public void actionSucces() {
                        Toast.makeText(getContext(), "Sters cu succes", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void actionFailed() {
                        Toast.makeText(getContext(), "Nu exista!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        users = new ArrayList<User>();

        users.addAll(new ApplicationController().getAppDatabase().userDao().getAll());

       /* users.add(new User("Ion", "Gheorghe"));
        users.add(new User("Maria", "Georgescu"));
        users.add(new User("Liliana", "Popescu"));
        users.add(new User("Mihai", "Popa"));*/

        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rec_view_users_list);
        usersAdapter = new UsersAdapter(getContext(), users);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(usersAdapter);

    }
}
