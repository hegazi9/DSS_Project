package com.example.hegazy.dss_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Message extends Activity implements View.OnClickListener
{
    Button send ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meesage);

        send= (Button) findViewById(R.id.send);
        send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v== send)
        {
            Toast.makeText(this, "Thanks for Your Opinion", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(this , Levels.class);
            startActivity(in);
        }
    }
}
