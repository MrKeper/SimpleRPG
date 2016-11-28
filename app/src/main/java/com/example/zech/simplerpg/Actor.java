package com.example.zech.simplerpg;

/*
 * Created by Keenan on 11/11/2016.
 */

import android.media.Image;

import java.io.Serializable;
import java.util.ArrayList;

public class Actor implements Serializable
{
    public String actor_name;
    public String type;
    public int base_health;
    public int current_health;
    public int mana;
    public ArrayList<String> moveList;
    public int strength;
    public int dexterity;
    public int constitution;
    public int intelligence;
    public int willpower;
    public Image graphic;

    public int getMana()
    {
        return  mana;
    }
}
