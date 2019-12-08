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

public class LowPage extends Activity implements View.OnClickListener
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

            Question.add("Number of chess boxes ......... square.");
            Answers.add("64");
            Question.add("The highest scores of the Rachter scale for earthquakes are ............ degrees.");
            Answers.add("12");
            Question.add("(Umm Kulthum ) married  ....... times.");
            Answers.add("5");
            Question.add("The number of bottles in the bowling game ......... Bottles.");
            Answers.add("12");
            Question.add("For the lion in Arabic more than ......... Name.");
            Answers.add("1500");
            Question.add("The Total eclipse of the sun occurs every year .......");
            Answers.add("360");
            Question.add(".......... country in the world does not look at any watery flat .");
            Answers.add("26");


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
                    Toast.makeText(LowPage.this,"Congratulations",Toast.LENGTH_LONG).show();
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

            Intent in = new Intent(this, LowPage.class);
            startActivity(in);
            loop++;
            finish();

        }

    }

}
