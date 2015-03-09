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
import android.widget.Toast;

public class LoginFragment extends Fragment {
    private Button regLoginBtn;
    private LoginFragmentInterface loginInterface;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        regLoginBtn = (Button) v.findViewById(R.id.login_reg);
        regLoginBtn.setOnClickListener(loginInterface.loginRegisterButtonClicked());

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            loginInterface = (LoginFragmentInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement LoginFragmentInterface");
        }
    }

    public static interface LoginFragmentInterface {
        public View.OnClickListener loginButtonClicked();
        public View.OnClickListener loginRegisterButtonClicked();
    }
}
