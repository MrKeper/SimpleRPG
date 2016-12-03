package com.example.zech.simplerpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Travel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");



        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent22 = new Intent(getApplicationContext(), RegionMenu.class);
                intent22.putExtra("user",user);
                startActivity(intent22);
                finish();


            }
        });


    }

}
