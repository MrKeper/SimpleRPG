package com.example.zech.simplerpg;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.graphics.Color.WHITE;

public class Travel extends AppCompatActivity {

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
        setContentView(R.layout.activity_travel);

        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");
        final MediaPlayer buttonSound  = MediaPlayer.create(this, R.raw.button_press);


        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setBackgroundResource(R.drawable.woodbutton);
        backButton.setTextColor(WHITE);
        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                Intent intent22 = new Intent(getApplicationContext(), RegionMenu.class);
                intent22.putExtra("user",user);
                startActivity(intent22);
                finishAfterSound(buttonSound);


            }
        });

        Button t1Button = (Button) findViewById(R.id.region1Button);
        t1Button.setBackgroundResource(R.drawable.woodbutton);
        t1Button.setTextColor(WHITE);
        t1Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                Intent intent22 = new Intent(getApplicationContext(), RegionMenu.class);
                intent22.putExtra("user",user);
                startActivity(intent22);
                finishAfterSound(buttonSound);


            }
        });

        Button t2Button = (Button) findViewById(R.id.region2Button);
        t2Button.setBackgroundResource(R.drawable.woodbutton);
        t2Button.setTextColor(WHITE);

        Button t3Button = (Button) findViewById(R.id.region3Button);
        t3Button.setBackgroundResource(R.drawable.woodbutton);
        t3Button.setTextColor(WHITE);

    }

}
