package com.example.zech.simplerpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.graphics.Color.WHITE;

public class Inventory extends AppCompatActivity {

    public boolean viewingConsumables = true;
    public int stat_change[] = {0,1,2,3,4,5};
    public Consumable test_pot = new Consumable("test health pot",null,"Heals 10 health",stat_change,0);
    public Weapon test_weapon = new Weapon("test sword",null,"A amazing sword",stat_change,0);
    public Armor test_armor = new Armor("Test armor",null,"A set of test armror",stat_change,0);
    public Button item;
    public String selected_item;
    public ArrayList<Item> player_inventory = new ArrayList<>();
    public ViewGroup layout;
    public User_Character user;
    public boolean equippedWeapon = false;
    public boolean equippedArmor = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        Intent inventory_intent_get = getIntent();
        user = (User_Character) getIntent().getSerializableExtra("user");
        layout = (ViewGroup) findViewById(R.id.invLayout);
        player_inventory = user.inventory;
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
            TextView invConsume = new TextView(this);
            invConsume.setText("Inventory: Consumables\n");
            invConsume.setTextColor(WHITE);
            invConsume.setTextSize(25);
            invConsume.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
            layout.addView(invConsume);
            for(int i = 0; i < player_inventory.size(); i++)
            {
                if(player_inventory.get(i).getClass() == Consumable.class)
                {
                    count++;
                    item = new Button(this);
                    item.setText(player_inventory.get(i).name+"\n-"+player_inventory.get(i).description+"\n Value: "+player_inventory.get(i).value+"g");
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
            equippedWeapon = false;
            equippedArmor = false;
            layout.removeAllViews();
            TextView invWeapons = new TextView(this);
            invWeapons.setText("Inventory: Weapons & Armor\n");
            invWeapons.setTextColor(WHITE);
            invWeapons.setTextSize(25);
            invWeapons.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
            layout.addView(invWeapons);
            for(int i = 0; i < player_inventory.size(); i++)
            {
                if(player_inventory.get(i).getClass() == Weapon.class || player_inventory.get(i).getClass() == Armor.class)
                {
                    count++;
                    item = new Button(this);
                    if(player_inventory.get(i).isEquipped)
                    {
                        item.setText(player_inventory.get(i).name+"\n-"+player_inventory.get(i).description+"\n Value: "+player_inventory.get(i).value+"g"+"\n-Equipped-");
                        if(player_inventory.get(i).getClass() == Weapon.class)
                        { equippedWeapon = true; }
                        if(player_inventory.get(i).getClass() == Armor.class)
                        {   equippedArmor = true; }
                    }
                    else
                    {
                        item.setText(player_inventory.get(i).name+"\n-"+player_inventory.get(i).description+"\n Value: "+player_inventory.get(i).value+"g");
                    }
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
    final int CONTEXT_MENU_UNEQUIP = 5;
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
            for(int i= 0; i < player_inventory.size(); i++)
            {
                if(player_inventory.get(i).name.equals(selected_item))
                {
                    if(player_inventory.get(i).getClass() == Weapon.class)
                    {
                        menu.setHeaderTitle("Weapon Options");
                        if(equippedWeapon) {menu.add(Menu.NONE, CONTEXT_MENU_UNEQUIP, Menu.NONE, "Unequip");}
                        else  {menu.add(Menu.NONE, CONTEXT_MENU_EQUIP, Menu.NONE, "Equip");}
                        menu.add(Menu.NONE, CONTEXT_MENU_DESTORY, Menu.NONE, "Destory");
                        menu.add(Menu.NONE, CONTEXT_MENU_CANCEL, Menu.NONE, "Cancel");
                    }
                    if(player_inventory.get(i).getClass() == Armor.class)
                    {
                        menu.setHeaderTitle("Armor Options");
                        if(equippedArmor) {menu.add(Menu.NONE, CONTEXT_MENU_UNEQUIP, Menu.NONE, "Unequip");}
                        else  {menu.add(Menu.NONE, CONTEXT_MENU_EQUIP, Menu.NONE, "Equip");}
                        menu.add(Menu.NONE, CONTEXT_MENU_DESTORY, Menu.NONE, "Destory");
                        menu.add(Menu.NONE, CONTEXT_MENU_CANCEL, Menu.NONE, "Cancel");

                    }
                    break;
                }
            }

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
                    for(int i= 0; i < player_inventory.size(); i++)
                    {
                        if(player_inventory.get(i).name.equals(selected_item))
                        {
                            Consumable remove =  (Consumable) player_inventory.get(i);
                            player_inventory.remove(remove);
                            user.useConsumable(remove);
                            break;
                        }
                    }
                    refreshLayout(true);
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
            switch (item.getItemId())
            {
                case CONTEXT_MENU_UNEQUIP:
                {
                    for(int i= 0; i < player_inventory.size(); i++)
                    {
                        if(player_inventory.get(i).name.equals(selected_item))
                        {
                            if(player_inventory.get(i).getClass() == Weapon.class)
                            {   user.unequipWeapon(); }
                            if(player_inventory.get(i).getClass() == Armor.class)
                            { user.unequipArmor();    }
                            player_inventory.get(i).isEquipped = false;
                            break;
                        }
                    }
                    refreshLayout(false);
                }
                break;
                case CONTEXT_MENU_EQUIP:
                {
                    Weapon w = null;
                    Armor a = null;
                    for(int i= 0; i < player_inventory.size(); i++)
                    {
                        if(player_inventory.get(i).name.equals(selected_item))
                        {
                            if(player_inventory.get(i).getClass() == Weapon.class)
                            { w =  (Weapon) player_inventory.get(i); user.equipWeapon(w); }
                            if(player_inventory.get(i).getClass() == Armor.class)
                            { a = (Armor)  player_inventory.get(i);  user.equipArmor(a);  }
                            player_inventory.get(i).isEquipped = true;
                            break;
                        }
                    }
                    refreshLayout(false);
                }
                break;
                case CONTEXT_MENU_DESTORY:
                {
                    for(int i= 0; i < player_inventory.size(); i++)
                    {
                        if(player_inventory.get(i).name.equals(selected_item))
                        {
                            if(player_inventory.get(i).getClass() == Weapon.class && equippedWeapon)
                            { user.unequipWeapon(); }
                            if(player_inventory.get(i).getClass() == Armor.class && equippedArmor)
                            { user.unequipArmor(); }
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
