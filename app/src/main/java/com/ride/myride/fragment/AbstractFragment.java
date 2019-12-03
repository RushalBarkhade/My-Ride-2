package com.ride.myride.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ride.myride.AbstractActivity;
import com.ride.myride.R;
import com.ride.myride.firebase.RideDetails;
import com.ride.myride.recycle_views.RideRecycle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractFragment extends Fragment implements View.OnClickListener {

    AbstractActivity activity;
    ProgressDialog progressDialog;
    private String userType;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (AbstractActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(),container,false);
    }

     protected abstract int getFragmentLayout();

     RecyclerView setRecycleView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.ride_details_recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading Data");
        progressDialog.show();
        return recyclerView;
    }

     void setEmptyTextView(View view) {
        TextView view1 = view.findViewById(R.id.no_found_text_view);
        view1.setVisibility(View.VISIBLE);
        RecyclerView recyclerView = view.findViewById(R.id.ride_details_recycle_view);
        recyclerView.setVisibility(View.GONE);
    }

     void setLayout(final View view, String rideType){
        activity.getFirebase().getRiderList().orderByChild("rideType").equalTo(rideType).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                if (dataSnapshot.getChildrenCount()>0) {
                    activity.service.execute(new Runnable() {
                        @Override
                        public void run() {
                            final List<RideDetails> rideDetails = new ArrayList<>();
                            for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                                RideDetails details = snapshot.getValue(RideDetails.class);
                                rideDetails.add(details);
                                Log.v("TAG",String.valueOf(rideDetails.size()));
                            }
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    RideRecycle recycle = new RideRecycle(rideDetails);
                                    RecyclerView recycleView = setRecycleView(view);
                                    recycleView.setAdapter(recycle);
                                    progressDialog.dismiss();
                                }
                            });
                        }
                    });
                }
                else
                    setEmptyTextView(view);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.v("TAG",databaseError.toString());
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.make_ride) {
            activity.loadFragment(new LoginRegisterFragment(), R.id.frameLayout);
            userType="make_ride";
        }
        if (v.getId()==R.id.book_ride) {
            activity.loadFragment(new LoginRegisterFragment(), R.id.frameLayout);
            userType="book_ride";
        }
        if (v.getId()==R.id.login) {
            activity.loadFragment(new LoginFragment(), R.id.frameLayout);
        }
        if (v.getId()==R.id.register) {
            activity.loadFragment(new RegisterFragment(), R.id.frameLayout);
        }
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
