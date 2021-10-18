package com.gasmpgmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    TextView tvAvgTotalPrice, tvAvgPricePerGallon, tvAvgTotalGallons;
    List<String> gasTotalPrice, gasTotalGallons, gasPerGallon;
    AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        calculate();

    }

    public void calculate() {

        tvAvgPricePerGallon = findViewById(R.id.textviewPricePerGallon);
        tvAvgTotalPrice = findViewById(R.id.textviewAvgTotalPrice);
        tvAvgTotalGallons = findViewById(R.id.textViewAvgTotalGallons);

        DecimalFormat decimalFormat = new DecimalFormat("#.000");

        double avgTotalPrice = 0;
        double avgTotalGallons = 0;
        double avgPerGallon = 0;

        database = AppDatabase.getDBInstance(this);
        gasTotalPrice = database.getGasDao().getAllTotalPrice();
        gasTotalGallons = database.getGasDao().getAllTotalGallons();
        gasPerGallon = database.getGasDao().getAllPricePerGallon();

        for (int i = 0; i < gasTotalPrice.size(); i++ ) {
            avgTotalPrice += Double.parseDouble(gasTotalPrice.get(i));
        }
        avgTotalPrice = avgTotalPrice / gasTotalPrice.size();
        String tp = decimalFormat.format(avgTotalPrice) +  "";
        tvAvgTotalPrice.setText(tp);

//        Total Gallons
        for (int i = 0; i < gasTotalGallons.size(); i++ ) {
            avgTotalGallons += Double.parseDouble(gasTotalGallons.get(i));
        }
        avgTotalGallons = avgTotalGallons / gasTotalGallons.size();
        String tg = decimalFormat.format(avgTotalGallons) + "";
        tvAvgTotalGallons.setText(tg);

//        Per Gallon
        for (int i = 0; i < gasPerGallon.size(); i++ ) {
            avgPerGallon += Double.parseDouble(gasPerGallon.get(i));
        }
        avgPerGallon = avgPerGallon / gasPerGallon.size();
        String pg = decimalFormat.format(avgPerGallon) + "";
        tvAvgPricePerGallon.setText(pg);
    }
}