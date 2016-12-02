package com.example.zech.simplerpg;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        TextView startMusicCredit = new TextView(this);
        startMusicCredit.setText("\nStart music: Enderal Soundtrack - Ancient Fathers - Marvin Kopp\n");
        startMusicCredit.setTextColor(WHITE);
        startMusicCredit.setTextSize(23);
        startMusicCredit.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(startMusicCredit);

        TextView woodenButtonCredit = new TextView(this);
        woodenButtonCredit.setText("\nwooden button from: http://www.ronraye.com/TestObjects.html\n");
        woodenButtonCredit.setTextColor(WHITE);
        woodenButtonCredit.setTextSize(23);
        woodenButtonCredit.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(woodenButtonCredit);


        TextView buttonSoundCredit = new TextView(this);
        buttonSoundCredit.setText("\nButton sounds: Final Fantasy VIII Sound Effects - Cursor Move\n");
        buttonSoundCredit.setTextColor(WHITE);
        buttonSoundCredit.setTextSize(23);
        buttonSoundCredit.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(buttonSoundCredit);

        TextView facesCredit = new TextView(this);
        facesCredit.setText("\nfaces from: https://vxresource.wordpress.com/category/resources/faces\n");
        facesCredit.setTextColor(WHITE);
        facesCredit.setTextSize(23);
        facesCredit.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(facesCredit);

        TextView mobImgCredit = new TextView(this);
        mobImgCredit.setText("\nhttps://vxresource.wordpress.com/category/resources/battlers/\n");
        mobImgCredit.setTextColor(WHITE);
        mobImgCredit.setTextSize(23);
        mobImgCredit.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(mobImgCredit);

        TextView introCredit = new TextView(this);
        introCredit.setText("\nIntro speech - Robin Gogberg - A Tale Untold\n");
        introCredit.setTextColor(WHITE);
        introCredit.setTextSize(23);
        introCredit.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(introCredit);

        TextView battleSoundAndLowHealthSpundCredit = new TextView(this);
        battleSoundAndLowHealthSpundCredit.setText("\nbattle music and low health sound - pokemon\n");
        battleSoundAndLowHealthSpundCredit.setTextColor(WHITE);
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
                finish();
            }
        });
    }
}
