package com.example.zech.simplerpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.security.PublicKey;
import java.util.ArrayList;

public class Inventory extends AppCompatActivity {

      public boolean viewingConsumables = true;
      int[] stat_change = new int[7];
      Consumable test_pot = new Consumable("test health pot",null,"Heals 10 health",stat_change);
      Weapon test_weapon = new Weapon("test sword",null,"A amazing sword",stat_change);
     Armor test_armor = new Armor("Test armor",null,"A set of test armror",stat_change);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        //Intent inventory_intent_get = getIntent();
        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");
        final LinearLayout layout = (LinearLayout) View.inflate(this,R.layout.activity_inventory,null);
        //layout.setId(R.id.invLayout);
        final ArrayList<Item> player_inventory = user.inventory;
        player_inventory.add(test_pot);
        player_inventory.add(test_armor);
        player_inventory.add(test_weapon);
        Button back_button = (Button) findViewById(R.id.invBack);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Testing.class);
                intent.putExtra("user",user);
                startActivity(intent);
                finish();
            }
        });
        Button consume = (Button) findViewById(R.id.consumeButton);
        consume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(!viewingConsumables)
                {
                    viewingConsumables = true;
                    layout.removeAllViews();
                    for(int i = 0; i < player_inventory.size(); i++)
                    {
                        if(player_inventory.get(i).getClass() == Consumable.class)
                        {
                            Button item = new Button(v.getContext());
                            item.setText(player_inventory.get(i).name+"\n"+player_inventory.get(i).description);
                            item.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
                            item.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v)
                                {
                                    //popup menu
                                    //use consumable?
                                    //destory
                                    //cancel
                                }
                            });
                            layout.addView(item);
                        }
                    }
                }
            }
        });
        Button equips = (Button) findViewById(R.id.equipsButton);
        equips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(viewingConsumables)
                {
                    viewingConsumables = false;
                    layout.removeAllViews();
                    for(int i = 0; i < player_inventory.size(); i++)
                    {
                        if (player_inventory.get(i).getClass() == Weapon.class || player_inventory.get(i).getClass() == Armor.class) {
                            Button item = new Button(v.getContext());
                            item.setText(player_inventory.get(i).name + "\n" + player_inventory.get(i).description);
                            item.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                            item.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v)
                                {
                                    //popup menu
                                    //equip?
                                    //destory
                                    //cancel
                                }
                            });
                            layout.addView(item);
                        }
                    }
                }
            }
        });
        for(int i = 0; i < player_inventory.size(); i++)
        {
            if(player_inventory.get(i).getClass() == Consumable.class)
            {
                Button item = new Button(this);
                item.setText(player_inventory.get(i).name+"\n"+player_inventory.get(i).description);
                item.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
                item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        //use consumable?
                    }
                });
                layout.addView(item);
            }
        }
    }
}
