package com.example.zech.simplerpg;

import java.io.Serializable;

/**
 * Created by Keenan on 11/28/2016.
 */

public class Quest implements Serializable
{
    public int quest_id;
    //public String quest_type;
    public String quest_name;
    public String quest_description;
    public String item_name;
    //public String mob_name;
    //public int amountWanted;
    public int count;
    public Boolean isActive;
    public Boolean isComplete;
    public int experince_reward;
    public Item item_reward;

    public Quest (int id,String qname, String description,String iname, int er, Item ir)
    {
        quest_id = id;
        //quest_type = type;
        quest_name = qname;
        quest_description = description;
        //amountWanted = amount;
        count = 0;
        isActive = true;
        isComplete = false;
        item_name = iname;
       // mob_name = mname;
        experince_reward = er;
        item_reward = ir;
    }
}
