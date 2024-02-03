package com.example.textbookshare.view.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.textbookshare.R;
import com.example.textbookshare.model.Textbook;

import java.util.List;

public class TextbookAdapter extends RecyclerView.Adapter<TextbookAdapter.TextbookViewHolder> {

    private List<Textbook> textbooks;

    public void setTextbooks(List<Textbook> textbooks) {
        this.textbooks = textbooks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TextbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_textbook, parent, false);
        return new TextbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextbookViewHolder holder, int position) {
        if (textbooks != null) {
            Textbook textbook = textbooks.get(position);
            holder.bind(textbook);
        }
    }

    @Override
    public int getItemCount() {
        return textbooks != null ? textbooks.size() : 0;
    }

    public static class TextbookViewHolder extends RecyclerView.ViewHolder {

        private final TextView titleTextView;
        private final TextView authorTextView;

        public TextbookViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textViewTitle);
            authorTextView = itemView.findViewById(R.id.textViewAuthor);
        }

        public void bind(Textbook textbook) {
            titleTextView.setText(textbook.getTitle());
            authorTextView.setText(textbook.getAuthor());
        }
    }
}
