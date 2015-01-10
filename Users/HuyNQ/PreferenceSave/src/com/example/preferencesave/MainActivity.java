package com.example.preferencesave;

import java.util.ArrayList;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends PreferenceActivity {
	
	final Context context = this;
	Dialog dialog;
	
	ListView mListView;
	ArrayList<Object> mData;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main); 
        
        addPreferencesFromResource(R.xml.pref_data_config);  
        
        //create dialog
		dialog= new Dialog(context);
		
		//set view for dialog
		dialog.setContentView(R.layout.custom_dialog);
		dialog.setTitle("Open source license");
		
		//find listivew in dialog
		mListView = (ListView)dialog.findViewById(R.id.listView1);
		
		//populate data for listview
		mData = new ArrayList<Object>();
		mData.add(new LisenceDialogCat("Notices for files"));
		mData.add(new LisenceDialogItem("prto-micro.jar", "It might be (my suggestion) that when you're defining style, you're not giving as parent default CheckBox style. Therefore, in some Android/Device you're missing property that defined in that parent.Alternatively (as this exception causes problems with CheckBox itself) try to move it to your apk (widget.CheckBox.java).That's a bad thing that Android Market doesn't allow you to check android version that causes crash. Have you tried to run emulator with Android 1.5 to check this?"));
		mData.add(new LisenceDialogItem("jmonkeyengine.jar", "It might be (my suggestion) that when you're defining style, you're not giving as parent default CheckBox style. Therefore, in some Android/Device you're missing property that defined in that parent.Alternatively (as this exception causes problems with CheckBox itself) try to move it to your apk (widget.CheckBox.java).That's a bad thing that Android Market doesn't allow you to check android version that causes crash. Have you tried to run emulator with Android 1.5 to check this?"));
		mData.add(new LisenceDialogItem("gson.jar", "It might be (my suggestion) that when you're defining style, you're not giving as parent default CheckBox style. Therefore, in some Android/Device you're missing property that defined in that parent.Alternatively (as this exception causes problems with CheckBox itself) try to move it to your apk (widget.CheckBox.java).That's a bad thing that Android Market doesn't allow you to check android version that causes crash. Have you tried to run emulator with Android 1.5 to check this?"));
		mData.add(new LisenceDialogItem("keyczar-071f-060112.jar", "It might be (my suggestion) that when you're defining style, you're not giving as parent default CheckBox style. Therefore, in some Android/Device you're missing property that defined in that parent.Alternatively (as this exception causes problems with CheckBox itself) try to move it to your apk (widget.CheckBox.java).That's a bad thing that Android Market doesn't allow you to check android version that causes crash. Have you tried to run emulator with Android 1.5 to check this?"));
        
		MyAdapter adapter = new MyAdapter(getApplicationContext(), 0);
		
		mListView.setAdapter(adapter);
		
        //find licensesDialog
        Preference licensePref = (Preference)findPreference("licensePref");
        licensePref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			
			@Override
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				
				//show dialog
				dialog.show();
				
				return true;
			}
		});
        
        //tham khao them cai nay de lam custom dialog: http://examples.javacodegeeks.com/android/core/ui/dialog/android-custom-dialog-example/
    }
    
    @Override
    public void onBackPressed() {
    	// TODO Auto-generated method stub
    	//super.onBackPressed();
    	dialog.dismiss();
    }
    
    public class MyAdapter extends ArrayAdapter<Object>{
    	public MyAdapter(Context context, int resource){
    		super(context, resource);
    	}
    	
    	@Override
    	public int getCount() {
    		// TODO Auto-generated method stub
    		return mData.size();
    	}
    	
    	@Override
    	public View getView(int position, View convertView, ViewGroup parent) {
    		LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    		
    		// TODO Auto-generated method stub
    		Object item = mData.get(position);
    		ViewHolderCat holderCat = new ViewHolderCat();
    		ViewHolderItem holderItem = new ViewHolderItem();
    		
    		boolean isCreateNew = true;
    		
    		if(convertView==null){
    			isCreateNew = true;
    		}
    		else{
	    		if(item instanceof LisenceDialogCat && convertView.getTag() instanceof ViewHolderCat){
	    			isCreateNew = false;
	    		}
	    		
	    		if(item instanceof LisenceDialogItem && convertView.getTag() instanceof ViewHolderItem){
	    			isCreateNew = false;
	    		}
    		}
    		
    		if(isCreateNew){
				if(item instanceof LisenceDialogCat){
    				TextView txtCat = new TextView(getApplicationContext());
    				convertView = txtCat;
    				
    				holderCat = new ViewHolderCat();
    				holderCat.txtCat = txtCat;
    				
    				convertView.setTag(holderCat);
    			}
    			else if (item instanceof LisenceDialogItem){
    				convertView = inflater.inflate(R.layout.item_list_dialog, parent, false);
    				
    				holderItem = new ViewHolderItem();
    				
    				holderItem.txtContent = (TextView)convertView.findViewById(R.id.txtItemContent);
    				holderItem.txtTitle = (TextView)convertView.findViewById(R.id.txtItemTitle);
    				
    				convertView.setTag(holderItem);
    			}
    			
    		}
    		else{
    			if(item instanceof LisenceDialogCat){
    				holderCat = (ViewHolderCat)convertView.getTag();
    			}
    			else if (item instanceof LisenceDialogItem){
    				holderItem = (ViewHolderItem)convertView.getTag();
    			}
    		}
    		
    		if(item instanceof LisenceDialogCat){
    			holderCat.txtCat.setText(((LisenceDialogCat)item).catName);
			}
			else if (item instanceof LisenceDialogItem){
				holderItem.txtContent.setText(((LisenceDialogItem)item).content);
				holderItem.txtTitle.setText(((LisenceDialogItem)item).title);
			}
    		
    		return convertView;
    	}
    }
    
    private class ViewHolderItem{
    	TextView txtTitle;
    	TextView txtContent;
    }
    
    private class ViewHolderCat{
    	TextView txtCat;
    }
}
