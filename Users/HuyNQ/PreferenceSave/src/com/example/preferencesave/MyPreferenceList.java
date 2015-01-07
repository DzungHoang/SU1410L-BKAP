package com.example.preferencesave;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.widget.Toast;

public class MyPreferenceList extends ListPreference implements OnClickListener{

    private int mClickedDialogEntryIndex;

    public MyPreferenceList(Context context, AttributeSet attrs) {
        super(context, attrs);


    }

    public MyPreferenceList(Context context) {
        this(context, null);
    }

    private int getValueIndex() {
        return findIndexOfValue(this.getValue() +"");
    }


    @Override
    protected void onPrepareDialogBuilder(Builder builder) {
        super.onPrepareDialogBuilder(builder);

        mClickedDialogEntryIndex = getValueIndex();
        builder.setSingleChoiceItems(this.getEntries(), mClickedDialogEntryIndex, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                mClickedDialogEntryIndex = which;

            }
        });

        System.out.println(getEntry() + " " + this.getEntries()[0]);
        builder.setPositiveButton("OK", this);
    }

    public  void onClick (DialogInterface dialog, int which)
    {
    	if(which == DialogInterface.BUTTON_POSITIVE){
    		this.setValue(this.getEntryValues()[mClickedDialogEntryIndex]+""); 
    		Toast.makeText(getContext(), "fuck clicked", Toast.LENGTH_SHORT).show();
    	}
    	else if(which == DialogInterface.BUTTON_NEGATIVE){
    		
    	}

    }
    

}
