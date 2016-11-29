package com.example.zech.simplerpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.graphics.Color.WHITE;

public class Inventory extends AppCompatActivity {

    public boolean viewingConsumables = true;
    int[] stat_change = new int[7];
    public Consumable test_pot = new Consumable("test health pot",null,"Heals 10 health",stat_change);
    public Weapon test_weapon = new Weapon("test sword",null,"A amazing sword",stat_change);
    public Armor test_armor = new Armor("Test armor",null,"A set of test armror",stat_change);
    public Button item;
    public String selected_item;
    public ArrayList<Item> player_inventory = new ArrayList<>();
    public ViewGroup layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        Intent inventory_intent_get = getIntent();
        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");
        layout = (ViewGroup) findViewById(R.id.invLayout);
        player_inventory = user.inventory;
        player_inventory.add(test_pot);
        player_inventory.add(test_armor);
        player_inventory.add(test_weapon);
        Button back_button = (Button) findViewById(R.id.invBack);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), user_information_page.class);
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
                refreshLayout(true);
            }
        });
        Button equips = (Button) findViewById(R.id.equipsButton);
        equips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                refreshLayout(false);
            }
        });
        refreshLayout(true);
    }

    public void refreshLayout(Boolean isConsume)
    {
        //removeALL
        int count = 0;
        if (isConsume)
        {
            viewingConsumables = true;
            layout.removeAllViews();
            for(int i = 0; i < player_inventory.size(); i++)
            {
                if(player_inventory.get(i).getClass() == Consumable.class)
                {
                    count++;
                    item = new Button(this);
                    item.setText(player_inventory.get(i).name+"\n-"+player_inventory.get(i).description);
                    item.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
                    item.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v)
                        {
                            Button button = (Button) v;
                            String button_text = button.getText().toString();
                            String [] name = button_text.split("\n");
                            selected_item = name[0];
                            registerForContextMenu(item);
                            openContextMenu(item);
                        }
                    });
                    layout.addView(item);
                }
            }
            if(count == 0)
            {
                TextView noConsumeables = new TextView(this);
                noConsumeables.setText("No Consumables");
                noConsumeables.setTextColor(WHITE);
                noConsumeables.setTextSize(30);
                noConsumeables.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
                layout.addView(noConsumeables);
            }
        }
        if(!isConsume)
        {
            viewingConsumables = false;
            layout.removeAllViews();
            for(int i = 0; i < player_inventory.size(); i++)
            {
                if(player_inventory.get(i).getClass() == Weapon.class || player_inventory.get(i).getClass() == Armor.class)
                {
                    count++;
                    item = new Button(this);
                    item.setText(player_inventory.get(i).name+"\n-"+player_inventory.get(i).description);
                    item.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
                    item.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v)
                        {
                            Button button = (Button) v;
                            String button_text = button.getText().toString();
                            String [] name = button_text.split("\n");
                            selected_item = name[0];
                            registerForContextMenu(item);
                            openContextMenu(item);
                        }
                    });
                    layout.addView(item);
                }
            }
            if(count == 0)
            {
                TextView noEquips = new TextView(this);
                noEquips.setText("No Weapons or Armor");
                noEquips.setTextColor(WHITE);
                noEquips.setTextSize(30);
                noEquips.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
                layout.addView(noEquips);
            }
        }
    }

    final int CONTEXT_MENU_USE = 1;
    final int CONTEXT_MENU_DESTORY = 2;
    final int CONTEXT_MENU_CANCEL = 3;
    final int CONTEXT_MENU_EQUIP = 4;
    @Override
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        //Context menu
        if(viewingConsumables)
        {
            menu.setHeaderTitle("Consumable Options");
            menu.add(Menu.NONE, CONTEXT_MENU_USE, Menu.NONE, "Use");
            menu.add(Menu.NONE, CONTEXT_MENU_DESTORY, Menu.NONE, "Destory");
            menu.add(Menu.NONE, CONTEXT_MENU_CANCEL, Menu.NONE, "Cancel");
        }
        else
        {
            menu.setHeaderTitle("Equipables Options");
            menu.add(Menu.NONE, CONTEXT_MENU_EQUIP, Menu.NONE, "Equip");
            menu.add(Menu.NONE, CONTEXT_MENU_DESTORY, Menu.NONE, "Destory");
            menu.add(Menu.NONE, CONTEXT_MENU_CANCEL, Menu.NONE, "Cancel");
        }

    }

    @Override
    public boolean onContextItemSelected (MenuItem item)
    {
        if(viewingConsumables)
        {
            switch (item.getItemId()) {
                case CONTEXT_MENU_USE:
                {
                    //find item
                    // user.consumeItem
                }
                break;
                case CONTEXT_MENU_DESTORY:
                {
                    // Edit Action
                    for(int i= 0; i < player_inventory.size(); i++)
                    {
                        if(player_inventory.get(i).name.equals(selected_item))
                        {
                            Item remove = player_inventory.get(i);
                            player_inventory.remove(remove);
                            break;
                        }
                    }
                refreshLayout(true);
            }
            break;
            case CONTEXT_MENU_CANCEL:
            {
                closeContextMenu();
            }
            break;
            }
        }
        else
        {
            switch (item.getItemId()) {
                case CONTEXT_MENU_EQUIP:
                {
                    //find item
                    //if armor user.equipArmor
                    // if weapon user.equipWeapon
                }
                break;
                case CONTEXT_MENU_DESTORY:
                {
                    for(int i= 0; i < player_inventory.size(); i++)
                    {
                        if(player_inventory.get(i).name.equals(selected_item))
                        {
                            Item remove = player_inventory.get(i);
                            player_inventory.remove(remove);
                            break;
                        }
                    }
                    refreshLayout(false);
                }
                break;
                case CONTEXT_MENU_CANCEL:
                {
                    closeContextMenu();
                }
                break;
            }
        }
        return super.onContextItemSelected(item);
    }
}
