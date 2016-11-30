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
    /*
        base_health = base_health - w.equip()[0];
        strength = strength + w.equip()[1];
        defense = defense + w.equip()[2];
        willpower = willpower + w.equip()[3];
        dexterity = dexterity + w.equip()[4];
        constitution = constitution + w.equip()[5];
     */
    public int[] stats = new int[6];
}
