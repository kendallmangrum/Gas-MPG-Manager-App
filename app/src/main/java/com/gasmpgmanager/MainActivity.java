package com.gasmpgmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submitBttn;
    EditText etStationName, etDate, etPricePerGallon, etTotalPrice, etTotalGallons, etMPG;
    AppDatabase database;
    GasDao gasDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupElements();
        setupDatabase();
    }

    public void setupElements() {
        submitBttn = findViewById(R.id.submitBttn);
        etStationName = findViewById(R.id.etStationName);
        etDate = findViewById(R.id.etDate);
        etPricePerGallon = findViewById(R.id.etPricePerGallon);
        etTotalPrice = findViewById(R.id.etTotalPrice);
        etTotalGallons = findViewById(R.id.etTotalGallons);
        etMPG = findViewById(R.id.etMPG);

    }

    public void setupDatabase() {
        database = Room.databaseBuilder(MainActivity.this, AppDatabase.class, "gas").allowMainThreadQueries().build();
        gasDao = database.getGasDao();
    }

    public void submitData(View view) {
        Gas gas = new Gas();
        gas.setStationName(etStationName.getText().toString());
        gas.setDate(etDate.getText().toString());
        gas.setPricePerGallon(etPricePerGallon.getText().toString());
        gas.setTotalPrice(etTotalPrice.getText().toString());
        gas.setTotalGallons(etTotalGallons.getText().toString());
        gas.setMpg(etMPG.getText().toString());

        etStationName.setText("");
        etDate.setText("");
        etPricePerGallon.setText("");
        etTotalPrice.setText("");
        etTotalGallons.setText("");
        etMPG.setText("");

        gasDao.insert(gas);
        Toast.makeText(this, "Data added", Toast.LENGTH_SHORT).show();
    }

    public void viewHistory(View view) {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }

    public void viewAverages(View view) {
        startActivity(new Intent(MainActivity.this, ThirdActivity.class));
    }
}