package com.example.thinkerlab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class FileUpload extends AppCompatActivity {
    Button upload,select;
    TextView no;
    //EditText et;
    FirebaseStorage firebaseStorage;
    FirebaseDatabase firebaseDatabase;
    //StorageReference storageReference;
    //DatabaseReference databaseReference;
    Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_upload);
        firebaseStorage=FirebaseStorage.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        select=findViewById(R.id.button);
        upload=findViewById(R.id.button2);
        no=findViewById(R.id.textView12);
      select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(FileUpload.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
                {
                    selectPdf();
                }
                else {
                    ActivityCompat.requestPermissions(FileUpload.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},9);
                }
            }
        });
      //storageReference=FirebaseStorage.getInstance().getReference();
      //databaseReference=FirebaseDatabase.getInstance().getReference("uploads");
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uri!=null)
                {
                    uploadfile(uri);
                }
                else
                {
                    Toast.makeText(FileUpload.this,"Select a File",Toast.LENGTH_SHORT).show();
                }
               //selectPdf();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==9&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            selectPdf();
        }
        else {
            Toast.makeText(FileUpload.this,"Get permissions",Toast.LENGTH_SHORT).show();
        }
    }

    private void selectPdf() {
        Intent i=new Intent();
        i.setType("application/pdf");
        i.setAction(Intent.ACTION_GET_CONTENT);
        //startActivityForResult(Intent.createChooser(i,"Select Pdf file"),1);
        startActivityForResult(i,86);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 86 && resultCode == RESULT_OK && data != null && data.getData()!=null) {
            uri = data.getData();
            no.setText("A file is selected : "+data.getData().getLastPathSegment());
            uploadfile(data.getData());
        } else {
            Toast.makeText(FileUpload.this,"Please select a file",Toast.LENGTH_SHORT).show();

        }
    }
    private void uploadfile(Uri uri) {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File......");
        progressDialog.setProgress(0);
        progressDialog.show();
        //StorageReference s=storageReference.child("uploads/"+System.currentTimeMillis()+".pdf");
        //s.putFile(uri)
               // .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                  //  @Override
                  //  public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                       /* Task<Uri> uriTask= taskSnapshot.getStorage().getDownloadUrl();
                        while (!uriTask.isComplete());
                        Uri url=uriTask.getResult();
                        Uploadpdf uploadpdf=new Uploadpdf(et.getText().toString(),url.toString());
                        databaseReference.child(databaseReference.push().getKey()).setValue(uploadpdf);
                        Toast.makeText(FileUpload.this,"File Uploaded",Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                double p=(100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                progressDialog.setMessage("Uploaded: "+(int)p+"%");

            }
        });*/

        final String fn=System.currentTimeMillis()+"";
        final StorageReference storageReference=firebaseStorage.getReference();
        storageReference.child("Uploads").child(fn).putFile(uri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        String url=storageReference.getDownloadUrl().toString();
                        DatabaseReference databaseReference=firebaseDatabase.getReference();
                        databaseReference.child(fn).setValue(url).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(FileUpload.this,"File successfully uploaded!",Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(FileUpload.this,"File not successfully uploaded!",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(FileUpload.this,"File not successfully uploaded!",Toast.LENGTH_SHORT).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                int cp=(int)(100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(cp);
            }
        });
    }
}
