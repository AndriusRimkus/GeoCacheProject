package com.geocache.nav.geocacheproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    protected OnBackPressedListener onBackPressedListener;
    Fragment registerFragment, loginFragment;

    public Fragment getRegisterFragment() {
        return registerFragment;
    }

    public Fragment getLoginFragment() {
        return loginFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        if (savedInstanceState == null) {
            registerFragment = new RegisterFragment();
            loginFragment = new LoginFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            ft.add(R.id.fragmentContainer, registerFragment);
            ft.detach(registerFragment);
            ft.add(R.id.fragmentContainer, loginFragment);
            ft.commit();
        }
        else {
            loginFragment = getSupportFragmentManager().getFragment(savedInstanceState, "loginFragment");
            registerFragment = getSupportFragmentManager().getFragment(savedInstanceState, "registerFragment");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.giedriaus) {
            Intent intent = new Intent(this, BarcodeScanner.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
        this.onBackPressedListener = onBackPressedListener;
    }

    @Override
    public void onBackPressed() {
        if (onBackPressedListener != null)
            onBackPressedListener.doBack();
        else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "loginFragment", loginFragment);
        getSupportFragmentManager().putFragment(outState, "registerFragment", registerFragment);
    }
}
