package com.example.fbtabactionbar;

import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements ActionBar.TabListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;
    int[] lstIcons;
    int[] lstIconsSelected;

    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //set a list of action bar tab's icons
        lstIcons = new int[5];
        lstIcons[0] = R.drawable.feed;
        lstIcons[1] = R.drawable.friends;
        lstIcons[2] = R.drawable.message;
        lstIcons[3] = R.drawable.notification;
        lstIcons[4] = R.drawable.more;
        
        lstIconsSelected = new int[5];
        lstIconsSelected[0] = R.drawable.feed_selected;
        lstIconsSelected[1] = R.drawable.friends_selected;
        lstIconsSelected[2] = R.drawable.message_selected;
        lstIconsSelected[3] = R.drawable.notification_selected;
        lstIconsSelected[4] = R.drawable.more_selected;

        // Set up the action bar.
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS); 

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
//            actionBar.addTab(
//                    actionBar.newTab()
//                            .setText(mSectionsPagerAdapter.getPageTitle(i))
//                            .setTabListener(this));
        	actionBar.addTab(
                    actionBar.newTab().setCustomView(R.layout.layout_action_bar_tab_item).setTabListener(this));
        }

        
        //modify content of each tab
        for(int i=0; i< mSectionsPagerAdapter.getCount(); i++){
        	ImageView imgView = (ImageView)actionBar.getTabAt(i).getCustomView().findViewById(R.id.imgMoreIcon);
        	
        	if(i==0){
        		imgView.setImageResource(lstIconsSelected[i]);
        	}
        	else{
        		imgView.setImageResource(lstIcons[i]);
        	}
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_bar_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
        
        //change image resource of tab view
        ImageView imgView = (ImageView)(tab.getCustomView().findViewById(R.id.imgMoreIcon));
        //Toast.makeText(getApplicationContext(), "index la: "+tab.getPosition(), Toast.LENGTH_SHORT).show();
        imgView.setImageResource(lstIconsSelected[tab.getPosition()]);
        
        //set action bar title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getActionBarTitle(tab.getPosition()));
    }
    
    public CharSequence getActionBarTitle(int position) {
        switch (position) {
            case 0:
                return getString(R.string.title_section1);
            case 1:
                return getString(R.string.title_section2);
            case 2:
                return getString(R.string.title_section3);
            case 3:
                return getString(R.string.title_section4);
            case 4:
                return getString(R.string.title_section5);    
              
        }
        return null;
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    	//restore image resource of tab view to unselected image
        ImageView imgView = (ImageView)(tab.getCustomView().findViewById(R.id.imgMoreIcon));
        //Toast.makeText(getApplicationContext(), "index la: "+tab.getPosition(), Toast.LENGTH_SHORT).show();
        imgView.setImageResource(lstIcons[tab.getPosition()]);
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

        	if(position==4){
        		return FragmentMore.newInstance();
        	}
        	else if(position ==0){
        		return FragmentFeed.newInstance();
        	}
        	else{
        		return PlaceholderFragment.newInstance(position + 1);
        	}
        		

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            
            //get label
            TextView txtSection  = (TextView)rootView.findViewById(R.id.section_label);          
            txtSection.setText("Trang thu "+getArguments().getInt(ARG_SECTION_NUMBER));
            
            return rootView;
        }
    }

}
