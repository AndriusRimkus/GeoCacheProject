package com.geocache.nav.geocacheproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    private Button registerButton;
    private RegisterFragmentInterface registerInterface;


    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_register, container, false);
        registerButton = (Button) v.findViewById(R.id.register_btn);
        registerButton.setOnClickListener(registerInterface.registerButtonClicked());

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            registerInterface = (RegisterFragmentInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement RegisterFragmentInterface");
        }
    }

    public static interface RegisterFragmentInterface {
        public View.OnClickListener registerButtonClicked();
    }

}
