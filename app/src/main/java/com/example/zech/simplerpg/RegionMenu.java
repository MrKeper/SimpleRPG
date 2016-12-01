package com.example.zech.simplerpg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class RegionMenu extends Activity {

    //Current_info temp2 = (Current_info) getIntent().getSerializableExtra("temp");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_menu);


        //final Current_info temp2 = (Current_info) getIntent().getSerializableExtra("temp");

        //TextView textViewGold = (TextView) findViewById(R.id.textView2);
        //textViewGold.setText(String.valueOf(temp2.current_gold));




        Button dungeonButton = (Button) findViewById(R.id.dungeonButton);
        dungeonButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                //Intent intent1 = new Intent(getApplicationContext(), Shop.class);
                //startActivity(intent1);
            }
        });


        Button shopButton = (Button) findViewById(R.id.shopButton);
        shopButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent11 = new Intent(getApplicationContext(), Shop.class);
                //intent11.putExtra("tempObj", temp2);
                startActivity(intent11);
            }
        });



        Button saveLoadButton = (Button) findViewById(R.id.saveloadButton);
        saveLoadButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent3 = new Intent(getApplicationContext(), SaveAndLoad.class);
                startActivity(intent3);
            }
        });



        Button travelButton = (Button) findViewById(R.id.travelButton);
        travelButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent4 = new Intent(getApplicationContext(), Travel.class);
                startActivity(intent4);
            }
        });



        Button statsButton = (Button) findViewById(R.id.statsButton);
        statsButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent4 = new Intent(getApplicationContext(), stats_information.class);
                startActivity(intent4);
            }
        });


    }
}
