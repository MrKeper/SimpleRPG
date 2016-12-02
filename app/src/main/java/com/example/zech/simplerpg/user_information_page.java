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

        // possible change picture based on current health.
        ImageView userImage = new ImageView(this);
        if(user.sex.equals("male"))
        {
            if(user.current_health > user.base_health*.6)
            {
                userImage.setImageResource(R.drawable.male_high_health);
            }
            else if(user.current_health <= user.base_health*.6 && user.current_health >= user.base_health*.4)
            {
                userImage.setImageResource(R.drawable.male_mid_health);
            }
            else
            {
                userImage.setImageResource(R.drawable.male_low_health);
            }
        }
        else
        {
            if(user.current_health > user.base_health*.6)
            {
                userImage.setImageResource(R.drawable.female_high_health);
            }
            else if(user.current_health <= user.base_health*.6 && user.current_health >= user.base_health*.4)
            {
                userImage.setImageResource(R.drawable.female_mid_health);
            }
            else
            {
                userImage.setImageResource(R.drawable.female_low_health);
            }
        }
        userImage.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userImage);

        TextView userName = new TextView(this);
        userName.setText("Name: "+user.actor_name);
        userName.setTextColor(WHITE);
        userName.setTextSize(23);
        userName.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userName);

        TextView userLevel = new TextView(this);
        userLevel.setText("Level: "+user.user_level);
        userLevel.setTextColor(WHITE);
        userLevel.setTextSize(23);
        userLevel.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userLevel);

        TextView userEXP = new TextView(this);
        userEXP.setText("Experince for next level: ("+user.experince_bar+"/"+user.experince_needed_to_level+")");
        userEXP.setTextColor(WHITE);
        userEXP.setTextSize(23);
        userEXP.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userEXP);

        TextView userHealth = new TextView(this);
        userHealth.setText("Health:("+user.current_health+"/"+user.max_health+")");
        userHealth.setTextColor(WHITE);
        userHealth.setTextSize(23);
        userHealth.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userHealth);

        TextView userSTR = new TextView(this);
        userSTR.setText("Strength: "+user.strength);
        userSTR.setTextColor(WHITE);
        userSTR.setTextSize(23);
        userSTR.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userSTR);

        TextView userDEF = new TextView(this);
        userDEF.setText("Defense: "+user.defense);
        userDEF.setTextColor(WHITE);
        userDEF.setTextSize(23);
        userDEF.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userDEF);

        TextView userDEX = new TextView(this);
        userDEX.setText("Dexterity: "+user.dexterity);
        userDEX.setTextColor(WHITE);
        userDEX.setTextSize(23);
        userDEX.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userDEX);

        TextView userWIL = new TextView(this);
        userWIL.setText("Willpower: "+user.willpower);
        userWIL.setTextColor(WHITE);
        userWIL.setTextSize(23);
        userWIL.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userWIL);


        TextView userCON = new TextView(this);
        userCON.setText("Constitution: "+user.constitution);
        userCON.setTextColor(WHITE);
        userCON.setTextSize(23);
        userCON.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userCON);

        TextView userGold = new TextView(this);
        userGold.setText("Gold: "+user.current_gold+"g");
        userGold.setTextColor(WHITE);
        userGold.setTextSize(23);
        userGold.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userGold);

        TextView userWeapon = new TextView(this);
        if(user.equiped_weapon != null) { userWeapon.setText("Equipped Weapon: \n"+user.equiped_weapon.name); }
        else { userWeapon.setText("Equipped Weapon: None"); }
        userWeapon.setTextColor(WHITE);
        userWeapon.setTextSize(23);
        userWeapon.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userWeapon);

        TextView userArmor = new TextView(this);
        if(user.equiped_armor != null) { userArmor.setText("Equipped Armor: \n"+user.equiped_armor.name); }
        else { userArmor.setText("Equipped Armor: None"); }
        userArmor.setTextColor(WHITE);
        userArmor.setTextSize(23);
        userArmor.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(userArmor);

        if(user.current_addtional_stat_points > 0)
        {
            TextView userStatpotins = new TextView(this);
            userStatpotins.setText("Additional Stat Points: "+user.current_addtional_stat_points);
            userStatpotins.setTextColor(WHITE);
            userStatpotins.setTextSize(23);
            userStatpotins.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            layout.addView(userStatpotins);
        }

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
                Intent intent = new Intent(v.getContext(), QuestLog.class);
                intent.putExtra("user",user);
                startActivity(intent);
                finish();
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
        Intent intent = new Intent(v.getContext(),AllocateStatsUserInfo.class);
        intent.putExtra("user",user);
        startActivity(intent);
        finish();
            }
        });

    }
}
