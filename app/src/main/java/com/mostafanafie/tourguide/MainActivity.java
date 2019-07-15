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

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    // Initialize the ViewPager
    @BindView(R.id.container) ViewPager mViewPager;
    // Initialize the TabLayout
    @BindView(R.id.sliding_tabs) TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        // Initialize ButterKnife
        ButterKnife.bind(this);

        // Setup the ViewPager
        setupViewPager(mViewPager);
        // Attach the ViewPager to the TabLayout
        mTabLayout.setupWithViewPager(mViewPager);
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
