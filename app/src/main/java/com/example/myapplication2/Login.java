package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.databinding.ActivitySignupBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    //variable for each information
    EditText num,psswd;
    Button button;
    TextView registerToApp;
    ActivitySignupBinding binding;
    FirebaseDatabase db;
    DatabaseReference reference;

    //Text signUpLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        reference = db.getReference("UserData");

        button.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view){
              num = findViewById(R.id.Lnumber);
              psswd = findViewById(R.id.Lpsswd);
                if(num == null ){
                    Toast.makeText(Login.this,"Login Successfully!!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Login.this,"Try Again!!",Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Go to signUp Activity
        registerToApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(Login.this, Signup.class);
                startActivity(signUpIntent);
            }
        });
    }
}