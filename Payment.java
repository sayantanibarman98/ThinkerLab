package com.example.thinkerlab;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Payment extends AppCompatActivity {
    EditText a,b,c,d;
    Button ab;
    final int UPI_PAYMENT=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        a=findViewById(R.id.amount);
        b=findViewById(R.id.upi);
        c=findViewById(R.id.name);
        d=findViewById(R.id.note);
        ab=findViewById(R.id.pay);
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount=a.getText().toString();
                String note=d.getText().toString();
                String name=c.getText().toString();
                String upi=b.getText().toString();
                payUsingUpi(amount,note,name,upi);
            }
        });
    }

    private void payUsingUpi(String amount, String note, String name, String upi) {
        Uri uri=Uri.parse("upi://pay").buildUpon()
                .appendQueryParameter("pa",upi)
                .appendQueryParameter("pn",name)
                .appendQueryParameter("tn",note)
                .appendQueryParameter("am",amount)
                .appendQueryParameter("cu","INR")
                .build();
        Intent ii=new Intent(Intent.ACTION_VIEW);
        ii.setData(uri);
        Intent chooser=Intent.createChooser(ii,"Pay with");
        if(null!=chooser.resolveActivity(getPackageManager())){
            startActivityForResult(chooser,UPI_PAYMENT);
        }
        else
        {
            Toast.makeText(Payment.this,"No UPI app found! Please install one to continue",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case UPI_PAYMENT:
                if((resultCode==RESULT_OK)||(resultCode==11)){
                    if(data!=null)
                    {
                        String t=data.getStringExtra("response");
                        Log.d("UPI","OnActivityResult: "+t);
                        ArrayList<String> datalist= new ArrayList<>();
                        datalist.add(t);
                        upiPayment(datalist);
                    }
                    else {
                        Log.d("UPI","OnActivityResult: "+"Return data is null");
                        ArrayList<String> datalist= new ArrayList<>();
                        datalist.add("nothing");
                        upiPayment(datalist);

                    }

            }
                else
                {
                    Log.d("UPI","OnActivityResult: "+"Return data is null");
                    ArrayList<String> datalist= new ArrayList<>();
                    datalist.add("nothing");
                    upiPayment(datalist);
                }
                break;
        }
    }

    private void upiPayment(ArrayList<String> datalist) {
        if(isConnectionAvailable(Payment.this))
        {
            String str=datalist.get(0);
            Log.d("UPIPAY","upiPayment: "+str);
            String pc="";
            if(str==null)
                str="discard";
            String status="";
            String ap="";
            String response[]=str.split("&");
            for (int i=0;i<response.length;i++)
            {
                String equal[]=response[i].split("=");
                if(equal.length>=2)
                {
                    if(equal[0].toLowerCase().equals("Status".toLowerCase())){
                        status=equal[1].toLowerCase();
                    }
                    else if(equal[0].toLowerCase().equals("ApprovalRefNo".toLowerCase())||equal[0].toLowerCase().equals("txnRef".toLowerCase())){
                        ap=equal[1];
                    }
                }
                else
                {
                    pc="Payment cancelled by User.";
                }
            }
            if(status.equals("success"))
            {
                Toast.makeText(Payment.this,"Transaction Successful!",Toast.LENGTH_SHORT).show();
                Log.d("UPI","responseStr: "+ap);
                startActivity(new Intent(Payment.this,BuildingWithBricks.class));
            }
            else if("Payment cancelled by user.".equals(pc))
            {
                Toast.makeText(Payment.this,"Payment cancelled by user",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(Payment.this,"Transaction failed! Please try again",Toast.LENGTH_SHORT).show();
            }

        }
        else {
            Toast.makeText(Payment.this,"Internet Connection is not available!Please check and try again!",Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean isConnectionAvailable(Context context) {
        ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager!=null)
        {
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if(networkInfo!=null&&networkInfo.isConnected()&&networkInfo.isConnectedOrConnecting())
            {
                return true;

            }
        }
        return false;
    }


}
