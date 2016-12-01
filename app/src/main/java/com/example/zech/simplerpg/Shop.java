package com.example.zech.simplerpg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Shop extends Activity {

    //Current_info temp2 = (Current_info) getIntent().getSerializableExtra("temp");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);


        //final Current_info temp2 = (Current_info) getIntent().getSerializableExtra("temp");


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






        Button newButton = (Button) findViewById(R.id.button);
        newButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent11 = new Intent(getApplicationContext(), ShopBuy.class);
                //intent11.putExtra("tempObj", temp2);
                startActivity(intent11);
            }
        });



    }
}
