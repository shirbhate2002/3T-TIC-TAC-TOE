package com.example.a3t;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class palypage extends AppCompatActivity {

    CardView singleplayer,dualplayer,adout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palypage);

        singleplayer=findViewById(R.id.single);
        singleplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startsingleplayer = new Intent(palypage.this,selectlevel.class);
                startActivity(startsingleplayer);
            }
        });
        dualplayer=findViewById(R.id.dule);
        dualplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dualplater = new Intent(palypage.this,twoplayers.class);
                startActivity(dualplater);
            }
        });
    }
}
