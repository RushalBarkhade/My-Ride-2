package com.ride.myride.fragment;

import android.view.View;
import android.widget.EditText;
import com.ride.myride.R;

public class PersonalInfoFragment extends AbstractFragment {

    public PersonalInfoFragment(){}

    @Override
    protected int getFragmentLayout() {
        return R.layout.personal_info;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        EditText firstname = view.findViewById(R.id.firstname);
        EditText lastname = view.findViewById(R.id.lastname);
        EditText email = view.findViewById(R.id.email);
        EditText password = view.findViewById(R.id.password);
    }
}
