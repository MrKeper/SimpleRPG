package com.example.zech.simplerpg;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.graphics.Color.WHITE;

public class stats_information extends AppCompatActivity {
    public MediaPlayer buttonSound;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_information);
        final Intent returnToSender = getIntent();
        buttonSound  = MediaPlayer.create(this, R.raw.button_press);
        Button back_button = (Button) findViewById(R.id.statInfoBack);
        back_button.setBackgroundResource(R.drawable.woodbutton);
        back_button.setTextColor(WHITE);
        back_button.setTextSize(20);
        back_button.setSoundEffectsEnabled(false);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonSound.start();
                finish();
            }
        });
    }
}
