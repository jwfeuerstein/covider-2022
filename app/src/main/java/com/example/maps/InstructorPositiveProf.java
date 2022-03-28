package com.example.maps;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.widget.TextView;
        import android.widget.Toast;

public class InstructorPositiveProf extends AppCompatActivity {

    TextView hello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_positive_prof);

        User temp = (User) getIntent().getSerializableExtra("tempUser");

        hello = (TextView) findViewById(R.id.hello);
        hello.setText("Hello " + temp.getFirstName() + " " + temp.getLastName() + "!");


    }

    private void showToast(String text){
        Toast.makeText(InstructorPositiveProf.this, text, Toast.LENGTH_SHORT).show();
    }
}