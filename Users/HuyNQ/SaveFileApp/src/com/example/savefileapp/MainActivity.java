package com.example.savefileapp;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button btnSave;
	EditText txtFileName;
	EditText txtContent;
	Spinner spinnerFiles;
	
	ArrayList<String> lstFileName;
	
	int selectedIndex=0;
	int totalFile = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Log.d("huynq", "data path: "+FileUtils.DataPath);
        
        txtFileName = (EditText)findViewById(R.id.txtFileName);
        txtContent = (EditText)findViewById(R.id.txtContent);     
        
        //find spinner;
        spinnerFiles = (Spinner)findViewById(R.id.spinnerFiles);
        BindSpinnerData();
        
        btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String fileName =txtFileName.getText().toString().trim(); 
				if(fileName!=""){
					if(FileUtils.createFile(FileUtils.DataPath, fileName, txtContent.getText().toString())){
						Toast.makeText(getApplicationContext(), "create file successful",Toast.LENGTH_SHORT	).show();
						BindSpinnerData();  
					}
					else{
						Toast.makeText(getApplicationContext(), "create file failed",Toast.LENGTH_SHORT	).show();
					}
				}
			}
		});
          
        spinnerFiles.setOnItemSelectedListener(new OnItemSelectedListener() {
        	@Override
        	public void onItemSelected(AdapterView<?> parent, View view,
        			int position, long id) {
        		// TODO Auto-generated method stub
        		String fileName = (String)spinnerFiles.getItemAtPosition(position);
        		
        		txtFileName.setText(fileName);
        		
        		txtContent.setText(FileUtils.readFile(FileUtils.DataPath, fileName));
        		
        		selectedIndex = position;
        	}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			} 
		});
    }
    
    private void BindSpinnerData(){
    	//get list of files in folder
        lstFileName = new ArrayList<String>();
        lstFileName = FileUtils.ListFileInFolder(FileUtils.DataPath);
        
        if(lstFileName!=null){
	        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,lstFileName);
	        
	        spinnerFiles.setAdapter(adapter);
        }
        
        if(lstFileName.size()>totalFile){
        	totalFile = lstFileName.size();
        	selectedIndex = totalFile-1;
        }

        spinnerFiles.setSelection(selectedIndex, true);
        
        
    }
}
