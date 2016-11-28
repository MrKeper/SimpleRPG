package com.example.zech.simplerpg;

import java.util.ArrayList;

/**
 * Created by Keenan on 11/11/2016.
 */

public class Mob extends Actor
{
    public  int mob_id;
    public int mob_level;

    public Mob(String name,int id,int lvl,int hp, int mp, int str, int dex, int con, int intel,int wil)
    {
        actor_name = name;
        current_health= hp;
        base_health = hp;
        mana = mp;
        strength = str;
        dexterity = dex;
        constitution = con;
        intelligence = intel;
        willpower = wil;
        type = "mob";
        mob_id = id;
        mob_level = lvl;
        moveList = new ArrayList<>();
    }

    public void addMove(String move)
    {
        moveList.add(move);
        return;
    }
}
