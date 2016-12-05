package com.example.zech.simplerpg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.graphics.Color.GRAY;
import static android.graphics.Color.WHITE;


public class RegionMenu extends Activity {

    //Current_info temp2 = (Current_info) getIntent().getSerializableExtra("temp");

    public MediaPlayer buttonSound;
    public MediaPlayer townMusic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_menu);

        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");

        buttonSound  = MediaPlayer.create(this, R.raw.button_press);
        townMusic = MediaPlayer.create(this, R.raw.town_soundtrack_1);
        townMusic.setLooping(true);
        townMusic.start();
        Button dungeonButton = (Button) findViewById(R.id.dungeonButton);
        dungeonButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                townMusic.release();
                Intent intent = new Intent(getApplicationContext(), Dungeon.class);
                intent.putExtra("user", user);
                startActivity(intent);
                finishAfterSound(buttonSound);
            }
        });


        Button shopButton = (Button) findViewById(R.id.shopButton);
        shopButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                townMusic.release();
                Intent intent11 = new Intent(getApplicationContext(), Shop.class);
                intent11.putExtra("user", user);
                startActivity(intent11);
                finishAfterSound(buttonSound);
            }
        });



        Button saveLoadButton = (Button) findViewById(R.id.saveloadButton);
        saveLoadButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                townMusic.release();
                Intent intent3 = new Intent(getApplicationContext(), SaveAndLoad.class);
                intent3.putExtra("user",user);
                startActivity(intent3);
                finishAfterSound(buttonSound);
            }
        });



        Button travelButton = (Button) findViewById(R.id.travelButton);
        travelButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                Intent intent4 = new Intent(getApplicationContext(), Travel.class);
                intent4.putExtra("user",user);
                startActivity(intent4);
                finishAfterSound(buttonSound);
            }
        });



        Button playerInfoButton = (Button) findViewById(R.id.playerInfoButton);
        playerInfoButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                townMusic.release();
                Intent intent5 = new Intent(getApplicationContext(), user_information_page.class);
                intent5.putExtra("user",user);
                startActivity(intent5);
                finishAfterSound(buttonSound);
            }
        });

        Button questBoard = (Button) findViewById(R.id.questBoard);
        questBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSound.start();
                townMusic.release();
                Intent intent5 = new Intent(getApplicationContext(), town1QuestBoard.class);
                intent5.putExtra("user",user);
                startActivity(intent5);
                finishAfterSound(buttonSound);
            }
        });

        TextView regionName = (TextView) findViewById(R.id.regionName);
        regionName.setText("Ironforge");
        regionName.setTextColor(GRAY);
        regionName.setTextSize(35);
        regionName.setBackgroundColor(WHITE);

    }

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

}
