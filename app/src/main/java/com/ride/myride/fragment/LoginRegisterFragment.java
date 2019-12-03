package com.ride.myride.fragment;

import android.view.View;
import android.widget.Button;

import com.ride.myride.R;

public class LoginRegisterFragment extends AbstractFragment {


    public LoginRegisterFragment(){}

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        Button login = view.findViewById(R.id.login);
        Button register = view.findViewById(R.id.register);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.login_register_fragment;
    }
}
