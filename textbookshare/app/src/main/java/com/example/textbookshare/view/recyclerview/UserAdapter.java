package com.example.textbookshare.view.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.textbookshare.R;
import com.example.textbookshare.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private final Context context;
    private List<User> users;
    private LayoutInflater inflater;

    public UserAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.bind(user.getUsername(), user.getEmail());
    }

    @Override
    public int getItemCount() {
        return users != null ? users.size() : 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView nameView;
        TextView emailView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.textViewName);
            emailView = itemView.findViewById(R.id.textViewEmail);
        }

        public void bind(String name, String email) {
            nameView.setText(name);
            emailView.setText(email);
        }
    }
}
