package com.example.zech.simplerpg;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveAndLoad extends AppCompatActivity {
    User_Character user;
    MediaPlayer buttonSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_and_load);


        user = (User_Character) getIntent().getSerializableExtra("user");

        buttonSound  = MediaPlayer.create(this, R.raw.button_press);

        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(save(user,"savefile.txt"))
                {
                    Toast save = Toast.makeText(getApplicationContext(),"Save Successful.",Toast.LENGTH_SHORT);
                    save.show();
                }
            }
        });


        Button loadButton = (Button) findViewById(R.id.loadButton);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSound.start();
                User_Character temp;
                temp = load("savefile.txt");
                if(user != null)
                {
                    user = temp;
                    Toast load = Toast.makeText(getApplicationContext(),"Load Successful.",Toast.LENGTH_SHORT);
                    load.show();
                }

            }
        });


        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                Intent intent4 = new Intent(getApplicationContext(), RegionMenu.class);
                intent4.putExtra("user",user);
                startActivity(intent4);
                finishAfterSound(buttonSound);
            }
        });

        Button toMain = (Button) findViewById(R.id.toMain);
        toMain.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                Intent intent4 = new Intent(getApplicationContext(), StartPage.class);
               // intent4.putExtra("user",user);
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

    public Boolean save (User_Character user, String filename)
    {
        FileOutputStream fos = null;
        try {
            fos = getApplicationContext().openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(user);
            os.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
//)
//        ;
        //}}
