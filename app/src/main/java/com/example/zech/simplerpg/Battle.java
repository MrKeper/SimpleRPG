package com.example.zech.simplerpg;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
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
    ImageView monsterImage;
    Boolean isFleeing = false;

    /* This was suppose to shake the character - BROKEN
    ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) monsterImage.getLayoutParams();
                            if(temp % 6 == 0)
                                p.setMargins(0,0,10,0);
                            else if(temp % 3 == 0)
                                p.setMargins(0,0,0,0);
                            monsterImage.requestLayout();
     */
    public void healthBarColorMonitor(){
        final Handler handler = new Handler();
        final int userOrange = user.base_health / 2;
        final int userRed = user.base_health / 5;
        final MediaPlayer lowHPsound = MediaPlayer.create(this, R.raw.low_health_sound);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(user.current_health > 0 ) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if(user.current_health < userOrange){
                                userHealthProgress.getProgressDrawable().setColorFilter(Color.rgb(255,165,0), PorterDuff.Mode.SRC_IN);
                            }
                            if(user.current_health < userRed){
                                userHealthProgress.getProgressDrawable().setColorFilter(Color.rgb(200,0,0), PorterDuff.Mode.SRC_IN);
                                if(!lowHPsound.isPlaying() && !isFleeing){
                                    lowHPsound.start();
                                    lowHPsound.setLooping(true);
                                }else if(isFleeing){
                                    lowHPsound.stop();
                                    return;
                                }
                            }
                        }
                    });
                    try {
                        Thread.sleep(300);
                    } catch (Exception e) {
                        System.out.println("ColorMonitor Sleep ERROR");
                    }
                }
                lowHPsound.stop();
            }
        }).start();
    }

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
                        Thread.sleep(100);
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
        monsterImage = (ImageView)  findViewById(R.id.monsterView);

        // Initialize stuff
        userHPtext.setText(user.current_health + " / " + user.base_health);
        userHealthProgress.setMax(user.base_health);
        userHealthProgress.setProgress(user.current_health);
        userHealthProgress.getProgressDrawable().setColorFilter(Color.rgb(0,200,0), PorterDuff.Mode.SRC_IN);


        final MediaPlayer mp  = MediaPlayer.create(this, R.raw.battle_music1);
        final MediaPlayer attackSound = MediaPlayer.create(this, R.raw.sword_attack_short);
        final MediaPlayer fleeSound = MediaPlayer.create(this, R.raw.flee_sound);
        mp.start();
        mp.setLooping(true);

        healthBarColorMonitor();

        Button attackButton = (Button) findViewById(R.id.attackButton);
        attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attackSound.start();
                changeUserHealthBar(user.current_health - 30);
                userAttackAnimation();
                //attackSound.stop();
            }
        });

        Button runButton = (Button) findViewById(R.id.runButton);
        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                mp.stop();
                attackSound.stop();
                fleeSound.start();

                final Handler handler = new Handler();
                isFleeing = true;

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Thread.sleep(1000);
                        }catch (Exception e){
                            System.out.println("FLEE Sleep not working:");
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(v.getContext(), Testing.class);
                                intent.putExtra("user",user);
                                startActivity(intent);
                                finish();
                            }
                        });
                    }
                }).start();
                //finish();
            }
        });

    }
}
