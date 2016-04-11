package com.josepher.voicebox.ideaA;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.josepher.voicebox.ContributeActivity;
import com.josepher.voicebox.R;

public class HistoryActivityA extends AppCompatActivity {

    public HistoryActivityA() {
        // Required empty public constructor
    }

    public static HistoryActivityA newInstance() {
        HistoryActivityA fragment = new HistoryActivityA();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity_history1);

        Button finishedButton = (Button) findViewById(R.id.finish_button);
        finishedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivityA.this, ContributeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
