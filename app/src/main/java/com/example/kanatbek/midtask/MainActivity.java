package com.example.kanatbek.midtask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kanatbek.midtask.activities.CurrencyDetailed;

public class MainActivity extends AppCompatActivity {

    private Button usdBtn;
    private Button eurBtn;
    private Button gbpBtn;
    private Button rubBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usdBtn = findViewById(R.id.usd_btn);
        eurBtn = findViewById(R.id.eur_btn);
        gbpBtn = findViewById(R.id.gbp_btn);
        rubBtn = findViewById(R.id.rub_btn);

        final Intent i = new Intent(this, CurrencyDetailed.class);

        usdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("currency", "USD");
                startActivity(i);
            }
        });

        eurBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("currency", "EUR");
                startActivity(i);
            }
        });

        gbpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("currency", "GBP");
                startActivity(i);
            }
        });

        rubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i.putExtra("currency", "RUB");
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
//        do nothing
    }
}
