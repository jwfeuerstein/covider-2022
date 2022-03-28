package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {

    Button submit;
    String email = "", first = "", last = "", type = "", password = "";

    EditText emailInput;
    EditText firstInput;
    EditText lastInput;
    EditText password1Input;
    EditText password2Input;

    RadioGroup rg;
    RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        User temp = (User) getIntent().getSerializableExtra("tempUser");

        rg = (RadioGroup) findViewById(R.id.radioGroup1);


        emailInput = (EditText) findViewById(R.id.email);
        firstInput = (EditText) findViewById(R.id.firstname);
        lastInput = (EditText) findViewById(R.id.lastname);
        password1Input = (EditText) findViewById(R.id.password1);
        password2Input = (EditText) findViewById(R.id.password2);

        submit = (Button) findViewById(R.id.submit); //find the button by its assigned id
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                boolean valid = true;
                email = emailInput.getText().toString();
                first = firstInput.getText().toString();
                last = lastInput.getText().toString();
                if(password1Input.getText().toString().length() != 0 || password2Input.getText().toString().length() != 0){
                    if(!password1Input.getText().toString().equals(password2Input.getText().toString())){
                        showToast("Passwords Do Not Match, Password not Changed");
                        password = "";
                    }
                    else{
                        password = password1Input.getText().toString();
                    }
                }


                if(rg.getCheckedRadioButtonId() != -1){
                    int selectedId = rg.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedId);
                    temp.setType(radioButton.getText().toString());
                }

                if(email.length() != 0){
                    temp.setEmail(email);
                }
                if(first.length() != 0){
                    temp.setFirstName(first);
                }
                if(last.length() != 0){
                    temp.setLastName(last);
                }
                if(password.length() != 0){
                    temp.setPassword(password);
                }

                Intent myIntent = new Intent(EditProfile.this,
                        Profile.class);
                myIntent.putExtra("tempUser", temp);
                startActivity(myIntent);

            }
        });


    }
    private void showToast(String text){
        Toast.makeText(EditProfile.this, text, Toast.LENGTH_SHORT).show();
    }
}