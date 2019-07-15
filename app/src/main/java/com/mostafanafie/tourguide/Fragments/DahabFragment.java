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

public class DahabFragment extends Fragment {

    // Initialize the ArrayList
    private ArrayList<Attraction> mAttractionsList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attractions, container, false);

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
        String[] names = getResources().getStringArray(R.array.dahab_names);
        String[] descriptions = getResources().getStringArray(R.array.dahab_descriptions);
        TypedArray images = getResources().obtainTypedArray(R.array.dahab_images);

        for (int i = 0; i < names.length; i++) {
            mAttractionsList.add(new Attraction(names[i], descriptions[i], images.getResourceId(i, 0)));
        }
    }

    private void setupRecyclerView(View view) {
        // Initialize the recycler view
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        // Initialize the adapter, and pass the ArrayList to it
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mAttractionsList);
        // Attach the adapter to the recycler view
        recyclerView.setAdapter(adapter);
        // Attach the layout manager to the recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
