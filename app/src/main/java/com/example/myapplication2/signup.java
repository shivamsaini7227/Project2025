package com.example.myapplication2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class signup extends AppCompatActivity {

    EditText signupName;
    EditText SignupNumber;
    EditText SignupPsswd;
    EditText SignupConfirm;
    Button signupBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        signupName=findViewById(R.id.Sname);
        SignupNumber=findViewById(R.id.Snumber);
        SignupPsswd=findViewById(R.id.SPasswd);
        SignupConfirm=findViewById(R.id.SconfirmPsswd);

        signupBttn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                if (signupName.getText().toString().equals(" ") || SignupNumber.getText().toString().equals(" ")) {
                    Toast.makeText(signup.this, "Fill all the details !!", Toast.LENGTH_SHORT).show();
                }
                if (!SignupPsswd.getText().toString().equals(SignupConfirm.getText().toString())) {
                    Toast.makeText(signup.this, "Password doesn't matches", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(signup.this, "SignUp Sucessfully!!", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}