package com.example.zech.simplerpg;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Keenan on 11/11/2016.
 */

public class User_Character extends Actor implements Serializable
{
    public ArrayList<Item> inventory;
    public Armor equiped_armor;
    public Weapon equiped_weapon;
    public int current_gold;
    public int user_level;
    public int experince_bar;
    public int experince_needed_to_level;
    public ArrayList<Quest> quest_list;
    public int current_addtional_stat_points;
    public String sex;
    public int max_health;
    public ArrayList<Integer> completedDungeons;
    public int superAttackCharge;
    public String lastTownAt;

    public User_Character(String name)
    {
        actor_name = name;
        type = "user";
        sex = null;
        strength = 5;
        defense = 5;
        willpower = 5;
        dexterity = 5;
        constitution = 5;
        max_health = 50 + constitution*10;
        current_health = max_health;
        superAttackCharge = 0;
        current_gold = 10;
        user_level = 1;
        experince_bar = 0;
        experince_needed_to_level = 100;
        current_addtional_stat_points = 3;
        equiped_armor = null;
        equiped_weapon = null;
        inventory = new ArrayList<Item>();
        quest_list = new ArrayList<Quest>();
        completedDungeons = new ArrayList<Integer>();
        lastTownAt = null;
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Mob spider = new Mob("Giant Spider","giantspider",1,30,5,2,4,5);
        Mob serpant = new Mob("Silver King Snake","silverserpant",2,80,9,8,6,7);
        Mob beast = new Mob("Wild Beast","wildbeast",3,60,10,2,6,6);
        Mob drsgon = new Mob("Young Twin-Headed Dragon","twinheadeddragon",4,300,18,12,8,8);

        int[] weapon_stat_change = {0,1,0,0,0,0};
        int[] item_stat_change   = {10,0,0,0,0,0};
        Weapon start_weapon = new Weapon("Wooden Sword",null,"Its something.(+1 STR)",weapon_stat_change,0);
        Consumable water = new Consumable("Water",null,"A bottle of water (+10 HP).",item_stat_change,0);
        Quest test_quest1 = new Quest(1,"All your base are belong to us","Complete the game","God's Heart",25000,start_weapon);
        Quest test_quest2 = new Quest(2,"Welcome to Papa's House","Start the game","Wooden Sword",0,start_weapon);
        inventory.add(start_weapon);
        inventory.add(water);
        quest_list.add(test_quest1);
        quest_list.add(test_quest2);
    }

    public void refeshQuestList()
    {
        if(quest_list.isEmpty())
            return;
        for(int i = 0; i < quest_list.size(); i++)
        {
            String itemname = quest_list.get(i).item_name;
            for(int k = 0; k < inventory.size(); k++)
            {
                if(itemname.equals(inventory.get(k).name))
                {
                    quest_list.get(i).isComplete = true;
                }
            }
        }
    }

    public void turnInQuest(Quest quest)
    {
        for(int i = 0; i < quest_list.size(); i++)
        {
            if(quest.quest_id == quest_list.get(i).quest_id && quest_list.get(i).isComplete)
            {
                experince_bar = experince_bar + quest.experince_reward;
                if(quest.item_reward != null)
                {
                    inventory.add(quest.item_reward);
                }
            }
        }
    }

    public void equipWeapon(Weapon w)
    {
        if(w == null)
            return;
        if(equiped_weapon != null)
            unequipWeapon();
        equiped_weapon = w;
        strength = strength + w.getStatBuffs()[1];
        defense = defense + w.getStatBuffs()[2];
        willpower = willpower + w.getStatBuffs()[3];
        dexterity = dexterity + w.getStatBuffs()[4];
        constitution = constitution + w.getStatBuffs()[5];
        max_health = 50 + constitution*10 + w.getStatBuffs()[0];
    }

    public void unequipWeapon()
    {
        if(equiped_weapon == null)
            return;
        Weapon w = equiped_weapon;
        equiped_weapon = null;
        strength = strength - w.getStatBuffs()[1];
        defense = defense - w.getStatBuffs()[2];
        willpower = willpower - w.getStatBuffs()[3];
        dexterity = dexterity - w.getStatBuffs()[4];
        constitution = constitution - w.getStatBuffs()[5];
        max_health = 50 + constitution*10 - w.getStatBuffs()[0];
    }

    public void equipArmor(Armor a)
    {
        if(a == null)
            return;
        if(equiped_armor != null)
            unequipArmor();
        equiped_armor = a;
        strength = strength + a.getStatBuffs()[1];
        defense = defense + a.getStatBuffs()[2];
        willpower = willpower + a.getStatBuffs()[3];
        dexterity = dexterity + a.getStatBuffs()[4];
        constitution = constitution + a.getStatBuffs()[5];
        max_health = 50 + constitution*10 + a.getStatBuffs()[0];
    }

    public void unequipArmor()
    {
        if(equiped_armor == null)
            return;
        Armor a = equiped_armor;
        equiped_armor = null;
        max_health = max_health - a.getStatBuffs()[0];
        strength = strength - a.getStatBuffs()[1];
        defense = defense - a.getStatBuffs()[2];
        willpower = willpower - a.getStatBuffs()[3];
        dexterity = dexterity - a.getStatBuffs()[4];
        constitution = constitution - a.getStatBuffs()[5];
        max_health = 50 + constitution*10 - a.getStatBuffs()[0];
    }

    public void useConsumable(Consumable c)
    {
        if(c == null)
            return;

        if(current_health+c.getStatBuffs()[0] > max_health)
            current_health = max_health;
        else
            current_health = current_health + c.getStatBuffs()[0];
        strength = strength + c.getStatBuffs()[1];
        defense = defense + c.getStatBuffs()[2];
        willpower = willpower + c.getStatBuffs()[3];
        dexterity = dexterity + c.getStatBuffs()[4];
        constitution = constitution + c.getStatBuffs()[5];
    }

    public void respawn()
    {
        current_gold = (int)(current_gold * 0.8);
        experince_bar = 0;
    }

    public void levelUp()
    {
        user_level++;
        experince_bar = Math.abs(experince_needed_to_level-experince_bar);
        experince_needed_to_level = (user_level*50)+50;
        max_health = 50 + constitution*10;
        current_addtional_stat_points = current_addtional_stat_points + 3;
    }
}
