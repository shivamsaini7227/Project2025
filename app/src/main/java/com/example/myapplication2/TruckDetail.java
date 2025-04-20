package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.databinding.ActivityTruckDetailBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class TruckDetail extends AppCompatActivity {
    EditText truckCompanyEditText, truckLicensePlateEditText;
    Spinner truckTypeSpinner;
    Button finishButton;
    FirebaseDatabase db;
    DatabaseReference reference;
    ActivityTruckDetailBinding binding;

    String companyName, licensePlate, truckType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck_detail);
        binding = ActivityTruckDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        truckCompanyEditText = findViewById(R.id.truckCompany);
        truckLicensePlateEditText = findViewById(R.id.truckLicensePlate);
        truckTypeSpinner = findViewById(R.id.truckSpinner);
        finishButton = findViewById(R.id.LBttn);

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                companyName = truckCompanyEditText.getText().toString().trim();
                licensePlate = truckLicensePlateEditText.getText().toString().trim();
                truckType = truckTypeSpinner.getSelectedItem().toString();
                savingDataToDatabase(companyName,licensePlate,truckType);
                Intent goToHome = new Intent(TruckDetail.this, Home.class);
                startActivity(goToHome);
                finish();
            }

            private void savingDataToDatabase(String companyName, String licensePlate , String truckType) {
                userData user = new truckUserData(companyName, licensePlate, truckType);
                db = FirebaseDatabase.getInstance();
                reference = db.getReference("TruckDetails");
                reference.child(licensePlate).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        binding.truckCompany.setText("");
                        binding.truckLicensePlate.setText("");
                        binding.truckSpinner.setSelection(0);
                        Toast.makeText(TruckDetail.this, "Driver detial updated sucessfully!!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}