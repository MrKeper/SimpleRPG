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
    int bNum;
    Button attackButton;
    Button runButton;
    TextView userHPtext;
    TextView enemyHPtext;
    TextView chooseActiontext;
    ImageView enemyHitImage;
    ImageView userHitImage;
    ProgressBar userHealthProgress;
    ProgressBar enemyHealthProgress;
    ImageView monsterImage;
    ImageView userImage;
    Boolean isFleeing = false;
    Boolean userAttacksFirst = false;
    Boolean userWin = false;
    Boolean userLose = false;


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

    public void turnSequence(final boolean playerFirst){
        final MediaPlayer attackSound = MediaPlayer.create(this, R.raw.sword_attack_short);
        final MediaPlayer enemySound = MediaPlayer.create(this, R.raw.punch1);
        if(playerFirst){
            attackSound.start();
            changeEnemyHealthBar(enemy.current_health - (int)Math.max(user.strength*3-enemy.defense/2,1));
            userAttackAnimation();
        }else{
            enemySound.start();
            changeUserHealthBar(user.current_health - (int)Math.max(enemy.strength*3-user.defense/2,1));
            enemyAttackAnimation();
        }

        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Sleep not working:" + userHealthProgress.getProgress());
                }
                if(user.current_health == 0){
                    userLose = true;
                    attackSound.release();
                    enemySound.release();
                    return;
                }else if(enemy.current_health == 0){
                    userWin = true;
                    attackSound.release();
                    enemySound.release();
                    return;
                }
                if(playerFirst) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println("Sleep not working:" + userHealthProgress.getProgress());
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            enemySound.start();
                            changeUserHealthBar(user.current_health - (int)Math.max(enemy.strength*3-user.defense/2,1));
                            enemyAttackAnimation();
                        }
                    });

                }else{
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            attackSound.start();
                            changeEnemyHealthBar(enemy.current_health - (int)Math.max(user.strength*3-enemy.defense/2,1));
                            userAttackAnimation();
                        }
                    });

                }
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("Sleep not working:" + userHealthProgress.getProgress());
                }
                attackSound.release();
                enemySound.release();
                if(user.current_health == 0){
                    userLose = true;
                    return;
                }else if(enemy.current_health == 0){
                    userWin = true;
                    return;
                }
            }
        }).start();
    }

    public void healthBarColorMonitor(){
        final Handler handler = new Handler();
        final int userOrange = user.max_health / 2;
        final int userRed = user.max_health / 5;
        final int enemyOrange = enemy.base_health / 2;
        final int enemyRed = enemy.base_health / 5;
        //final MediaPlayer lowHPsound = MediaPlayer.create(this, R.raw.low_health_sound);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //boolean started = false;
                    while (user.current_health > 0 && enemy.current_health > 0) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (enemy.current_health < enemyOrange) {
                                    enemyHealthProgress.getProgressDrawable().setColorFilter(Color.rgb(255, 165, 0), PorterDuff.Mode.SRC_IN);
                                }
                                if (enemy.current_health < enemyRed) {
                                    enemyHealthProgress.getProgressDrawable().setColorFilter(Color.rgb(200, 0, 0), PorterDuff.Mode.SRC_IN);
                                }
                                if (user.current_health < userOrange) {
                                    userHealthProgress.getProgressDrawable().setColorFilter(Color.rgb(255, 165, 0), PorterDuff.Mode.SRC_IN);
                                }
                                if (user.current_health < userRed) {
                                    userHealthProgress.getProgressDrawable().setColorFilter(Color.rgb(200, 0, 0), PorterDuff.Mode.SRC_IN);

                                    if (!isFleeing) {
                                        //lowHPsound.start();
                                        //lowHPsound.setLooping(true);
                                        //started = true;
                                    } else if (isFleeing) {
                                        //lowHPsound.stop();
                                        //lowHPsound.release();
                                        return;
                                    }
                                }
                                if (userWin || userLose) {
                                    //lowHPsound.stop();
                                    //lowHPsound.release();
                                    return;
                                }
                            }
                        });
                        try {
                            Thread.sleep(300);
                        } catch (Exception e) {
                            System.out.println("ColorMonitor Sleep ERROR");
                        }
                    }
                    //lowHPsound.stop();
                    //lowHPsound.release();
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

    public void enemyAttackAnimation(){
        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {

                int i = 0;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userHitImage.setVisibility(View.VISIBLE);
                        //turnFinish();
                    }
                });
                while(i <= 10){
                    final int temp = i;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String name = "claw_attack"+temp;
                            int id = getResources().getIdentifier(name, "drawable", getPackageName());
                            userHitImage.setImageResource(id);

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
                        userHitImage.setVisibility(View.INVISIBLE);
                        //turnFinish();
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
        bNum = (int) getIntent().getSerializableExtra("bNum");
        userHPtext = (TextView)  findViewById(R.id.userHealthText);
        enemyHPtext = (TextView)  findViewById(R.id.enemyHealthText);
        chooseActiontext = (TextView)  findViewById(R.id.textchooseaction);
        userHealthProgress = (ProgressBar) findViewById(R.id.userHealthBar);
        enemyHealthProgress = (ProgressBar) findViewById(R.id.enemyHealthBar);
        enemyHitImage = (ImageView) findViewById(R.id.enemyHitImage);
        userHitImage = (ImageView) findViewById(R.id.userHitImage);
        userImage = (ImageView)  findViewById(R.id.userView);
        monsterImage = (ImageView)  findViewById(R.id.monsterView);
        TextView hpLabel = (TextView) findViewById(R.id.HPLabel);
        hpLabel.setText(user.actor_name+"'s HP:");
        TextView enemeyHpLabel = (TextView) findViewById(R.id.enemyHPLabel);
        enemeyHpLabel.setText(enemy.actor_name+"'s HP:");
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
        showDice.show();

        final MediaPlayer mp  = MediaPlayer.create(this, R.raw.battle_music1);
        //final MediaPlayer attackSound = MediaPlayer.create(this, R.raw.sword_attack_short);
        final MediaPlayer fleeSound = MediaPlayer.create(this, R.raw.flee_sound);
        mp.start();
        mp.setLooping(true);
        //final MediaPlayer lowHPsound = MediaPlayer.create(this, R.raw.low_health_sound);
        healthBarColorMonitor();

        attackButton = (Button) findViewById(R.id.attackButton);
        attackButton.setBackgroundResource(R.drawable.woodbutton);
        attackButton.setTextColor(WHITE);
        attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //attackSound.start();
                actionChosen();
                turnSequence(userAttacksFirst);
            }
        });

        runButton = (Button) findViewById(R.id.runButton);
        runButton.setBackgroundResource(R.drawable.woodbutton);
        runButton.setTextColor(WHITE);
        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                mp.stop();
                actionChosen();
                mp.release();
                //lowHPsound.stop();
                //lowHPsound.release();

                //MediaPlayer enemySound =
                /*if(!userAttacksFirst){
                    changeUserHealthBar(user.current_health - enemy.strength*3);
                    enemyAttackAnimation();
                }*/

                fleeSound.start();

                final Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        isFleeing = true;
                    }
                });


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Thread.sleep(1000);
                        }catch (Exception e){
                            System.out.println("FLEE Sleep not working:");
                        }
                        fleeSound.release();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(v.getContext(), Dungeon.class);
                                intent.putExtra("battleData", "flee");
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

        //Make thread for catching lose/win
        final Handler handler = new Handler();
        //isFleeing = true;
        final MediaPlayer dSound = MediaPlayer.create(this, R.raw.deathsound1);
        new Thread(new Runnable() {
            @Override
            public void run() {

                while(!userLose && !userWin) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println("FLEE Sleep not working:");
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if(isFleeing) return;
                        }
                    });


                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mp.stop();
                        mp.release();
                        //lowHPsound.stop();
                        //lowHPsound.release();
                        actionChosen();

                        fleeSound.release();
                    }
                });
                dSound.start();
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("FLEE Sleep not working:");
                }
                dSound.stop();
                dSound.release();


                if(userWin) {
                    Intent intent = new Intent(Battle.this, Dungeon.class);
                    intent.putExtra("battleData", "win"+bNum);
                    intent.putExtra("user", user);
                    startActivity(intent);
                    finish();
                }
                if(userLose) {
                    Intent intent = new Intent(Battle.this, Dungeon.class);
                    intent.putExtra("battleData", "lose");
                    intent.putExtra("user", user);
                    startActivity(intent);
                    finish();
                }
            }
        }).start();

    }
}
