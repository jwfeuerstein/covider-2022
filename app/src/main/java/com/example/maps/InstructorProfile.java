package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class InstructorProfile extends AppCompatActivity {
    TextView hello;
    Button map;
    Button editProfile;
    Button viewClasses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_profile);

        User temp = (User) getIntent().getSerializableExtra("tempUser");

        hello = (TextView) findViewById(R.id.hello);
        hello.setText("Hello " + temp.getFirstName() + " " + temp.getLastName() + "!");


        map = (Button) findViewById(R.id.map); //find the button by its assigned id
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


//                Intent myIntent = new Intent(InstructorProfile.this,
//                        MapsActivity.class);
//                myIntent.putExtra("tempUser", temp);
//                startActivity(myIntent);



            }
        });

        editProfile = (Button) findViewById(R.id.editprofile); //find the button by its assigned id
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


                Intent myIntent = new Intent(InstructorProfile.this,
                        EditProfile.class);
                myIntent.putExtra("tempUser", temp);
                startActivity(myIntent);



            }
        });

        viewClasses = (Button) findViewById(R.id.classes); //find the button by its assigned id
        viewClasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


                Intent myIntent = new Intent(InstructorProfile.this,
                        ClassList.class);
                myIntent.putExtra("tempUser", temp);
                startActivity(myIntent);



            }
        });


    }

    private void showToast(String text){
        Toast.makeText(InstructorProfile.this, text, Toast.LENGTH_SHORT).show();
    }
}