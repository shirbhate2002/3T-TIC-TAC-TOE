package com.example.a3t;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class selectlevel extends AppCompatActivity {

    CardView easy,hard,expert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectlevel);
        easy=findViewById(R.id.easy);
        hard=findViewById(R.id.hard);
        expert=findViewById(R.id.expert);
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                esayintent();
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hardintent();
            }
        });
        expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expertintent();
            }
        });
    }

    private void esayintent() {
        Intent starteasy=new Intent(selectlevel.this,singleplayer.class);
        starteasy.putExtra("level",1);
        startActivity(starteasy);
    }
    private void hardintent() {
        Intent starteasy=new Intent(selectlevel.this,singleplayer.class);
        starteasy.putExtra("level",2);
        startActivity(starteasy);
    }
    private void expertintent() {
        Intent starteasy=new Intent(selectlevel.this,singleplayer.class);
        starteasy.putExtra("level",3);
        startActivity(starteasy);
    }
}
