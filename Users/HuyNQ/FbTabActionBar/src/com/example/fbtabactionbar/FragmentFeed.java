package com.example.fbtabactionbar;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentFeed extends Fragment{
	
	ArrayList<Object> mData;
	ListView mListView;
	
	private FragmentFeed(){
		
	}
	
	public static FragmentFeed newInstance(){
		return new FragmentFeed();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_feed, container,false);
		
		//populate data
		mData = new ArrayList<Object>();
		mData.add(new FeedItemMain("King Leonidas", "8 hours ago", "this is SPARTA!!! this is madness too!!!", R.drawable.profile, R.drawable.this_is_sparta, 1000, 900));
		mData.add(new FeedItemMain("Homer Simpson", "12 hours ago", "a kitty and a dog are playing together, close friendship", R.drawable.homer, R.drawable.kitty, 200, 500));
		mData.add(new FeedItemMain("Beavis", "1 day ago", "boring boring need help!", R.drawable.beavis, 0, 200, 500));
		mData.add(new FeedItemMain("Beavis", "1 day ago", "a kitty and a dog are playing together, close friendship", R.drawable.beavis, R.drawable.gator, 200, 500));
		mData.add(new FeedItemMain("King Leonidas", "2 days ago", "first battle, 1000 kills", R.drawable.profile, 0, 1000, 900));
		mData.add(new FeedItemMain("Butthead", "3 days ago", "a kitty and a dog are playing together, close friendship", R.drawable.butthead, R.drawable.rabbit, 200, 500));
		mData.add(new FeedItemMain("Homer Simpson", "4 days ago", "a kitty and a dog are playing together, close friendship", R.drawable.homer, R.drawable.frog, 200, 500));
		
		mListView = (ListView)view.findViewById(R.id.lstFeeds);
		
		MyAdapter adapter = new MyAdapter(getActivity().getApplicationContext(),0);
		mListView.setAdapter(adapter);
		
		return view;
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
			Object item = mData.get(position);
			ViewHolder holder;
			
			LayoutInflater inflater = (LayoutInflater)getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
			
			if(item instanceof FeedItemMain){
				FeedItemMain feed = (FeedItemMain)item;
				
				if(convertView!=null){
					holder = (ViewHolder)convertView.getTag();
				}
				
				else{
					convertView = inflater.inflate(R.layout.layout_feed_item, parent,false);
					
					holder = new ViewHolder();
					holder.txtName = (TextView)convertView.findViewById(R.id.txtFeedTitle);
					holder.txtTime = (TextView)convertView.findViewById(R.id.txtFeedTime);
					holder.txtContent = (TextView)convertView.findViewById(R.id.txtFeedContent);
					holder.imgProfileIndex = (ImageView)convertView.findViewById(R.id.imgFeedTitle);
					holder.imgContentIndex = (ImageView)convertView.findViewById(R.id.imgFeedContent);
					holder.txtLike = (TextView)convertView.findViewById(R.id.txtFeedLike);
					holder.txtComment = (TextView)convertView.findViewById(R.id.txtFeedComment);
					
					convertView.setTag(holder);
				}
				
				holder.txtName.setText(feed.name);
				holder.txtTime.setText(feed.time);
				holder.txtContent.setText(feed.content);
				holder.imgProfileIndex.setImageResource(feed.imgProfileIndex);
				
				Log.d("huynq","img index is: "+feed.imgContentIndex);
				if(feed.imgContentIndex!=0){
					holder.imgContentIndex.setImageResource(feed.imgContentIndex);
					holder.imgContentIndex.setVisibility(View.VISIBLE);
				}
				else{
					holder.imgContentIndex.setImageResource(0);
					holder.imgContentIndex.setVisibility(View.GONE);
				}
				
				holder.txtLike.setText(feed.countLike+" likes");
				holder.txtComment.setText(feed.countComment+" comments");		
				
			}
			return convertView;
		}
		
	}//end class
	
	private class ViewHolder{
		TextView txtName;
		TextView txtTime;
		TextView txtContent;
		ImageView imgProfileIndex;
		ImageView imgContentIndex;
		TextView txtLike;
		TextView txtComment;
	}
}
