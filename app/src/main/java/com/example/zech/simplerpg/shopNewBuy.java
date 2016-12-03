package com.example.zech.simplerpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class shopNewBuy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_new_buy);

        final User_Character user = (User_Character) getIntent().getSerializableExtra("user");

        int gold = user.current_gold;

        TextView t = (TextView)findViewById(R.id.textView3);
        //t.setText(String.valueOf(gold));
        ArrayList<Item> newInv= user.inventory;
        Item item = newInv.get(0);
        t.setText(String.valueOf(item.name));

        String[] itemList = new String[10];
        for (int i = 0; (i < newInv.size()) && ((newInv.get(i).name) != null); i++)
        {
            itemList[i] = newInv.get(i).name;
        }

        ListAdapter adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList);
        ListView list = (ListView) findViewById(R.id.theList);
        //list.setAdapter(adap);



        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent4 = new Intent(getApplicationContext(), Shop.class);
                intent4.putExtra("user",user);
                startActivity(intent4);
                finish();

            }
        });



    }
}
