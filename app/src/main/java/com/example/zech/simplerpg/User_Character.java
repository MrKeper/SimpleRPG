package com.example.zech.simplerpg;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Keenan on 11/11/2016.
 */

public class User_Character extends Actor implements Serializable
{
    public ArrayList<Item> inventory;
    public Item equiped_armor;
    public Item equiped_weapon;
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
        mana = 100;
        strength = 5;
        dexterity = 5;
        constitution = 5;
        intelligence = 5;
        willpower = 5;
        moveList = new ArrayList<String>();
        current_gold = 5;
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

    public void equipWeapon()
    {

    }

    public void unequipWeapon()
    {

    }

    public void equipArmor()
    {

    }

    public void unequipArmor()
    {

    }

    public  void destroyItem()
    {

    }

    public void respawn()
    {
        current_gold = (int)(current_gold * 0.8);
        experince_bar = 0;
    }

    public void useConsumable()
    {

    }

    public void levelUp()
    {
        user_level++;
        experince_bar = Math.abs(experince_needed_to_level-experince_bar);
        experince_needed_to_level = (user_level*50)+50;
        current_addtional_stat_points = current_addtional_stat_points + 3;
    }
}
