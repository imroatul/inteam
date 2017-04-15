package com.tolahtoleh.tolahtolehnew;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.tolahtoleh.tolahtolehnew.Tab.MyAdapter;
import com.tolahtoleh.tolahtolehnew.Tab.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewpager;

    private DrawerLayout nDrawerLayout;
    private ActionBarDrawerToggle nToggle;
    //private Toolbar nToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // nToolbar = (Toolbar) findViewById(R.id.nav_action);
        //setSupportActionBar(nToolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mViewpager=(ViewPager)findViewById(R.id.vp_tabs);
        mViewpager.setAdapter(new MyAdapter(getSupportFragmentManager(), this));

        mSlidingTabLayout=(SlidingTabLayout)findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.warnaToscaPrimary));
                mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.warnaPutihPrimary));//warna line indicator
                mSlidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_tab);
                mSlidingTabLayout.setViewPager(mViewpager);

        //menu Navigasi Drawer
        nDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        nToggle = new ActionBarDrawerToggle(this, nDrawerLayout, R.string.open, R.string.close);

        nDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      if(nToggle.onOptionsItemSelected(item)){
          return true;
      }
       return super.onOptionsItemSelected(item);
    }
}
