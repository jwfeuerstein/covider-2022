package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;


public class SignUp extends AppCompatActivity {

    String email = "", first = "", last = "", type = "", password = "";

    EditText emailInput;
    EditText firstInput;
    EditText lastInput;
    EditText password1Input;
    EditText password2Input;


    Button submit;
    RadioGroup rg;
    RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        rg = (RadioGroup) findViewById(R.id.radioGroup1);


        emailInput = (EditText) findViewById(R.id.email);
        firstInput = (EditText) findViewById(R.id.firstname);
        lastInput = (EditText) findViewById(R.id.lastname);
        password1Input = (EditText) findViewById(R.id.password1);
        password2Input = (EditText) findViewById(R.id.password2);



        submit = (Button) findViewById(R.id.submit); //find the button by its assigned id
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                boolean valid = true;
                email = emailInput.getText().toString();
                first = firstInput.getText().toString();
                last = lastInput.getText().toString();
                if(password1Input.getText().toString().equals(password2Input.getText().toString())){
                    password = password1Input.getText().toString();
                }
                else{
                    showToast("Passwords Do Not Match");
                    valid = false;
                }

                if(rg.getCheckedRadioButtonId() == -1){
                    valid = false;
                    showToast("Select a Type");
                }
                else{
                    int selectedId = rg.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedId);
                    type = radioButton.getText().toString();
                }

                if(email.length() == 0){
                    showToast("Email can not be empty");
                    valid = false;
                }
                if(first.length() == 0){
                    showToast("First name can not be empty");
                    valid = false;
                }
                if(last.length() == 0){
                    showToast("Last name can not be empty");
                    valid = false;
                }
                if(password.length() == 0){
                    showToast("Password can not be empty");
                    valid = false;
                }

                if(valid){
                    User newUser = new User(email, first, last, type, password);
                    Intent myIntent = new Intent(SignUp.this,
                            CovidTest.class);
                    myIntent.putExtra("tempUser", newUser);
                    startActivity(myIntent);
                }

            }
        });
    }

    private void showToast(String text){
        Toast.makeText(SignUp.this, text, Toast.LENGTH_SHORT).show();
    }
}