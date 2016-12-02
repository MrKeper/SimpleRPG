package com.example.zech.simplerpg;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.graphics.Color.WHITE;

public class character_creation_stats extends AppCompatActivity {
    public MediaPlayer buttonSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation_stats);
        Intent character_creation_stat = getIntent();
        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");
        buttonSound = MediaPlayer.create(this, R.raw.button_press);
        final TextView spend_points_message = (TextView) findViewById(R.id.spendPointsMessage);
        spend_points_message.setVisibility(View.INVISIBLE);
        final TextView pointsRemaining = (TextView) findViewById(R.id.remainingPoints);
        pointsRemaining.setText("Points remaining: "+ user.current_addtional_stat_points);
        final TextView strength = (TextView) findViewById(R.id.strView);
        strength.setText("STR: "+user.strength);
        final TextView defense= (TextView) findViewById(R.id.defView);
        defense.setText("DEF: "+user.defense);
        final TextView dexterity= (TextView) findViewById(R.id.dexView);
        dexterity.setText("DEX: "+user.dexterity);
        final TextView willpower= (TextView) findViewById(R.id.wilView);
        willpower.setText("WIL: "+user.willpower);
        final TextView constitution= (TextView) findViewById(R.id.conView);
        constitution.setText("CON: "+user.constitution);
////////////////////////////////////////////////////////////////////////////////////////
        Button decrease_strength = (Button) findViewById(R.id.strDec);
        decrease_strength.setSoundEffectsEnabled(false);
        decrease_strength.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                buttonSound.start();
                if(user.strength > 1)
                {
                    user.strength--;
                    user.current_addtional_stat_points++;
                    strength.setText("STR: "+user.strength);
                    pointsRemaining.setText("Points remaining: "+ user.current_addtional_stat_points);
                }

            }
        });

        Button increase_strength = (Button) findViewById(R.id.strInc);
        increase_strength.setSoundEffectsEnabled(false);
        increase_strength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonSound.start();
                if(user.current_addtional_stat_points > 0)
                {
                    user.strength++;
                    user.current_addtional_stat_points--;
                    strength.setText("STR: "+user.strength);
                    pointsRemaining.setText("Points remaining: "+ user.current_addtional_stat_points);
                }

            }
        });
////////////////////////////////////////////////////////////////////////////////////////
        Button decrease_dexterity = (Button) findViewById(R.id.dexDec);
        decrease_dexterity.setSoundEffectsEnabled(false);
        decrease_dexterity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonSound.start();
                if( user.dexterity > 1 )
                {
                    user.dexterity--;
                    user.current_addtional_stat_points++;
                    dexterity.setText("DEX: "+user.dexterity);
                    pointsRemaining.setText("Points remaining: "+ user.current_addtional_stat_points);
                }

            }
        });

        Button increase_dexterity = (Button) findViewById(R.id.dexInc);
        increase_dexterity.setSoundEffectsEnabled(false);
        increase_dexterity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonSound.start();
                if(user.current_addtional_stat_points > 0)
                {
                    user.dexterity++;
                    user.current_addtional_stat_points--;
                    dexterity.setText("DEX: "+user.dexterity);
                    pointsRemaining.setText("Points remaining: "+ user.current_addtional_stat_points);
                }

            }
        });
////////////////////////////////////////////////////////////////////////////////////////
        Button decrease_defense = (Button) findViewById(R.id.defDec);
        decrease_defense.setSoundEffectsEnabled(false);
        decrease_defense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonSound.start();
                if(user.defense > 1 )
                {
                    user.defense--;
                    user.current_addtional_stat_points++;
                    defense.setText("DEF: "+user.defense);
                    pointsRemaining.setText("Points remaining: "+ user.current_addtional_stat_points);
                }

            }
        });

        Button increase_defense = (Button) findViewById(R.id.defInc);
        increase_defense.setSoundEffectsEnabled(false);
        increase_defense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonSound.start();
                if(user.current_addtional_stat_points > 0)
                {
                    user.defense++;
                    user.current_addtional_stat_points--;
                    defense.setText("DEF: "+user.defense);
                    pointsRemaining.setText("Points remaining: "+ user.current_addtional_stat_points);
                }

            }
        });
////////////////////////////////////////////////////////////////////////////////////////
        Button decrease_willpower = (Button) findViewById(R.id.wilDec);
        decrease_willpower.setSoundEffectsEnabled(false);
        decrease_willpower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonSound.start();
                if(user.willpower > 1)
                {
                    user.willpower--;
                    user.current_addtional_stat_points++;
                    willpower.setText("WIL: "+user.willpower);
                    pointsRemaining.setText("Points remaining: "+ user.current_addtional_stat_points);
                }

            }
        });

        Button increase_willpower = (Button) findViewById(R.id.wilInc);
        increase_willpower.setSoundEffectsEnabled(false);
        increase_willpower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonSound.start();
                if(user.current_addtional_stat_points > 0)
                {
                    user.willpower++;
                    user.current_addtional_stat_points--;
                    willpower.setText("WIL: "+user.willpower);
                    pointsRemaining.setText("Points remaining: "+ user.current_addtional_stat_points);
                }

            }
        });
////////////////////////////////////////////////////////////////////////////////////////
        Button decrease_constitution = (Button) findViewById(R.id.conDec);
        decrease_constitution.setSoundEffectsEnabled(false);
        decrease_constitution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonSound.start();
                if(user.constitution > 1 )
                {
                    user.constitution--;
                    user.current_addtional_stat_points++;
                    user.max_health = 100 + user.constitution*10;
                    user.current_health = user.max_health;
                    constitution.setText("CON: "+user.constitution);
                    pointsRemaining.setText("Points remaining: "+ user.current_addtional_stat_points);
                }

            }
        });

        Button increase_constitution = (Button) findViewById(R.id.conInc);
        increase_constitution.setSoundEffectsEnabled(false);
        increase_constitution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonSound.start();
                if(user.current_addtional_stat_points > 0)
                {
                    user.constitution++;
                    user.current_addtional_stat_points--;
                    user.max_health = 100 + user.constitution*10;
                    user.current_health = user.max_health;
                    constitution.setText("CON: "+user.constitution);
                    pointsRemaining.setText("Points remaining: "+ user.current_addtional_stat_points);
                }

            }
        });
////////////////////////////////////////////////////////////////////////////////////////
        Button back_button = (Button) findViewById(R.id.charStatsBack);
        back_button.setBackgroundResource(R.drawable.woodbutton);
        back_button.setTextColor(WHITE);
        back_button.setSoundEffectsEnabled(false);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(v.getContext(), character_creation_sex.class);
                user.strength = 5;
                user.defense = 5;
                user.dexterity = 5;
                user.constitution = 5;
                user.willpower = 5;
                user.current_addtional_stat_points = 5;
                intent.putExtra("user",user);
                buttonSound.start();
                startActivity(intent);
                try {
                    Thread.sleep(126);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                buttonSound.stop();
                finish();
            }
        });

        Button confirm_button = (Button) findViewById(R.id.charStatConfirm);
        confirm_button.setBackgroundResource(R.drawable.woodbutton);
        confirm_button.setTextColor(WHITE);
        confirm_button.setTextSize(12);
        confirm_button.setSoundEffectsEnabled(false);
        confirm_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(user.current_addtional_stat_points != 0)
                {
                    spend_points_message.setVisibility(View.VISIBLE);
                }
                else
                {
                    Intent intent = new Intent(v.getContext(), prologue_one.class);
                    intent.putExtra("user",user);
                    buttonSound.start();
                    startActivity(intent);
                    try {
                        Thread.sleep(126);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    buttonSound.stop();
                    finish();
                }
            }
        });

        Button stat_info = (Button) findViewById(R.id.statInfo);
        stat_info.setSoundEffectsEnabled(false);
        stat_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(v.getContext(), stats_information.class);
                //intent.putExtra("user",user);
                buttonSound.start();
                startActivity(intent);
                try {
                    Thread.sleep(126);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                buttonSound.stop();
                //finish();
            }
        });
    }
}
