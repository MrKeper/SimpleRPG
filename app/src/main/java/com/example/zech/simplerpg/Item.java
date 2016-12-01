package com.example.zech.simplerpg;

/*
 * Created by Zech on 11/20/2016.
 */

import android.media.Image;

import java.io.Serializable;
import java.util.ArrayList;

public class Item implements Serializable
{
    public String name;
    public Image icon;
    public String description;
    public int value;
    public boolean isEquipped = false; //used for weapons and armor;
    /*
        base_health = base_health - w.getStatBuffs()[0];
        strength = strength + w.getStatBuffs()[1];
        defense = defense + w.getStatBuffs()[2];
        willpower = willpower + w.getStatBuffs()[3];
        dexterity = dexterity + w.getStatBuffs()[4];
        constitution = constitution + w.getStatBuffs()[5];
     */
    public int[] stats = new int[6];
}
