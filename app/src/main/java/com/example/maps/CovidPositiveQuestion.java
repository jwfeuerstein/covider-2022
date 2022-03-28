package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class CovidPositiveQuestion extends AppCompatActivity {

    Button yes;
    Button no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_positive_question);

        User temp = (User) getIntent().getSerializableExtra("tempUser");

        yes = (Button) findViewById(R.id.yes); //find the button by its assigned id
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if(temp.getType().equals("Student")){
                    Intent myIntent = new Intent(CovidPositiveQuestion.this,
                            PositiveProf.class);
                    myIntent.putExtra("tempUser", temp);
                    startActivity(myIntent);
                }
                else if(temp.getType().equals("Instructor")){
                    Intent myIntent = new Intent(CovidPositiveQuestion.this,
                            InstructorPositiveProf.class);
                    myIntent.putExtra("tempUser", temp);
                    startActivity(myIntent);
                }

            }
        });

        no = (Button) findViewById(R.id.no); //find the button by its assigned id
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if(temp.getType().equals("Student")){
                    Intent myIntent = new Intent(CovidPositiveQuestion.this,
                            Profile.class);
                    myIntent.putExtra("tempUser", temp);
                    startActivity(myIntent);
                }
                else if(temp.getType().equals("Instructor")){
                    Intent myIntent = new Intent(CovidPositiveQuestion.this,
                            InstructorProfile.class);
                    myIntent.putExtra("tempUser", temp);
                    startActivity(myIntent);
                }
            }
        });
    }
}