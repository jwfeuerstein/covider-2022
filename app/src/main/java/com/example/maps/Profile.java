package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.os.Handler;

public class Profile extends AppCompatActivity {

    User temp;
    TextView hello;
    Button map;
    Button editProfile;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        temp = (User) getIntent().getSerializableExtra("tempUser");

        content();




    }



    public void content(){
        count++;
        if(count == 5){
            Intent myIntent = new Intent(Profile.this,
                    Notification.class);
            myIntent.putExtra("tempUser", temp);
            startActivity(myIntent);
        }

        hello = (TextView) findViewById(R.id.hello);
        hello.setText("Hello " + temp.getFirstName() + " " + temp.getLastName() + "!");


        map = (Button) findViewById(R.id.map); //find the button by its assigned id
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent myIntent = new Intent(Profile.this,
                        MapsActivity.class);
                myIntent.putExtra("tempUser", temp);
                startActivity(myIntent);



            }
        });

        editProfile = (Button) findViewById(R.id.editprofile); //find the button by its assigned id
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


                Intent myIntent = new Intent(Profile.this,
                        Notification.class);
                myIntent.putExtra("tempUser", temp);
                startActivity(myIntent);



            }
        });
        refresh(10000);
    }

    private void refresh(int milliseconds){
        final Handler handler = new Handler();

        final Runnable runnable = new Runnable(){
            public void run(){
                content();
            }
        };

        handler.postDelayed(runnable, milliseconds);
    }

    private void showToast(String text){
        Toast.makeText(Profile.this, text, Toast.LENGTH_SHORT).show();
    }
}