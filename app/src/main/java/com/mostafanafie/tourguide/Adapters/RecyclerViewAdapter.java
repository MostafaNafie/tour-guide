package com.mostafanafie.tourguide.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.mostafanafie.tourguide.Attraction;
import com.mostafanafie.tourguide.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    // Initialize the ArrayList
    private ArrayList<Attraction> mAttractionsList;

    // Constructor
    public RecyclerViewAdapter(ArrayList<Attraction> attractionsList) {
        this.mAttractionsList = attractionsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Bind the attractions to the view holder
        Attraction attraction = mAttractionsList.get(position);
        holder.nameTextView.setText(attraction.getName());
        holder.descriptionTextView.setText(attraction.getDescription());
        holder.imageView.setImageResource(attraction.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return mAttractionsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // Initialize the views of the list item
        ConstraintLayout parentLayout;
        ImageView imageView;
        TextView nameTextView;
        TextView descriptionTextView;

        // Constructor
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.textView_name);
            descriptionTextView = itemView.findViewById(R.id.textView_description);
        }
    }


}
