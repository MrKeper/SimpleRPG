package com.example.zech.simplerpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Testing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");

        Button battleButton = (Button) findViewById(R.id.battle_button);
        battleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Battle.class);
                intent.putExtra("user",user);
                startActivity(intent);
                finish();
            }
        });

        Button playerInfoButton = (Button) findViewById(R.id.playerInfo);
        playerInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), user_information_page.class);
                intent.putExtra("user",user);
                startActivity(intent);
                finish();
            }
        });
    }
}
