package com.example.zech.simplerpg;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static android.graphics.Color.WHITE;

public class StartPage extends AppCompatActivity {

    public MediaPlayer mp;
    public MediaPlayer buttonSound;
    // faces from: https://vxresource.wordpress.com/category/resources/faces/
    //wooden button from: http://www.ronraye.com/TestObjects.html
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        Intent start_page_intent = getIntent();
        mp  = MediaPlayer.create(this, R.raw.backgroundmusic);
        mp.start();
        mp.setLooping(true);
        buttonSound  = MediaPlayer.create(this, R.raw.button_press);
        Button new_button = (Button) findViewById(R.id.newGame);
        new_button.setBackgroundResource(R.drawable.woodbutton);
        new_button.setTextColor(WHITE);
        new_button.setTextSize(20);
        new_button.setSoundEffectsEnabled(false);

        new_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n)
            {
                //intent char creation

                Intent intent = new Intent(n.getContext(), character_creation_name.class);
                buttonSound.start();
                startActivity(intent);
                mp.stop();
                finish();
            }
        });
        final Button load_button = (Button) findViewById(R.id.loadGame);
        load_button.setBackgroundResource(R.drawable.woodbutton);
        load_button.setTextColor(WHITE);
        load_button.setTextSize(20);
        load_button.setSoundEffectsEnabled(false);

        load_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View l)
            {
                //load save
                buttonSound.start();
                User_Character u = load("savefile.txt");
                if(u == null)
                {
                    //show no save message
                }
                else
                {
                    Intent intent = new Intent(l.getContext(), user_information_page.class);
                    mp.stop();
                    intent.putExtra("user",u);
                    startActivity(intent);
                    finish();
                }
            }
        });

        Button credit_button = (Button) findViewById(R.id.creditsButton);
        credit_button.setBackgroundResource(R.drawable.woodbutton);
        credit_button.setTextColor(WHITE);
        credit_button.setTextSize(20);
        credit_button.setSoundEffectsEnabled(false);

        credit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e)
            {
                mp.stop();
                buttonSound.start();
                finish();
            }
        });

        Button exit_button = (Button) findViewById(R.id.exitGame);
        exit_button.setBackgroundResource(R.drawable.woodbutton);
        exit_button.setTextColor(WHITE);
        exit_button.setTextSize(20);
        exit_button.setSoundEffectsEnabled(false);

        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e)
            {
                mp.stop();
                buttonSound.start();
                finish();
            }
        });


    }

    public void save (User_Character user, String filename)
    {
        FileOutputStream fos = null;
        try {
            fos = getApplicationContext().openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(user);
            os.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User_Character load (String filename)
    {
        FileInputStream fis;
        User_Character user = null;
        try {
            fis = getApplicationContext().openFileInput(filename);
            ObjectInputStream is = new ObjectInputStream(fis);
            user = (User_Character) is.readObject();
            is.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
