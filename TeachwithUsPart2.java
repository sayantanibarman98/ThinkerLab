package com.example.thinkerlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class TeachwithUsPart2 extends AppCompatActivity {
    private EditText etname;
    private EditText etmobno;
    private EditText etemail;
    private EditText etcoll;
    private Button save,next;
    private TextView name,mobno,email,Designation;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_teachwith_us_part2);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TeachwithUsPart2.this,TeachWithUs.class));
            }
        });
        setupUIViews();
        //firebaseAuth= FirebaseAuth.getInstance();
        /*save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseDatabase=FirebaseDatabase.getInstance();
                databaseReference =firebaseDatabase.getReference("users");
                String fn=name.getText().toString();
                String ln=mobno.getText().toString();
                String ei=email.getText().toString();
                String sn=Designation.getText().toString();
                String pass=college.getText().toString();
                String fnn=etname.getText().toString();
                String lnn=etmobno.getText().toString();
                String eii=etemail.getText().toString();
                String snn=etcoll.getText().toString();
                UserHelperClass helperClass=new UserHelperClass(fn,ln,ei,sn,pass,fnn,lnn,eii,snn);
                databaseReference.child(ei).setValue(helperClass);
                if(validate())
                {
                    //upload to database
                    String user_email= emailID.getText().toString().trim();
                    String user_password= pass1.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(RegistrationActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
                            }
                            else
                            {
                                Toast.makeText(RegistrationActivity.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });*/
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TeachwithUsPart2.this,Teachwithuspart3.class));
            }
        });
    }
    private void setupUIViews()
    {
        etname=(EditText)findViewById(R.id.etname);
        etcoll=(EditText)findViewById(R.id.editText);
        etemail=(EditText)findViewById(R.id.editText2);
        etmobno=(EditText)findViewById(R.id.etcoll);
        name=(TextView) findViewById(R.id.Name);
        mobno=(TextView) findViewById(R.id.mobno);
        email=(TextView) findViewById(R.id.email);
        Designation=(TextView) findViewById(R.id.Designation);

        next=(Button) findViewById(R.id.btnnext);
        save=(Button) findViewById(R.id.btnsave);


    }
   /* private boolean validate()
    {
        Boolean result=false;
        String name11=name.getText().toString();
        String name12=name1.getText().toString();
        String email=emailID.getText().toString();
        String name13=name3.getText().toString();
        String password1=pass1.getText().toString();
        String password2=pass2.getText().toString();
        if(name11.isEmpty()&&name12.isEmpty()&&email.isEmpty()&&name13.isEmpty()&&password1.isEmpty()&&password2.isEmpty())
        {
            Toast.makeText(this,"Please enter all the details",Toast.LENGTH_SHORT).show();
        }
        else
        {
            result=true;
        }
        return  result;

    }*/
}
