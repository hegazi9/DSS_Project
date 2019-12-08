package com.example.hegazy.dss_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MediumPage extends Activity implements View.OnClickListener
{
    ArrayList<String> Question = new ArrayList<>();
    ArrayList <String> Answers = new ArrayList<>();
    Button next;
    EditText edtxt ;
    TextView QuestionsText;
    static int   loop   =0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lowpage);
        QuestionsText =(TextView) findViewById(R.id.QuestionText);
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(this);
        edtxt= (EditText) findViewById(R.id.edtxt);
        next.setEnabled(false);

        Question.add(" Who is the first Arab player to qualify for the FIFA World Cup ?");
        Answers.add("egypt");
        Question.add(" What is the name of the place where the bees live ?");
        Answers.add("cell");
        Question.add(" What is the largest city in Europe ?");
        Answers.add("london");
        Question.add(" What is the standard carat gold ?");
        Answers.add("24");
        Question.add(" How many normal human teeth ?");
        Answers.add("32");
        Question.add(" How many eyes has a bee ?");
        Answers.add("5");
        Question.add("What is the second country in the world in terms of space ?");
        Answers.add("canada");
        Question.add("What is the smallest continent in the world ?");
        Answers.add("australia");
        Question.add("What is the language of Austria ?");
        Answers.add("German");
        Question.add("What are the strongest and most powerful types of stones ?");
        Answers.add("Diamond");






        Intent on = getIntent();

        String s = Question.get(loop);
        QuestionsText.setText(s);

        edtxt.addTextChangedListener(new TextWatcher()

        {
            boolean check =false;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int Index  = Answers.indexOf(s.toString());
                if (Index==-1) {
                    edtxt.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    check = false;
                    if (!check) next.setEnabled(false);
                } else {
                    edtxt.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.aa, 0);
                    check = true;
                }
                if (check&&loop !=Question.size()-1){
                    next.setEnabled(true);
                }
                if (check&&loop ==Question.size()-1) {
                    Toast.makeText(MediumPage.this,"Congratulations",Toast.LENGTH_LONG).show();
                    loop=0;
                    finish();
                }

            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


    }

    @Override
    public void onClick(View v) {

        if (v == next) {

            Intent in = new Intent(this, MediumPage.class);
            startActivity(in);
            loop++;
            finish();

        }

    }

}
