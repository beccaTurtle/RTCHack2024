package com.example.textbookshare.view.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.textbookshare.R;
import com.example.textbookshare.databinding.ItemTextbookBinding;
import com.example.textbookshare.model.Textbook;

import java.util.List;

public class TextbookAdapter extends RecyclerView.Adapter<TextbookAdapter.TextbookViewHolder> {

    private final Context context;
    private List<Textbook> textbooks;
    private final ItemClickListener itemClickListener;
    private LayoutInflater inflater;

    public TextbookAdapter(Context context, List<Textbook> textbooks, ItemClickListener itemClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.textbooks = textbooks;
        this.itemClickListener = itemClickListener;
    }

    public void setTextbooks(List<Textbook> textbooks) {
        this.textbooks = textbooks;
        notifyDataSetChanged(); // Notify the adapter that the data has changed
    }

//    @NonNull
    @Override
    public TextbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_textbook, parent, false);
//        ItemTextbookBinding binding = ItemTextbookBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TextbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TextbookViewHolder holder, int position) {
        Textbook textbook = textbooks.get(position);
        holder.bind(textbook.getTitle(), textbook.getAuthor());
        holder.itemView.setOnClickListener(v -> {
            itemClickListener.onItemClick(textbook);
                }

        );
    }

    @Override
    public int getItemCount() {
        return textbooks.size();
    }

    public interface ItemClickListener {
        void onItemClick(Textbook textbook);

    }

    public class TextbookViewHolder extends RecyclerView.ViewHolder {
        TextView titleView;
        TextView authorView;

        public TextbookViewHolder(@NonNull View itemView){
            super(itemView);
            titleView = itemView.findViewById(R.id.textViewTitle);
            authorView = itemView.findViewById(R.id.textViewAuthor);
        }

        public void bind(String title, String author) {
            titleView.setText(title);
            authorView.setText(author);
        }
    }
//        private final ItemTextbookBinding binding;
//
//        public TextbookViewHolder(ItemTextbookBinding binding) {
//            super(binding.getRoot());
//            this.binding = binding;
//
//            // Set click listener for the entire item view
//            itemView.setOnClickListener(v -> {
//                int position = getAdapterPosition();
//                if (position != RecyclerView.NO_POSITION && itemClickListener != null) {
//                    itemClickListener.onItemClick(textbooks.get(position));
//                }
//            });
//        }
//
//        public void bind(Textbook textbook) {
//            binding.textViewTitle.setText(textbook.getTitle());
//            binding.textViewAuthor.setText(textbook.getAuthor());
//        }
    }

