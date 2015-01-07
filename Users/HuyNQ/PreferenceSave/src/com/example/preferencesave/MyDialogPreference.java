package com.example.preferencesave;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;

public class MyDialogPreference extends DialogPreference{

	public MyDialogPreference(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected View onCreateDialogView() {
		// TODO Auto-generated method stub
		return super.onCreateDialogView();
	}
	
	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		super.onClick(dialog, which);
	}
	
}
