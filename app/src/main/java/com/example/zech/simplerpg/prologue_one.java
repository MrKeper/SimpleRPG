package com.example.zech.simplerpg;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;

import static android.graphics.Color.WHITE;

public class prologue_one extends AppCompatActivity {
    public MediaPlayer buttonSound;
    public MediaPlayer intro;
    public ScrollView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_one);
        Intent prologue1 = getIntent();
        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");
        save(user,"savefile.txt");
        buttonSound = MediaPlayer.create(this, R.raw.button_press);
        intro =  MediaPlayer.create(this, R.raw.intro);
        intro.start();
        sv  =(ScrollView)findViewById(R.id.scrV);
        TextView message = (TextView) findViewById(R.id.prologueOneText);
        message.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        message.setText("There once was a legend\n" +
                "About treasures and gold\n" +
                "About all thing’s magic \n" +
                "About a girl and her boy\n" +
                "\n" +
                "Wizards and dragons \n" +
                "All creatures you’ll find\n" +
                "In the depth of your dreams\n" +
                "In your heart in your mind\n" +
                "\n" +
                "Far across the land \n" +
                "High above the sea \n" +
                "There’s a land of adventure\n" +
                "A home for you and me \n" +
                "\n" +
                "This is your path\n" +
                "To greatness you are sworn \n" +
                "The world will come to witness \n" +
                "A true hero reborn\n" +
                "\n" +
                "Now...Take a deep breath \n" +
                "As the story unfolds \n" +
                "Because this is the legend \n" +
                "Of A Tale Untold \n");
        sendScroll();
        Button proceed = (Button) findViewById(R.id.prologueOneProceed);
        proceed.setBackgroundResource(R.drawable.woodbutton);
        proceed.setTextColor(WHITE);
        proceed.setSoundEffectsEnabled(false);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSound.start();
                intro.release();
                Intent intent = new Intent(v.getContext(), RegionMenu.class);
                intent.putExtra("user",user);
                startActivity(intent);
                finishAfterSound(buttonSound);
                //finsih();
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

    private void sendScroll(){
        final Handler handler = new Handler();
        ObjectAnimator.ofInt(sv, "scrollY",  10000).setDuration(165000).start();

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                try {Thread.sleep(36000);} catch (InterruptedException e) {}
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //sv.smoothScrollTo(0,View.FOCUS_DOWN);

                    }
                });
            }
        }).start();*/
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
