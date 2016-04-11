package com.josepher.voicebox;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends AppCompatActivity {

    private String localityTitle;
    private TextView localityTitleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MainFragmentPagerAdapter(getSupportFragmentManager()));

        // Give the PagerSlidingTabStrip the ViewPager
        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);
        tabsStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                switch(position) {
                    case 1:
                        setLocalityTitle("City of Provo");
                        break;
                    case 2:
                        setLocalityTitle("City of Provo");
                        break;
                    case 3:
                        setLocalityTitle("State of Utah");
                        break;
                    case 4:
                        setLocalityTitle("United States of America");
                        break;
                    case 5:
                        setLocalityTitle("United States of America");
                        break;
                    default:
                        setLocalityTitle("City of Provo");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        localityTitleView = (TextView) findViewById(R.id.locality_title_view);
        setLocalityTitle("City of Provo");
    }

    public void setLocalityTitle(String title) {
        this.localityTitle = title;
        this.localityTitleView.setText(title);
    }
}
