package com.ride.myride.fragment;

import android.view.View;
import android.widget.Button;

import com.ride.myride.R;

public class SelectorFragment extends AbstractFragment {

    public SelectorFragment(){}

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        Button makeRide = view.findViewById(R.id.make_ride);
        Button bookRide = view.findViewById(R.id.book_ride);
        makeRide.setOnClickListener(this);
        bookRide.setOnClickListener(this);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_selector;
    }
}
