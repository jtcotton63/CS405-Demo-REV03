package com.josepher.voicebox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContributeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contribute);

        Button createIdeaButton = (Button) findViewById(R.id.contribute_button);
        createIdeaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (Toast.makeText(getApplicationContext(), "Thank you for your contribution.", Toast.LENGTH_SHORT)).show();
                finish();
            }
        });
    }
}
