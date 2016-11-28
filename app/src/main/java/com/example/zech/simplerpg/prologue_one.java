package com.example.zech.simplerpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class prologue_one extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_one);
        Intent prologue1 = getIntent();
        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");
        TextView message = (TextView) findViewById(R.id.prologueOneText);
        message.setText("Greetings "+user.actor_name+",\nINSERT INTRO HERE."+
        "\nStrength = "+user.strength+"\nSex = "+user.sex);
        Button proceed = (Button) findViewById(R.id.prologueOneProceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
