package com.example.zech.simplerpg;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.graphics.Color.WHITE;

public class user_information_page extends AppCompatActivity {

    public ViewGroup layout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information_page);
        Intent inventory_intent_get = getIntent();
        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");
        layout = (ViewGroup) findViewById(R.id.userInfoLayout);

        ImageView userImage = new ImageView(this);
        if(user.sex.equals("male")) {   userImage.setImageResource(R.drawable.male_high_health); }
        else {  userImage.setImageResource(R.drawable.female_high_health); }
        userImage.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userImage);

        TextView userName = new TextView(this);
        userName.setText("Name: "+user.actor_name);
        userName.setTextColor(WHITE);
        userName.setTextSize(15);
        userName.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userName);

        TextView userLevel = new TextView(this);
        userLevel.setText("Level: "+user.user_level);
        userLevel.setTextColor(WHITE);
        userLevel.setTextSize(15);
        userLevel.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userLevel);

        TextView userEXP = new TextView(this);
        userEXP.setText("("+user.experince_bar+"/"+user.experince_needed_to_level+")");
        userEXP.setTextColor(WHITE);
        userEXP.setTextSize(15);
        userEXP.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userEXP);

        TextView userHealth = new TextView(this);
        userHealth.setText("Health: "+user.current_health);
        userHealth.setTextColor(WHITE);
        userHealth.setTextSize(15);
        userHealth.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userHealth);

        TextView userSTR = new TextView(this);
        userSTR.setText("Strength: "+user.strength);
        userSTR.setTextColor(WHITE);
        userSTR.setTextSize(15);
        userSTR.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userSTR);

        TextView userINT = new TextView(this);
        userINT.setText("Intelligence: "+user.intelligence);
        userINT.setTextColor(WHITE);
        userINT.setTextSize(15);
        userINT.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userINT);

        TextView userCON = new TextView(this);
        userCON.setText("Constitution: "+user.constitution);
        userCON.setTextColor(WHITE);
        userCON.setTextSize(15);
        userCON.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userCON);

        Button backButton = (Button) findViewById(R.id.userInfoBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Testing.class);
                intent.putExtra("user",user);
                startActivity(intent);
                finish();
            }
        });

        Button questLogButton =  (Button) findViewById(R.id.questLogUserInfoButton);
        questLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(v.getContext(), QuestLog.class);
                intent.putExtra("user",user);
                startActivity(intent);
                finish();*/
            }
        });

        Button inventoryButton =  (Button) findViewById(R.id.userInfoInventoryButton);
        inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Inventory.class);
                intent.putExtra("user",user);
                startActivity(intent);
                finish();

            }
        });

        Button levelUpButton = (Button) findViewById(R.id.userInfoLevelUp);
        if(user.experince_bar >= user.experince_needed_to_level)
        {
            levelUpButton.getBackground().setColorFilter(Color.parseColor("#e5c100"), PorterDuff.Mode.MULTIPLY);
            levelUpButton.setText("Level Up");
        }
        else if(user.current_addtional_stat_points > 0)
        {
            levelUpButton.setText("Allocate stat points");
        }
        else
        {
            levelUpButton.setVisibility(View.INVISIBLE);
        }
        levelUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.experince_bar >= user.experince_needed_to_level)
                {
                     user.levelUp();

                    //temp
                    Intent intent = new Intent(v.getContext(), user_information_page.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                    finish();
                    //intent to alloc screen
                }
                else
                {
                    //intent to alloc screen
                }
            }
        });

    }
}
