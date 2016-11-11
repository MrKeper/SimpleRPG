package com.example.zech.simplerpg;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Keenan on 11/11/2016.
 */

public class User_Character extends Actor implements Serializable
{
    //public ArrayList<Item> inventory;
    //public Item equiped_armor;
    //public Item equiped_weapon;
    public int current_gold;
    public int user_level;
    public int experince_bar;
    //public ArrayList<Quest> quest_list;
    public int current_addtional_stat_points;
    public String sex;

    public User_Character(String name)
    {
        actor_name = name;
        type = "user";
        health = 100;
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
        current_addtional_stat_points = 5;
        //equiped_armor = null;
        //equiped_weapon = null;
        //inventory = new Arraylist<Item>();
        //quest_list = new Arraylist<Quest>();
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
        experince_bar = 0;
        current_addtional_stat_points = current_addtional_stat_points + 3;
    }
}
