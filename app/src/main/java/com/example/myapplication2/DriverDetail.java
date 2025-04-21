package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.apache.commons.lang3.StringUtils;

import com.example.myapplication2.databinding.ActivityDriverDetailBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DriverDetail extends AppCompatActivity {

    String driverName, phoneNumber, driverAddress , driverAdhaar , driverLicense;
    ActivityDriverDetailBinding binding;
    //static final int PICK_IMAGE_REQUEST = 100;
    FirebaseDatabase db;
    DatabaseReference reference;
//    Uri imageUri;
//    StorageReference storageReference;
//    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityDriverDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.driverDetailsSaveBttn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                driverName = binding.driverName.getText().toString();
                phoneNumber = binding.driverPhone.getText().toString();
                driverAddress = binding.driverPermanentAddress.getText().toString();
                driverAdhaar = binding.driverAdhaar.getText().toString();
                driverLicense = binding.driverLicense.getText().toString();

                if (StringUtils.isBlank(driverName) || StringUtils.isBlank(phoneNumber) || StringUtils.isBlank(driverAddress) ||
                StringUtils.isBlank(driverAdhaar) || StringUtils.isBlank(driverLicense)) {
                    Toast.makeText(DriverDetail.this, "Fill All the details", Toast.LENGTH_SHORT).show();
                }
                savingDataToDatabase(driverName, phoneNumber, driverAddress , driverAdhaar , driverLicense);
            }
            private void savingDataToDatabase(String driverName, String phoneNumber, String driverAddress ,
                                              String driverAdhaar , String driverLicense) {
                userData user = new userData(driverName, phoneNumber, driverAddress , driverAdhaar ,driverLicense);
                db = FirebaseDatabase.getInstance();
                reference = db.getReference("userData");
                reference.child(driverAdhaar).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        binding.driverName.setText("");
                        binding.driverPhone.setText("");
                        binding.driverPermanentAddress.setText("");
                        binding.driverAdhaar.setText("");
                        binding.driverLicense.setText("");
                        Toast.makeText(DriverDetail.this, "Driver detial updated sucessfully!!", Toast.LENGTH_SHORT).show();

                        Intent SignupIntent = new Intent(DriverDetail.this, CoDriverDetail.class);
                        startActivity(SignupIntent);
                    }
                });
            }
        });


    }

    //THIS CODE IS FOR UPLOAD IMAGES
//      binding.driverAdhaar.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            selectImage();
//        }
//    });
//
//        binding.driverLicense.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            selectImage();
//        }
//    });
//

//    private void selectImage() {
//
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent, 100);
//
//    }
//
//    private void uploadImage() {
//
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setTitle("Uploading File....");
//        progressDialog.show();
//
//
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CANADA);
//        Date now = new Date();
//        String fileName = formatter.format(now);
//        storageReference = FirebaseStorage.getInstance().getReference("images/"+fileName);
//
//        storageReference.putFile(imageUri)
//                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//
//                        binding.firebaseimage.setImageURI(null);
//                        Toast.makeText(MainActivity.this,"Successfully Uploaded",Toast.LENGTH_SHORT).show();
//                        if (progressDialog.isShowing())
//                            progressDialog.dismiss();
//
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//
//
//                        if (progressDialog.isShowing())
//                            progressDialog.dismiss();
//                        Toast.makeText(MainActivity.this,"Failed to Upload",Toast.LENGTH_SHORT).show();
//
//
//                    }
//                });
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 100 && data != null && data.getData() != null){
//
//            imageUri = data.getData();
//            binding.firebaseimage.setImageURI(imageUri);
//
//
//        }
//    }

}