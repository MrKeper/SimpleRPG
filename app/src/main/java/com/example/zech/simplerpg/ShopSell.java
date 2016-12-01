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
        String cGold = sharedPref.getString("username","");
        TextView textViewGold = (TextView) findViewById(R.id.textView3);
        textViewGold.setText(cGold);

        //System.out.println("gogo\n");
        //System.out.println(cGold);


        //final Current_info temp2 = (Current_info) getIntent().getSerializableExtra("temp");


        //TextView textViewGold = (TextView) findViewById(R.id.textView3);
        //textViewGold.setText(String.valueOf(temp2.current_gold));


        Button sellButton = (Button) findViewById(R.id.goldButton);
        sellButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                //Current_info temptemp = ((Current_info) getApplicationContext());
                //int globalVarValue = temptemp.getGold();
                //(temp2.current_gold) += 10;
                //temptemp.current_gold += 10;
            }
        });





    }
}
