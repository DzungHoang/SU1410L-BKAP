package com.example.day14listviewhw;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
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
        dataImage.add(new ImageItem("Blood Seeker",1500,R.drawable.blood_seeker,1200,false));
        dataImage.add(new ImageItem("Alechemist",2000,R.drawable.alchemist,800,false));
        dataImage.add(new ImageItem("Queen of Pain",1800,R.drawable.queen,5000,true));
        dataImage.add(new ImageItem("Shadow Demon",300,R.drawable.shadow_demon,2000,false));
        
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
    		
    		//must set to final, so we can use this object in OnClick function
    		final ImageButton btnLike = (ImageButton)view.findViewById(R.id.btnLike);
    		
    		//depend on the status of isLike, in dataImage.get(position), we will decide the image of the btnLike
    		boolean isLike = dataImage.get(position).GetIsLike();
    		if(isLike){
    			btnLike.setImageResource(R.drawable.heart_selected);
    		}
    		else{
    			btnLike.setImageResource(R.drawable.heart);
    		}
    		
    		//must use final, so we can use position inside onClick() function
    		final int pos = position;
    		
    		//add click listener for button like
    		btnLike.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//check like status if its true, we set false and vice versa
					boolean value = dataImage.get(pos).GetIsLike();
					value = !value;
					dataImage.get(pos).SetIsLike(value);
					
					//update btnLike again
					
					if(value==true){

						btnLike.setImageResource(R.drawable.heart_selected);
					}
					else{
						btnLike.setImageResource(R.drawable.heart);
					}
	
				}
			});
    		
    		return view;
    		
    				
    	}
    	

    }
}
