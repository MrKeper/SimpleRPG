package com.example.zech.simplerpg;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class StartPage extends AppCompatActivity {

    public MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        Intent start_page_intent = getIntent();
        mp  = MediaPlayer.create(this, R.raw.backgroundmusic);
        mp.start();
        mp.setLooping(true);
        Button new_button = (Button) findViewById(R.id.newGame);
        //new_button.getBackground().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.MULTIPLY);
        new_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n)
            {
                //intent char creation

                Intent intent = new Intent(n.getContext(), character_creation_name.class);
                mp.stop();
                startActivity(intent);
                finish();
            }
        });
        Button load_button = (Button) findViewById(R.id.loadGame);
        //load_button.getBackground().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.MULTIPLY);
        load_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View l)
            {
                //load save
                User_Character user = new User_Character("Tes");
                user.sex = "male";
                user.experince_bar = 101;
                Mob test_mob = new Mob("Great TestMob Onazuka",1000,1,10,3,4,5,8,6);
                int[] stat_change = new int[7];
                Weapon test_weapon = new Weapon("Demon Slaying Wooden Sword",null,"A wooden sword",stat_change);
                Weapon god_weapon = new Weapon("God Slaying Wooden Sword",null,"A wooden sword",stat_change);
                Consumable water = new Consumable("Water",null,"A bottle of water.",stat_change);
                Quest test_quest = new Quest("TEST","All your base are belong to us","Complete the game",1,"Holy Grail",1000,25,test_weapon);
                user.inventory.add(god_weapon);
                user.inventory.add(water);
                user.quest_list.add(test_quest);
                Intent intent = new Intent(l.getContext(), user_information_page.class);
                intent.putExtra("user",user);
                startActivity(intent);
                finish();
                mp.stop();
            }
        });
        Button exit_button = (Button) findViewById(R.id.exitGame);
        //exit_button.getBackground().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.MULTIPLY);
        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e)
            {
                finish();
                mp.stop();
            }
        });


    }

}
