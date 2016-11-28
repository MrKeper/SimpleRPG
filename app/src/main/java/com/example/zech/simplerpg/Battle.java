package com.example.zech.simplerpg;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Battle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");

        MediaPlayer mp  = MediaPlayer.create(this, R.raw.battle_music1);
        mp.start();
        mp.setLooping(true);


    }
}
