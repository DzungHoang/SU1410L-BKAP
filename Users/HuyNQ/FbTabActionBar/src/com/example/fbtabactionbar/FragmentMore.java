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

public class FragmentMore extends Fragment{
	ArrayList<Object> mData;
	ListView mListView;
	
	private FragmentMore(){
		
	}
	
	public static FragmentMore newInstance(){
		FragmentMore fm = new FragmentMore();
		return fm;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View view = inflater.inflate(R.layout.fragment_more, container,false);
		
		//find list view
		mListView = (ListView)view.findViewById(R.id.listMore);
		
		//populate data
		mData = new ArrayList<Object>();
		mData.add(new MoreItemProfile(R.drawable.profile, "Huy Nguyen", "View your profile",6));
		
		mData.add(new MoreItemCat("Favorites"));
		mData.add(new MoreItemNormal(R.drawable.circle1,"Nearby Places",0));
		mData.add(new MoreItemNormal(R.drawable.circle2,"Events",2));
		mData.add(new MoreItemNormal(R.drawable.circle3,"Friends",0));
		
		mData.add(new MoreItemCat("Groups"));
		mData.add(new MoreItemNormal(R.drawable.circle1,"Create Group",0));
		mData.add(new MoreItemNormal(R.drawable.circle2,"SU1410L-BKAP",21));
		mData.add(new MoreItemNormal(R.drawable.circle3,"A2 CVA",0));
		
		mData.add(new MoreItemCat("Apps"));
		mData.add(new MoreItemNormal(R.drawable.circle1,"Games",0));
		mData.add(new MoreItemNormal(R.drawable.circle2,"Chat",2));
		mData.add(new MoreItemNormal(R.drawable.circle3,"Like Pages",1));
		mData.add(new MoreItemNormal(R.drawable.circle4,"Find Friends",14));
		mData.add(new MoreItemNormal(R.drawable.circle3,"Fresh Meat",0));
		
		MyAdapter adapter = new MyAdapter(getActivity().getApplicationContext(), 0);
		mListView.setAdapter(adapter);
		
		Toast.makeText(getActivity().getApplicationContext(),"hell no", Toast.LENGTH_SHORT).show();
		
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
			LayoutInflater inflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			ViewHolderProfile holderProfile;
			ViewHolderNormal holderNormal;
			ViewHolderCat holderCat;
			
			Object item = mData.get(position);
			
			boolean isCreateNew = false;
			
			if(convertView==null){
				isCreateNew = true;
			}
			else{
				if(item instanceof MoreItemCat && convertView.getTag() instanceof ViewHolderCat){
					isCreateNew = false;
				}
				
				if(item instanceof MoreItemNormal && convertView.getTag() instanceof ViewHolderNormal){
					isCreateNew = false;
				}
				
				if(item instanceof MoreItemProfile && convertView.getTag() instanceof ViewHolderCat){
					isCreateNew = false;
				}
			}
			
			if(isCreateNew){
				if(item instanceof MoreItemCat){
					convertView = inflater.inflate(R.layout.layout_more_category, parent, false);
					holderCat = new ViewHolderCat();
					holderCat.txtCat = (TextView) convertView.findViewById(R.id.txtMoreCat);
					
					convertView.setTag(holderCat);
					
					holderCat.txtCat.setText(((MoreItemCat)item).catName);
				}
				else if(item instanceof MoreItemProfile){
					convertView = inflater.inflate(R.layout.layout_more_item_profile, parent, false);
					holderProfile = new ViewHolderProfile();
					holderProfile.txtContentBig = (TextView)convertView.findViewById(R.id.txtMoreName);
					holderProfile.txtContentSmall = (TextView)convertView.findViewById(R.id.txtProfile);
					holderProfile.imgView = (ImageView)convertView.findViewById(R.id.imgMoreProfile);
					holderProfile.txtCount = (TextView)convertView.findViewById(R.id.txtMoreCountProfile);
					
					convertView.setTag(holderProfile);
					
					holderProfile.txtContentBig.setText(((MoreItemProfile)item).contentBig);
					holderProfile.txtContentSmall.setText(((MoreItemProfile)item).contentSmall);
					holderProfile.imgView.setImageResource(((MoreItemProfile)item).imgPath);
					holderProfile.txtCount.setText(Integer.toString(((MoreItemProfile)item).count));
				}
				else if(item instanceof MoreItemNormal){
					convertView = inflater.inflate(R.layout.layout_more_item_normal, parent, false);
					holderNormal = new ViewHolderNormal();
					
					holderNormal.txtContent = (TextView)convertView.findViewById(R.id.txtMoreContent);
					holderNormal.txtCount = (TextView)convertView.findViewById(R.id.txtMoreCount);
					holderNormal.imgView = (ImageView)convertView.findViewById(R.id.imgMoreIcon);
					
					convertView.setTag(holderNormal);
					
					holderNormal.txtContent.setText(((MoreItemNormal)item).content);
					holderNormal.txtCount.setText(Integer.toString(((MoreItemNormal)item).count));
					
					//Log.d("huynq","path la: "+((MoreItemNormal)item).imgPath);
					
					holderNormal.imgView.setImageResource(((MoreItemNormal)item).imgPath);
				}
			}
			else{
				if(item instanceof MoreItemCat){
					holderCat = (ViewHolderCat)convertView.getTag();
					
					holderCat.txtCat.setText(((MoreItemCat)item).catName);
				}
				
				else if(item instanceof MoreItemProfile){
					holderProfile = (ViewHolderProfile)convertView.getTag();
					
					holderProfile.txtContentBig.setText(((MoreItemProfile)item).contentBig);
					holderProfile.txtContentSmall.setText(((MoreItemProfile)item).contentSmall);
					holderProfile.imgView.setImageResource(((MoreItemProfile)item).imgPath);
					holderProfile.txtCount.setText(Integer.toString(((MoreItemProfile)item).count));
				}
				
				else if(item instanceof MoreItemNormal){
					holderNormal = (ViewHolderNormal)convertView.getTag();
					
					holderNormal.txtContent.setText(((MoreItemNormal)item).content);
					holderNormal.txtCount.setText(Integer.toString(((MoreItemNormal)item).count));
					holderNormal.imgView.setImageResource(((MoreItemNormal)item).imgPath);
				}
			}
			return convertView;
		}
		
		
	}//end class
	
	private class ViewHolderProfile{
		ImageView imgView;
		TextView txtContentBig;
		TextView txtContentSmall;
		TextView txtCount;
	}
	
	private class ViewHolderNormal{
		ImageView imgView;
		TextView txtContent;
		TextView txtCount;
	}
	
	private class ViewHolderCat{
		TextView txtCat;
	}
}