package com.example.zech.simplerpg;

/*
 * Created by Zech on 11/20/2016.
 */

import android.media.Image;

import java.io.Serializable;

public class Weapon extends Item implements Serializable
{
    //=== enherited from Item ===
    //public String name;
    //public Image icon;
    //public String description;

    // Optional - gear graphic for battles(NOT IMPLEMENTED)

    public Weapon(String n, Image i, String d, int[] ss)
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
