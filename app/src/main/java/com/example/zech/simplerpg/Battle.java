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
import android.widget.Toast;

import static android.graphics.Color.WHITE;

public class Battle extends AppCompatActivity {

    User_Character user;
    Mob enemy;
    Button attackButton;
    Button runButton;
    TextView userHPtext;
    TextView enemyHPtext;
    TextView chooseActiontext;
    ImageView enemyHitImage;
    ProgressBar userHealthProgress;
    ProgressBar enemyHealthProgress;
    ImageView monsterImage;
    ImageView userImage;
    Boolean isFleeing = false;
    Boolean userAttacksFirst = false;
    /* This was suppose to shake the character - BROKEN
    ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) monsterImage.getLayoutParams();
                            if(temp % 6 == 0)
                                p.setMargins(0,0,10,0);
                            else if(temp % 3 == 0)
                                p.setMargins(0,0,0,0);
                            monsterImage.requestLayout();
     */
    public void actionChosen(){
        attackButton.setVisibility(View.INVISIBLE);
        runButton.setVisibility(View.INVISIBLE);
        chooseActiontext.setVisibility(View.INVISIBLE);
    }
    public void turnFinish(){
        attackButton.setVisibility(View.VISIBLE);
        runButton.setVisibility(View.VISIBLE);
        chooseActiontext.setVisibility(View.VISIBLE);
    }

    public void turnSequence(boolean playerFirst){
        if(playerFirst){
            changeEnemyHealthBar(enemy.current_health - user.strength*3);
            userAttackAnimation();
        }else{

        }
    }

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
                                    lowHPsound.release();
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
                lowHPsound.release();
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
                            String hpText = user.current_health + " / " + user.max_health;
                            while(hpText.length() < 9) hpText = " "+hpText;
                            userHPtext.setText(hpText);
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

    public void changeEnemyHealthBar(final int n){
        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(enemy.current_health >  Math.max(0,n)){
                    enemy.current_health = enemy.current_health - 1;
                    //final int tempHP = userHealthProgress.getProgress() - 1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            enemyHealthProgress.setProgress(enemy.current_health);
                            String hpText = enemy.current_health + " / " + enemy.base_health;
                            while(hpText.length() < 9) hpText = " "+hpText;
                            enemyHPtext.setText(hpText);
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
                        turnFinish();
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
        enemy = (Mob) getIntent().getSerializableExtra("enemy");
        userHPtext = (TextView)  findViewById(R.id.userHealthText);
        enemyHPtext = (TextView)  findViewById(R.id.enemyHealthText);
        chooseActiontext = (TextView)  findViewById(R.id.textchooseaction);
        userHealthProgress = (ProgressBar) findViewById(R.id.userHealthBar);
        enemyHealthProgress = (ProgressBar) findViewById(R.id.enemyHealthBar);
        enemyHitImage = (ImageView) findViewById(R.id.enemyHitImage);
        userImage = (ImageView)  findViewById(R.id.userView);
        monsterImage = (ImageView)  findViewById(R.id.monsterView);

        // Initialize stuff
        userHPtext.setText(user.current_health + " / " + user.max_health);
        userHealthProgress.setMax(user.max_health);
        userHealthProgress.setProgress(user.current_health);
        userHealthProgress.getProgressDrawable().setColorFilter(Color.rgb(0,200,0), PorterDuff.Mode.SRC_IN);
        if(user.sex.equalsIgnoreCase("female")){
            int id = getResources().getIdentifier("female_high_health", "drawable", getPackageName());
            userImage.setImageResource(id);
        }

        enemyHPtext.setText(enemy.current_health + " / " + enemy.base_health);
        enemyHealthProgress.setMax(enemy.base_health);
        enemyHealthProgress.setProgress(enemy.current_health);
        enemyHealthProgress.getProgressDrawable().setColorFilter(Color.rgb(0,200,0), PorterDuff.Mode.SRC_IN);
        int id = getResources().getIdentifier(enemy.imagename, "drawable", getPackageName());
        monsterImage.setImageResource(id);

        //Roll the Dice
        int dice = (int) (Math.random()*10)+1;
        Toast showDice;

        if(dice > 5)
            showDice = Toast.makeText(getApplicationContext(),"Dice Rolled("+dice+"): Enemy attacks first",Toast.LENGTH_LONG);
        else {
            showDice = Toast.makeText(getApplicationContext(), "Dice Rolled("+dice+"): "+user.actor_name+" attacks first", Toast.LENGTH_LONG);
            userAttacksFirst = true;
        }
        showDice.
        showDice.show();

        final MediaPlayer mp  = MediaPlayer.create(this, R.raw.battle_music1);
        final MediaPlayer attackSound = MediaPlayer.create(this, R.raw.sword_attack_short);
        final MediaPlayer fleeSound = MediaPlayer.create(this, R.raw.flee_sound);
        mp.start();
        mp.setLooping(true);

        healthBarColorMonitor();

        attackButton = (Button) findViewById(R.id.attackButton);
        attackButton.setBackgroundResource(R.drawable.woodbutton);
        attackButton.setTextColor(WHITE);
        attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attackSound.start();
                actionChosen();
                turnSequence(true);
            }
        });

        runButton = (Button) findViewById(R.id.runButton);
        runButton.setBackgroundResource(R.drawable.woodbutton);
        runButton.setTextColor(WHITE);
        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                mp.stop();
                attackSound.stop();
                actionChosen();
                mp.release();
                attackSound.release();
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
                                Intent intent = new Intent(v.getContext(), Dungeon.class);
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
