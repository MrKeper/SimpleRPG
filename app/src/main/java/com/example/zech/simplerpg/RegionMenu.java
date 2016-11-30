package com.example.zech.simplerpg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegionMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_menu);


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

                Intent intent2 = new Intent(getApplicationContext(), Shop.class);
                //intent2.putExtra("objTown", object1);
                startActivity(intent2);
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
