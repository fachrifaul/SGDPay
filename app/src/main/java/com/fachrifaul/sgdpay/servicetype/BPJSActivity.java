package com.fachrifaul.sgdpay.servicetype;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.fachrifaul.sgdpay.R;

public class BPJSActivity extends AppCompatActivity {

    private AppCompatEditText customerNumberEditText;
    private Button nextButton;

    public static Intent getStartIntent(Context context, String titleScreen) {
        Intent intent = new Intent(context, BPJSActivity.class);
        intent.putExtra("titleScreen", titleScreen);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpjs);

        String titleScreen = getIntent().getStringExtra("titleScreen");

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(titleScreen);

        customerNumberEditText = (AppCompatEditText) findViewById(R.id.customerNumberEditText);
        nextButton = (Button) findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                productChoice();
            }

        });
    }

    @Override public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
    
    private void productChoice() {
        new MaterialDialog.Builder(this)
                .title("Pilih Produk")
                .items(R.array.bpjs_values)
                .itemsCallbackSingleChoice(0, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        String message = "Anda akan membayar BPJS no " +  customerNumberEditText.getText().toString() +
                                " selama " + text +
                                " sebesar Rp. 123.000 Jika Benar masukan PIN anda.";
                        dialogPin(message);
                        return true;
                    }
                })
                .positiveText("Pilih")
                .positiveColorRes(R.color.colorPrimary)
                .show();
    }

    private void dialogPin(String message) {
        new MaterialDialog.Builder(this)
                .title("Konfirmasi Transaksi")
                .content(message)
                .inputType(InputType.TYPE_CLASS_NUMBER)
                .inputRange(6,6)
                .input("Pin Anda", null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        Toast.makeText(dialog.getContext(), "Transaksi telah berhasil.", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .positiveText("Kirim")
                .positiveColorRes(R.color.colorPrimary)
                .negativeText("Batal")
                .negativeColorRes(R.color.colorPrimary)
                .show();
    }
}
