package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.databinding.ActivityLoginBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class Login extends AppCompatActivity {
    EditText num,psswd;
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.LBttn.setOnClickListener(new View.OnClickListener(){
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

        binding.SignupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(Login.this, Signup.class);
                startActivity(signUpIntent);
            }
        });
    }
}