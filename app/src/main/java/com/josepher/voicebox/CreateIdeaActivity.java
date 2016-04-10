package com.josepher.voicebox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class CreateIdeaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        // Button
        Button createIdeaButton = (Button) findViewById(R.id.create_idea_button);
        createIdeaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Populate university list
        ArrayList<String> universities = new ArrayList();
        universities.add("Brigham Young University");
        universities.add("University of Utah");
        universities.add("Utah Valley University");
        ArrayAdapter<String> stateAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, universities);
        Spinner universityDropdown = (Spinner) findViewById(R.id.university_dropdown);
        universityDropdown.setAdapter(stateAdapter);
    }
}
