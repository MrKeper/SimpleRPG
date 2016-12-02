package com.example.zech.simplerpg;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class ShopSell extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_sell);


        SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

        //Show gold
        int cGold = sharedPref.getInt("current_gold", 0);
        TextView textViewGold = (TextView) findViewById(R.id.textView3);
        textViewGold.setText(String.valueOf(cGold));

        //Show potions
        int cPotions = sharedPref.getInt("current_potions", 0);
        //TextView textViewPotion = (TextView) findViewById(R.id.textView10);
        //textViewPotion.setText(String.valueOf(cPotions));



        /*Button sellButton = (Button) findViewById(R.id.sellPotionButton);
        sellButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                int tempGold = sharedPref.getInt("current_gold", 0);
                int tempPotion = sharedPref.getInt("current_potions", 0);


                if(tempPotion > 0) {
                    editor.putInt("current_potions", tempPotion-1);
                    editor.putInt("current_gold", tempGold + 10);
                    editor.apply();

                    TextView textViewGold = (TextView) findViewById(R.id.textView3);
                    textViewGold.setText(String.valueOf(String.valueOf(sharedPref.getInt("current_gold", 0))));

                    //TextView textViewPotion = (TextView) findViewById(R.id.textView10);
                    //textViewPotion.setText(String.valueOf(String.valueOf(sharedPref.getInt("current_potions", 0))));
                }
            }
        });*/





    }
}
