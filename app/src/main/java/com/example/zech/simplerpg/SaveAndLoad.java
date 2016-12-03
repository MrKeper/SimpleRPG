package com.example.zech.simplerpg;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveAndLoad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_and_load);


        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");

    /*
        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FileOutputStream fos = null;
                try {
                    fos = getApplicationContext().openFileOutput("filename", Context.MODE_PRIVATE);

                    ObjectOutputStream os = new ObjectOutputStream(fos);
                    os.writeObject(user);
                    os.close();
                    fos.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }


                Button loadButton = (Button) findViewById(R.id.loadButton);
                loadButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        FileInputStream fis = null;
                        try {
                            fis = getApplicationContext().openFileInput("filename");

                            ObjectInputStream is = new ObjectInputStream(fis);
                            User_Character simpleClass = (User_Character) is.readObject();

                            TextView textView1 = (TextView) findViewById(R.id.textView7);
                            textView1.setText(String.valueOf(simpleClass.current_gold));

                            is.close();
                            fis.close();


                        } catch (Exception e) {
                            e.printStackTrace();
                        }



            }
        });
*/

                Button backButton = (Button) findViewById(R.id.backButton);
                backButton.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {

                        Intent intent4 = new Intent(getApplicationContext(), RegionMenu.class);
                        intent4.putExtra("user",user);
                        startActivity(intent4);
                        finish();
                    }
                });

        }



    }
//)
//        ;
        //}}
