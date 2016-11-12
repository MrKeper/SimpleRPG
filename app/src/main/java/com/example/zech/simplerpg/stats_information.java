package com.example.zech.simplerpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class stats_information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_information);
        Intent stats_information = getIntent();
        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");
        Button back_button = (Button) findViewById(R.id.statInfoBack);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), character_creation_stats.class);
                intent.putExtra("user",user);
                startActivity(intent);
                finish();
            }
        });
    }
}
