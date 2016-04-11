package com.josepher.voicebox;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.josepher.voicebox.ideaA.SummaryFragmentA;

/**
 * Created by Josepher on 3/18/2016.
 */
public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 5;
    private String tabTitles[] = new String[] { "", "", "" };

    public MainFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return SummaryFragmentA.newInstance();
        } else if(position == 1) {
            return SummaryFragmentA.newInstance();
        } else {
            return SummaryFragmentA.newInstance();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
