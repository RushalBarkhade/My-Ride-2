package com.ride.myride;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.ride.myride.fragment.PersonalInfoFragment;
import com.ride.myride.fragment.ProfessionalInfoFragment;
import com.ride.myride.utils.ViewPagerAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.View;

public class UserInfoActivity extends AbstractActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.htab_viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        tabLayout.setupWithViewPager(viewPager);

        adapter.addFragments(new PersonalInfoFragment(),"Personal");
        adapter.addFragments(new ProfessionalInfoFragment(),"Professional");
        viewPager.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.activity_user_info;
    }

    @Override
    public void getValues(Object values, char flag) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void getPlace(String place) {

    }
}
