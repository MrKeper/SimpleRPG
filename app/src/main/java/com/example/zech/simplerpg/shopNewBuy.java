package com.example.zech.simplerpg;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;

public class shopNewBuy extends AppCompatActivity {
    public ViewGroup layout;
    MediaPlayer buttonSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_new_buy);

        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");
        layout = (ViewGroup) findViewById(R.id.shopBuyLayout);
        buttonSound  = MediaPlayer.create(this, R.raw.button_press);

        Button bufferButton = (Button) findViewById(R.id.makeInvs);
        bufferButton.setVisibility(View.INVISIBLE);

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
        t.setText("Gold: "+String.valueOf(gold));



        final Button buyWater = new Button(this);
        int[] item_stat_change = {10, 0, 0, 0, 0, 0};
        final Consumable water = new Consumable("Water", null, "A bottle of water (+10 HP).", item_stat_change, 3);
        buyWater.setText(water.name+"\n-"+water.description+"\n Value: "+water.value+"g");
        buyWater.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        buyWater.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                if(user.current_gold >= water.value)
                {

                    user.inventory.add(water);
                    user.current_gold -= water.value;
                    Intent intent4 = new Intent(getApplicationContext(), shopNewBuy.class);
                    intent4.putExtra("user", user);
                    startActivity(intent4);
                    finishAfterSound(buttonSound);
                }
                else
                {
                    Toast nofunds = Toast.makeText(getApplicationContext(),"Insufficient funds.",Toast.LENGTH_SHORT);
                    nofunds.show();
                }
            }
        });
        layout.addView(buyWater);


        final Button buyBasicHealthPotion = new Button(this);
        int[] item_stat_changePotion1 = {30, 0, 0, 0, 0, 0};
        final Consumable basicHeathPotion = new Consumable("Small Health Potion", null, "A basic Health Potion (+30 HP).", item_stat_changePotion1, 8);
        buyBasicHealthPotion.setText(basicHeathPotion.name+"\n-"+basicHeathPotion.description+"\n Value: "+basicHeathPotion.value+"g");
        buyBasicHealthPotion.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        buyBasicHealthPotion.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                if(user.current_gold >= basicHeathPotion.value)
                {

                    user.inventory.add(basicHeathPotion);
                    user.current_gold -= basicHeathPotion.value;
                    Intent intent4 = new Intent(getApplicationContext(), shopNewBuy.class);
                    intent4.putExtra("user", user);
                    startActivity(intent4);
                    finishAfterSound(buttonSound);
                }
                else
                {
                    Toast nofunds = Toast.makeText(getApplicationContext(),"Insufficient funds.",Toast.LENGTH_SHORT);
                    nofunds.show();
                }
            }
        });
        layout.addView(buyBasicHealthPotion);


        final Button buyInterHealthPotion = new Button(this);
        int[] item_stat_changePotion2 = {60, 0, 0, 0, 0, 0};
        final Consumable interHeathPotion = new Consumable("Medium Health Potion", null, "An intermediate Health Potion (+60 HP).", item_stat_changePotion2, 16);
        buyInterHealthPotion.setText(interHeathPotion.name+"\n-"+interHeathPotion.description+"\n Value: "+interHeathPotion.value+"g");
        buyInterHealthPotion.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        buyInterHealthPotion.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                if(user.current_gold >= interHeathPotion.value)
                {

                    user.inventory.add(interHeathPotion);
                    user.current_gold -= interHeathPotion.value;
                    Intent intent4 = new Intent(getApplicationContext(), shopNewBuy.class);
                    intent4.putExtra("user", user);
                    startActivity(intent4);
                    finishAfterSound(buttonSound);
                }
                else
                {
                    Toast nofunds = Toast.makeText(getApplicationContext(),"Insufficient funds.",Toast.LENGTH_SHORT);
                    nofunds.show();
                }
            }
        });
        layout.addView(buyInterHealthPotion);

        final Button buyAdvancedHealthPotion = new Button(this);
        int[] item_stat_changePotion3 = {120, 0, 0, 0, 0, 0};
        final Consumable advancHealthPotion = new Consumable("Large Health Potion", null, "An advance Health Potion (+120 HP).", item_stat_changePotion3, 32);
        buyAdvancedHealthPotion.setText(advancHealthPotion.name+"\n-"+advancHealthPotion.description+"\n Value: "+advancHealthPotion.value+"g");
        buyAdvancedHealthPotion.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        buyAdvancedHealthPotion.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                if(user.current_gold >= advancHealthPotion.value)
                {

                    user.inventory.add(advancHealthPotion);
                    user.current_gold -= advancHealthPotion.value;
                    Intent intent4 = new Intent(getApplicationContext(), shopNewBuy.class);
                    intent4.putExtra("user", user);
                    startActivity(intent4);
                    finishAfterSound(buttonSound);
                }
                else
                {
                    Toast nofunds = Toast.makeText(getApplicationContext(),"Insufficient funds.",Toast.LENGTH_SHORT);
                    nofunds.show();
                }
            }
        });
        layout.addView(buyAdvancedHealthPotion);


        final Button buyRusteySword = new Button(this);
        int[] item_stat_change2 = {0, 2, 0, 0, 0, 0};
        final Weapon rusted_Sword = new Weapon("Rusted Sword", null, "A old rusted sword, but hey its better than wood (+2 STR).", item_stat_change2, 8);
        buyRusteySword.setText(rusted_Sword.name+"\n-"+rusted_Sword.description+"\n Value: "+rusted_Sword.value+"g");
        buyRusteySword.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        buyRusteySword.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                if(user.current_gold >= rusted_Sword.value)
                {

                    user.inventory.add(rusted_Sword);
                    user.current_gold -= rusted_Sword.value;
                    Intent intent4 = new Intent(getApplicationContext(), shopNewBuy.class);
                    intent4.putExtra("user", user);
                    startActivity(intent4);
                    finishAfterSound(buttonSound);
                }
                else
                {
                    Toast nofunds = Toast.makeText(getApplicationContext(),"Insufficient funds.",Toast.LENGTH_SHORT);
                    nofunds.show();
                }
            }
        });
        layout.addView(buyRusteySword);


        final Button buyLeatherArmor = new Button(this);
        int[] item_stat_change3 = {0, 0, 2, 0, 0, 0};
        final Armor leatherArmor = new Armor("Leather Armor", null, "A proper set of armor for a beginner. (+2 DEF).", item_stat_change3, 8);
        buyLeatherArmor.setText(leatherArmor.name+"\n-"+leatherArmor.description+"\n Value: "+leatherArmor.value+"g");
        buyLeatherArmor.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        buyLeatherArmor.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                if(user.current_gold >= leatherArmor.value)
                {

                    user.inventory.add(leatherArmor);
                    user.current_gold -= leatherArmor.value;
                    Intent intent4 = new Intent(getApplicationContext(), shopNewBuy.class);
                    intent4.putExtra("user", user);
                    startActivity(intent4);
                    finishAfterSound(buttonSound);
                }
                else
                {
                    Toast nofunds = Toast.makeText(getApplicationContext(),"Insufficient funds.",Toast.LENGTH_SHORT);
                    nofunds.show();
                }
            }
        });
        layout.addView(buyLeatherArmor);

        final Button buyIronArmor = new Button(this);
        int[] item_stat_change4 = {0, 0, 5, 0, 0, 0};
        final Armor ironArmor = new Armor("Iron Armor", null, "A proper set of armor for a proven warrior. (+5 DEF).", item_stat_change4, 20);
        buyIronArmor.setText(ironArmor.name+"\n-"+ironArmor.description+"\n Value: "+ironArmor.value+"g");
        buyIronArmor.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        buyIronArmor.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonSound.start();
                if(user.current_gold >= ironArmor.value)
                {

                    user.inventory.add(ironArmor);
                    user.current_gold -= ironArmor.value;
                    Intent intent4 = new Intent(getApplicationContext(), shopNewBuy.class);
                    intent4.putExtra("user", user);
                    startActivity(intent4);
                    finishAfterSound(buttonSound);
                }
                else
                {
                    Toast nofunds = Toast.makeText(getApplicationContext(),"Insufficient funds.",Toast.LENGTH_SHORT);
                    nofunds.show();
                }
            }
        });
        layout.addView(buyIronArmor);

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setBackgroundResource(R.drawable.woodbutton);
        backButton.setTextColor(WHITE);
        backButton.setSoundEffectsEnabled(false);
        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent5 = new Intent(getApplicationContext(), Shop.class);
                intent5.putExtra("user",user);
                startActivity(intent5);
                finish();

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
