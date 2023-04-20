package com.example.mcqapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class truefalse extends AppCompatActivity {

    TextView present_index,total_que,questionn;
    int index = 0,score=0;
    String correctanswer = "";
    RadioGroup group;
    RadioButton opta,optb,radio;
    Button submit;

    String question [] = {"In the animation film “Finding Nemo,” the main protagonist is a pufferfish?","Is Mount Kilimanjaro the world’s tallest peak? ","Spaghetto is the singular form of the word spaghetti.","Pinocchio was Walt Disney’s first animated feature film in full color?","Venezuela is home to the world’s highest waterfall?","The capital of Australia is Sydney?","Polar bears can only live in the Arctic region, not in the Antarctic?","The United Kingdom is almost the same size as France?","Walt Disney has the record for most Academy Awards?", "Seahorses have stomachs, which aid in the digestion of food?",};

    String choices[][] = {{"True","False"},{"True","False"},{"True","False"},{"True","False"},{"True","False"},{"True","False"},{"True","False"},{"True","False"},{"True","False"},{"True","False"}};

    String correctans[]={"False","False","True","False","True","False","True","False","True","False"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truefalse);

        group = findViewById(R.id.group);
        present_index = findViewById(R.id.present);
        total_que = findViewById(R.id.total);
        questionn = findViewById(R.id.questions);
        opta = findViewById(R.id.opta);
        optb = findViewById(R.id.optb);
        submit = findViewById(R.id.submit);
        total_que.setText(String.valueOf("/"+question.length));
        present_index.setText(String.valueOf(index+1));

        loadnewQuestion();

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                int selected_id = group.getCheckedRadioButtonId();
                radio = findViewById(selected_id);
                correctanswer = radio.getText().toString();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(view.getId() == R.id.submit)
                        {
                            if(correctanswer.equals(correctans[index]))
                            {
                                score++;
                            }

                            index++;
                            if(index == question.length)
                            {
                                finishQuiz();
                                return;
                            }

                            present_index.setText(String.valueOf(index+1));
                            loadnewQuestion();

                        }
                    }
                });
            }
        });
    }
    void loadnewQuestion()
    {
        questionn.setText(String.valueOf(question[index]));
        opta.setText(String.valueOf(choices[index][0]));
        optb.setText(String.valueOf(choices[index][1]));

    }
    void finishQuiz()
    {
        new AlertDialog.Builder(this).setMessage("Score is "+score+" out of"+question.length).setCancelable(true).show();
    }
}
