package com.example.zech.simplerpg;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.graphics.Color.WHITE;

public class Dungeon extends AppCompatActivity {

    Button enterBattle;
    Button enterBattle2;
    Button enterBattle3;
    Button back;
    ImageView completedImage;
    User_Character user;

    public void finishAfterSound(final MediaPlayer mp){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("finishAfterSound sleep ERROR");
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mp.release();
                        finish();
                    }
                });

            }
        }).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungeon);

        enterBattle = (Button) findViewById(R.id.enterBattle1);
        enterBattle2 = (Button) findViewById(R.id.enterBattle2);
        enterBattle3 = (Button) findViewById(R.id.enterBattle3);
        back = (Button) findViewById(R.id.dungeonBack);
        completedImage = (ImageView) findViewById(R.id.completedImage);
        user = (User_Character) getIntent().getSerializableExtra("user");

        enterBattle.setBackgroundResource(R.drawable.woodbutton);
        enterBattle.setTextColor(WHITE);
        enterBattle2.setBackgroundResource(R.drawable.woodbutton);
        enterBattle2.setTextColor(WHITE);
        enterBattle3.setBackgroundResource(R.drawable.woodbutton);
        enterBattle3.setTextColor(WHITE);

        //Initialize Dungeon Progress
        int dProgress = 0;
        try{
            dProgress = user.completedDungeons.get(0);
        }catch(Exception e){
            user.completedDungeons.add(0);
        }
        // Case 0 : None of the battles have been completed
        if(dProgress == 0){
            completedImage.setVisibility(View.INVISIBLE);
            enterBattle2.setText("Locked");
            enterBattle3.setText("Locked");
        }
        // Case 1 : Battle#1 completed
        if(dProgress == 1){
            completedImage.setVisibility(View.INVISIBLE);
            enterBattle2.setText("Battle#2");
            enterBattle3.setText("Locked");
        }
        // Case 2 : Battle#1&2 completed
        if(dProgress == 2){
            completedImage.setVisibility(View.INVISIBLE);
            enterBattle2.setText("Battle#2");
            enterBattle3.setText("Boss Battle");
        }
        // Case 3 : All 3 battles completed(Dungeon Complete)
        if(dProgress == 3){
            completedImage.setVisibility(View.VISIBLE);
            enterBattle2.setText("Battle#2");
            enterBattle3.setText("Boss Battle");
        }


        back.setBackgroundResource(R.drawable.woodbutton);
        back.setTextColor(WHITE);

        final MediaPlayer mp  = MediaPlayer.create(this, R.raw.dungeon_music);
        final MediaPlayer buttonSound = MediaPlayer.create(this, R.raw.button_press);
        mp.start();
        mp.setLooping(true);

        enterBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //My testing stats for user
                //user.current_health = 180;
                //user.base_health = 200;
                // MOB test
                //Mob(String name,String image_name,int id,int hp, int str, int def ,int wil, int dex)
                Mob snake = new Mob("snake","bigsnake",111,80,4,4,4,4);
                Intent intent = new Intent(v.getContext(), Battle.class);
                intent.putExtra("user",user);
                intent.putExtra("enemy",snake);

                mp.stop();
                mp.release();
                startActivity(intent);
                buttonSound.start();
                finishAfterSound(buttonSound);
            }
        });

        enterBattle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Testing dProgress
                user.completedDungeons.set(0,0);
                Intent intent = new Intent(v.getContext(), Dungeon.class);
                intent.putExtra("user",user);
                mp.stop();
                mp.release();
                startActivity(intent);
                buttonSound.start();
                finishAfterSound(buttonSound);
            }
        });


        enterBattle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Testing dProgress
                user.completedDungeons.set(0,user.completedDungeons.get(0)+1);
                Intent intent = new Intent(v.getContext(), Dungeon.class);
                intent.putExtra("user",user);
                mp.stop();
                mp.release();
                startActivity(intent);
                buttonSound.start();
                finishAfterSound(buttonSound);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RegionMenu.class);
                intent.putExtra("user",user);
                mp.stop();
                mp.release();
                startActivity(intent);
                buttonSound.start();
                finishAfterSound(buttonSound);
            }
        });


    }
}
