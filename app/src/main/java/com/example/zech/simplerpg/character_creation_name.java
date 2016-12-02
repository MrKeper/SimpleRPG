package com.example.zech.simplerpg;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static android.graphics.Color.WHITE;

public class character_creation_name extends AppCompatActivity {

    public MediaPlayer buttonSound;
    public User_Character u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation_name);
        Intent char_creation_name = getIntent();
        final TextView errorName = (TextView) findViewById(R.id.errorMessageName);
        errorName.setTextColor(WHITE);
        errorName.setTextSize(20);
        errorName.setVisibility(View.INVISIBLE);
        buttonSound = MediaPlayer.create(this, R.raw.button_press);
        final EditText enter_name_field = (EditText) findViewById(R.id.editTextCharName);
        Button back_button = (Button) findViewById(R.id.backCharName);
        back_button.setBackgroundResource(R.drawable.woodbutton);
        back_button.setTextColor(WHITE);
        back_button.setSoundEffectsEnabled(false);
        u = null;
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(v.getContext(), StartPage.class);
                buttonSound.start();
                startActivity(intent);
                finish();
            }
        });

        Button confirm_button = (Button) findViewById(R.id.confirmCharName);
        confirm_button.setBackgroundResource(R.drawable.woodbutton);
        confirm_button.setTextColor(WHITE);
        confirm_button.setSoundEffectsEnabled(false);

        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String player_name = enter_name_field.getText().toString();
                String[] name_split = player_name.split("");
                int space_count = 0;
                for(int i = 0; i < name_split.length; i++)
                {
                    if(name_split[i].equals(" "))
                    {
                        space_count++;
                    }
                }

                if(player_name.length() < 2 || player_name.length() > 15 || space_count == player_name.length())
                {
                    errorName.setVisibility(View.VISIBLE);
                    return;
                }

                u = new User_Character(player_name);
                save(u,"savefile.txt");
                Intent intent = new Intent(v.getContext(), character_creation_sex.class);
                intent.putExtra("user",u);
                buttonSound.start();
                startActivity(intent);
                finish();
                //make actor
                //proceed
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
