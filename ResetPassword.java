package com.example.thinkerlab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

    private EditText email;
    private Button resetPassword;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        email=(EditText)findViewById(R.id.etresetemail);
        resetPassword=(Button)findViewById(R.id.btnRP);
        firebaseAuth=FirebaseAuth.getInstance();
        resetPassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String useremail=email.getText().toString().trim();
                if(useremail.equals(""))
                {
                    Toast.makeText(ResetPassword.this,"Enter your registered email ID",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(ResetPassword.this,"Password Reset Email sent!",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(ResetPassword.this,MainActivity.class));
                            }
                            else
                            {
                                Toast.makeText(ResetPassword.this,"Failed to send Password Reset Email!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
