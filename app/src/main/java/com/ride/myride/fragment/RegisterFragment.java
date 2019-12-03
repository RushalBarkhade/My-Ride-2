package com.ride.myride.fragment;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Handler;
import androidx.annotation.NonNull;

import com.ride.myride.R;
import com.ride.myride.SelectorActivity;

public class RegisterFragment extends AbstractFragment {
    public interface Listener {
        public String onSomeEvent();
    }
    private Listener listener;
    private EditText dob;
    private SelectorActivity activity;

    public RegisterFragment(){}

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity= (SelectorActivity) context;
        listener = (Listener) context;

    }

    @Override
    public void onStart() {
        super.onStart();
        View view=getView();
        EditText firstName = view.findViewById(R.id.firstname);
        EditText lastName = view.findViewById(R.id.lastname);
        dob = view.findViewById(R.id.dob);
        EditText email = view.findViewById(R.id.email);
        EditText phone = view.findViewById(R.id.phone_number);
        EditText city = view.findViewById(R.id.city);
        EditText password = view.findViewById(R.id.password);
        dob.setOnClickListener(this);
        dob.setText(listener.onSomeEvent());

    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.layout_register;
    }

    @Override
    public void onClick(final View v) {
        super.onClick(v);
        if (v.getId()==R.id.dob){
            activity.setData(v.getId());
            Log.v("TAG",String.valueOf(activity.getMonth()));
        }
    }
}
