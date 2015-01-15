package com.example.day22sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends Activity {

	EditText txtName;
	EditText txtQuantity;
	Button btnAdd, btnNavListView;
	
	DBController mDBController;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		
		txtName=(EditText)findViewById(R.id.txtAddPhoneName);
		txtQuantity=(EditText)findViewById(R.id.txtAddQuantity);
		btnAdd=(Button)findViewById(R.id.btnAddPhone);
		btnNavListView = (Button)findViewById(R.id.btnNavListView);
		
		btnAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(txtName.getText().toString().trim().length()==0|| txtQuantity.getText().toString().trim().length()==0){
					Toast.makeText(getApplicationContext(), "Hay nhap dien thoai", Toast.LENGTH_SHORT).show();
				}
				else{
					String name = txtName.getText().toString();
					int quantity = Integer.valueOf(txtQuantity.getText().toString());
					
					ContentValues values = new ContentValues();
					values.put(DBController.NAME_COL, name);
					values.put(DBController.QUANTITY_COL, quantity);
					
					mDBController.insert(values);
					
					Toast.makeText(getApplicationContext(), "Them moi thanh cong", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		btnNavListView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
			    startActivity(intent);
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
