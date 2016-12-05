package com.example.zech.simplerpg;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.YELLOW;

public class shopNewBuy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_new_buy);

        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");

        final ArrayList<Item> newInv= user.inventory;
        int listSize = newInv.size();
        String[] foods = new String[listSize];
        //String[] foods = {"empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty"};
        for (int i = 0; i < newInv.size(); i++)
        {
            String tempName = newInv.get(i).name;
            //int tempPrice = newInv.get(i).value;
            foods[i] = tempName;
        }

        ListAdapter adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);
        final ListView list = (ListView) findViewById(R.id.theList);
        list.setAdapter(adap);
        list.setBackgroundColor(Color.parseColor("#ffffffff"));



        int gold = user.current_gold;
        TextView t = (TextView)findViewById(R.id.goldText);
        t.setTextColor(YELLOW);
        t.setBackgroundColor(BLACK);
        t.setText(String.valueOf(gold));



        Button buyWater = (Button) findViewById(R.id.button);
        buyWater.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(user.current_gold >= 5)
                {

                    int[] item_stat_change = {10, 0, 0, 0, 0, 0};
                    Consumable water = new Consumable("Water", null, "A bottle of water (+10 HP).", item_stat_change, 0);
                    user.inventory.add(water);
                    user.current_gold -= 5;
                    //}
                    Intent intent4 = new Intent(getApplicationContext(), shopNewBuy.class);
                    intent4.putExtra("user", user);
                    startActivity(intent4);
                    finish();
                }
                else
                {

                }
            }
        });


        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent5 = new Intent(getApplicationContext(), Shop.class);
                intent5.putExtra("user",user);
                startActivity(intent5);
                finish();

            }
        });



    }
}
