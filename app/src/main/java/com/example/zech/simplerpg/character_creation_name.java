package com.example.zech.simplerpg;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class character_creation_name extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation_name);
        Intent char_creation_name = getIntent();
        final TextView errorName = (TextView) findViewById(R.id.errorMessageName);
        errorName.setTextColor(Color.WHITE);
        errorName.setVisibility(View.INVISIBLE);
        final EditText enter_name_field = (EditText) findViewById(R.id.editTextCharName);
        Button back_button = (Button) findViewById(R.id.backCharName);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(v.getContext(), StartPage.class);
                startActivity(intent);
                finish();
            }
        });
        Button confirm_button = (Button) findViewById(R.id.confirmCharName);
        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String player_name = enter_name_field.getText().toString();
                String[] name_split = player_name.split("");
                int space_count = 0;
                for(int i = 0; i < name_split.length; i++)
                {
                    if(name_split[i].equals(" "))
                    {
                        space_count++;
                    }
                }

                if(player_name.length() < 2 || player_name.length() > 15 || space_count == player_name.length())
                {
                    errorName.setVisibility(View.VISIBLE);
                }
                Intent intent = new Intent(v.getContext(), character_creation_sex.class);
                startActivity(intent);
                //create actor and add name
                finish();
                //make actor
                //proceed
            }
        });


    }
}
