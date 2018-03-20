package com.fachrifaul.sgdpay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by fachrifebrian on 1/4/18.
 */

public class MainEmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startActivity(LoginActivity.getStartIntent(this));
        finish();
    }
}
