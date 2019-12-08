package com.example.hegazy.dss_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HighPage extends Activity implements View.OnClickListener
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

        Question.add(" How much does the liver weigh in an adult?");
        Answers.add("1.5");
        Question.add(" How long is the Nile river inside Egypt ?");
        Answers.add("1530");
        Question.add(" What is the Arab state that is going through the equator ?");
        Answers.add("somalia");
        Question.add(" What is the highest plateau in the plateau world ?");
        Answers.add("tibet");
        Question.add(" What is the color of healthy lungs ?");
        Answers.add("pink");
        Question.add(" What is the fastest marine creatures ?");
        Answers.add("tuna");
        Question.add("What is the lighter metal ?");
        Answers.add("lithium");
        Question.add("When did America make the first space flight?");
        Answers.add("1962");
        Question.add("What is the largest nonviolent animal ?");
        Answers.add("squid");
        Question.add("What is the vessel speedometer ?");
        Answers.add("node");



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
                    Toast.makeText(HighPage.this,"Congratulations",Toast.LENGTH_LONG).show();
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

            Intent in = new Intent(this, HighPage.class);
            startActivity(in);
            loop++;
            finish();

        }

    }

}
