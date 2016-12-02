package com.example.zech.simplerpg;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Testing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");

        //Temp Julian code START
        /////////////////////////////////////////////////////////////////////////
        //final Current_info tempSTATS = new Current_info();

        final Current_info tempSTATS2 = new Current_info();


        tempSTATS2.inventory = user.inventory;
        tempSTATS2.equiped_armor = user.equiped_armor;
        tempSTATS2.equiped_weapon = user.equiped_weapon;
        tempSTATS2.current_gold = user.current_gold;
        tempSTATS2.user_level = user.user_level;
        tempSTATS2.experince_bar = user.experince_bar;
        tempSTATS2.experince_needed_to_level = user.experince_needed_to_level;
        tempSTATS2.quest_list = user.quest_list;
        tempSTATS2.current_addtional_stat_points = user.current_addtional_stat_points;
        tempSTATS2.sex = user.sex;
        tempSTATS2.completedDungeons = user.completedDungeons;
        ////////////////////////////////////////////////////////////////////////
        //Temp Julian code END



        Button battleButton = (Button) findViewById(R.id.battle_button);
        battleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //My testing stats for user
                user.current_health = 180;
                user.base_health = 200;
                Intent intent = new Intent(v.getContext(), Battle.class);
                intent.putExtra("user",user);
                startActivity(intent);
                finish();
            }
        });

        Button playerInfoButton = (Button) findViewById(R.id.playerInfo);
        playerInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), user_information_page.class);
                //save(user,"savefile.txt");
                intent.putExtra("user",user);
                startActivity(intent);
                finish();
            }
        });

        Button exitButton = (Button) findViewById(R.id.testingExit);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(user,"savefile.txt");
                finish();
            }
        });




        //Temp Julian code START
        ///////////////////////////////////////////////////////////////////////////////////



        Button buttonToRegion = (Button) findViewById(R.id.testButton);
        buttonToRegion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                /*
                SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);


                SharedPreferences.Editor editor = sharedPref.edit();


                editor.putString("username", "TheName");
                editor.putInt("current_gold", user.current_gold);
                editor.putInt("user_level", user.user_level);
                editor.putInt("experience_bar", user.experince_bar);
                editor.putInt("current_additional_stat_points", user.current_addtional_stat_points);
                editor.putInt("current_potions", 3);


                Gson gson = new Gson();
                String json = gson.toJson(tempSTATS2);
                editor.putString("MyObject", json);




                editor.commit();
                //editor.putString("username", "TheName");
                //editor.putString("username", "TheName");
                //editor.putString("username", "TheName");

                //tempSTATS2.inventory = user.inventory;
                //tempSTATS2.equiped_armor = user.equiped_armor;
                //tempSTATS2.equiped_weapon = user.equiped_weapon;
                //tempSTATS2.current_gold = user.current_gold;
                //tempSTATS2.user_level = user.user_level;
                //tempSTATS2.experince_bar = user.experince_bar;
                //tempSTATS2.experince_needed_to_level = user.experince_needed_to_level;
                //tempSTATS2.quest_list = user.quest_list;
                //tempSTATS2.current_addtional_stat_points = user.current_addtional_stat_points;
                //tempSTATS2.sex = user.sex;
                //tempSTATS2.completedDungeons = user.completedDungeons;


                //editor.apply();
                //editor.putString("username", "TheNewName");
                //editor.apply();

                */


                Intent intent2 = new Intent(getApplicationContext(), RegionMenu.class);
                intent2.putExtra("user",user);
                //intent2.putExtra("temp",tempSTATS);
                startActivity(intent2);
                finish();
            }
        });
        //////////////////////////////////////////////////////////////////////////////////////////
        //Temp Julian code END



    }

    public void save (User_Character user, String filename)
    {
        FileOutputStream fos = null;
        try {
            fos = getApplicationContext().openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(user);
            os.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
