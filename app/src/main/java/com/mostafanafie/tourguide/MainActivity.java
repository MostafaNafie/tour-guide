package com.mostafanafie.tourguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.mostafanafie.tourguide.Adapters.CitiesStatePagerAdapter;
import com.mostafanafie.tourguide.Fragments.AswanFragment;
import com.mostafanafie.tourguide.Fragments.CairoFragment;
import com.mostafanafie.tourguide.Fragments.DahabFragment;
import com.mostafanafie.tourguide.Fragments.LuxorFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        // Initialize the ViewPager
        ViewPager mViewPager = findViewById(R.id.container);
        // Setup the ViewPager
        setupViewPager(mViewPager);
        // Attach the ViewPager to the TabLayout
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        // Initialize the FragmentStatePagerAdapter
        CitiesStatePagerAdapter adapter = new CitiesStatePagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        // Add the Fragments to the adapter
        adapter.addFragment(new CairoFragment(), getResources().getString(R.string.cairo));
        adapter.addFragment(new LuxorFragment(), getResources().getString(R.string.luxor));
        adapter.addFragment(new DahabFragment(), getResources().getString(R.string.dahab));
        adapter.addFragment(new AswanFragment(), getResources().getString(R.string.aswan));
        // Attach the adapter to the ViewPager
        viewPager.setAdapter(adapter);
    }
}
