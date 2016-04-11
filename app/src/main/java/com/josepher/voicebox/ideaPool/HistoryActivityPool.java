package com.josepher.voicebox.ideaPool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.josepher.voicebox.ContributeActivity;
import com.josepher.voicebox.R;

public class HistoryActivityPool extends AppCompatActivity {

    public HistoryActivityPool() {
        // Required empty public constructor
    }

    public static HistoryActivityPool newInstance() {
        HistoryActivityPool fragment = new HistoryActivityPool();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pool_activity_history);

        Button finishedButton = (Button) findViewById(R.id.finish_button);
        finishedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivityPool.this, ContributeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
