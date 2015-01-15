package com.example.day22sqlite;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button btnNavListView;
	
	ListView listView;
	
	ArrayList<PhoneModel> mData;
	
	DBController mDBController;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        listView = (ListView)findViewById(R.id.listViewPhone);
        btnNavListView = (Button)findViewById(R.id.btnNavAddFromListView);
        btnNavListView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), AddActivity.class);
			    startActivity(intent);
			}
		});
        

        
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {

            	Intent myIntent = new Intent(getApplicationContext(), EditActivity.class);
				myIntent.putExtra("phoneName",mData.get(position).phoneName);
				myIntent.putExtra("quantity",mData.get(position).quantity+"");
				startActivity(myIntent);
            }
	  });
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	mDBController = new DBController(getApplicationContext());
    	
    	Cursor cursor = mDBController.query(null, null,null,null,null,null);
    	
    	mData = new ArrayList<PhoneModel>();
    	
    	if(cursor !=null && cursor.moveToFirst()){
    		do{
    			String name = cursor.getString(cursor.getColumnIndex(DBController.NAME_COL));
    			int quantity = cursor.getInt(cursor.getColumnIndex(DBController.QUANTITY_COL));
    			
    			PhoneModel phone = new PhoneModel(name, quantity);
    			
    			mData.add(phone);
    			
    		}while (cursor.moveToNext());
    	}
    	
    	MyAdapter adapter = new MyAdapter(getApplicationContext(), 0);
    	listView.setAdapter(adapter);
    	
    	super.onResume();
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
    		// TODO Auto-generated method stub
    		LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    		ViewHolder holder;
    		
    		if(convertView==null){
    			convertView = inflater.inflate(R.layout.layout_item_list_phone, parent,false);
    			holder = new ViewHolder();
    			holder.txtName = (TextView)convertView.findViewById(R.id.txtListPhoneName);
    			holder.txtQuantity = (TextView)convertView.findViewById(R.id.txtListQuantity);
    			
    			convertView.setTag(holder);
    		}
    		else{
    			holder = (ViewHolder)convertView.getTag();
    		}
    		
    		holder.txtName.setText(mData.get(position).phoneName);
    		holder.txtQuantity.setText(mData.get(position).quantity+"");
    		
    		return convertView;
    	}
    }
    
    private class ViewHolder{
    	TextView txtName;
    	TextView txtQuantity;
    }
    
    
}
