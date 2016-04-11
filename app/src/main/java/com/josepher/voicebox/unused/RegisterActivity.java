package com.josepher.voicebox.unused;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.josepher.voicebox.MainActivity;
import com.josepher.voicebox.R;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unused_activity_register);

        ArrayList<String> states = new ArrayList();
        states.add("Alaska");
        states.add("Arizona");
        states.add("Arkansas");
        ArrayAdapter<String> universityAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, states);
        Spinner universityDropdown = (Spinner) findViewById(R.id.state_dropdown);
        universityDropdown.setAdapter(universityAdapter);

        Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
