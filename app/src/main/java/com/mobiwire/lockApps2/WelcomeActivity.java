package com.mobiwire.lockApps2;

import android.content.Intent;
import android.os.Bundle;


/*
user interface
 */
public class WelcomeActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        PrefUtils.setKioskModeActive(true, getApplicationContext()); // set Lock mode : ON
        startService(new Intent(this, KioskService.class));          // start service
                                                                     // turn in background (monitors application)
    }
}
