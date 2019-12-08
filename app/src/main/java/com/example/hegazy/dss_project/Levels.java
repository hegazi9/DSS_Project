package com.example.hegazy.dss_project;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Levels extends AppCompatActivity implements View.OnClickListener
{
    Button low , medium ,high , back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levels);

        low = (Button) findViewById(R.id.button);
        medium = (Button) findViewById(R.id.button2);
        high = (Button) findViewById(R.id.button3);
        back = (Button) findViewById(R.id.back);
        low.setOnClickListener(this);
        medium.setOnClickListener(this);
        high.setOnClickListener(this);
        back.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        if( v == low)
        {
            Intent in = new Intent(this,LowPage.class);
            startActivity(in);
        }
        else if( v == medium)
        {
            Intent in = new Intent(this,MediumPage.class);
            startActivity(in);
        }
        else if( v == high)
        {
            Intent in = new Intent(this,HighPage.class);
            startActivity(in);
        }
        else if( v == back)
        {
            Intent in = new Intent(this,Second.class);
            startActivity(in);
        }
    }
}
