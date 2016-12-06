package com.example.zech.simplerpg;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.graphics.Color.WHITE;

public class credits extends AppCompatActivity {
    public ViewGroup layout;
    public MediaPlayer buttonSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        layout = (ViewGroup) findViewById(R.id.creditLayout);
        buttonSound  = MediaPlayer.create(this, R.raw.button_press);

        // faces from: https://vxresource.wordpress.com/category/resources/faces/
        //wooden button from: http://www.ronraye.com/TestObjects.html
        //mobs: https://vxresource.wordpress.com/category/resources/battlers/
        //Button sounds: Final Fantasy VIII Sound Effects - Cursor Move
        //Start music: Enderal Soundtrack - Ancient Fathers - Marvin Kopp
        //Intro speech - Robin Gogberg - A Tale Untold
        //battle music and low health sound - pokemon
        TextView creditsText = new TextView(this);
        creditsText.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        creditsText.setText("Credits:\n");
        creditsText.setTextColor(WHITE);
        creditsText.setTextSize(23);
        creditsText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(creditsText);

        TextView startMusicCredit = new TextView(this);
        startMusicCredit.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        startMusicCredit.setText("\nStart music:\nEnderal Soundtrack - Ancient Fathers - Marvin Kopp\n");
        startMusicCredit.setTextColor(WHITE);
        startMusicCredit.setTextSize(23);
        startMusicCredit.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(startMusicCredit);

        TextView woodenButtonCredit = new TextView(this);
        woodenButtonCredit.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        woodenButtonCredit.setText("\nwooden button from:\nhttp://www.ronraye.com/TestObjects.html\n");
        woodenButtonCredit.setTextColor(WHITE);
        woodenButtonCredit.setTextSize(23);
        woodenButtonCredit.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(woodenButtonCredit);


        TextView buttonSoundCredit = new TextView(this);
        buttonSoundCredit.setText("\nButton sounds:\nFinal Fantasy VIII Sound Effects - Cursor Move\n");
        buttonSoundCredit.setTextColor(WHITE);
        buttonSoundCredit.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        buttonSoundCredit.setTextSize(23);
        buttonSoundCredit.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(buttonSoundCredit);

        TextView facesCredit = new TextView(this);
        facesCredit.setText("\nFace Images from:\nhttps://vxresource.wordpress.com/category/resources/faces\n");
        facesCredit.setTextColor(WHITE);
        facesCredit.setTextSize(23);
        facesCredit.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        facesCredit.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(facesCredit);

        TextView mobImgCredit = new TextView(this);
        mobImgCredit.setText("\nMob Images from:\nhttps://vxresource.wordpress.com/category/resources/battlers/\n");
        mobImgCredit.setTextColor(WHITE);
        mobImgCredit.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        mobImgCredit.setTextSize(23);
        mobImgCredit.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(mobImgCredit);

        TextView introCredit = new TextView(this);
        introCredit.setText("\nIntro speech - Robin Gogberg - A Tale Untold\n");
        introCredit.setTextColor(WHITE);
        introCredit.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        introCredit.setTextSize(23);
        introCredit.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(introCredit);

        TextView battleSoundAndLowHealthSpundCredit = new TextView(this);
        battleSoundAndLowHealthSpundCredit.setText("\nbattle music and low health sound - pokemon\n");
        battleSoundAndLowHealthSpundCredit.setTextColor(WHITE);
        battleSoundAndLowHealthSpundCredit.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        battleSoundAndLowHealthSpundCredit.setTextSize(23);
        battleSoundAndLowHealthSpundCredit.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(battleSoundAndLowHealthSpundCredit);

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setBackgroundResource(R.drawable.woodbutton);
        backButton.setTextColor(WHITE);
        backButton.setTextSize(20);
        backButton.setSoundEffectsEnabled(false);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSound.start();
                finishAfterSound(buttonSound);
                //finsish();
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
}
