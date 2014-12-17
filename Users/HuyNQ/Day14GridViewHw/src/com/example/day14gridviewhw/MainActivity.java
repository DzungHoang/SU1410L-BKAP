package com.example.day14gridviewhw;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	ArrayList<Hero> heroesData; 
	GridView gridView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        heroesData = new ArrayList<Hero>();
        heroesData.add(new Hero("Centaur",1900,300,R.drawable.centaur_warrunner,false));
        heroesData.add(new Hero("Alchemist",2000,200,R.drawable.alchemist,false));
        heroesData.add(new Hero("Blood Seeker",2200,180,R.drawable.blood_seeker,true));
        heroesData.add(new Hero("Queen of Pain",3000,500,R.drawable.queen_of_pain,false));
        heroesData.add(new Hero("Shadow Demon",2400,200,R.drawable.shadow_demon,false));
        heroesData.add(new Hero("Bounty Hunter",2800,400,R.drawable.bounty_hunter,false));
        heroesData.add(new Hero("Centaur2",3000,200,R.drawable.centaur_warrunner,true));
        heroesData.add(new Hero("Alchemist2",4000,300,R.drawable.alchemist,false));
        heroesData.add(new Hero("Blood Seeker2",4200,280,R.drawable.blood_seeker,false));
        heroesData.add(new Hero("Queen of Pain2",5000,300,R.drawable.queen_of_pain,false));
        heroesData.add(new Hero("Shadow Demon2",6400,400,R.drawable.shadow_demon,true));
        heroesData.add(new Hero("Bounty Hunter2",4800,100,R.drawable.bounty_hunter,false));
        
        gridView = (GridView)findViewById(R.id.gridView1);
        
        MyAdapter adapter = new MyAdapter(this, 0);
        gridView.setAdapter(adapter);
    }
    
    public class MyAdapter extends ArrayAdapter<String>{
    	public MyAdapter(Context context, int resource){
    		super(context, resource);
    	}
    	
    	@Override
    	public int getCount() {
    		// TODO Auto-generated method stub
    		return heroesData.size();
    	}
    	
    	@Override
    	public View getView(int position, View convertView, ViewGroup parent) {
    		// TODO Auto-generated method stub
    		LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    		
    		View view = inflater.inflate(R.layout.list_item_view,parent, false);
    		
    		TextView txtName = (TextView)view.findViewById(R.id.txtName);
    		TextView txtPrice = (TextView)view.findViewById(R.id.txtPrice);
    		TextView txtLike = (TextView)view.findViewById(R.id.txtLike);
    		
    		txtName.setText(heroesData.get(position).GetName());
    		txtPrice.setText(heroesData.get(position).GetPrice()+" d");
    		txtLike.setText(heroesData.get(position).GetLike()+" luot thich");
    		
    		ImageView imgView = (ImageView)view.findViewById(R.id.imgView);
    		imgView.setImageResource(heroesData.get(position).GetPathIndex());
    		
    		final ImageButton btnLike = (ImageButton)view.findViewById(R.id.btnLike);
    		boolean isLike = heroesData.get(position).GetIsLike();
    		
    		if(isLike){
    			btnLike.setImageResource(R.drawable.heart_selected);
    		}
    		else{
    			btnLike.setImageResource(R.drawable.heart);
    		}
    		
    		final int pos = position;
    		
    		//add event click for btnlike
    		btnLike.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//modify property isLike of object in hereoesData
					boolean value = heroesData.get(pos).GetIsLike();
					value = !value;
					heroesData.get(pos).isLike = value;
					
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
