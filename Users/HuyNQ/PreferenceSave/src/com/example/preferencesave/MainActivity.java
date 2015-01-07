package com.example.preferencesave;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;

public class MainActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        
        addPreferencesFromResource(R.xml.pref_data_config);  
        
        //find licensesDialog
//        Preference licensePref = (Preference)findPreference("licensePref");
//        licensePref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
//			
//			@Override
//			public boolean onPreferenceClick(Preference preference) {
//				// TODO Auto-generated method stub
//				//MyDialogPreference dialog = new MyDialogPreference(getApplicationContext(), null);
//				
//				return true;
//			}
//		});
        
        //tham khao them cai nay de lam custom dialog: http://examples.javacodegeeks.com/android/core/ui/dialog/android-custom-dialog-example/
    }
}
