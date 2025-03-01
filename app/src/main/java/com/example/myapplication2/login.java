package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    //variable for each information
    EditText username;
    EditText password;
    Button button;
    TextView register;
    //Text signUpLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username= findViewById(R.id.num);
        password= findViewById(R.id.confirmPass);
        button= findViewById(R.id.signupBttn);
        register = findViewById(R.id.SignupLink);

        //Go to signUp Activity
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signIntent = new Intent(getApplicationContext(), signup.class);
                startActivity(signIntent);
                finish();
            }
        });

        //Checking button

        button.setOnClickListener(new View.OnClickListener(){

            public  void onClick(View view){
                if(username.getText().toString().equals("user") && password.getText().toString().equals("user123")){
                    Toast.makeText(login.this,"Login Successfully!!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(login.this,"Try Again!!",Toast.LENGTH_SHORT).show();
                }

            }
        });




    }
}