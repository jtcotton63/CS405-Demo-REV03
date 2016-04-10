package com.josepher.voicebox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HistoryActivity1 extends AppCompatActivity {

    public HistoryActivity1() {
        // Required empty public constructor
    }

    public static HistoryActivity1 newInstance() {
        HistoryActivity1 fragment = new HistoryActivity1();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history1);

        Button finishedButton = (Button) findViewById(R.id.finish_button);
        finishedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivity1.this, ContributeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
