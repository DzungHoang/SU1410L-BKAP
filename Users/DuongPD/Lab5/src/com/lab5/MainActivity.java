package com.lab5;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {
	ListView lv;
	ArrayList<CongViec> array;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Init();

	}

	public void Init() {
		array = new ArrayList<CongViec>();
		array.add(new CongViec("chụp ảnh cưới", "0/4 công việc đã hoàn thành"));
		array.add(new CongViec("mua nhẫn cưới", "0/3 công việc đã hoàn thành"));
		array.add(new CongViec("thuê dịch vụ cưới hỏi",
				"0/3 công việc đã hoàn thành"));
		array.add(new CongViec("thuê xe cưới", "0/3 công việc đã hoàn thành"));
		array.add(new CongViec("đặt nhà hàng tiệc cưới",
				"0/4 công việc đã hoàn thành"));
		array.add(new CongViec("làm thiệp cưới", "0/5 công việc đã hoàn thành"));
		array.add(new CongViec("mua giường tủ", "0/4 công việc đã hoàn thành"));

		lv = (ListView) findViewById(R.id.lv);
		// MyAdapter adapter=new MyAdapter(this, 0, 0, array);
		MyAdapter adapter = new MyAdapter(this, 0);
		lv.setAdapter(adapter);

	}

	public class MyAdapter extends ArrayAdapter<CongViec> {

		// public MyAdapter(Context context, int resource, int
		// textViewResourceId,
		// List<CongViec> objects) {
		// super(context, resource, textViewResourceId, objects);
		// // TODO Auto-generated constructor stub
		// }
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
			Log.d("abc", " " + position);
			LayoutInflater inflater = (LayoutInflater) getApplicationContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View view = inflater.inflate(R.layout.item_listview, parent, false);
			TextView tvtencongviec = (TextView) view
					.findViewById(R.id.tvtencongviec);
			TextView tvcongviec = (TextView) view.findViewById(R.id.tvcongviec);
			ImageView img = (ImageView) view.findViewById(R.id.img);
			
			
			tvtencongviec.setText(array.get(position).TenCongViec);
			tvcongviec.setText(array.get(position).CongViec);
			img.setImageResource(R.drawable.icon);
			return view;
		}

	}

}
