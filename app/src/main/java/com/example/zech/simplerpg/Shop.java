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


        //final Current_info temp2 = (Current_info) getIntent().getSerializableExtra("temp");


        SharedPreferences  mPrefs = getPreferences(MODE_PRIVATE);
        //SharedPreferences.Editor editor = mPrefs.edit();

        //SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedPref.edit();

        //Gson gson = new Gson();

        //String json = mPrefs.getString("MyObject", "");
        //Current_info obj = gson.fromJson(json, Current_info.class);

        //int cGold = obj.current_gold;
        //TextView textViewGold = (TextView) findViewById(R.id.textView4);
        //textViewGold.setText(String.valueOf(cGold));





        Button sellButton = (Button) findViewById(R.id.sellButton);
        sellButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent22 = new Intent(getApplicationContext(), ShopSell.class);
                //intent22.putExtra("tempObj", temp2);
                startActivity(intent22);





            }
        });




        Button buyButton = (Button) findViewById(R.id.buyButton);
        buyButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent11 = new Intent(getApplicationContext(), ShopBuy.class);
                //intent11.putExtra("tempObj", temp2);
                startActivity(intent11);



            }
        });



    }
}
