package com.example.zech.simplerpg;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.graphics.Color.WHITE;
import static android.graphics.Color.RED;

public class AllocateStatsUserInfo extends AppCompatActivity {
    public int initStr;
    public int initDef;
    public int initWil;
    public int initDex;
    public int initCon;
    public MediaPlayer buttonSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allocate_stats_user_info);
        Intent character_creation_stat = getIntent();
        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");
        buttonSound = MediaPlayer.create(this,R.raw.button_press);
        if(user.experince_bar >= user.experince_needed_to_level)
        {
            user.levelUp();
        }
        initStr = user.strength;
        initDef = user.defense;
        initWil = user.willpower;
        initDex = user.dexterity;
        initCon = user.constitution;

        final TextView spend_points_message = (TextView) findViewById(R.id.spendPointsMessage);
        spend_points_message.setVisibility(View.INVISIBLE);
        spend_points_message.setTextColor(RED);
        spend_points_message.setTextSize(18);
        final TextView pointsRemaining = (TextView) findViewById(R.id.remainingPoints);
        pointsRemaining.setText("Points remaining: " + user.current_addtional_stat_points);
        pointsRemaining.setTextColor(WHITE);
        pointsRemaining.setTextSize(19);
        final TextView strength = (TextView) findViewById(R.id.strView);
        strength.setText("STR: " + user.strength);
        strength.setTextColor(WHITE);
        strength.setTextSize(17);
        final TextView defense = (TextView) findViewById(R.id.defView);
        defense.setText("DEF: " + user.defense);
        defense.setTextColor(WHITE);
        defense.setTextSize(17);
        final TextView dexterity = (TextView) findViewById(R.id.dexView);
        dexterity.setText("DEX: " + user.dexterity);
        dexterity.setTextColor(WHITE);
        dexterity.setTextSize(17);
        final TextView willpower = (TextView) findViewById(R.id.wilView);
        willpower.setText("WIL: " + user.willpower);
        willpower.setTextColor(WHITE);
        willpower.setTextSize(17);
        final TextView constitution = (TextView) findViewById(R.id.conView);
        constitution.setText("CON: " + user.constitution);
        constitution.setTextColor(WHITE);
        constitution.setTextSize(17);
////////////////////////////////////////////////////////////////////////////////////////
        Button decrease_strength = (Button) findViewById(R.id.strDec);
        decrease_strength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.strength-1 >= initStr)
                {
                    if (user.strength > 1) {
                        user.strength--;
                        user.current_addtional_stat_points++;
                        buttonSound.start();
                        strength.setText("STR: " + user.strength);
                        pointsRemaining.setText("Points remaining: " + user.current_addtional_stat_points);
                    }
                }
            }
        });

        Button increase_strength = (Button) findViewById(R.id.strInc);
        increase_strength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.current_addtional_stat_points > 0) {
                    user.strength++;
                    buttonSound.start();
                    user.current_addtional_stat_points--;
                    strength.setText("STR: " + user.strength);
                    pointsRemaining.setText("Points remaining: " + user.current_addtional_stat_points);
                }

            }
        });
////////////////////////////////////////////////////////////////////////////////////////
        Button decrease_dexterity = (Button) findViewById(R.id.dexDec);
        decrease_dexterity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.dexterity-1 >= initDex)
                {
                    if (user.dexterity > 1)
                    {
                        user.dexterity--;
                        user.current_addtional_stat_points++;
                        buttonSound.start();
                        dexterity.setText("DEX: " + user.dexterity);
                        pointsRemaining.setText("Points remaining: " + user.current_addtional_stat_points);
                    }
                }
            }
        });

        Button increase_dexterity = (Button) findViewById(R.id.dexInc);
        increase_dexterity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.current_addtional_stat_points > 0) {
                    user.dexterity++;
                    user.current_addtional_stat_points--;
                    buttonSound.start();
                    dexterity.setText("DEX: " + user.dexterity);
                    pointsRemaining.setText("Points remaining: " + user.current_addtional_stat_points);
                }

            }
        });
////////////////////////////////////////////////////////////////////////////////////////
        Button decrease_defense = (Button) findViewById(R.id.defDec);
        decrease_defense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.defense-1 >= initDef)
                {
                    if (user.defense > 1) {
                        user.defense--;
                        buttonSound.start();
                        user.current_addtional_stat_points++;
                        defense.setText("DEF: " + user.defense);
                        pointsRemaining.setText("Points remaining: " + user.current_addtional_stat_points);
                    }
                }
            }
        });

        Button increase_defense = (Button) findViewById(R.id.defInc);
        increase_defense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.current_addtional_stat_points > 0) {
                    user.defense++;
                    buttonSound.start();
                    user.current_addtional_stat_points--;
                    defense.setText("DEF: " + user.defense);
                    pointsRemaining.setText("Points remaining: " + user.current_addtional_stat_points);
                }

            }
        });
////////////////////////////////////////////////////////////////////////////////////////
        Button decrease_willpower = (Button) findViewById(R.id.wilDec);
        decrease_willpower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.willpower-1 >= initWil)
                {
                    if (user.willpower > 1) {
                        user.willpower--;
                        buttonSound.start();
                        user.current_addtional_stat_points++;
                        willpower.setText("WIL: " + user.willpower);
                        pointsRemaining.setText("Points remaining: " + user.current_addtional_stat_points);
                    }
                }
            }
        });

        Button increase_willpower = (Button) findViewById(R.id.wilInc);
        increase_willpower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.current_addtional_stat_points > 0) {
                    user.willpower++;
                    buttonSound.start();
                    user.current_addtional_stat_points--;
                    willpower.setText("WIL: " + user.willpower);
                    pointsRemaining.setText("Points remaining: " + user.current_addtional_stat_points);
                }

            }
        });
////////////////////////////////////////////////////////////////////////////////////////
        Button decrease_constitution = (Button) findViewById(R.id.conDec);
        decrease_constitution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.constitution-1 >= initCon)
                {
                    if (user.constitution > 1) {
                        user.constitution--;
                        buttonSound.start();
                        user.current_addtional_stat_points++;
                        user.max_health = 50 + user.constitution*10;
                        constitution.setText("CON: " + user.constitution);
                        pointsRemaining.setText("Points remaining: " + user.current_addtional_stat_points);
                    }
                }
            }
        });

        Button increase_constitution = (Button) findViewById(R.id.conInc);
        increase_constitution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.current_addtional_stat_points > 0) {
                    user.constitution++;
                    buttonSound.start();
                    user.current_addtional_stat_points--;
                    user.max_health = 50 + user.constitution*10;
                    constitution.setText("CON: " + user.constitution);
                    pointsRemaining.setText("Points remaining: " + user.current_addtional_stat_points);
                }

            }
        });
////////////////////////////////////////////////////////////////////////////////////////
        Button back_button = (Button) findViewById(R.id.backButton);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSound.start();
                if(user.current_addtional_stat_points != 0)
                {
                    spend_points_message.setVisibility(View.VISIBLE);
                }
                else
                {
                    user.current_health = user.max_health;
                    Intent intent = new Intent(v.getContext(), user_information_page.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                    finishAfterSound(buttonSound);
                    //finish();
                }
            }
        });

        Button stat_info = (Button) findViewById(R.id.statInfo);
        stat_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), stats_information.class);
                //intent.putExtra("user", user);
                startActivity(intent);
                //finish();
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
