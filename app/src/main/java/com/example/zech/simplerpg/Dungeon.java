package com.example.zech.simplerpg;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.graphics.Color.WHITE;

public class Dungeon extends AppCompatActivity {

    Button enterBattle;
    Button back;
    User_Character user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungeon);

        enterBattle = (Button) findViewById(R.id.enterBattle1);
        back = (Button) findViewById(R.id.dungeonBack);
        user = (User_Character) getIntent().getSerializableExtra("user");

        enterBattle.setBackgroundResource(R.drawable.woodbutton);
        enterBattle.setTextColor(WHITE);
        back.setBackgroundResource(R.drawable.woodbutton);
        back.setTextColor(WHITE);

        final MediaPlayer mp  = MediaPlayer.create(this, R.raw.dungeon_music);
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
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Testing.class);
                intent.putExtra("user",user);
                mp.stop();
                mp.release();
                startActivity(intent);
                finish();
            }
        });


    }
}
