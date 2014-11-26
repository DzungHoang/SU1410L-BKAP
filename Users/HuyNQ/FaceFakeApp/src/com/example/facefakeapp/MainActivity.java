package com.example.facefakeapp;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	ImageButton btnLogin, btnQuestion;
	EditText txtUser, txtPass;
	TextView lblSignUp, lblLog;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_login);
        
        //find elements
        btnLogin = (ImageButton)findViewById(R.id.btnLogin);
        btnQuestion = (ImageButton)findViewById(R.id.btnQuestion);
        
        txtUser = (EditText)findViewById(R.id.txtEmail);
        txtPass = (EditText)findViewById(R.id.txtPassword);
        
        lblSignUp = (TextView)findViewById(R.id.lblSignUp);

        //draw underline for lblSignUp
        lblSignUp.setPaintFlags(lblSignUp.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        
        lblLog = (TextView)findViewById(R.id.lblLog);
        
        //add event click for button login
        btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				lblLog.setText("user: "+txtUser.getText()+", pass: "+txtPass.getText());
			}
		});
        
        //add event click for button question
        btnQuestion.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				lblLog.setText("Navigating to help page...");
			}
		});
        
        //add event click for signup link
        lblSignUp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				lblLog.setText("Directing to signup page...");
			}
		});
    }

}
