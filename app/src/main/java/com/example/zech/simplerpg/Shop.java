package com.example.zech.simplerpg;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import static android.graphics.Color.WHITE;

public class Shop extends Activity {

    //Current_info temp2 = (Current_info) getIntent().getSerializableExtra("temp");

    public MediaPlayer buttonSound;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");

        buttonSound  = MediaPlayer.create(this, R.raw.button_press);



        Button sellButton = (Button) findViewById(R.id.sellButton);
        sellButton.setBackgroundResource(R.drawable.woodbutton);
        sellButton.setTextColor(WHITE);
        sellButton.setSoundEffectsEnabled(false);
        sellButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                Intent intent22 = new Intent(getApplicationContext(), ShopSell.class);
                intent22.putExtra("user", user);
                startActivity(intent22);
                finishAfterSound(buttonSound);

            }
        });




        Button buyButton = (Button) findViewById(R.id.buyButton);
        buyButton.setBackgroundResource(R.drawable.woodbutton);
        buyButton.setTextColor(WHITE);
        buyButton.setSoundEffectsEnabled(false);
        buyButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                Intent intent44 = new Intent(getApplicationContext(), shopNewBuy.class);
                intent44.putExtra("user", user);
                startActivity(intent44);
                finishAfterSound(buttonSound);
            }
        });



        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setBackgroundResource(R.drawable.woodbutton);
        backButton.setTextColor(WHITE);
        backButton.setSoundEffectsEnabled(false);
        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                Intent intent4 = new Intent(getApplicationContext(), RegionMenu.class);
                intent4.putExtra("user", user);
                startActivity(intent4);
                finishAfterSound(buttonSound);
            }
        });
    }

    public void finishAfterSound(final MediaPlayer mp){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(mp.getDuration());
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
