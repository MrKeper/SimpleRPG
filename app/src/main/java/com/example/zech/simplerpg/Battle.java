package com.example.zech.simplerpg;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Battle extends AppCompatActivity {

    User_Character user;
    TextView userHPtext;
    ProgressBar userHealthProgress;

    public void changeUserHealthBar(final int n){
        final Handler handler = new Handler();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while(user.current_health > Math.max(0,n)){
                    user.current_health = user.current_health - 1;
                    //final int tempHP = userHealthProgress.getProgress() - 1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            userHealthProgress.setProgress(user.current_health);
                            userHPtext.setText(user.current_health + " / " + user.base_health);
                        }
                    });
                    try{
                        Thread.sleep(50);
                    }catch (Exception e){
                        System.out.println("Sleep not working:"+userHealthProgress.getProgress());
                    }
                }
            }
        }).start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        user = (User_Character) getIntent().getSerializableExtra("user");
        userHPtext = (TextView)  findViewById(R.id.userHealthText);
        userHealthProgress = (ProgressBar) findViewById(R.id.userHealthBar);

        // Initialize stuff
        userHPtext.setText(user.current_health + " / " + user.base_health);
        userHealthProgress.setMax(user.base_health);
        userHealthProgress.setProgress(user.current_health);


        MediaPlayer mp  = MediaPlayer.create(this, R.raw.battle_music1);
        final MediaPlayer attackSound = MediaPlayer.create(this, R.raw.sword_attack_short);
        mp.start();
        mp.setLooping(true);

        Button attackButton = (Button) findViewById(R.id.attackButton);
        attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attackSound.start();
                changeUserHealthBar(40);
                //attackSound.stop();
            }
        });

    }
}
