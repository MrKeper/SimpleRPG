package com.example.zech.simplerpg;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.graphics.Color.WHITE;

public class prologue_one extends AppCompatActivity {
    public MediaPlayer buttonSound;
    public MediaPlayer intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_one);
        Intent prologue1 = getIntent();
        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");
        buttonSound = MediaPlayer.create(this, R.raw.button_press);
        intro =  MediaPlayer.create(this, R.raw.intro);
        intro.start();
        TextView message = (TextView) findViewById(R.id.prologueOneText);
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
        Button proceed = (Button) findViewById(R.id.prologueOneProceed);
        proceed.setBackgroundResource(R.drawable.woodbutton);
        proceed.setTextColor(WHITE);
        proceed.setSoundEffectsEnabled(false);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSound.start();
                Intent intent = new Intent(v.getContext(), Testing.class);
                intent.putExtra("user",user);
                startActivity(intent);
                finish();
            }
        });
    }
}
