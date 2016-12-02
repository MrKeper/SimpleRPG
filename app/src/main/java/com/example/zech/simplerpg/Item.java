package com.example.zech.simplerpg;

/*
 * Created by Zech on 11/20/2016.
 */

import android.media.Image;

import java.io.Serializable;
import java.util.ArrayList;

class Item implements Serializable
{
     String name;
     Image icon;
     String description;
     int value;
     boolean isEquipped = false; //used for weapons and armor;
    /*
        base_health = base_health - w.getStatBuffs()[0];
        strength = strength + w.getStatBuffs()[1];
        defense = defense + w.getStatBuffs()[2];
        willpower = willpower + w.getStatBuffs()[3];
        dexterity = dexterity + w.getStatBuffs()[4];
        constitution = constitution + w.getStatBuffs()[5];
     */
     public Item (String n)
     {
         name = n;
         icon = null;
         description = null;
     }

     int[] stats = new int[6];
}
