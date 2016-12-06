package com.example.zech.simplerpg;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import java.util.logging.LogRecord;

import static android.graphics.Color.WHITE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.YELLOW;


public class QuestLog extends AppCompatActivity
{
    public ViewGroup layout;
    public MediaPlayer buttonSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_log);
        Intent questLogIntent = getIntent();
        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");
        layout = (ViewGroup) findViewById(R.id.questLogLayout);
        buttonSound  = MediaPlayer.create(this, R.raw.button_press);
        user.refeshQuestList();
        ArrayList<Quest> quest_log = user.quest_list;
        TextView questText = new TextView(this);
        questText.setText("\nActive Quests: \n");
        questText.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        questText.setTextColor(YELLOW);
        questText.setTextSize(25);
        questText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(questText);
        if(quest_log.size()  == 0)
        {
            TextView quest_info = new TextView(this);
            quest_info.setText("\n\nNo Quests Currently");
            quest_info.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
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
                                +"\nProgress: (0/1)"
                                +"\n-Rewards-\nExperince: "+quest.experince_reward+"  \nItem: "+quest.item_reward.name+"\n");
                }
                else
                {

                        quest_info.setText("Quest: "+quest.quest_name+"\n"+quest.quest_description
                                +"\nProgress: (0/1)"
                                +"\n-Rewards-\nExperince: "+quest.experince_reward+"\nItem: N/A\n");

                }
                quest_info.setTextColor(WHITE);
                quest_info.setTextSize(23);
                quest_info.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                quest_info.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
                layout.addView(quest_info);
            }
            TextView questReadyText = new TextView(this);
            questReadyText.setText("Ready to Turn In/Complete: \n");
            questReadyText.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
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
                            +"\nProgress: (1/1)"
                            +"\n-Rewards-\nExperince: "+quest.experince_reward+"  \nItem: "+quest.item_reward.name+"\n");
                }
                else
                {

                    quest_info.setText("Quest: "+quest.quest_name+"\n"+quest.quest_description
                            +"\nProgress: (1/1)"
                            +"\n-Rewards-\nExperince: "+quest.experince_reward+"\nItem: N/A\n");

                }
                quest_info.setTextColor(WHITE);
                quest_info.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                quest_info.setTextSize(23);
                quest_info.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
                layout.addView(quest_info);
            }
        }
        Button backButton = (Button) findViewById(R.id.questLogBack);
        backButton.setSoundEffectsEnabled(false);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSound.start();
                Intent intent = new Intent(v.getContext(), user_information_page.class);
                intent.putExtra("user",user);
                startActivity(intent);
                //while(buttonSound.isPlaying()); //do nothing
                //buttonSound.stop();
                finishAfterSound(buttonSound);
                //finish();
            }
        });
    }


    public void finishAfterSound(final MediaPlayer mp){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("finishAfterSound sleep ERROR");
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mp.release();
                        finish();
                    }
                });

            }
        }).start();
    }
}
