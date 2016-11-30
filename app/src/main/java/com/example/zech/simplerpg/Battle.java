package com.example.zech.simplerpg;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Battle extends AppCompatActivity {

    User_Character user;
    TextView userHPtext;
    ImageView enemyHitImage;
    ProgressBar userHealthProgress;

    public void changeUserHealthBar(final int n){
        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(user.current_health >  Math.max(0,n)){
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

    public void userAttackAnimation(){
        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(400);
                }catch (Exception e){
                    System.out.println("Sleep not working:"+userHealthProgress.getProgress());
                }

                int i = 11;
                while(i <= 31){
                    final int temp = i;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String name = "battle_slash"+temp;
                            int id = getResources().getIdentifier(name, "drawable", getPackageName());
                            enemyHitImage.setImageResource(id);
                        }
                    });
                    try{
                        Thread.sleep(80);
                    }catch (Exception e){
                        System.out.println("Sleep not working:"+userHealthProgress.getProgress());
                    }
                    i++;
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        int id = getResources().getIdentifier("battle_slash0", "drawable", getPackageName());
                        enemyHitImage.setImageResource(id);
                    }
                });
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
        enemyHitImage = (ImageView) findViewById(R.id.enemyHitImage);

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
                userAttackAnimation();
                //attackSound.stop();
            }
        });

    }
}
