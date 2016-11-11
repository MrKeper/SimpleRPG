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
        Intent character_creation_stats = getIntent();
        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");
        final TextView strength = (TextView) findViewById(R.id.StrView);
        strength.setText("STR: "+user.strength);
        TextView intelligence= (TextView) findViewById(R.id.intView);
        intelligence.setText("STR: "+user.intelligence);
        TextView dexterity= (TextView) findViewById(R.id.dexView);
        dexterity.setText("STR: "+user.dexterity);
        TextView willpower= (TextView) findViewById(R.id.wilView);
        willpower.setText("STR: "+user.willpower);
        TextView constitution= (TextView) findViewById(R.id.conView);
        constitution.setText("STR: "+user.constitution);
////////////////////////////////////////////////////////////////////////////////////////
        Button decrease_strength = (Button) findViewById(R.id.strDec);
        decrease_strength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                user.strength--;
                user.current_addtional_stat_points++;

            }
        });

        Button increase_strength = (Button) findViewById(R.id.strInc);
        increase_strength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
////////////////////////////////////////////////////////////////////////////////////////
        Button decrease_dexterity = (Button) findViewById(R.id.dexDec);
        decrease_dexterity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button increase_dexterity = (Button) findViewById(R.id.dexInc);
        increase_dexterity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
////////////////////////////////////////////////////////////////////////////////////////
        Button decrease_intelligence = (Button) findViewById(R.id.intDec);
        decrease_intelligence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button increase_intelligence = (Button) findViewById(R.id.intInc);
        increase_intelligence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
////////////////////////////////////////////////////////////////////////////////////////
        Button decrease_willpower = (Button) findViewById(R.id.wilDec);
        decrease_willpower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button increase_willpower = (Button) findViewById(R.id.wilInc);
        increase_willpower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
////////////////////////////////////////////////////////////////////////////////////////
        Button decrease_constitution = (Button) findViewById(R.id.conDec);
        decrease_constitution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button increase_constitution = (Button) findViewById(R.id.conInc);
        increase_constitution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
////////////////////////////////////////////////////////////////////////////////////////
        Button back_button = (Button) findViewById(R.id.charStatsBack);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(v.getContext(), character_creation_sex.class);
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

            }
        });
    }
}
