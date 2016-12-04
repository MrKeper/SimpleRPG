package com.example.zech.simplerpg;

import java.util.ArrayList;

/**
 * Created by Keenan on 11/11/2016.
 */

public class Mob extends Actor
{
    public  int mob_id;
    public String imagename;

    public Mob(String name,String image_name,int id,int hp, int str, int def ,int wil, int dex)
    {
        actor_name    = name;
        imagename     = image_name;
        base_health   = hp;
        current_health= hp;
        strength      = str;
        dexterity     = dex;
        defense       = def;
        willpower     = wil;
        type          = "mob";
        mob_id        = id;
        //moveList = new ArrayList<>();
    }

    public void addMove(String move)
    {
        //moveList.add(move);
        return;
    }
}
