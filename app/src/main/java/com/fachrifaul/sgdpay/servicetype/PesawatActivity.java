package com.fachrifaul.sgdpay.servicetype;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.fachrifaul.sgdpay.R;

public class PesawatActivity extends AppCompatActivity {

    public static Intent getStartIntent(Context context, String titleScreen) {
        Intent intent = new Intent(context, PesawatActivity.class);
        intent.putExtra("titleScreen", titleScreen);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesawat);

        String titleScreen = getIntent().getStringExtra("titleScreen");

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(titleScreen);
    }

    @Override public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
