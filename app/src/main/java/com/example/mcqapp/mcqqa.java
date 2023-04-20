package com.example.mcqapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class mcqqa extends AppCompatActivity {
    TextView present_index,total_que,questionn;
    int index = 0,score=0;
    String correctanswer = "";
    RadioGroup group;
    RadioButton opta,optb,optc,optd,radio;
    Button submit;
    String question [] = {"Which company owns the android?","How to pass the data between activities in Android?"," On which thread services work in android?","What is an anonymous class in android?","What are the functionalities of HTTP Client interface in android?"," What is transient data in android?","WHich method is used to find GPS enabled or disabled pro-grammatically in android?","Can a class be immutable in android?","Which one is not the Programming Language?", "Where are you watching this video?",};
    String choices[][] = {{"Google","Apple","Nokia","Samsung"},{"Intent","Content Provider","BroadCast Reciever","None of the above"}, {"Worker Thread","Own Thread","Main Thread","None of the above"},{"Interface class","Java class","Manifest File","A class that doesnot have name"},{"Connection Management","Cookies Management","Authentication Management","All of the above"},{"Permanent Data","Secure Data","Temporary Data","Logical Data"},{"finish()","getGPSStatus","onProviderDisable","getGPS()"},{"No,it can't","Yes, class can be imutable","Can't make class as final class","None of the above"},{"Java","Kotlin","Notepad","Python"}, {"Facebook","Whatsapp","Instagram","Youtube"}};
    String correctans[]={"Google","Intent","Main Thread","A class that doesnot have name","All of the above","Logical Data","onProviderDisable","Yes, class can be imutable","Notepad","Youtube"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcqqa);

        group = findViewById(R.id.group);
        present_index = findViewById(R.id.present);
        total_que = findViewById(R.id.total);
        questionn = findViewById(R.id.questions);
        opta = findViewById(R.id.opta);
        optb = findViewById(R.id.optb);
        optc = findViewById(R.id.optc);
        optd = findViewById(R.id.optd);
        submit = findViewById(R.id.submit);
        total_que.setText(String.valueOf("/"+question.length));
        present_index.setText(String.valueOf(index+1));

        loadnewQuestion();

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                group.setBackgroundColor(4);
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
        optc.setText(String.valueOf(choices[index][2]));
        optd.setText(String.valueOf(choices[index][3]));
    }
    void finishQuiz()
    {
        new AlertDialog.Builder(this).setMessage("Score is "+score+" out of"+question.length).setCancelable(true).show();
    }
}