package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class CovidTest extends AppCompatActivity {

    Button yes;
    Button no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_test);

        User temp = (User) getIntent().getSerializableExtra("tempUser");

        yes = (Button) findViewById(R.id.yes); //find the button by its assigned id
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent myIntent = new Intent(CovidTest.this,
                        CovidPositiveQuestion.class);
                myIntent.putExtra("tempUser", temp);
                startActivity(myIntent);
            }
        });

        no = (Button) findViewById(R.id.no); //find the button by its assigned id
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent myIntent = new Intent(CovidTest.this,
                        TrojanCheck.class);
                myIntent.putExtra("tempUser", temp);
                startActivity(myIntent);
            }
        });
    }
}