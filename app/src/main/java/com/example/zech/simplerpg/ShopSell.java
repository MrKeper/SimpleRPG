package com.example.zech.simplerpg;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
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

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;


public class ShopSell extends AppCompatActivity {
    MediaPlayer buttonSound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_sell);


        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");
        buttonSound  = MediaPlayer.create(this, R.raw.button_press);

        final ArrayList<Item> newInv= user.inventory;
        int listSize = newInv.size();
        String[] foods = new String[listSize];
        //String[] foods = {"empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty"};
        for (int i = 0; i < newInv.size(); i++)
        {
            String tempName = newInv.get(i).name;
            int tempPrice = newInv.get(i).value;
            foods[i] =  tempPrice + "g" + " " + tempName;
        }

        ListAdapter adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);
        final ListView list = (ListView) findViewById(R.id.inventoryList);
        list.setAdapter(adap);
        list.setBackgroundColor(Color.parseColor("#ffffffff"));



        int gold = user.current_gold;
        TextView t = (TextView)findViewById(R.id.goldText);
        t.setText("Gold: "+String.valueOf(gold));
        t.setTextColor(YELLOW);
        t.setBackgroundColor(BLACK);

        list.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //String choice = String.valueOf(parent.getItemAtPosition(position));
                        String selectedFromList =(list.getItemAtPosition(position).toString());
                        buttonSound.start();
                        int itemValue = user.inventory.get(position).value;

                        String tempItemName = user.inventory.get(position).name;
                        //(user.equiped_weapon.name.equals(tempItemName))
                        if (user.equiped_weapon != null)
                        {
                            if(user.equiped_weapon.name.equals(tempItemName))
                            {
                                user.unequipWeapon();
                            }
                        }
                        if(user.equiped_armor != null)
                        {
                            if(user.equiped_armor.name.equals(tempItemName))
                            {
                                user.unequipArmor();
                            }
                        }
                        user.inventory.remove(position);
                        user.current_gold += itemValue;
                        Intent intent7 = new Intent(getApplicationContext(), ShopSell.class);
                        intent7.putExtra("user", user);
                        startActivity(intent7);
                        finishAfterSound(buttonSound);

                    }
                }

        );

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setBackgroundResource(R.drawable.woodbutton);
        backButton.setTextColor(WHITE);
        backButton.setSoundEffectsEnabled(false);
        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                Intent intent4 = new Intent(getApplicationContext(), Shop.class);
                intent4.putExtra("user",user);
                startActivity(intent4);
                finishAfterSound(buttonSound);

            }
        });
    }


    public void finishAfterSound(final MediaPlayer mp){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(mp.getDuration());
                } catch (Exception e) {
                    System.out.println("finishAfterSound sleep ERROR");
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mp.release();
                        finish();
                    }
                });

            }
        }).start();
    }

}
