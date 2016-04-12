package com.josepher.voicebox;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.josepher.voicebox.ideaPool.HistoryActivityPool;

public class MainActivity extends AppCompatActivity {

    // Sliding
    PagerSlidingTabStrip tabsStrip;
    ViewPager viewPager;

    // Title
    private String localityTitle;
    private TextView localityTitleView;

    // Buttons
    Button contributeButton;
    Button historyButton;
    ImageButton inFavorOfButton;
    ImageButton notInFavorOfButton;
    Button shareIdeaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MainFragmentPagerAdapter(getSupportFragmentManager()));

        // Give the PagerSlidingTabStrip the ViewPager
        tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
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

        // Set listeners for buttons
        contributeButton = (Button) findViewById(R.id.contribute_button);
        contributeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContributeActivity.class);
                startActivity(intent);
            }
        });

        historyButton = (Button) findViewById(R.id.history_button);
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoryActivityPool.class);
                startActivity(intent);
            }
        });

        inFavorOfButton = (ImageButton) findViewById(R.id.in_favor_of_button);
        inFavorOfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (Toast.makeText(getApplicationContext(), "Response recorded", Toast.LENGTH_SHORT)).show();
            }
        });

        notInFavorOfButton = (ImageButton) findViewById(R.id.not_in_favor_of_button);
        notInFavorOfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (Toast.makeText(getApplicationContext(), "Response recorded", Toast.LENGTH_SHORT)).show();
            }
        });

        shareIdeaButton = (Button) findViewById(R.id.share_idea_button);
        shareIdeaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateIdeaActivity.class);
                startActivity(intent);
            }
        });

    }

    public void setLocalityTitle(String title) {
        this.localityTitle = title;
        this.localityTitleView.setText(title);
    }
}
