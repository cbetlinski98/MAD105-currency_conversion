package com.example.cbetl.currencyconversion;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double conversionRate = 1.28;
    double currencyEntered = 0.0;
    double convertedCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText currency = (EditText) findViewById(R.id.txtCurrency);
        final RadioButton gbpToUsd = (RadioButton) findViewById(R.id.radGBPtoUSD);
        final RadioButton usdToGbp = (RadioButton) findViewById(R.id.radUSDtoGBP);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        final Button convert = (Button) findViewById(R.id.btnConvert);


        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currencyEntered = Double.parseDouble(currency.getText().toString());
                DecimalFormat dollars = new DecimalFormat("##.##");
                if (gbpToUsd.isChecked()) {
                    if (currencyEntered <= 78) {
                        convertedCurrency = currencyEntered * conversionRate;
                        result.setText(dollars.format(convertedCurrency) + " dollars");

                    } else {
                        Toast.makeText(MainActivity.this, "Pounds must be less than 78", Toast.LENGTH_LONG).show();

                    }
                }
                if (usdToGbp.isChecked()) {
                    if (currencyEntered <= 100) {
                        convertedCurrency = currencyEntered / conversionRate;
                        result.setText(dollars.format(convertedCurrency) + " pounds");

                    } else {
                        Toast.makeText(MainActivity.this, "Dollars must be less than 100", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
    }}