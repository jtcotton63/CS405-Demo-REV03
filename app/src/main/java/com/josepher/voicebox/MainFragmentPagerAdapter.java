package com.josepher.voicebox;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.josepher.voicebox.ideaPool.SummaryFragmentPool;
import com.josepher.voicebox.ideaCats.SummaryFragmentCats;
import com.josepher.voicebox.ideaTeachers.SummaryFragmentTeachers;
import com.josepher.voicebox.issueLibrary.SummaryFragmentLibrary;

/**
 * Created by Josepher on 3/18/2016.
 */
public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 6;

    public MainFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 1) {
            return SummaryFragmentCats.newInstance();
        } else if(position == 2) {
            return SummaryFragmentLibrary.newInstance();
        } else if(position == 3) {
            return SummaryFragmentTeachers.newInstance();
        } else if(position == 4) {
            return SummaryFragmentPool.newInstance();
        } else if(position == 5) {
            return SummaryFragmentPool.newInstance();
        } else {
            return SummaryFragmentPool.newInstance();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "";
    }
}
