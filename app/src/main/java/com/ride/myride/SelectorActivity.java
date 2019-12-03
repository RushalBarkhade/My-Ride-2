package com.ride.myride;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.ride.myride.fragment.RegisterFragment;
import com.ride.myride.fragment.SelectorFragment;
import android.util.Log;

public class SelectorActivity extends AlterFunctionActivity implements RegisterFragment.Listener {
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadFragment(new SelectorFragment(),R.id.frameLayout);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_selector;
    }

    @Override
    public void getValues(Object values, char flag) {

    }

    @Override
    protected Context getActivity() {
        return this;
    }

    @Override
    protected void setData(int id, int year, int month, int dayOfMonth) {
        setDay(dayOfMonth);
        setMonth(month+1);
        setYear(year);
    }

    @Override
    protected void setTime(int id, int hour, int min) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void getPlace(String place) {

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String onSomeEvent() {
        String date  = getDay() +"/"+
                getMonth() +"/"+
                getYear();
        return date;
    }
}
