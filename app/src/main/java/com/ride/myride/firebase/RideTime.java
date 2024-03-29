package com.ride.myride.firebase;

public class RideTime {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int min;
    private boolean ampm;

    public RideTime(int year, int month, int day, int hour, int min, boolean ampm) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.min = min;
        this.ampm = ampm;
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

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public boolean isAmpm() {
        return ampm;
    }

    public void setAmpm(boolean ampm) {
        this.ampm = ampm;
    }

    public RideTime() {
    }

}
