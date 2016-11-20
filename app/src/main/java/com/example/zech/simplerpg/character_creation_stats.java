package com.example.zech.simplerpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class character_creation_stats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation_stats);
        Intent character_creation_stat = getIntent();
        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");
        final TextView spend_points_message = (TextView) findViewById(R.id.spendPointsMessage);
        spend_points_message.setVisibility(View.INVISIBLE);
        final TextView pointsRemaining = (TextView) findViewById(R.id.remainingPoints);
        pointsRemaining.setText("Points remaining: "+ user.current_addtional_stat_points);
        final TextView strength = (TextView) findViewById(R.id.StrView);
        strength.setText("STR: "+user.strength);
        final TextView intelligence= (TextView) findViewById(R.id.intView);
        intelligence.setText("INT: "+user.intelligence);
        final TextView dexterity= (TextView) findViewById(R.id.dexView);
        dexterity.setText("DEX: "+user.dexterity);
        final TextView willpower= (TextView) findViewById(R.id.wilView);
        willpower.setText("WIL: "+user.willpower);
        final TextView constitution= (TextView) findViewById(R.id.conView);
        constitution.setText("CON: "+user.constitution);
////////////////////////////////////////////////////////////////////////////////////////
        Button decrease_strength = (Button) findViewById(R.id.strDec);
        decrease_strength.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
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
        increase_strength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
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
        decrease_dexterity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
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
        increase_dexterity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
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
        Button decrease_intelligence = (Button) findViewById(R.id.intDec);
        decrease_intelligence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(user.intelligence > 1 )
                {
                    user.intelligence--;
                    user.current_addtional_stat_points++;
                    intelligence.setText("INT: "+user.intelligence);
                    pointsRemaining.setText("Points remaining: "+ user.current_addtional_stat_points);
                }

            }
        });

        Button increase_intelligence = (Button) findViewById(R.id.intInc);
        increase_intelligence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(user.current_addtional_stat_points > 0)
                {
                    user.intelligence++;
                    user.current_addtional_stat_points--;
                    intelligence.setText("INT: "+user.intelligence);
                    pointsRemaining.setText("Points remaining: "+ user.current_addtional_stat_points);
                }

            }
        });
////////////////////////////////////////////////////////////////////////////////////////
        Button decrease_willpower = (Button) findViewById(R.id.wilDec);
        decrease_willpower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
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
        increase_willpower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(user.current_addtional_stat_points > 0)
                {
                    user.willpower++;
                    user.current_addtional_stat_points--;
                    willpower.setText("STR: "+user.willpower);
                    pointsRemaining.setText("Points remaining: "+ user.current_addtional_stat_points);
                }

            }
        });
////////////////////////////////////////////////////////////////////////////////////////
        Button decrease_constitution = (Button) findViewById(R.id.conDec);
        decrease_constitution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(user.constitution > 1 )
                {
                    user.constitution--;
                    user.current_addtional_stat_points++;
                    constitution.setText("CON: "+user.constitution);
                    pointsRemaining.setText("Points remaining: "+ user.current_addtional_stat_points);
                }

            }
        });

        Button increase_constitution = (Button) findViewById(R.id.conInc);
        increase_constitution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(user.current_addtional_stat_points > 0)
                {
                    user.constitution++;
                    user.current_addtional_stat_points--;
                    constitution.setText("CON: "+user.constitution);
                    pointsRemaining.setText("Points remaining: "+ user.current_addtional_stat_points);
                }

            }
        });
////////////////////////////////////////////////////////////////////////////////////////
        Button back_button = (Button) findViewById(R.id.charStatsBack);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(v.getContext(), character_creation_sex.class);
                user.strength = 5;
                user.intelligence = 5;
                user.dexterity = 5;
                user.constitution = 5;
                user.willpower = 5;
                user.current_addtional_stat_points = 5;
                intent.putExtra("user",user);
                startActivity(intent);
                finish();
            }
        });

        Button confirm_button = (Button) findViewById(R.id.charStatConfirm);
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
                    startActivity(intent);
                    finish();
                }
            }
        });

        Button stat_info = (Button) findViewById(R.id.statInfo);
        stat_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(v.getContext(), stats_information.class);
                intent.putExtra("user",user);
                startActivity(intent);
                finish();
            }
        });
    }
}