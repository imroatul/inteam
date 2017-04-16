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
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileSettingDrawerItem;
import com.tolahtoleh.tolahtolehnew.Tab.MyAdapter;
import com.tolahtoleh.tolahtolehnew.Tab.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewpager;

    private Drawer.Result navigationDrawer;
    private AccountHeader.Result headerNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mViewpager = (ViewPager) findViewById(R.id.vp_tabs);
        mViewpager.setAdapter(new MyAdapter(getSupportFragmentManager(), this));

        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.warnaToscaPrimary));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.warnaPutihPrimary));//warna line indicator
        mSlidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_tab);
        mSlidingTabLayout.setViewPager(mViewpager);

        //============================================================
        headerNavigation = new AccountHeader()
                .withActivity(this)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .withHeaderBackground(R.color.warnaToscaLainlain)
                .addProfiles(
                        new ProfileDrawerItem().withName("User Name").withEmail("username@gmail.com").withIcon(getResources().getDrawable(R.drawable.ic_account_circle_white_24dp))
                )
                .build();
        navigationDrawer = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(false)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withAccountHeader(headerNavigation)
                .withSelectedItem(0)
                .build();
        navigationDrawer.addItem(new PrimaryDrawerItem().withName("Transaksi").withIcon(getResources().getDrawable(R.drawable.color_card)));
        navigationDrawer.addItem(new PrimaryDrawerItem().withName("Favorit").withIcon(getResources().getDrawable(R.drawable.color_like)));
        navigationDrawer.addItem(new PrimaryDrawerItem().withName("Poin").withIcon(getResources().getDrawable(R.drawable.color_money_bag)));
        navigationDrawer.addItem(new PrimaryDrawerItem().withName("Bantuan").withIcon(getResources().getDrawable(R.drawable.color_help)));
    }


    @Override
   public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

 /*   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      if(nToggle.onOptionsItemSelected(item)){
          return true;
      }
       return super.onOptionsItemSelected(item);
    }*/
}
