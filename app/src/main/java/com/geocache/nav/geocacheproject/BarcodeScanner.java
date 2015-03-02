package com.geocache.nav.geocacheproject;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Giedrius on 2015.02.28.
 */
public class BarcodeScanner extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanner_scan);
    }
}