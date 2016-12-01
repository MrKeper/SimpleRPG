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

    public User_Character(String name)
    {
        actor_name = name;
        type = "user";
        //base_health = 100;
        strength = 5;
        defense = 5;
        willpower = 5;
        dexterity = 5;
        constitution = 5;
        max_health = 50 + constitution*10;
        current_health = max_health;
        //moveList = new ArrayList<String>();
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
