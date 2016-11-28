package com.example.zech.simplerpg;

import android.media.Image;

import java.io.Serializable;

/**
 * Created by Keenan on 11/28/2016.
 */

public class Armor extends Item implements Serializable
{
    //=== enherited from Item ===
    //public String name;
    //public Image icon;
    //public String description;

    // Optional - gear graphic for battles(NOT IMPLEMENTED)
    private int[] stats = new int[7];
    //{Strength, Intelligence, Defense, Health}

    public Armor(String n, Image i, String d, int[] ss)
    {
        name = n;
        icon = i;
        description = d;
        stats = ss;
    }

    public int[] equip()
    {
        return stats;
    }
}
