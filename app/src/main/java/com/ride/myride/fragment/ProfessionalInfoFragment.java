package com.ride.myride.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.ride.myride.R;

public class ProfessionalInfoFragment extends AbstractFragment {

    public ProfessionalInfoFragment(){}

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        EditText drivingLicence = view.findViewById(R.id.driving_licence);
        TextView verification = view.findViewById(R.id.verificarion_id);
        EditText city = view.findViewById(R.id.city);
        EditText numberPlate = view.findViewById(R.id.number_plate);
        
        drivingLicence.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    System.out.println(s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //getActivity().finish();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.professional_info;
    }
}
