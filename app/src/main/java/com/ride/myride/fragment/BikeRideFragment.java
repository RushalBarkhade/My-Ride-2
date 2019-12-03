package com.ride.myride.fragment;

import android.view.View;

import com.ride.myride.R;

public class BikeRideFragment extends AbstractFragment {

    public BikeRideFragment(){}

    @Override
    protected int getFragmentLayout() {
        return R.layout.ride_fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        final View view = getView();
      setLayout(view,"bike");
    }
}
