package com.example.thinkerlab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Teachwithuspart3 extends AppCompatActivity {
    Button sf,upload;
    TextView notification;
    FirebaseStorage firebaseStorage;
    FirebaseDatabase firebaseDatabase;
    Uri uri;
    ProgressDialog progressDialog;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_teachwithuspart3);
        firebaseStorage=FirebaseStorage.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        sf=findViewById(R.id.btnsave);
        upload=findViewById(R.id.btnnext);
        notification=findViewById(R.id.textView11);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Teachwithuspart3.this,TeachwithUsPart2.class));
            }
        });
        sf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(Teachwithuspart3.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
                {
                    selectPDF();
                }
                else
                {
                    ActivityCompat.requestPermissions(Teachwithuspart3.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},9);
                }
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uri!=null)
                {
                    uploadFile(uri);
                }
                else
                {
                    Toast.makeText(Teachwithuspart3.this,"Select a File",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void uploadFile(Uri uri) {
        progressDialog= new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File..........");
        progressDialog.setProgress(0);
        progressDialog.show();
       final String filename = System.currentTimeMillis() + "";
        StorageReference storageReference = firebaseStorage.getReference();
        storageReference.child("Uploads").child(filename).putFile(uri)
              .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                  @Override
                  public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                      Task<Uri>uriTask=taskSnapshot.getStorage().getDownloadUrl();
                      DatabaseReference reference=firebaseDatabase.getReference();
                      reference.child(filename).setValue(uriTask).addOnCompleteListener(new OnCompleteListener<Void>() {
                          @Override
                          public void onComplete(@NonNull Task<Void> task) {
                               if(task.isSuccessful())
                               {
                                   Toast.makeText(Teachwithuspart3.this,"File Successfully Uploaded",Toast.LENGTH_SHORT).show();
                               }
                               else
                               {
                                   Toast.makeText(Teachwithuspart3.this,"File not Successfully Uploaded",Toast.LENGTH_SHORT).show();
                               }
                          }
                      });
                  }
              }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Teachwithuspart3.this,"File not Successfully Uploaded",Toast.LENGTH_SHORT).show();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                int cp=(int)(100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(cp);
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==9 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            selectPDF();
        }
        else
        {
            Toast.makeText(Teachwithuspart3.this,"Please provide Permission....",Toast.LENGTH_SHORT).show();
        }
    }

    private void selectPDF()
    {
        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,86);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 86 && resultCode == RESULT_OK && data != null) {
                  uri=data.getData();
                  notification.setText("A file is selected :"+data.getData().getLastPathSegment());
        }
        else
        {
            Toast.makeText(Teachwithuspart3.this,"Please select a file",Toast.LENGTH_SHORT).show();
        }
    }
}
