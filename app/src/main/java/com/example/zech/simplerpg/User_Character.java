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
    public ArrayList<Integer> completedDungeons;

    public User_Character(String name)
    {
        actor_name = name;
        type = "user";
        current_health = 100;
        base_health = 100;
        strength = 5;
        defense = 5;
        willpower = 5;
        dexterity = 5;
        constitution = 5;
        moveList = new ArrayList<String>();
        current_gold = 10;
        user_level = 1;
        experince_bar = 0;
        experince_needed_to_level = 100;
        current_addtional_stat_points = 5;
        equiped_armor = null;
        equiped_weapon = null;
        inventory = new ArrayList<Item>();
        quest_list = new ArrayList<Quest>();
        completedDungeons = new ArrayList<Integer>();
    }

    public void equipWeapon(Weapon w)
    {
        if(equiped_weapon == null)
            unequipWeapon();
        equiped_weapon = w;
        base_health = base_health - w.equip()[0];
        strength = strength + w.equip()[1];
        defense = defense + w.equip()[2];
        willpower = willpower + w.equip()[3];
        dexterity = dexterity + w.equip()[4];
        constitution = constitution + w.equip()[5];

    }

    public void unequipWeapon()
    {
        Weapon w = equiped_weapon;
        inventory.add(w);
        equiped_weapon = null;
        base_health = base_health - w.equip()[0];
        strength = strength + w.equip()[1];
        defense = defense + w.equip()[2];
        willpower = willpower + w.equip()[3];
        dexterity = dexterity + w.equip()[4];
        constitution = constitution + w.equip()[5];
    }

    public void equipArmor(Armor a)
    {

    }

    public void unequipArmor()
    {

    }

    public  void destroyItem(Item i)
    {
        //if i in iventory , destroy
    }

    public void respawn()
    {
        current_gold = (int)(current_gold * 0.8);
        experince_bar = 0;
    }

    public void useConsumable()
    {
        //stats change based on item stats
    }

    public void levelUp()
    {
        user_level++;
        experince_bar = Math.abs(experince_needed_to_level-experince_bar);
        experince_needed_to_level = (user_level*50)+50;
        current_addtional_stat_points = current_addtional_stat_points + 3;
    }
}
