package com.example.recorderapp;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Typeface tfHand = Typeface.createFromAsset(getAssets(), "fonts/segoesc.ttf");
        
        TextView txtVoice = (TextView)findViewById(R.id.txtVoice);
        txtVoice.setTypeface(tfHand);
    }
}
