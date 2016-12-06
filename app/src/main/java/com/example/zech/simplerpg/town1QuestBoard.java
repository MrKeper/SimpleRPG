package com.example.zech.simplerpg;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;

public class town1QuestBoard extends AppCompatActivity {
    public ViewGroup layout;
    public MediaPlayer buttonSound;
    public MediaPlayer questComplete;
    public Boolean clearDungeon1Complete = false;
    public Boolean townInNeedIIComplete = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_town1_quest_board);
        Intent questLogIntent = getIntent();
        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");
        layout = (ViewGroup) findViewById(R.id.questBoardLayout);
        buttonSound  = MediaPlayer.create(this, R.raw.button_press);
        questComplete = MediaPlayer.create(this,R.raw.winning);
        ArrayList<Integer> currentQuests = new ArrayList<>();
        TextView questBoardText = new TextView(this);
        questBoardText.setText("\nAvaliable Quests: \n");
        questBoardText.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        questBoardText.setTextColor(WHITE);
        questBoardText.setTextSize(25);
        questBoardText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(questBoardText);

        ////////////////////////////////////////////////////////////////////////////// Quest: ClearDungone1
        int[] bronzeStats = {0,3,0,0,0,0};
        Weapon bronzeSword = new Weapon("Bronze Sword",null,"A solid sword forged by the locals of Myrefall (+3 STR)",bronzeStats,8);
        final Quest clearDungeon1 = new Quest(100,"Town in Need I",
                "Recently Myrefall has been having issues with monsters wondering out of the dungeon. This could be due to overpopulation. Clear the dungeon out to give them a hand.",
                "Boss' Heart", 50,bronzeSword);


        TextView quest_info = new TextView(this);
        quest_info.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        quest_info.setText("Quest: "+clearDungeon1.quest_name+"\n"+clearDungeon1.quest_description
                +"\n-Rewards-\nExperince: "+clearDungeon1.experince_reward+"  \nItem: "+clearDungeon1.item_reward.name+"\n");
        quest_info.setTextColor(WHITE);
        quest_info.setTextSize(23);
        quest_info.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        for(int i = 0; i < user.quest_list.size(); i++)
        {
            if(user.quest_list.get(i).quest_id == clearDungeon1.quest_id && user.quest_list.get(i).isComplete)
            {
                clearDungeon1Complete = true;
            }
            currentQuests.add(user.quest_list.get(i).quest_id);
        }
        if(!user.completedQuests.contains(clearDungeon1.quest_id))
        {
            layout.addView(quest_info);

        }
        Button acceptQuestClearDungeon1 = new Button(this);
        acceptQuestClearDungeon1.setSoundEffectsEnabled(false);
        if(currentQuests.contains(clearDungeon1.quest_id) && !clearDungeon1Complete)
        {
            acceptQuestClearDungeon1.setText("Quest Taken");
        }
        else if(user.completedQuests.contains(clearDungeon1.quest_id))
        {
            acceptQuestClearDungeon1.setText("Quest: "+clearDungeon1.quest_name+" Completed");
        }
        else if(clearDungeon1Complete && !user.completedQuests.contains(clearDungeon1.quest_id))
        {
            acceptQuestClearDungeon1.setText("Turn in Quest");
            acceptQuestClearDungeon1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    questComplete.start();
                    user.turnInQuest(clearDungeon1);
                    Intent intent = new Intent(v.getContext(), town1QuestBoard.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                    buttonSound.release();
                    finishAfterSound(questComplete);
                }
            });
        }
        else
        {
            acceptQuestClearDungeon1.setText("Accept Quest");
            acceptQuestClearDungeon1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonSound.start();
                    //FOR TESTING: clearDungeon1.isComplete = true;
                    user.quest_list.add(clearDungeon1);
                    Intent intent = new Intent(v.getContext(), town1QuestBoard.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                    finishAfterSound(buttonSound);
                }
            });

        }
        layout.addView(acceptQuestClearDungeon1);
        ////////////////////////////////////////////////////////////////////////////// Quest: TownInNeedII
        if(clearDungeon1Complete && user.completedQuests.contains(clearDungeon1.quest_id))
        {
            int[] ironStats = {0,5,0,0,0,0};
            Weapon ironSword = new Weapon("Iron Sword",null,"A proper sword for a proven warrior. (+5 STR).",ironStats,20);
            final Quest townInNeedII = new Quest(200,"Town in Need II",
                    "Th overpopulation continues to cause issues. Clear the dungeon 3 additional times to help the town out.",
                    "Boss' Hearts", 50,ironSword);


            TextView quest_info2 = new TextView(this);
            quest_info2.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            quest_info2.setText("Quest: "+townInNeedII.quest_name+"\n"+townInNeedII.quest_description
                    +"\n-Rewards-\nExperince: "+townInNeedII.experince_reward+"  \nItem: "+townInNeedII.item_reward.name+"\n");
            quest_info2.setTextColor(WHITE);
            quest_info2.setTextSize(23);
            quest_info2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
            for(int i = 0; i < user.quest_list.size(); i++)
            {
                if(user.quest_list.get(i).quest_id == townInNeedII.quest_id && user.quest_list.get(i).isComplete)
                {
                    townInNeedIIComplete = true;
                }
            }
            if(!user.completedQuests.contains(townInNeedII.quest_id))
            {
                layout.addView(quest_info2);

            }

            Button accepttownInNeed2 = new Button(this);
            accepttownInNeed2.setSoundEffectsEnabled(false);
            if(currentQuests.contains(townInNeedII.quest_id) && !townInNeedIIComplete)
            {
                accepttownInNeed2.setText("Quest Taken");
            }
            else if(user.completedQuests.contains(townInNeedII.quest_id))
            {
                accepttownInNeed2.setText("Quest: "+townInNeedII.quest_name+" Completed");
            }
            else if(townInNeedIIComplete && !user.completedQuests.contains(townInNeedII.quest_id))
            {
                accepttownInNeed2.setText("Turn in Quest");
                accepttownInNeed2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        questComplete.start();
                        user.turnInQuest(townInNeedII);
                        Intent intent = new Intent(v.getContext(), town1QuestBoard.class);
                        intent.putExtra("user",user);
                        startActivity(intent);
                        buttonSound.release();
                        finishAfterSound(questComplete);
                    }
                });
            }
            else
            {
                accepttownInNeed2.setText("Accept Quest");
                accepttownInNeed2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttonSound.start();
                        user.quest_list.add(townInNeedII);
                        Intent intent = new Intent(v.getContext(), town1QuestBoard.class);
                        intent.putExtra("user",user);
                        startActivity(intent);
                        finishAfterSound(buttonSound);
                    }
                });

            }
            layout.addView(accepttownInNeed2);
        }



        ////////////////////////////////////////////////////////////////////////////// Quests above
        Button backButton = (Button) findViewById(R.id.backButtonQuestBoard);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSound.start();
                Intent intent = new Intent(getApplicationContext(), RegionMenu.class);
                intent.putExtra("user",user);
                startActivity(intent);
                finishAfterSound(buttonSound);
            }
        });

    }

    public void finishAfterSound(final MediaPlayer mp){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(mp.getDuration());
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
