package com.lab5gridview;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity{
	Integer []anh=new Integer[]{R.drawable.chomchom,R.drawable.nhomy,R.drawable.camtuoi,R.drawable.chomchom};
	GridView gv;
	ArrayList<HoaQua> array;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Init();
	}

	public void Init() {
		array = new ArrayList<HoaQua>();
		array.add(new HoaQua("chom chom", "1900d", "300 luot thich"));
		array.add(new HoaQua("Nho my", "1500d", "200 luot thich"));
		array.add(new HoaQua("cam tuoi", "1700d", "100 luot thich"));
		array.add(new HoaQua("chom chom", "1900d", "300 luot thich"));
		
		gv= (GridView) findViewById(R.id.gv);
		//MyAdapter adapter=new MyAdapter(this, 0, 0, array);
		MyAdapter adapter=new MyAdapter(this, 0);
		gv.setAdapter(adapter);
		
	}
	public class MyAdapter extends ArrayAdapter<HoaQua>{

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
			View view= inflater.inflate(R.layout.item_gridview,parent,false);
			TextView tvtenhoaqua= (TextView) view.findViewById(R.id.tvtenqua);
			TextView tvgiahoaqua=(TextView) view.findViewById(R.id.tvgiaqua);
			TextView tvluotlike=(TextView) view.findViewById(R.id.tvluotlike);
			ImageView imhoaqua= (ImageView) view.findViewById(R.id.img);
			ImageView imglike=(ImageView) view.findViewById(R.id.imglike);
			ImageView imshare=(ImageView) view.findViewById(R.id.imgshare);
			
			
			tvtenhoaqua.setText(array.get(position).tenhoaqua);
			tvgiahoaqua.setText(array.get(position).giahoaqua);
			tvluotlike.setText(array.get(position).luotlike);
			imhoaqua.setImageResource(anh[position]);
			imglike.setImageResource(R.drawable.like);
			imshare.setImageResource(R.drawable.share);
			
			return view;
		}
	}

}
