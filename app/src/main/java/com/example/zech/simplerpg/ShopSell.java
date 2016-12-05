package com.example.zech.simplerpg;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ShopSell extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_sell);


        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");




        final ArrayList<Item> newInv= user.inventory;
        int listSize = newInv.size();
        String[] foods = new String[listSize];
        //String[] foods = {"empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty"};
        for (int i = 0; i < newInv.size(); i++)
        {
            String tempName = newInv.get(i).name;
            int tempPrice = newInv.get(i).value;
            foods[i] = "G" + tempPrice + " " + tempName;
        }

        ListAdapter adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);
        final ListView list = (ListView) findViewById(R.id.inventoryList);
        list.setAdapter(adap);
        list.setBackgroundColor(Color.parseColor("#ffffffff"));



        int gold = user.current_gold;
        TextView t = (TextView)findViewById(R.id.goldText);
        t.setText(String.valueOf(gold));


        list.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //String choice = String.valueOf(parent.getItemAtPosition(position));
                        String selectedFromList =(list.getItemAtPosition(position).toString());


                        int itemValue = user.inventory.get(position).value;
                        user.inventory.remove(position);
                        user.current_gold += itemValue;
                        //}
                        Intent intent7 = new Intent(getApplicationContext(), ShopSell.class);
                        intent7.putExtra("user", user);
                        startActivity(intent7);
                        finish();
                        //if(selectedFromList.equals)



                        //TextView t = (TextView)findViewById(R.id.goldText);
                        //t.setText(selectedFromList);

                    }
                }

        );







        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent4 = new Intent(getApplicationContext(), Shop.class);
                intent4.putExtra("user",user);
                startActivity(intent4);
                finish();

            }
        });


    }
}
