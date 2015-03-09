package com.geocache.nav.geocacheproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity implements RegisterFragment.RegisterFragmentInterface,
        LoginFragment.LoginFragmentInterface {
    // Views
    Fragment registerFragment;
    Fragment loginFragment;

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
        if (id == R.id.Karolio) {
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (!registerFragment.isDetached()) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
            ft.detach(registerFragment);
            ft.attach(loginFragment);
            ft.commit();
        }
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

    @Override
    public View.OnClickListener registerButtonClicked() {
        return null;
    }

    @Override
    public View.OnClickListener loginButtonClicked() {
        return null;
    }

    @Override
    public View.OnClickListener loginRegisterButtonClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
                ft.detach(loginFragment);
                ft.attach(registerFragment);
                ft.commit();
            }
        };
    }
}