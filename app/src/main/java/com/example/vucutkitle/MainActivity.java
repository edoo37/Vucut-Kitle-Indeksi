package com.example.vucutkitle;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {

    double height, weight, result, idealWeight;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(MainActivity.this,"ca-app-pub-1688280870930124~8546572575");

        AdView mAdview = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        final SeekBar heightSeekBar = (SeekBar) findViewById(R.id.heightSeekBar);
        SeekBar weightSeekBar = (SeekBar) findViewById(R.id.weightSeekBar);
        final TextView heightTextView = (TextView) findViewById(R.id.heightTextView);
        final TextView weightTextView = (TextView) findViewById(R.id.weightTextView);
        final TextView bmiResult = (TextView) findViewById(R.id.bmiTextView);
        Button nextButton = (Button) findViewById(R.id.buttonNext);


        heightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


                height = seekBar.getProgress();
                heightTextView.setText(String.valueOf(height) + "cm");
                idealWeight = Math.round((50 + 2.3 * ((height / 2.54) - 60)));
                bmiResult.setText(String.valueOf(calculate(height, weight)));


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                height = seekBar.getProgress();
                heightTextView.setText(String.valueOf(height) + "cm");
                idealWeight = Math.round((50 + 2.3 * ((height / 2.54) - 60)));
                bmiResult.setText(String.valueOf(calculate(height, weight)));


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


                height = seekBar.getProgress();
                heightTextView.setText(String.valueOf(height) + "cm");
                idealWeight = Math.round((50 + 2.3 * ((height / 2.54) - 60)));
                bmiResult.setText(String.valueOf(calculate(height, weight)));


            }
        });

        weightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                weight = seekBar.getProgress();
                weightTextView.setText(String.valueOf(weight) + "kg");
                bmiResult.setText(String.valueOf(calculate(height, weight)));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                weight = seekBar.getProgress();
                weightTextView.setText(String.valueOf(weight) + "kg");
                bmiResult.setText(String.valueOf(calculate(height, weight)));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                weight = seekBar.getProgress();
                weightTextView.setText(String.valueOf(weight) + "kg");
                bmiResult.setText(String.valueOf(calculate(height, weight)));
            }
        });


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (weight > 0 && height >= 110) {


                    Intent intent = new Intent(MainActivity.this, SonucGoster.class);
                    intent.putExtra("result", result);
                    intent.putExtra("idealWeight", idealWeight);
                    startActivity(intent);

                } else {

                    Toast.makeText(MainActivity.this, "Boy değeriniz 110 cm'den büyük olmalıdır.", Toast.LENGTH_LONG).show();
                }


            }
        });

    }


    private double calculate(double height, double weight) {


        if (height < 110) {
        } else {
            result = Math.round(weight / (height * height / 100 / 100));
        }


        return result;


    }


}


