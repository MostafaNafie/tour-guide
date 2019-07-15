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

import butterknife.BindView;
import butterknife.ButterKnife;

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
        @BindView(R.id.parent_layout) ConstraintLayout parentLayout;
        @BindView(R.id.imageView) ImageView imageView;
        @BindView(R.id.textView_name) TextView nameTextView;
        @BindView(R.id.textView_description) TextView descriptionTextView;

        // Constructor
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize ButterKnife
            ButterKnife.bind(this, itemView);
        }
    }


}
