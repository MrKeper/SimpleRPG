package com.example.zech.simplerpg;

import android.app.Activity;
import android.app.Application;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Julian on 11/30/2016.
 */

public class Current_info extends Application{

    //public ArrayList<Item> inventory;
    //public Armor equiped_armor;
    //public Weapon equiped_weapon;
    public int current_gold = 10;
    //public int user_level;
    //public int experince_bar;
    //public int experince_needed_to_level;
    //public ArrayList<Quest> quest_list;
    //public int current_addtional_stat_points;
    //public String sex;
    //public ArrayList<Integer> completedDungeons;




    //private String mGlobalVarValue;

    public int getGold() {
        return current_gold;
    }

    public void setGold(int goldIn) {
        current_gold = goldIn;
    }





}
