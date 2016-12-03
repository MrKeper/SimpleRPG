package com.example.zech.simplerpg;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

public class Shop extends Activity {

    //Current_info temp2 = (Current_info) getIntent().getSerializableExtra("temp");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");





        Button sellButton = (Button) findViewById(R.id.sellButton);
        sellButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent22 = new Intent(getApplicationContext(), ShopSell.class);
                intent22.putExtra("user", user);
                startActivity(intent22);
                finish();

            }
        });




        Button buyButton = (Button) findViewById(R.id.buyButton);
        buyButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent44 = new Intent(getApplicationContext(), shopNewBuy.class);
                intent44.putExtra("user", user);
                startActivity(intent44);
                finish();
            }
        });



        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent4 = new Intent(getApplicationContext(), RegionMenu.class);
                intent4.putExtra("user", user);
                startActivity(intent4);
                finish();
            }
        });


    }
}
