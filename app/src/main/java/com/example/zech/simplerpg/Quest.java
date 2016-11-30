package com.example.zech.simplerpg;

import java.io.Serializable;

/**
 * Created by Keenan on 11/28/2016.
 */

public class Quest implements Serializable
{
    public int quest_id;
    public static int quest_id_count = 1;
    public String quest_type;
    public String quest_name;
    public String quest_description;
    public String item_name;
    public int mob_id;
    public int amountWanted;
    public int count;
    public Boolean isActive;
    public Boolean isComplete;
    public int experince_reward;
    public Item item_reward;

    public Quest (String type, String qname, String description, int amount ,String iname, int mid, int er, Item ir)
    {
        quest_id = quest_id_count;
        quest_id_count++;
        quest_type = type;
        quest_name = qname;
        quest_description = description;
        amountWanted = amount;
        count = 0;
        isActive = true;
        isComplete = false;
        item_name = iname;
        mob_id = mid;
        experince_reward = er;
        item_reward = ir;
    }
}
