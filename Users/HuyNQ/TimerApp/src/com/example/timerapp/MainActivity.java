package com.example.timerapp;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //set font for txtAlarm
        TextView txtAlarm = (TextView)findViewById(R.id.txtAlarm);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/segoesc.ttf");
        txtAlarm.setTypeface(tf);
        
        //set font for txtWorldClock
        TextView txtClock = (TextView)findViewById(R.id.txtClock);
        txtClock.setTypeface(tf);
        
        //set font for txtWorldClock
        TextView txtWatch = (TextView)findViewById(R.id.txtWatch);
        txtWatch.setTypeface(tf);
        
        //set font for txtWorldClock
        TextView txtTimer = (TextView)findViewById(R.id.txtTimer);
        txtTimer.setTypeface(tf);
        
        //set font for txtZeroBig
        TextView txtZeroBig = (TextView)findViewById(R.id.txtZeroBig);
        Typeface tfDigital = Typeface.createFromAsset(getAssets(), "fonts/digital_italic.ttf");
        txtZeroBig.setTypeface(tfDigital);
        
        //set font for txtZeroSmall
        TextView txtZeroSmall= (TextView)findViewById(R.id.txtZeroSmall);
        txtZeroSmall.setTypeface(tfDigital);
        
        //set font for txtInstruction
        TextView txtInstruction = (TextView)findViewById(R.id.txtInstruction);
        txtInstruction.setTypeface(tf);
    }
}
