package com.example.zech.simplerpg;

/**
 * Created by Keenan on 11/28/2016.
 */

public class Quest
{
    public int quest_id;
    public static int quest_id_count = 1;
    public String quest_type;
    public String item_name;
    public int mob_id;
    public Boolean isActive;
    public Boolean isComplete;
    public Boolean have_defeated_mob;
    public Boolean haveItem;
    public int experince_reward;
    public Item item_reward;

    public Quest (String type, String name, int mid, int er, Item ir)
    {
        quest_id = quest_id_count;
        quest_id_count++;
        quest_type = type;
        item_name = name;
        mob_id = mid;
        experince_reward = er;
        item_reward = ir;
    }
}
