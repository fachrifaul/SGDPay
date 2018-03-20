package com.fachrifaul.sgdpay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.fachrifaul.sgdpay.model.ServiceType;
import com.fachrifaul.sgdpay.servicetype.BPJSActivity;
import com.fachrifaul.sgdpay.servicetype.DataActivity;
import com.fachrifaul.sgdpay.servicetype.KeretaActivity;
import com.fachrifaul.sgdpay.servicetype.PLNActivity;
import com.fachrifaul.sgdpay.servicetype.PesawatActivity;
import com.fachrifaul.sgdpay.servicetype.PulsaActivity;
import com.fachrifaul.sgdpay.servicetype.TVInternetActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    private final String serviceNames[] = {
            "Data",
            "Pulsa & PascaBayar",
            "Token & Tagihan PLN",
            "BPJS",
            "PDAM",
            "TV & Internet",
            "Telkom",
            "Multifinance",
            "Voucher Game",
            "Kereta Api",
            "Tiket Pesawat"
    };

    @DrawableRes
    private final int serviceImgages[] = {
            R.drawable.ic_menu_home_data,
            R.drawable.ic_menu_home_pulsapaskabayar,
            R.drawable.ic_menu_home_pln,
            R.drawable.ic_menu_home_bpjs,
            R.drawable.ic_menu_home_pdam,
            R.drawable.ic_menu_home_tvinternet,
            R.drawable.ic_menu_home_telkom,
            R.drawable.ic_menu_home_multifinance,
            R.drawable.ic_menu_home_vouchergames,
            R.drawable.product_kai_icon,
            R.drawable.product_pesawat_icon
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<ServiceType> serviceTypes = prepareData();
        DataAdapter adapter = new DataAdapter(serviceTypes);
        recyclerView.setAdapter(adapter);

        adapter.setClickListener(new DataAdapter.OnItemClickListener() {
            @Override public void onClick(View view, int position) {
                Log.d("#POSITION", "IS " + position);
                if (position == 0) {
                    startActivity(DataActivity.getStartIntent(view.getContext(), serviceNames[position]));
                } else if (position == 1) {
                    startActivity(PulsaActivity.getStartIntent(view.getContext(), serviceNames[position]));
                } else if (position == 2) {
                    startActivity(PLNActivity.getStartIntent(view.getContext(), serviceNames[position]));
                } else if (position == 3) {
                    startActivity(BPJSActivity.getStartIntent(view.getContext(), serviceNames[position]));
                } else if (position == 4) {
                    //PDAM
                } else if (position == 5) {
                    startActivity(TVInternetActivity.getStartIntent(view.getContext(), serviceNames[position]));
                } else if (position == 6) {
                    //Telkom
                } else if (position == 7) {
                    //Multifinance
                } else if (position == 8) {
                    //Voucher Game
                } else if (position == 9) {
                    startActivity(KeretaActivity.getStartIntent(view.getContext(), serviceNames[position]));
                } else if (position == 10) {
                    startActivity(PesawatActivity.getStartIntent(view.getContext(), serviceNames[position]));
                }
            }
        });

    }

    private ArrayList<ServiceType> prepareData() {

        ArrayList<ServiceType> android_version = new ArrayList<>();
        for (int i = 0; i < serviceNames.length; i++) {
            ServiceType serviceType = new ServiceType();
            serviceType.setServiceName(serviceNames[i]);
            serviceType.setServiceImage(ContextCompat.getDrawable(this, serviceImgages[i]));
            android_version.add(serviceType);
        }
        return android_version;
    }
}
