package com.example.gmailfake;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentLeftPanel extends Fragment{
	ArrayList<Object> mData;
	ListView mListView;
	
	private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

    /**
     * Per the design guidelines, you should show the drawer on launch until the user manually
     * expands it. This shared preference tracks this.
     */
    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

    /**
     * A pointer to the current callbacks instance (the Activity).
     */
    private NavigationDrawerCallbacks mCallbacks;

    /**
     * Helper component that ties the action bar to the navigation drawer.
     */
    private ActionBarDrawerToggle mDrawerToggle;

    private DrawerLayout mDrawerLayout;
    private View mFragmentContainerView;

    private int mCurrentSelectedPosition = 0;
    private boolean mFromSavedInstanceState;
    private boolean mUserLearnedDrawer;
	
	public FragmentLeftPanel(){
		
	}
	
	public static FragmentLeftPanel newInstance(){
		return new FragmentLeftPanel();
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_left_panel,container,false);
		
		//populate data
		mData = new ArrayList<Object>();
		mData.add(new ItemEmail("huynq.omg@gmail.com", 123));
		mData.add(new ItemEmail("battlefield@gmail.com", 20));
		mData.add(new ItemEmail("payday@gmail.com", 12));
		
		mData.add(new ItemCat("Inbox"));
		mData.add(new ItemNormal(R.drawable.ic_action_email,"Primary",245,"#ffffff"));
		mData.add(new ItemNormal(R.drawable.ic_action_group, "Social", 123, "#4982F2"));
		mData.add(new ItemNormal(R.drawable.ic_action_labels, "Promotions", 44, "#16A763"));
		
		mData.add(new ItemCat("All labels"));	
		mData.add(new ItemNormal(R.drawable.ic_action_email,"Starred",245,"#ffffff"));
		mData.add(new ItemNormal(R.drawable.ic_action_group, "Important", 123, "#ffffff"));
		mData.add(new ItemNormal(R.drawable.ic_action_labels, "Sent", 44, "#ffffff"));
		mData.add(new ItemNormal(R.drawable.ic_action_labels, "Outbox", 44, "#ffffff"));
		mData.add(new ItemNormal(R.drawable.ic_action_labels, "Drafts", 44, "#ffffff"));
		mData.add(new ItemNormal(R.drawable.ic_action_labels, "All mail", 44, "#ffffff"));
		mData.add(new ItemNormal(R.drawable.ic_action_labels, "Spam", 44, "#ffffff"));
		mData.add(new ItemNormal(R.drawable.ic_action_labels, "Trash", 44, "#ffffff"));
		mData.add(new ItemNormal(R.drawable.ic_action_labels, "My tag", 44, "#ffffff"));
		
		mData.add(new ItemCat(""));
		mData.add(new ItemNormal(R.drawable.ic_action_settings,"Settings",0,"#ffffff"));
		mData.add(new ItemNormal(R.drawable.ic_action_help, "Help & feedback", 123, "#ffffff"));
		
		//find listview
		mListView = (ListView)view.findViewById(R.id.listViewGmail);
		
		//set item click event listener for listview
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });
		
		MyAdapter adapter = new MyAdapter(getActivity().getApplicationContext(), 0);
		mListView.setAdapter(adapter);
		
		mListView.setItemChecked(mCurrentSelectedPosition, true);
		return view;
	}
	
	 public boolean isDrawerOpen() {
	        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
	    }

	    /**
	     * Users of this fragment must call this method to set up the navigation drawer interactions.
	     *
	     * @param fragmentId   The android:id of this fragment in its activity's layout.
	     * @param drawerLayout The DrawerLayout containing this fragment's UI.
	     */
	    public void setUp(int fragmentId, DrawerLayout drawerLayout) {
	        mFragmentContainerView = getActivity().findViewById(fragmentId);
	        mDrawerLayout = drawerLayout;

	        // set a custom shadow that overlays the main content when the drawer opens
	        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
	        // set up the drawer's list view with items and click listener

	        ActionBar actionBar = getActionBar();
	        actionBar.setDisplayHomeAsUpEnabled(true);
	        actionBar.setHomeButtonEnabled(true);

	        // ActionBarDrawerToggle ties together the the proper interactions
	        // between the navigation drawer and the action bar app icon.
	        mDrawerToggle = new ActionBarDrawerToggle(
	                getActivity(),                    /* host Activity */
	                mDrawerLayout,                    /* DrawerLayout object */
	                R.drawable.ic_drawer,             /* nav drawer image to replace 'Up' caret */
	                R.string.navigation_drawer_open,  /* "open drawer" description for accessibility */
	                R.string.navigation_drawer_close  /* "close drawer" description for accessibility */
	        ) {
	            @Override
	            public void onDrawerClosed(View drawerView) {
	                super.onDrawerClosed(drawerView);
	                if (!isAdded()) {
	                    return;
	                }

	                getActivity().supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
	            }

	            @Override
	            public void onDrawerOpened(View drawerView) {
	                super.onDrawerOpened(drawerView);
	                if (!isAdded()) {
	                    return;
	                }

	                if (!mUserLearnedDrawer) {
	                    // The user manually opened the drawer; store this flag to prevent auto-showing
	                    // the navigation drawer automatically in the future.
	                    mUserLearnedDrawer = true;
	                    SharedPreferences sp = PreferenceManager
	                            .getDefaultSharedPreferences(getActivity());
	                    sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true).commit();
	                }

	                getActivity().supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
	            }
	        };

	        // If the user hasn't 'learned' about the drawer, open it to introduce them to the drawer,
	        // per the navigation drawer design guidelines.
	        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
	            mDrawerLayout.openDrawer(mFragmentContainerView);
	        }

	        // Defer code dependent on restoration of previous instance state.
	        mDrawerLayout.post(new Runnable() {
	            @Override
	            public void run() {
	                mDrawerToggle.syncState();
	            }
	        });

	        mDrawerLayout.setDrawerListener(mDrawerToggle);
	    }

	    private void selectItem(int position) {
	    	Toast.makeText(getActivity().getApplicationContext(), "cai da chon la: "+position, Toast.LENGTH_SHORT).show();
	    	
	        mCurrentSelectedPosition = position;
	        if (mListView != null) {
	            mListView.setItemChecked(position, true);
	        }
	        if (mDrawerLayout != null) {
	            mDrawerLayout.closeDrawer(mFragmentContainerView);
	        }
	        if (mCallbacks != null) {
	            mCallbacks.onNavigationDrawerItemSelected(position);
	        }
	    }

	    @Override
	    public void onAttach(Activity activity) {
	        super.onAttach(activity);
	        try {
	            mCallbacks = (NavigationDrawerCallbacks) activity;
	        } catch (ClassCastException e) {
	            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
	        }
	    }

	    @Override
	    public void onDetach() {
	        super.onDetach();
	        mCallbacks = null;
	    }

	    @Override
	    public void onSaveInstanceState(Bundle outState) {
	        super.onSaveInstanceState(outState);
	        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
	    }

	    @Override
	    public void onConfigurationChanged(Configuration newConfig) {
	        super.onConfigurationChanged(newConfig);
	        // Forward the new configuration the drawer toggle component.
	        mDrawerToggle.onConfigurationChanged(newConfig);
	    }

	    @Override
	    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	        // If the drawer is open, show the global app actions in the action bar. See also
	        // showGlobalContextActionBar, which controls the top-left area of the action bar.
	        if (mDrawerLayout != null && isDrawerOpen()) {
	            inflater.inflate(R.menu.global, menu);
	            showGlobalContextActionBar();
	        }
	        super.onCreateOptionsMenu(menu, inflater);
	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        if (mDrawerToggle.onOptionsItemSelected(item)) {
	            return true;
	        }

	        if (item.getItemId() == R.id.action_example) {
	            Toast.makeText(getActivity(), "Example action.", Toast.LENGTH_SHORT).show();
	            return true;
	        }

	        return super.onOptionsItemSelected(item);
	    }
	
	//for data adapter of list view
	public class MyAdapter extends ArrayAdapter<Object>{
		public MyAdapter(Context context, int resource){
			super (context, resource);
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
			
			ViewHolderNormal holderNormal = new ViewHolderNormal();
			ViewHolderEmail holderEmail = new ViewHolderEmail();
			ViewHolderCat holderCat = new ViewHolderCat();
			
			LayoutInflater inflater = (LayoutInflater)getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			boolean isCreateNew = true;
			
			if(convertView ==null){
				isCreateNew = true;
			}else{
				if(item instanceof ItemNormal && convertView.getTag() instanceof ViewHolderNormal){
					isCreateNew = false;
				}
				
				if(item instanceof ItemEmail && convertView.getTag() instanceof ViewHolderEmail){
					isCreateNew = false;
				}
				
				if(item instanceof ItemCat && convertView.getTag() instanceof ViewHolderCat){
					isCreateNew = false;
				}
				
			}
			
			
			if(!isCreateNew){
				if(item instanceof ItemNormal){
					holderNormal = (ViewHolderNormal)convertView.getTag();
				}
				else if(item instanceof ItemEmail){
					holderEmail = (ViewHolderEmail)convertView.getTag();
				}
				else if(item instanceof ItemCat){
					holderCat = (ViewHolderCat)convertView.getTag();
				}
			}
			else{
				if(item instanceof ItemNormal){
					convertView = inflater.inflate(R.layout.layout_item_normal, parent, false);
					holderNormal = new ViewHolderNormal();
					
					holderNormal.txtContext = (TextView)convertView.findViewById(R.id.txtContentNormal);
					holderNormal.txtCount = (TextView)convertView.findViewById(R.id.txtCountNormal);
					holderNormal.imgView = (ImageView)convertView.findViewById(R.id.imgViewNormal);
					
					convertView.setTag(holderNormal);
				}
				else if(item instanceof ItemEmail){
					convertView = inflater.inflate(R.layout.layout_item_checkbox, parent, false);
					holderEmail = new ViewHolderEmail();
					
					holderEmail.txtCount = (TextView)convertView.findViewById(R.id.txtCountEmail);
					holderEmail.radioEmail = (RadioButton)convertView.findViewById(R.id.radioBtn);
					
					convertView.setTag(holderEmail);
				}
				else if(item instanceof ItemCat){
					convertView = inflater.inflate(R.layout.layout_item_cat, parent, false);
					holderCat = new ViewHolderCat();
					
					holderCat.txtTitle = (TextView)convertView.findViewById(R.id.txtTitle);
					
					convertView.setTag(holderCat);
				}
			}
			
			//change data in holders
			if(item instanceof ItemNormal){
				ItemNormal itemNormal = (ItemNormal)item;
				
				holderNormal.txtContext.setText(itemNormal.content);
				holderNormal.txtCount.setText(""+itemNormal.count);
				holderNormal.imgView.setImageResource(itemNormal.imgIndex);
			}
			else if(item instanceof ItemEmail){
				ItemEmail itemEmail = (ItemEmail)item;
				
				Log.d("huynq","so email la:"+itemEmail.count);
				holderEmail.txtCount.setText(""+itemEmail.count);
				holderEmail.radioEmail.setText(itemEmail.email);
			}
			else if(item instanceof ItemCat){
				ItemCat itemCat = (ItemCat)item;
				
				holderCat.txtTitle.setText(itemCat.title);
			}
			
			return convertView;
		}
	}//end class
	
	private class ViewHolderNormal{
		TextView txtContext;
		TextView txtCount;
		ImageView imgView;
	}
	
	private class ViewHolderEmail{
		TextView txtCount;
		RadioButton radioEmail;
	}
	
	private class ViewHolderCat{
		TextView txtTitle;
	}
	//end data adapter of listview
	
	/**
     * Per the navigation drawer design guidelines, updates the action bar to show the global app
     * 'context', rather than just what's in the current screen.
     */
    private void showGlobalContextActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setTitle(R.string.app_name);
    }

    private ActionBar getActionBar() {
        return ((ActionBarActivity) getActivity()).getSupportActionBar();
    }

    /**
     * Callbacks interface that all activities using this fragment must implement.
     */
    public static interface NavigationDrawerCallbacks {
        /**
         * Called when an item in the navigation drawer is selected.
         */
        void onNavigationDrawerItemSelected(int position);
    }
}
