package com.example.proiect_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.proiect_1.database.User;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class UsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int TYPE_GREEN = 0;
    private final int TYPE_PINK = 1;


    private ArrayList<User> items;
    private Context context;

    public UsersAdapter(Context context, ArrayList<User> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0){
            return TYPE_GREEN;
        }

        return TYPE_PINK;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.user_row, parent, false);

        RecyclerView.ViewHolder viewHolder = new UsersAdapter.ViewHolder(view);
        return viewHolder;

        //return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        TextView fstNameTextView = ((ViewHolder)viewHolder).firstNameTextView;
        TextView lstNameTextView = ((ViewHolder)viewHolder).lastNameTextView;
        fstNameTextView.setText(items.get(position).firstName);
        lstNameTextView.setText(items.get(position).lastName);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView firstNameTextView;
        public TextView lastNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            firstNameTextView = itemView.findViewById(R.id.first_name);
            lastNameTextView = itemView.findViewById(R.id.last_name);
        }
    }

}
