package com.lab5listview;

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

public class MainActivity extends Activity{
	Integer anh[]=new Integer[]{R.drawable.hoangduy,R.drawable.thaomy};
	ListView lv;
	ArrayList<Anh> array;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Init();
	}
	public void Init() {
		array = new ArrayList<Anh>();
		array.add(new Anh("set combo 1", "1900d", "300 luot thich"));
		array.add(new Anh("Set combo 2", "1500d", "200 luot thich"));

		
		lv= (ListView) findViewById(R.id.lv);
		//MyAdapter adapter=new MyAdapter(this, 0, 0, array);
		MyAdapter adapter=new MyAdapter(this, 0);
		lv.setAdapter(adapter);
		
	}
	public class MyAdapter extends ArrayAdapter<Anh>{

//		public MyAdapter(Context context, int resource, int textViewResourceId,
//				ArrayList<HoaQua> objects) {
//			super(context, resource, textViewResourceId, objects);
//		}
		public MyAdapter(Context context, int resource) {
			super(context, resource);
			// TODO Auto-generated constructor stub
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return array.size();
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			LayoutInflater inflater = (LayoutInflater) getApplicationContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View view= inflater.inflate(R.layout.item_listview,parent,false);
			TextView tvten= (TextView) view.findViewById(R.id.tvten);
			TextView tvgia=(TextView) view.findViewById(R.id.tvgia);
			TextView tvluotlike=(TextView) view.findViewById(R.id.tvluotlike);
			ImageView imhoaqua= (ImageView) view.findViewById(R.id.img);
			ImageView imglike=(ImageView) view.findViewById(R.id.imglike);
			ImageView imshare=(ImageView) view.findViewById(R.id.imgshare);
			
			
			tvten.setText(array.get(position).ten);
			tvgia.setText(array.get(position).gia);
			tvluotlike.setText(array.get(position).like);
			imhoaqua.setImageResource(anh[position]);
			imglike.setImageResource(R.drawable.like);
			imshare.setImageResource(R.drawable.share);
			
			return view;
		}
	}

}
