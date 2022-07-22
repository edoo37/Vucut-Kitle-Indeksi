package com.example.vucutkitle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SonucGoster extends AppCompatActivity {


    double result, idealWeight;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc_goster);


        Intent intent = getIntent();

        result = intent.getDoubleExtra("result", 0);
        idealWeight = intent.getDoubleExtra("idealWeight", 1);




        showStatus(result);
    }

    private void showStatus(double result) {

        this.result = result;
        TextView showResult = (TextView) findViewById(R.id.detailsTextView);
        TextView showVKI = (TextView) findViewById(R.id.showVKI);
        TextView showIdealWeight = (TextView) findViewById(R.id.showIdealWeight);
       //Toolbar
        Toolbar dToolbar = (Toolbar)findViewById(R.id.displayToolbar);
        setSupportActionBar(dToolbar);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);

        if (result < 18.5) {

            showVKI.setText(String.valueOf(result));
            showResult.setText(R.string.underWeightDetails);
            showIdealWeight.setText(String.valueOf(idealWeight));


        } else if (result >= 18.5 && result < 25) {

            showVKI.setText(String.valueOf(result));
            showResult.setText(R.string.normalWeightDetails);
            showIdealWeight.setText(String.valueOf(idealWeight));

        } else if (result >= 25 && result >= 30) {
            showVKI.setText(String.valueOf(result));
            showResult.setText(R.string.overWeightDetails);
            showIdealWeight.setText(String.valueOf(idealWeight));

        }

    }
}
