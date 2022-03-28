package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    String username, password;

    EditText usernameInput;
    EditText passwordInput;
    Button goToAnotherClass;
    Button newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User karl = new User("karljian@usc.edu", "karl", "jiang", "Student", "karljian");


        usernameInput = (EditText) findViewById(R.id.usernameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);


        goToAnotherClass = (Button) findViewById(R.id.submit); //find the button by its assigned id

        goToAnotherClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                username = usernameInput.getText().toString();
                password = passwordInput.getText().toString();

                boolean whatever = checkPassword(username, password);




                if(username.equals("karljian") && password.equals("karljian") ){

                    Intent myIntent = new Intent(MainActivity.this,
                            CovidTest.class);
                    myIntent.putExtra("tempUser", karl);
                    startActivity(myIntent);
                }
                else{
                    showToast("Invalid Username or Password");
                }


            }
        });

        newUser = (Button) findViewById(R.id.signup); //find the button by its assigned id

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent myIntent = new Intent(MainActivity.this,
                        SignUp.class);
                myIntent.putExtra("tempUser", karl);
                startActivity(myIntent);
            }
        });

    }

    private void showToast(String text){
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

    private boolean checkPassword(String email, String password){
        try {
            URL url = new URL(("http://3.16.168.147/api/getprofile").toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection client = null;

        String send = "{\n\t\"email\": \"" + "\"" + email + "\"," + "\"password\": " + "\"" + password + "\"\n" + "}";
        showToast(send);

        return true;

    }
}