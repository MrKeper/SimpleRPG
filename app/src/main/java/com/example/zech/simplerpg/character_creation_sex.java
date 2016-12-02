package com.example.zech.simplerpg;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.graphics.Color.WHITE;

public class character_creation_sex extends AppCompatActivity {
    public MediaPlayer buttonSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation_sex);
        Intent character_creation_sex = getIntent();
        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");
        buttonSound = MediaPlayer.create(this, R.raw.button_press);
        Button male_button = (Button) findViewById(R.id.maleButton);
        male_button.setBackgroundResource(R.drawable.woodbutton);
        male_button.setTextColor(WHITE);
        male_button.setSoundEffectsEnabled(false);
        male_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                user.sex = "male";
                Intent intent = new Intent(v.getContext(), character_creation_stats.class);
                intent.putExtra("user",user);
                buttonSound.start();
                startActivity(intent);
                finish();
            }
        });

        Button female_button = (Button) findViewById(R.id.femaleButton);
        female_button.setBackgroundResource(R.drawable.woodbutton);
        female_button.setTextColor(WHITE);
        female_button.setSoundEffectsEnabled(false);
        female_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                user.sex = "female";
                Intent intent = new Intent(v.getContext(), character_creation_stats.class);
                intent.putExtra("user",user);
                buttonSound.start();
                startActivity(intent);
                finish();
            }
        });

        Button back_button = (Button) findViewById(R.id.backButtonSex);
        back_button.setBackgroundResource(R.drawable.woodbutton);
        back_button.setTextColor(WHITE);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(v.getContext(), character_creation_name.class);
                buttonSound.start();
                startActivity(intent);
                buttonSound.stop();
                finish();
            }
        });

    }
}
