package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.databinding.ActivityCoDriverDetailBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.apache.commons.lang3.StringUtils;

public class CoDriverDetail extends AppCompatActivity {

    String coDriverName, coDriverphoneNumber, codriverAddress , codriverAdhaar , codriverLicense;
    ActivityCoDriverDetailBinding binding;
    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityCoDriverDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.coDriverSaveBttn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                coDriverName = binding.coDriverName.getText().toString();
                coDriverphoneNumber = binding.coDriverPhone.getText().toString();
                codriverAddress = binding.coDriverAddress.getText().toString();
                codriverAdhaar = binding.coDriverAdhaarNumber.getText().toString();
                codriverLicense = binding.coDriverLicense.getText().toString();

                if (StringUtils.isBlank(coDriverName) || StringUtils.isBlank(coDriverphoneNumber)
                        || StringUtils.isBlank(codriverAddress) ||
                        StringUtils.isBlank(codriverAdhaar) || StringUtils.isBlank(codriverLicense)) {
                    Toast.makeText(CoDriverDetail.this, "Fill All the details", Toast.LENGTH_SHORT).show();
                }

                userData user = new userData(coDriverName, coDriverphoneNumber, codriverAddress , codriverAdhaar , codriverLicense);
                db = FirebaseDatabase.getInstance();
                reference = db.getReference("coDriverDetails");
                reference.child(codriverAdhaar).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        binding.coDriverName.setText("");
                        binding.coDriverPhone.setText("");
                        binding.coDriverAddress.setText("");
                        binding.coDriverAdhaarNumber.setText("");
                        binding.coDriverLicense.setText("");
                        Toast.makeText(CoDriverDetail.this, "Driver detial updated sucessfully!!", Toast.LENGTH_SHORT).show();

                        Intent SignupIntent = new Intent(CoDriverDetail.this, TruckDetail.class);
                        startActivity(SignupIntent);
                    }
                });
            }
        });


    }
}