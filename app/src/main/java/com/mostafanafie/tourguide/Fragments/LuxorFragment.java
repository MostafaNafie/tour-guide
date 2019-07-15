package com.mostafanafie.tourguide.Fragments;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mostafanafie.tourguide.Attraction;
import com.mostafanafie.tourguide.R;
import com.mostafanafie.tourguide.Adapters.RecyclerViewAdapter;

import java.util.ArrayList;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LuxorFragment extends Fragment {

    // Initialize the ArrayList
    private ArrayList<Attraction> mAttractionsList = new ArrayList<>();
    // Initialize the recycler view
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    // Initialize city data
    @BindArray(R.array.luxor_names) String[] names;
    @BindArray(R.array.luxor_descriptions) String[] descriptions;
    @BindArray(R.array.luxor_images) TypedArray images;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attractions, container, false);

        // Initialize ButterKnife
        ButterKnife.bind(this,view);

        // Check if this is not the first time to load the fragment
        // To avoid duplicate items in the ArrayList
        if (savedInstanceState == null) {
            // Setup the ArrayList
            setupArrayList();
        }
        // Setup the recycler view
        setupRecyclerView(view);

        return view;
    }

    private void setupArrayList() {
        // Populate the ArrayList with attractions
        for (int i = 0; i < names.length; i++) {
            mAttractionsList.add(new Attraction(names[i], descriptions[i], images.getResourceId(i, 0)));
        }
    }

    private void setupRecyclerView(View view) {
        // Initialize the adapter, and pass the ArrayList to it
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mAttractionsList);
        // Attach the adapter to the recycler view
        recyclerView.setAdapter(adapter);
        // Attach the layout manager to the recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
