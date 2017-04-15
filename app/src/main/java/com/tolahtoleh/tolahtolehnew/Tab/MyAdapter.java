package com.tolahtoleh.tolahtolehnew.Tab;

/**
 * Created by KING on 06/04/2017.
 */

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.tolahtoleh.tolahtolehnew.fragment.HomeFragment;
import com.tolahtoleh.tolahtolehnew.fragment.LainLainFragment;
import com.tolahtoleh.tolahtolehnew.fragment.MakananFragment;
import com.tolahtoleh.tolahtolehnew.fragment.MinumanFragment;
import com.tolahtoleh.tolahtolehnew.fragment.PakaianFragment;

import com.tolahtoleh.tolahtolehnew.R;
/**
 * Created by Ujang Wahyu on 18/08/2016.
 */

public class MyAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles ={"A","B","C","D","E"};
    int[] icon = new int[]{R.drawable.ic_home_white_24dp,R.drawable.ic_shopping_cart_white_24dp,R.drawable.ic_account_circle_white_24dp,R.drawable.ic_toys_white_24dp,R.drawable.ic_shopping_cart_white_24dp};
    private int heightIcon;

    public MyAdapter(FragmentManager fm, Context c){
        super(fm);
        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon=(int)(24*scale+0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag= null;

        if(position ==0){
            frag = new HomeFragment();
        }else if(position == 1){
            frag = new MakananFragment();
        }else if(position == 2){
            frag = new MinumanFragment();
        }else if(position == 3){
            frag = new PakaianFragment();
        }else if(position == 4) {
            frag = new LainLainFragment();
        }

        Bundle b = new Bundle();
        b.putInt("position", position);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    public CharSequence getPageTitle(int position){
        Drawable d = mContext.getResources().getDrawable(icon[position]);
        d.setBounds(0,0,heightIcon,heightIcon);
        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is,0,sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sp;
    }

}