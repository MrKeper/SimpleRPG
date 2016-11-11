package com.example.zech.simplerpg;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartPage extends AppCompatActivity {

    public MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        Intent start_page_intent = getIntent();
        mp = MediaPlayer.create(this, R.raw.backgroundmusic);
        mp.start();
        mp.setLooping(true);
        Button new_button = (Button) findViewById(R.id.newGame);
        new_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n)
            {
                //intent char creation

                Intent intent = new Intent(n.getContext(), character_creation_name.class);
                mp.stop();
                startActivity(intent);
                finish();
            }
        });
        Button load_button = (Button) findViewById(R.id.loadGame);
        load_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View l)
            {
                //load save
                mp.stop();
            }
        });
        Button exit_button = (Button) findViewById(R.id.exitGame);
        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e)
            {
                finish();
                mp.stop();
            }
        });


    }

}
