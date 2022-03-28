package com.example.maps;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TrojanCheck extends AppCompatActivity {
    int total1 = 0;
    int total2 = 0;
    int total3 = 0;
    int total4 = 0;
    int total5 = 0;


    boolean isSafe = false;


    Button yes1, no1, yes2, no2, yes3, no3, yes4, no4, yes5, no5, submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trojan_check);

        User temp = (User) getIntent().getSerializableExtra("tempUser");

        yes1 = (Button) findViewById(R.id.yes1); //find the button by its assigned id
        yes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                total1++;
            }
        });

        no1 = (Button) findViewById(R.id.no1); //find the button by its assigned id
        no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                total1 = 0;
            }
        });

        yes2 = (Button) findViewById(R.id.yes2); //find the button by its assigned id
        yes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                total2++;
            }
        });

        no2 = (Button) findViewById(R.id.no2); //find the button by its assigned id
        no2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                total2 = 0;
            }
        });

        yes3 = (Button) findViewById(R.id.yes3); //find the button by its assigned id
        yes3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                total3++;
            }
        });

        no3 = (Button) findViewById(R.id.no3); //find the button by its assigned id
        no3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                total3 = 0;
            }
        });

        yes4 = (Button) findViewById(R.id.yes4); //find the button by its assigned id
        yes4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                total4++;
            }
        });

        no4 = (Button) findViewById(R.id.no4); //find the button by its assigned id
        no4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                total4 = 0;
            }
        });

        yes5 = (Button) findViewById(R.id.yes5); //find the button by its assigned id
        yes5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                total5 ++;
            }
        });

        no5 = (Button) findViewById(R.id.no5); //find the button by its assigned id
        no5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                total5 = 0;
            }
        });

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (total1 + total2 + total3 + total4 + total5 == 0){
                    isSafe = true;
                }

                if(isSafe){
                    showToast("Thank you!");
                    if(temp.getType().equals("Student")){
                        Intent myIntent = new Intent(TrojanCheck.this,
                                Profile.class);
                        myIntent.putExtra("tempUser", temp);
                        startActivity(myIntent);
                    }
                    else if(temp.getType().equals("Instructor")){
                        Intent myIntent = new Intent(TrojanCheck.this,
                                InstructorProfile.class);
                        myIntent.putExtra("tempUser", temp);
                        startActivity(myIntent);
                    }


                }
                else{
                    showToast("Health not satisfactory");
                    if(temp.getType().equals("Student")){
                        Intent myIntent = new Intent(TrojanCheck.this,
                                PositiveProf.class);
                        myIntent.putExtra("tempUser", temp);
                        startActivity(myIntent);
                    }
                    else if(temp.getType().equals("Instructor")){
                        Intent myIntent = new Intent(TrojanCheck.this,
                                InstructorPositiveProf.class);
                        myIntent.putExtra("tempUser", temp);
                        startActivity(myIntent);
                    }

                }
            }
        });



    }

    private void showToast(String text){
        Toast.makeText(TrojanCheck.this, text, Toast.LENGTH_SHORT).show();
    }
}