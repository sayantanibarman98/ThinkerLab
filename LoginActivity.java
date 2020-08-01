package com.example.thinkerlab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private Button login;
    private TextView Register;
    private FirebaseAuth firebaseAuth;
    private TextView fp;
    private ProgressDialog progressDialog;
    private SignInButton signInButton;
    private GoogleSignInClient googleSignInClient;
    private String TAG="LoginActivity";
    private int RC_SIGN_IN=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        signInButton=findViewById(R.id.SIGNIN);
        name=(EditText)findViewById(R.id.etName);
        password=(EditText)findViewById(R.id.etPassword);
        //btn=(Button)findViewById(R.id.btnRegister);
        login=(Button)findViewById(R.id.btnLogin);
        Register=(TextView)findViewById(R.id.TvSignUp);
        fp=(TextView)findViewById(R.id.etFP);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog= new ProgressDialog(this);
        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                // .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleSignInClient=GoogleSignIn.getClient(this,gso);
        //part1
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.SIGNIN:
                        //FirebaseUser user=firebaseAuth.getCurrentUser();
                        //if(user!=null) {
                        signIn();
                        break;
                    //}
                }
            }
        });

        FirebaseUser user=firebaseAuth.getCurrentUser();
        if(user!=null)
        {
            finish();
            startActivity(new Intent(LoginActivity.this,HomePage.class));
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
            }
        });
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ResetPassword.class));
            }
        });


    }

    private  void signIn()
    {
        Intent signInIntent=googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent,RC_SIGN_IN);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==RC_SIGN_IN)
        {
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private  void handleSignInResult(Task<GoogleSignInAccount> completedTask)
    {
        try {
            GoogleSignInAccount acc=completedTask.getResult(ApiException.class);
            Toast.makeText(LoginActivity.this,"Signed In Successfully!",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(LoginActivity.this,HomePage.class);
            startActivity(intent);
            //FirebaseGoogleAuth(acc);
        }
        catch (ApiException e)
        {
            Toast.makeText(LoginActivity.this,"Signed In Failed!",Toast.LENGTH_SHORT).show();
            Log.v("Error","signInResult:failed code="+e.getStatusCode());
            // FirebaseGoogleAuth(null);
        }

    }
/*private  void FirebaseGoogleAuth(GoogleSignInAccount acct)
{
    AuthCredential authCredential= GoogleAuthProvider.getCredential(acct.getIdToken(),null);
    firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful())
            {
                Toast.makeText(MainActivity.this,"Successful!",Toast.LENGTH_SHORT).show();
                 FirebaseUser user=firebaseAuth.getCurrentUser();
                 updateUI(user);
            }
            else {
                Toast.makeText(MainActivity.this,"Failed!",Toast.LENGTH_SHORT).show();
                updateUI(null);
            }
        }
    });
}
private void updateUI(FirebaseUser fUser)
{

}*/


    private void validate(String username, String pass)
    {
        progressDialog.setMessage("This is a Tutorial App");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(username,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this,"Login Successful!",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,HomePage.class));
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Login Failed!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


