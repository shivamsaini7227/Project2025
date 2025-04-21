package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
    ActivitySignupBinding binding;
    String SignupUserName, SignupNumber, SignupPsswd, ConfirmPsswd;
    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.SignUpBttn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                SignupUserName = binding.Sname.getText().toString();
                SignupNumber = binding.Snumber.getText().toString();
                SignupPsswd = binding.SPasswd.getText().toString();
                ConfirmPsswd = binding.SconfirmPsswd.getText().toString();

                if (SignupUserName.isBlank() || SignupNumber.isBlank() || SignupPsswd.isBlank() || ConfirmPsswd.isBlank()) {
                    Toast.makeText(Signup.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                }

                if (!SignupPsswd.equals(ConfirmPsswd)) {
                        Toast.makeText(Signup.this, "Password Doesn't Match", Toast.LENGTH_SHORT).show();
                }
                    userData user = new userSignupData(SignupUserName, SignupNumber, SignupPsswd);
                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference("userSignupData");
                    reference.child(SignupUserName).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            binding.Sname.setText("");
                            binding.Snumber.setText("");
                            binding.SPasswd.setText("");
                            Toast.makeText(Signup.this, "SignUp Details Loaded Sucessfully!!", Toast.LENGTH_SHORT).show();
                            Intent SignupIntent = new Intent(Signup.this, DriverDetail.class);
                            startActivity(SignupIntent);
                        }
                    });

            }

        });
    }
}