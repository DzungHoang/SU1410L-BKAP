package com.example.day22sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends Activity {
	Button btnListView, btnSave;
	EditText txtQuantity;
	TextView txtPhoneName;
	DBController mDBController;
	
	int mID;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);
		
		btnListView = (Button)findViewById(R.id.btnNavListFromEdit);
		btnSave = (Button)findViewById(R.id.btnSave);
		txtQuantity = (EditText)findViewById(R.id.txtEditQuantity);
		txtPhoneName = (TextView)findViewById(R.id.txtEditPhoneName);
		
		Bundle bundle = getIntent().getExtras();
		String name = bundle.getString(DBController.NAME_COL);
		int quantity = Integer.valueOf(bundle.getString(DBController.QUANTITY_COL));
		mID = Integer.valueOf(bundle.getString(DBController.ID_COL));
		
//		Toast.makeText(getApplicationContext(), "so luong la: "+quantity, Toast.LENGTH_SHORT).show();
		
		txtPhoneName.setText(name);
		txtQuantity.setText(quantity+"");
		
		btnListView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
			    startActivity(intent);
			}
		});
		
		btnSave.setOnClickListener(new OnClickListener() {  
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
					
					int quantity = Integer.parseInt(txtQuantity.getText().toString());
					ContentValues values = new ContentValues();
					values.put(DBController.QUANTITY_COL, quantity);
					
					mDBController.update(values, DBController.ID_COL +" = ?", new String[]{mID+""});
					
					Toast.makeText(getApplicationContext(), "Da cap nhat xong", Toast.LENGTH_SHORT).show();
					
					Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				    startActivity(intent);
					 
				} 
				catch(NumberFormatException ex){
					Toast.makeText(getApplicationContext(), "Ko phai dang so", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		mDBController = new DBController(getApplicationContext());
		super.onResume();
	}
}
