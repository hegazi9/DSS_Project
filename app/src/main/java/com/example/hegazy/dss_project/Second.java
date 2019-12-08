package com.example.hegazy.dss_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Second extends AppCompatActivity implements View.OnClickListener
{
    Button button, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if (v == button)
        {
            Intent in = new Intent(this,Levels.class);
            startActivity(in);
        }
        else if (v == button2)
        {
            Intent in = new Intent(this,Message.class);
            startActivity(in);


        }
        else if (v == button3)
        {
            Intent in = new Intent(this,MainActivity.class);
            startActivity(in);
            finish();
        }

        }

    }
