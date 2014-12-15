package com.example.day14listviewhw;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	ArrayList<ImageItem> dataImage;
	ListView lstView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //pouplate data for dataImage
        dataImage = new ArrayList<ImageItem>();
        dataImage.add(new ImageItem("Blood Seeker",1500,R.drawable.blood_seeker,1200));
        dataImage.add(new ImageItem("Alechemist",2000,R.drawable.alchemist,800));
        dataImage.add(new ImageItem("Queen of Pain",1800,R.drawable.queen,5000));
        dataImage.add(new ImageItem("Shadow Demon",300,R.drawable.shadow_demon,2000));
        
        ListView lstView = (ListView)findViewById(R.id.listView1);
        
        //set adapter for list view
        MyAdapter adapter = new MyAdapter(this, 0);
        lstView.setAdapter(adapter);
    }
    
    public class MyAdapter extends ArrayAdapter<String>{
    	public MyAdapter(Context context, int resource) {
			// TODO Auto-generated constructor stub
    		super(context, resource);
		}
    	
    	@Override
    	public int getCount() {
    		// TODO Auto-generated method stub
    		return dataImage.size();
    	}
    	
    	@Override
    	public View getView(int position, View convertView, ViewGroup parent) {
    		// TODO Auto-generated method stub
LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    		
    		View view = inflater.inflate(R.layout.item_list_view, parent, false);
    		
    		TextView txtName = (TextView)view.findViewById(R.id.txtName);
    		TextView txtPrice = (TextView)view.findViewById(R.id.txtPrice);
    		TextView txtLike = (TextView)view.findViewById(R.id.txtLike);
    		
    		ImageView imgView = (ImageView)view.findViewById(R.id.imgView);
    		
    		txtName.setText(dataImage.get(position).GetName());
    		txtPrice.setText(dataImage.get(position).GetPrice()+" d");
    		txtLike.setText(dataImage.get(position).GetLikeCount()+" luot thich");
    		
    		imgView.setImageResource(dataImage.get(position).GetIndexPath());
    		
    		return view;
    		
    				
    	}
    	

    }
}
