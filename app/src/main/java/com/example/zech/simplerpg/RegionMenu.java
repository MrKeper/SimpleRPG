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

        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");



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
                intent11.putExtra("user", user);
                startActivity(intent11);
                finish();
            }
        });



        Button saveLoadButton = (Button) findViewById(R.id.saveloadButton);
        saveLoadButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent3 = new Intent(getApplicationContext(), SaveAndLoad.class);
                intent3.putExtra("user",user);
                startActivity(intent3);
                finish();
            }
        });



        Button travelButton = (Button) findViewById(R.id.travelButton);
        travelButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent4 = new Intent(getApplicationContext(), Travel.class);
                intent4.putExtra("user",user);
                startActivity(intent4);
                finish();
            }
        });



        Button statsButton = (Button) findViewById(R.id.statsButton);
        statsButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent5 = new Intent(getApplicationContext(), stats_information.class);
                intent5.putExtra("user",user);
                startActivity(intent5);
                finish();
            }
        });


    }
}
