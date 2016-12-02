package com.example.zech.simplerpg;

/*
 * Created by Zech on 11/20/2016.
 */

import android.media.Image;

import java.io.Serializable;

 class Consumable extends Item implements Serializable
{
    //=== enherited from Item ===
    //public String name;
    //public Image icon;
    //public String description;

    // Optional - gear graphic for battles(NOT IMPLEMENTED)

     Consumable(String n, Image i, String d, int[] ss, int gold_value)
    {
        super(n);
        //name = n;
        icon = i;
        description = d;
        stats = ss;
        value = gold_value;
    }

     int[] getStatBuffs()
    {
        return stats;
    }
}
