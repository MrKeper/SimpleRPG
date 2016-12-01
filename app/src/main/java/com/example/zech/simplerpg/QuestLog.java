package com.example.zech.simplerpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.graphics.Color.WHITE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.YELLOW;


public class QuestLog extends AppCompatActivity
{
    public ViewGroup layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_log);
        Intent questLogIntent = getIntent();
        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");
        layout = (ViewGroup) findViewById(R.id.questLogLayout);
        //For every Qust put TextView with infomation
        //add to layout.
        //if completed but not turned in,  Have a Complelte , mabye in green

        ArrayList<Quest> quest_log = user.quest_list;
        TextView questText = new TextView(this);
        questText.setText("\nActive Quests: \n");
        questText.setTextColor(YELLOW);
        questText.setTextSize(25);
        questText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(questText);
        if(quest_log.size()  == 0)
        {
            TextView quest_info = new TextView(this);
            quest_info.setText("No Quests Currently");
            quest_info.setTextColor(WHITE);
            quest_info.setTextSize(17);
            quest_info.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
            layout.addView(quest_info);
        }
        else
        {
            for(int i = 0; i < quest_log.size(); i++)
            {
                Quest quest = quest_log.get(i);
                if(quest.isComplete)
                    continue;
                TextView quest_info = new TextView(this);
                if(quest.item_reward != null)
                {
                        quest_info.setText("Quest: "+quest.quest_name+"\n"+quest.quest_description
                                +"\nProgress: ("+quest.count+"/"+quest.amountWanted+")"
                                +"\nRewards:\nExperince: "+quest.experince_reward+"  \nItem: "+quest.item_reward.name+"\n");
                }
                else
                {

                        quest_info.setText("Quest: "+quest.quest_name+"\n"+quest.quest_description
                                +"\nProgress: ("+quest.count+"/"+quest.amountWanted+")"
                                +"\nRewards: \nExperince: "+quest.experince_reward+"\nItem: N/A\n");

                }
                quest_info.setTextColor(WHITE);
                quest_info.setTextSize(23);
                quest_info.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
                layout.addView(quest_info);
            }
            TextView questReadyText = new TextView(this);
            questReadyText.setText("Ready to Turn In: \n");
            questReadyText.setTextColor(GREEN);
            questReadyText.setTextSize(25);
            questReadyText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
            layout.addView(questReadyText);
            for(int i = 0; i < quest_log.size(); i++)
            {
                Quest quest = quest_log.get(i);
                TextView quest_info = new TextView(this);
                if(!quest.isComplete)
                    continue;
                if(quest.item_reward != null)
                {
                    quest_info.setText("Quest: "+quest.quest_name+"\n"+quest.quest_description
                            +"\nProgress: ("+quest.count+"/"+quest.amountWanted+")"
                            +"\nRewards:\nExperince: "+quest.experince_reward+"  \nItem: "+quest.item_reward.name+"\n");
                }
                else
                {

                    quest_info.setText("Quest: "+quest.quest_name+"\n"+quest.quest_description
                            +"\nProgress: ("+quest.count+"/"+quest.amountWanted+")"
                            +"\nRewards: \nExperince: "+quest.experince_reward+"\nItem: N/A\n");

                }
                quest_info.setTextColor(WHITE);
                quest_info.setTextSize(23);
                quest_info.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
                layout.addView(quest_info);
            }
        }
        Button backButton = (Button) findViewById(R.id.questLogBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), user_information_page.class);
                intent.putExtra("user",user);
                startActivity(intent);
                finish();
            }
        });
    }
}
