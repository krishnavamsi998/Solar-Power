package com.example.solarpower;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton mSolarRadioButton,mBatteryRadioButton,mGridRadioButton;
    RadioGroup mRadioButtonGroup;

    Button mChangeModeButton;

    private String[] mRadioButtonTitles = {"Solar mode","Battery mode","Grid mode"};
    private int mCheckedRadioButton = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSolarRadioButton = (RadioButton)findViewById(R.id.solar_radio_button);
        mBatteryRadioButton = (RadioButton)findViewById(R.id.battery_radio_button);
        mGridRadioButton  = (RadioButton)findViewById(R.id.grid_radio_button);

        mRadioButtonGroup = (RadioGroup)findViewById(R.id.radio_buttons_group);
        mRadioButtonGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == mSolarRadioButton.getId())
                    mCheckedRadioButton = 0;
                if(i == mBatteryRadioButton.getId())
                    mCheckedRadioButton = 1;
                if(i == mGridRadioButton.getId())
                    mCheckedRadioButton = 2;

                Toast.makeText(MainActivity.this,mRadioButtonTitles[mCheckedRadioButton]+" selected",Toast.LENGTH_LONG).show();

            }
        });

        mChangeModeButton = (Button)findViewById(R.id.change_mode_button);
        mChangeModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"Changed to " +mRadioButtonTitles[mCheckedRadioButton],Toast.LENGTH_LONG).show();
            }
        });


    }
}